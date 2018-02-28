package com.xxl.job.executor.jobhandler;

import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.ExeAssChairmanElectronic;
import com.xxl.job.executor.service.first.ExeAssChairmanElectronicService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import com.xxl.job.executor.utils.Encrypt;
import com.xxl.job.executor.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 上报电子化考核结果
 * 0 15 9 10 * ?
 * @author liruimin<br>2017/9/7
 * @version 1.8.2
 */
@JobHander(value = "uploadPurposeCheckJobHandler")
@Service
public class UploadPurposeCheckJobHandler extends IJobHandler {
    @Autowired
    private ExeAssChairmanElectronicService exeAssChairmanElectronicService;
    /**
     * 上报目标考核结果
     * @param params 参数数组，不传参数默认为本年本月
     * 1、params[0] String year 年
     * 2、params[1] String month 月
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        String region = "";
        int regionLevel=0;
        String regionId ="";
        Date uploadtime = new Date();
        Map condition = new HashMap();
        if(params!=null && params.length==2) {
            String assessTime = params[0]+'-'+params[1];
            condition.put("assessTime",assessTime);
        }
        if(condition.isEmpty()){
            Calendar cal = Calendar.getInstance();
            String assessTime = cal.get(Calendar.YEAR)+'-'+String.valueOf(cal.get(Calendar.MONTH));
            condition.put("assessTime",assessTime);
        }
        List<ExeAssChairmanElectronic> exeAssChairmanElectronics = exeAssChairmanElectronicService.getPurposeCheck(condition);
        List<ExeAssChairmanElectronic> idList = new ArrayList<>();
        List<String> errorList = new ArrayList<>();
        for (ExeAssChairmanElectronic exeAssChairmanElectronic:exeAssChairmanElectronics) {
            exeAssChairmanElectronic.setPlatformName(DataHandUtil.getUserNameByCity(exeAssChairmanElectronic.getCityid().toString()));
            //时间格式是2017-10
            String[] time = exeAssChairmanElectronic.getAssesstime().split("-");
            String year = time[0];
            String month = time[1];
            if(StringUtil.isEmptyStr(exeAssChairmanElectronic.getUploadcode())){
                String code = Encrypt.encrypt(exeAssChairmanElectronic.getChairmanid()+exeAssChairmanElectronic.getAssesstime(),"MD5");
                exeAssChairmanElectronic.setUploadcode(code);
            }
            String result = CallApiUtil.uploadPurposeCheck(exeAssChairmanElectronic,year,month);
            XxlJobLogger.log(result);
            try {
                JSONObject res = JSONObject.parseObject(result);
                if (res.getBoolean("success").toString().equals("true")) {
                    System.out.println("true");
                    idList.add(exeAssChairmanElectronic);
                    continue;
                }
                errorList.add("id:"+exeAssChairmanElectronic.getId()+result);
            }catch (Exception e){
                XxlJobLogger.log(e.toString());
                continue;
            }
        }
        XxlJobLogger.log(errorList.toString());
        if(!idList.isEmpty()) {
            Map<String, Object> entity = new HashMap<String, Object>();
            entity.put("idList", idList);
            entity.put("uploadtime", uploadtime);
            exeAssChairmanElectronicService.updateUploadByIdList(entity);
        }
        return ReturnT.SUCCESS;
    }
}
