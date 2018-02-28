package com.xxl.job.executor.jobhandler.zhuji;

import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.constants.zhuji.BasinTypeConstant;
import com.xxl.job.executor.domain.zhuji.UploadReach;
import com.xxl.job.executor.enums.zhuji.DataTypeEnum;
import com.xxl.job.executor.service.first.MdReachService;
import com.xxl.job.executor.utils.DataHandUtil;
import com.xxl.job.executor.utils.StringUtil;
import com.xxl.job.executor.utils.zhuji.UpDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * 诸暨-绍兴接口（河长信息上报）
 * @author liruimin<br>2017/9/28
 * @version 1.8.2
 */
@JobHander(value = "reachUpJobHandler")
@Service
public class ReachUpJobHandler extends IJobHandler {
    @Autowired
    private MdReachService mdReachService;
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        Boolean isFirsmUpload = true;
        Map<String ,Object> map  = new HashMap<String ,Object>();
        map.put("regionId","330681000000");
        map.put("regionLevel","3");
        UploadReach uploadReach = mdReachService.getFirstZhujiReach(map);
        if(uploadReach!=null){
//            isFirsmUpload = false;
        }
        Map<String,Object> condition = new HashMap<String,Object>();
        List<UploadReach> uploadReaches = null;
        if(isFirsmUpload){
            uploadReaches = mdReachService.getZhuJiReach(condition);
        }else{
            Date lastUploadtime = uploadReach.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            uploadReaches = mdReachService.getZhuJiReach(condition);
        }
            String token = DataHandUtil.getToken();
            List<UploadReach> userList = new ArrayList<>();
            List<String> error = new ArrayList<>();
            Date date = new Date();
            for (UploadReach reach :uploadReaches) {
                reach.setAdCode(DataHandUtil.getRegionCode(null,reach.getCountyid(),reach.getTownid(),reach.getVillageid()));
                //设置流域为钱塘江流域
                reach.setBasin(BasinTypeConstant.QIANTANGJIANG);
                //设置数据类型为河道
                reach.setDataType(DataTypeEnum.REACH.getCode());
                //长度有时候有些问题，处理成0
                if(reach.getLength()!=null) {
                    if (reach.getLength().contains("-") || reach.getLength().contains("—")|| reach.getLength().equals("")) {
                        reach.setLength("0");
                    }
                }
                //绍兴的单位是米
                reach.setLength(String.valueOf(Double.valueOf(reach.getLength())*1000));
                reach.setRiverType(DataHandUtil.getRiverTypeCode(reach.getReachLevel()));
                String result = UpDataUtil.createriver(reach,token);
                if(StringUtil.isNotEmptyStr(result)) {
                    JSONObject res = JSONObject.parseObject(result);
                    if(res.getBoolean("success")){
                        Map<String,Object> param = new HashMap<String,Object>();
                    param.put("uploadtime",date);
                    param.put("srcid",res.getString("riverid"));
                    param.put("id",reach.getRiverId());
                    mdReachService.update(param);
                        System.out.println(res);
                        XxlJobLogger.log(res.toJSONString());
                }else{
                        result+="   id:"+reach.getRiverId();
                        System.out.println(result);
                        error.add(result);
                        XxlJobLogger.log(res.toJSONString());
                }
            }
        }
        XxlJobLogger.log(error.toString());
        return ReturnT.SUCCESS;
    }

}
