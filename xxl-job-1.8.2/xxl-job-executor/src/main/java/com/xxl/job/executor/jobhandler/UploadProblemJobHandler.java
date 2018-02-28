package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.UpProblem;
import com.xxl.job.executor.service.first.EhEventService;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import com.xxl.job.executor.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 上报问题新增服务
 * @author liruimin<br>2017/9/7
 * @version 1.8.2
 */
@JobHander(value = "uploadProblemJobHandler")
@Service
public class UploadProblemJobHandler extends IJobHandler {
    @Autowired
    private EhEventService ehEventService;
    @Autowired
    private MdAdminregionService mdAdminregionService;

    /**
     * 上报问题新增服务
     * @param params 参数数组，用逗号隔开(若不加参数，默认为上报金华，衢州，丽水数据)
     * 1、params[0] String region 区域名称 (如金华市) 默认为空
     * 2、params[1] String regionLevel 区域等级 (1：省，2：市，3：县，4：镇，5：村) 默认为空
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        String region = "";
        Date date = new Date();
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
        UpProblem firstUpProblem = ehEventService.getFirstEvent(condition);
        if(firstUpProblem==null){
            isFirstUpload =  true;
        }
        List<String> idList = new ArrayList<String>();
        List<UpProblem> upProblemList=null;
        List<UpProblem> errorList = new ArrayList<UpProblem>();
        if(isFirstUpload==true) {
            upProblemList = ehEventService.getUpEvenList(condition);
        }else{
            Date lastUploadtime = firstUpProblem.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            upProblemList = ehEventService.getUpEvenList(condition);
        }
        for (UpProblem upProblem:upProblemList) {
            String checkItem = upProblem.getCheckedItem();
            if(StringUtil.isNotEmptyStr(checkItem)){
                checkItem = DataHandUtil.getCheckItem(checkItem);
            }
            if(StringUtil.isNotEmptyStr(checkItem)){
                upProblem.setItemList(checkItem);
            }
            upProblem.setItemList(DataHandUtil.getItemList(upProblem.getItemList()));
            if(upProblem.getItemList()==null){
                errorList.add(upProblem);
                continue;
            }
            upProblem.setProblemType(DataHandUtil.getProblemType(upProblem.getProblemSource()));
            upProblem.setProblemSource(DataHandUtil.getProblemSource(upProblem.getProblemSource()));
            upProblem.setUserName(DataHandUtil.getUserNameByCity(upProblem.getEventbelongcity()));
            if(upProblem.getUserName()==null){
                errorList.add(upProblem);
                continue;
            }
            String result = CallApiUtil.uploadProblem(upProblem);
            if(result.equals("true")) {
                idList.add(upProblem.getProblemID());
                System.out.println("上报成功");
                continue;
            }
            System.out.println(result);
            errorList.add(upProblem);
        }
        if(!idList.isEmpty()) {
        Map<String,Object> entity = new HashMap<String, Object>();
        entity.put("uploadtime",date);
        entity.put("idList",idList);
        ehEventService.updateByIdList(entity);
        }
        XxlJobLogger.log(errorList.toString());
        return ReturnT.SUCCESS;
    }
}
