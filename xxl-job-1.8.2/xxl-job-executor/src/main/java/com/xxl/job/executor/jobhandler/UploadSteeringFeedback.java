package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.UpSteeringFeedback;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.service.first.PmSupervisionService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
//暂时不需要

/**
 * 上报督导单反馈信息
 * 0 15 9 10 * ?
 * @author liruimin<br>2017/9/8
 * @version 1.8.2
 */
@JobHander(value = "uploadSteeringFeedback")
@Service
public class UploadSteeringFeedback extends IJobHandler {
    @Autowired
    private MdAdminregionService mdAdminregionService;
    @Autowired
    private PmSupervisionService pmSupervisionService;
    /**
     * 上报督导单反馈信息
     * @param params 参数数组，用逗号隔开(若不加参数，默认为上报金华，衢州，丽水数据)
     * 1、params[0] String region 区域名称 (如金华市) 默认为空
     * 2、params[1] String regionLevel 区域等级 (1：省，2：市，3：县，4：镇，5：村) 默认为空
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        String region = "";
        int regionLevel = 0;
        String regionId = "";
        if (params != null && params.length >= 2) {
            region = params[0];
            regionLevel = Integer.parseInt(params[1]);
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("region", region);
            param.put("regionLevel", regionLevel);
            regionId = mdAdminregionService.findByregionName(param);
        }
        boolean isFirstUpload = false;
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("regionId", regionId);
        condition.put("regionLevel", regionLevel);
        UpSteeringFeedback firstUpSteeringFeedback = pmSupervisionService.getFirstSection(condition);
        if (firstUpSteeringFeedback == null) {
            isFirstUpload = true;
        }
        List<String> idList = new ArrayList<String>();
        List<UpSteeringFeedback> upSteeringFeedbackList = null;
        List<UpSteeringFeedback> errorList = new ArrayList<UpSteeringFeedback>();

        if (isFirstUpload == true) {
            upSteeringFeedbackList = pmSupervisionService.getUpSteeringFeedbackList(condition);
        }else{
            Date lastUploadtime = firstUpSteeringFeedback.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            upSteeringFeedbackList = pmSupervisionService.getUpSteeringFeedbackList(condition);
        }
        for (UpSteeringFeedback upSteeringFeedback:upSteeringFeedbackList) {
            upSteeringFeedback.setUserName(DataHandUtil.getUserNameByCity(upSteeringFeedback.getCityid()));
            String result = CallApiUtil.uploadSteeringFeedback(upSteeringFeedback);
            if(result.equals("true")){
                System.out.println("上报成功");
                idList.add(upSteeringFeedback.getListID());
                continue;
            }
            errorList.add(upSteeringFeedback);
        }
        Date date = new Date();
        Map<String,Object> entity = new HashMap<String, Object>();
        entity.put("uploadtime",date);
        pmSupervisionService.updateUploadtime(entity,idList);
        XxlJobLogger.log(errorList.toString());
        return ReturnT.SUCCESS;
    }
}
