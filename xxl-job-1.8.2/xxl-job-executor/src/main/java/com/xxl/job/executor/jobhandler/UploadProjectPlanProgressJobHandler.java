package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.UpProPlanProgress;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.service.first.PmProjectProgressService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 项目计划进展上报
 * 0 15 9 10 * ?
 * @author liruimin<br>2017/9/13
 * @version 1.8.2
 */
@JobHander(value = "uploadProjectPlanProgressJobHandler")
@Service
public class UploadProjectPlanProgressJobHandler extends IJobHandler {
    @Autowired
    private MdAdminregionService mdAdminregionService;
    @Autowired
    private PmProjectProgressService pmProjectProgressService;
    /**
     * 上报重点项目计划进展服务
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
        UpProPlanProgress firstUpProjectProgress = pmProjectProgressService.getFirstProjectProgress(condition);
        if (firstUpProjectProgress == null) {
            isFirstUpload = true;
        }
        List<String> idList = new ArrayList<String>();
        List<UpProPlanProgress> upProjectProgressList = null;
        List<UpProPlanProgress> errorList = new ArrayList<UpProPlanProgress>();

        if (isFirstUpload == true) {
            upProjectProgressList = pmProjectProgressService.getUpProjectProgressList(condition);
        }else{
            Date lastUploadtime = firstUpProjectProgress.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            upProjectProgressList = pmProjectProgressService.getUpProjectProgressList(condition);
        }
        Calendar calendar=Calendar.getInstance();
        for (UpProPlanProgress upProPlanProgress:upProjectProgressList) {
            upProPlanProgress.setUserName(DataHandUtil.getUserNameByCity(upProPlanProgress.getCityId()));
            upProPlanProgress.setProjectStatus(DataHandUtil.getProStatus(upProPlanProgress.getProjectStatus()));
            upProPlanProgress.setReportMonth(calendar.get(Calendar.MONTH));
            String result = CallApiUtil.uploadProjectPlanProgress(upProPlanProgress);
            if(result.equals("true")){
                System.out.println("上报成功");
                idList.add(upProPlanProgress.getProgressID());
                continue;
            }
            errorList.add(upProPlanProgress);
        }
        Date date = new Date();
        Map<String,Object> entity = new HashMap<String, Object>();
        entity.put("uploadtime",date);
        pmProjectProgressService.updateUploadtime(entity,idList);
        XxlJobLogger.log(errorList.toString());
        return ReturnT.SUCCESS;
    }
}
