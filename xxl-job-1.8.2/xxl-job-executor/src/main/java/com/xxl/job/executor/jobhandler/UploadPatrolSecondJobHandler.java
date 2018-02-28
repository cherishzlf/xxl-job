package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.UpParolerecord;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.service.first.MdLocusrecordService;
import com.xxl.job.executor.service.second.MdAdminregionSecondService;
import com.xxl.job.executor.service.second.MdLocusrecordSecondService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 巡查上报服务(指向嘉兴区县中间库)临时使用，后期删除
 * 0 15 9 10 * ?
 * @author liruimin<br>2017/9/7
 * @version 1.8.2
 */
@JobHander(value = "uploadPatrolSecondJobHandler")
@Service
public class UploadPatrolSecondJobHandler extends IJobHandler {
    /**
     * 巡查上报服务
     * @param params 参数数组，用逗号隔开(若不加参数，默认为上报金华，衢州，丽水数据)
     * 1、params[0] String region 区域名称 (如金华市) 默认为空
     * 2、params[1] String regionLevel 区域等级 (1：省，2：市，3：县，4：镇，5：村) 默认为空
     * @return
     * @throws Exception
     */
    @Autowired
    private MdLocusrecordSecondService mdLocusrecordSecondService;
    @Autowired
    private MdAdminregionSecondService mdAdminregionSecondService;
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
            regionId = mdAdminregionSecondService.findByregionName(param);
        }
        boolean isFirstUpload = false;
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("regionId", regionId);
        condition.put("regionLevel", regionLevel);
        UpParolerecord firstUpParolerecord = mdLocusrecordSecondService.getFirstParolerecord(condition);
        if (firstUpParolerecord == null) {
            isFirstUpload = true;
        }
        List<String> idList = new ArrayList<String>();
        List<UpParolerecord> mdLocusrecordVOList = null;
        List<UpParolerecord> upload = new ArrayList<UpParolerecord>();
        List<UpParolerecord> errorList = new ArrayList<UpParolerecord>();
        Date nowdate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(nowdate);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        nowdate = calendar.getTime();
        condition.put("date",nowdate);
        if (isFirstUpload == true) {
            mdLocusrecordVOList = mdLocusrecordSecondService.getLocusrecordForUpload(condition);
        }else{
            Date lastUploadtime = firstUpParolerecord.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            mdLocusrecordVOList = mdLocusrecordSecondService.getLocusrecordForUpload(condition);
        }
        for (UpParolerecord upParolerecord : mdLocusrecordVOList) {
            upParolerecord.setUserName(DataHandUtil.getUserNameByCity(upParolerecord.getCityId()));
            if(upParolerecord.getUserName()==null){
                continue;
            }
            //省里单位是千米
            upParolerecord.setLength(upParolerecord.getLength()/1000);
            boolean send=false;
            String result = "";
            while(send==false) {
                result = CallApiUtil.uploadPatrol(upParolerecord);
                if(!result.contains("Runtime")){
                    send=true;
                }
            }
            if (result.equals("true")) {
                System.out.println(result);
                upload.add(upParolerecord);
                continue;
            }
            errorList.add(upParolerecord);
        }
        for (UpParolerecord upParolerecord:upload) {
            String result = "";
            upParolerecord.setUserName(DataHandUtil.getUserNameByCity(upParolerecord.getCityId()));
            result =  CallApiUtil.upDatePatrol(upParolerecord);
            if (result.equals("true")) {
                System.out.println(result);
                idList.add(upParolerecord.getPatrolID());
                continue;
            }
            errorList.add(upParolerecord);
        }
         Date date = new Date();
        Map<String,Object> entity = new HashMap<String, Object>();
        entity.put("uploadtime",date);
        entity.put("idList",idList);
        mdLocusrecordSecondService.updateUploadtime(entity);
        XxlJobLogger.log(errorList.toString());
        return ReturnT.SUCCESS;
    }
}
