package com.xxl.job.executor.jobhandler.zhuji;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.zhuji.UpPatrol;
import com.xxl.job.executor.service.first.MdLocusrecordService;
import com.xxl.job.executor.utils.DataHandUtil;
import com.xxl.job.executor.utils.StringUtil;
import com.xxl.job.executor.utils.zhuji.UpDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 诸暨-绍兴接口（上报巡河轨迹）
 * @author liruimin<br>2017/9/28
 * 0 15 9 10 * ?
 * @version 1.8.2
 */
@JobHander(value = "upTrackJobHandler")
@Service
public class UpTrackJobHandler extends IJobHandler {
    @Autowired
    private MdLocusrecordService mdLocusrecordService;
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        Boolean isFirsmUpload = true;
        Map<String ,Object> map  = new HashMap<String ,Object>();
        map.put("regionId","330681000000");
        map.put("regionLevel","3");
        UpPatrol firstUpPatrol = mdLocusrecordService.getFirstZhujiTrack(map);
        if(firstUpPatrol!=null){
            isFirsmUpload = false;
        }
        Map<String,Object> condition = new HashMap<String,Object>();
        List<UpPatrol> upPatrols = null;
        if(isFirsmUpload){
            upPatrols = mdLocusrecordService.getZhuJiTrack(condition);
        }else{
            Date lastUploadtime = firstUpPatrol.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            upPatrols = mdLocusrecordService.getZhuJiTrack(condition);
        }
            String token = DataHandUtil.getToken();
            List<UpPatrol> userList = new ArrayList<>();
            List<String> error = new ArrayList<>();
            Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (UpPatrol upPatrol :upPatrols) {
                upPatrol.setMap("wgps84");
                JSONArray jsondata = JSONArray.parseArray(upPatrol.getJsondata());
                JSONArray patrol = new JSONArray();
                int num = jsondata.size()/500+1;
                for(int i =0;i<jsondata.size();i+=num){
                    JSONObject jo = JSONObject.parseObject(jsondata.getString(i));
                    JSONObject json = new JSONObject();
                    json.put("lng",jo.get("x"));
                    json.put("lat",jo.get("y"));
                    json.put("createtime",sdf.format(new Date(jo.getLong("t"))));
                    patrol.add(json);
                }
                //最后一个点的坐标
                JSONObject jo = JSONObject.parseObject(jsondata.getString(jsondata.size()-1));
                JSONObject json = new JSONObject();
                json.put("lng",jo.get("x"));
                json.put("lat",jo.get("y"));
                json.put("createtime",sdf.format(new Date(jo.getLong("t"))));
                patrol.add(json);
            System.out.println("解析结束，共"+patrol.size()+"个点。正在上报...");
//                patrol.add(jsondata.getString(jsondata.size()-1));
                upPatrol.setJsondata(patrol.toJSONString());
                String result = UpDataUtil.createtrack(upPatrol,token);
            System.out.println(result);
            XxlJobLogger.log(result);
                if(StringUtil.isNotEmptyStr(result)) {
                    JSONObject res = JSONObject.parseObject(result);
                    if(res.getBoolean("success")){
                        Map<String,Object> param = new HashMap<String,Object>();
                    param.put("uploadtime",date);
                    param.put("id",upPatrol.getId());
                    mdLocusrecordService.update(param);
                }else{
                    result+="   id:"+upPatrol.getId();
                    error.add(result);
                }
            }
        }
        XxlJobLogger.log(error.toString());

        return ReturnT.SUCCESS;
    }
}
