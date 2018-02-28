package com.xxl.job.executor.jobhandler.zhuji;

import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.constants.UpUserNameConstant;
import com.xxl.job.executor.domain.zhuji.UpUser;
import com.xxl.job.executor.service.first.SmUserService;
import com.xxl.job.executor.utils.DataHandUtil;
import com.xxl.job.executor.utils.Encrypt;
import com.xxl.job.executor.utils.StringUtil;
import com.xxl.job.executor.utils.zhuji.UpDataUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 诸暨-绍兴接口（河长信息上报）
 *
 * @author liruimin<br>2017/9/28
 * @version 1.8.2
 */
@JobHander(value = "userUpJobHandler")
@Service
public class UserUpJobHandler extends IJobHandler {
    @Autowired
    private SmUserService smUserService;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        Boolean isFirsmUpload = true;
        UpUser firstUpUser = smUserService.getFirstUser();
        if (firstUpUser != null) {
            isFirsmUpload = false;
        }
        Map<String, Object> condition = new HashMap<String, Object>();
        List<UpUser> upUsers = null;
        if (isFirsmUpload) {
            upUsers = smUserService.getUpUser(condition);
        } else {
            Date lastUploadtime = firstUpUser.getUploadtime();
            condition.put("uploadtime", lastUploadtime);
            upUsers = smUserService.getUpUser(condition);
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String nowDay = sdf.format(date);
//        String md5Code = MD5.getMD5Code("zhuji123");
//            String token = Encrypt.encrypt(UpUserNameConstant.USERKEY+ Encrypt.encrypt("zhuji123","MD5").toLowerCase()+nowDay,"MD5").toLowerCase();
        String token = DataHandUtil.getToken();
        List<UpUser> userList = new ArrayList<>();
        List<String> error = new ArrayList<>();
        for (UpUser upUser : upUsers) {
            upUser.setAdCode(DataHandUtil.getRegionCode(null, upUser.getCountyid(), upUser.getTownid(), upUser.getVillageid()));
            if (upUser.getType() == null) {
                upUser.setType(DataHandUtil.getRegionLevel(null, upUser.getCountyid(), upUser.getTownid(), upUser.getVillageid()));
            }
            upUser.setType(upUser.getType() - 2);
            if (StringUtil.isEmptyStr(upUser.getPhone())) {
                error.add(upUser.getUserId());
            } else if (upUser.getPhone().startsWith("0")) {
                upUser.setPhone(upUser.getPhone().substring(1));
            }
            String result = UpDataUtil.createuUserApi(upUser, token);
            if (StringUtil.isNotEmptyStr(result)) {
                JSONObject res = JSONObject.parseObject(result);
                if (res.getBoolean("success")) {
                    Map<String, Object> param = new HashMap<String, Object>();
                    param.put("uploadtime", date);
                    param.put("srcid", res.getString("userid"));
                    param.put("id", upUser.getUserId());
                    smUserService.update(param);
                } else {
                    result += "   id:" + upUser.getUserId();
                    error.add(result);
                }
            }
        }
        XxlJobLogger.log(error.toString());
        return ReturnT.SUCCESS;
    }
}
