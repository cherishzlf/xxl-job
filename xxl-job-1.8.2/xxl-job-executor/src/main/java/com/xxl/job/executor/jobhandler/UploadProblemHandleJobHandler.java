package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.UpProblemHandle;
import com.xxl.job.executor.service.first.EhTacheService;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 问题处理状态新增服务
 * @author liruimin<br>2017/9/7
 * @version 1.8.2
 */
@JobHander(value = "uploadProblemHandleJobHandler")
@Service
public class UploadProblemHandleJobHandler extends IJobHandler {
    @Autowired
    private MdAdminregionService mdAdminregionService;
    @Autowired
    private EhTacheService ehTacheService;
    /**
     * 问题处理状态新增服务
     * @param params 参数数组，用逗号隔开(若不加参数，默认为上报金华，衢州，丽水数据)
     * 1、params[0] String region 区域名称 (如金华市) 默认为空
     * 2、params[1] String regionLevel 区域等级 (1：省，2：市，3：县，4：镇，5：村) 默认为空
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        String region = "";
        int regionLevel=0;
        String regionId ="";
        if(params!=null && params.length==2) {
            region = params[0];
            regionLevel = Integer.parseInt(params[1]);
            Map<String,Object> param = new HashMap<String,Object>();
            param.put("region",region);
            param.put("regionLevel",regionLevel);
            regionId = mdAdminregionService.findByregionName(param);
        }else if(params!=null && params.length>2){
            XxlJobLogger.log("参数错误");
            return ReturnT.FAIL;
        }
        boolean isFirstUpload = false;

        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("regionId",regionId);
        condition.put("regionLevel",regionLevel);
        UpProblemHandle firstUpProblemHandle = ehTacheService.getUpProblemHandle(condition);
        if(firstUpProblemHandle==null){
            isFirstUpload =  true;
        }
        List<String> idList = new ArrayList<String>();
        List<UpProblemHandle> upProblemHandlerList=null;
        List<UpProblemHandle> errorList = new ArrayList<UpProblemHandle>();
        if(isFirstUpload==true) {
            upProblemHandlerList = ehTacheService.getUpProblemHandleList(condition);
        }else{
            Date lastUploadtime = firstUpProblemHandle.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            upProblemHandlerList = ehTacheService.getUpProblemHandleList(condition);
        }
        for (UpProblemHandle upProblemHandle:upProblemHandlerList) {
            upProblemHandle.setUserName(DataHandUtil.getUserNameByCity(upProblemHandle.getEventbelongcity()));
            String result = CallApiUtil.uploadProblemHandle(upProblemHandle);
            if(result.equals("true")) {
                idList.add(upProblemHandle.getHandleID());
                System.out.println("上报成功");
                continue;
            }
            XxlJobLogger.log(result);
            errorList.add(upProblemHandle);
        }
        Date date = new Date();
        if(!idList.isEmpty()) {
            Map<String, Object> entity = new HashMap<String, Object>();
            entity.put("uploadtime", date);
            entity.put("idList", idList);
            ehTacheService.updateByIdList(entity);
        }
        return ReturnT.SUCCESS;
    }
}
