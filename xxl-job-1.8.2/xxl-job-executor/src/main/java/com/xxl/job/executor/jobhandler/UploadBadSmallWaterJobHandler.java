package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.UpBadSmallWater;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.service.first.MdMicroService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 上报小微水体服务
 * 0 15 9 10 * ?
 * @author liruimin<br>2017/9/7
 * @version 1.8.2
 */
@JobHander(value = "uploadBadSmallWaterJobHandler")
@Service
public class UploadBadSmallWaterJobHandler extends IJobHandler {
    @Autowired
    private MdAdminregionService mdAdminregionService;
    @Autowired
    private MdMicroService mdMicroService;
    /**
     * 上报小微水体服务
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
        UpBadSmallWater firstUpProblemHandle = mdMicroService.getFirstBadSmallWater(condition);
        if(firstUpProblemHandle==null){
            isFirstUpload =  true;
        }
        List<String> idList = new ArrayList<String>();
        List<UpBadSmallWater> upBadSmallWaterProgresses=null;
        List<UpBadSmallWater> errorList = new ArrayList<UpBadSmallWater>();
        if(isFirstUpload==true) {
            upBadSmallWaterProgresses = mdMicroService.getUpBadSmallWater(condition);
        }else{
            Date lastUploadtime = firstUpProblemHandle.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            upBadSmallWaterProgresses = mdMicroService.getUpBadSmallWater(condition);
        }
        Calendar cal = Calendar.getInstance();
        for (UpBadSmallWater upBadSmallWater:upBadSmallWaterProgresses) {
            upBadSmallWater.setUserName(DataHandUtil.getUserNameByCity(upBadSmallWater.getCityId()));
            if(upBadSmallWater.getUserName()==null){
                errorList.add(upBadSmallWater);
                continue;
            }
            cal.setTime(upBadSmallWater.getPlanEndTime());
            upBadSmallWater.setPlanYear(cal.get(Calendar.YEAR));
            if(upBadSmallWater.getCountyid()!=null){
                upBadSmallWater.setAdminDivCode(DataHandUtil.getRegionCode(upBadSmallWater.getCountyid(),3));
            }else{
                upBadSmallWater.setAdminDivCode(DataHandUtil.getRegionCode(upBadSmallWater.getCityId(),2));
            }
            upBadSmallWater.setWaterType(DataHandUtil.getWaterType(upBadSmallWater.getWaterType()));
            String result = CallApiUtil.uploadBadSmallWater(upBadSmallWater);
            if(result.equals("true")){
                System.out.println("true");
                idList.add(upBadSmallWater.getWaterID());
                continue;
            }
            errorList.add(upBadSmallWater);
            System.out.println(result);
        }
        return ReturnT.SUCCESS;
    }
}
