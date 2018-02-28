package com.xxl.job.executor.jobhandler.zhuji;

import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.zhuji.UpWorkLog;
import com.xxl.job.executor.service.first.LogWorkLogService;
import com.xxl.job.executor.utils.DataHandUtil;
import com.xxl.job.executor.utils.StringUtil;
import com.xxl.job.executor.utils.zhuji.UpDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 诸暨-绍兴接口（上报巡河记录）
 * @author liruimin<br>2017/9/28
 * 0 15 9 10 * ?
 * @version 1.8.2
 */
@JobHander(value = "upWorkLogJobHandler")
@Service
public class UpWorkLogJobHandler extends IJobHandler {
    @Autowired
    private LogWorkLogService logWorkLogService;
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        Boolean isFirsmUpload = true;
        Map<String ,Object> map  = new HashMap<String ,Object>();
        map.put("regionId","330681000000");
        map.put("regionLevel","3");
        UpWorkLog upWorkLog = logWorkLogService.getFirstZhujiWorklog(map);
        if(upWorkLog!=null){
            isFirsmUpload = false;
        }
        Map<String,Object> condition = new HashMap<String,Object>();
        List<UpWorkLog> upWorkLogs = null;
        if(isFirsmUpload){
            upWorkLogs = logWorkLogService.getZhuJiWorkLogs(condition);
        }else{
            Date lastUploadtime = upWorkLog.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            upWorkLogs = logWorkLogService.getZhuJiWorkLogs(condition);
        }
            String token = DataHandUtil.getToken();
            List<UpWorkLog> userList = new ArrayList<>();
            List<String> error = new ArrayList<>();
            Date date = new Date();
            int count = 0;
            for (UpWorkLog workLog :upWorkLogs) {
                String result = UpDataUtil.createpatrol(workLog,token);
                XxlJobLogger.log(result);
                if(StringUtil.isNotEmptyStr(result)) {
                    JSONObject res = JSONObject.parseObject(result);
                    if(res.getBoolean("success")){
                        count++;
                        Map<String,Object> param = new HashMap<String,Object>();
                        param.put("uploadtime",date);
                        param.put("srcid",res.getString("patrolid"));
                        param.put("id",workLog.getId());
                        logWorkLogService.update(param);
                }else{
                    result+="   id:"+workLog.getId();
                    error.add(result);
                }
            }
        }
        XxlJobLogger.log(error.toString());
        XxlJobLogger.log("共成功上报"+count+"条巡河记录");
        return ReturnT.SUCCESS;
    }
}
