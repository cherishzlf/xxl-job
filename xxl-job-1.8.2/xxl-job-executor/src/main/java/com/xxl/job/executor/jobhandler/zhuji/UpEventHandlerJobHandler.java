package com.xxl.job.executor.jobhandler.zhuji;

import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.zhuji.UpEvent;
import com.xxl.job.executor.domain.zhuji.UpEventHandler;
import com.xxl.job.executor.domain.zhuji.UpWorkLog;
import com.xxl.job.executor.service.first.EhEventService;
import com.xxl.job.executor.service.first.EhTacheService;
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
@JobHander(value = "upEventHandlerJobHandler")
@Service
public class UpEventHandlerJobHandler extends IJobHandler {
    @Autowired
    private EhTacheService ehTacheService;
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        Boolean isFirsmUpload = true;
        Map<String ,Object> map  = new HashMap<String ,Object>();
        map.put("regionId","330681000000");
        map.put("regionLevel","3");
        Map<String,Object> condition = new HashMap<String,Object>();
        List<UpEventHandler> upEventHandlers = null;
        upEventHandlers = ehTacheService.getZhuJiTache(condition);
            String token = DataHandUtil.getToken();
            List<UpWorkLog> userList = new ArrayList<>();
            List<String> error = new ArrayList<>();
            Date date = new Date();
            for (UpEventHandler upEventHandler :upEventHandlers) {

                String result = UpDataUtil.handleproblem(upEventHandler,token);
                if(StringUtil.isNotEmptyStr(result)) {
                    System.out.println(result);
                    JSONObject res = JSONObject.parseObject(result);
                    if(res.getBoolean("success")){
                    Map<String,Object> param = new HashMap<String,Object>();
                    param.put("uploadtime",date);
                    param.put("srcid",res.getString("handleid"));
                    param.put("id",upEventHandler.getId());
                    ehTacheService.update(param);
                }else{
                    result+="   id:"+upEventHandler.getId();
                    error.add(result);
                }
            }
        }
        XxlJobLogger.log(error.toString());
        return ReturnT.SUCCESS;
    }
}
