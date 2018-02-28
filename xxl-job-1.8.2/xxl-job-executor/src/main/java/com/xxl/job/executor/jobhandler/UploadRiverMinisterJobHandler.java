package com.xxl.job.executor.jobhandler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.UploadRiverMaster;
import com.xxl.job.executor.domain.UploadRiverMinister;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.service.first.SmUserService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import com.xxl.job.executor.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 上报总河长信息
 * @author liruimin<br>2017/9/8
 * @version 1.8.2
 */
@JobHander(value = "uploadRiverMinisterJobHandler")
@Service
public class UploadRiverMinisterJobHandler extends IJobHandler {
    @Autowired
    private MdAdminregionService mdAdminregionService;
    @Autowired
    private SmUserService smUserService;
    /**
     * 河长信息上报服务
     * @param params 参数数组，用逗号隔开(若不加参数，默认为上报金华，衢州，丽水数据)
     * 1、params[0] String region 区域名称 (如金华市) 默认为空
     * 2、params[1] String regionLevel 区域等级 (1：省，2：市，3：县，4：镇，5：村) 默认为空
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        String region = "";
        Date date = new Date();
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
        List<String> idList = new ArrayList<String>();
        List<UploadRiverMinister> uploadRiverMasters = null;
        List<UploadRiverMinister> errorList = new ArrayList<UploadRiverMinister>();
        //获取总河长
        uploadRiverMasters = smUserService.getUpRiverMinisterList(condition);
        XxlJobLogger.log("查询到:"+uploadRiverMasters.size()+"条");
        for (UploadRiverMinister uploadRiverMinister:uploadRiverMasters) {
            uploadRiverMinister.setUserName(DataHandUtil.getUserNameByCity(uploadRiverMinister.getCityId()));
            Integer ministerLevel = null;
            //根据行政区域获取总河长的等级与行政区域编码

            if (StringUtil.isNotEmptyStr(uploadRiverMinister.getTownId())) {
                ministerLevel = 4;
                uploadRiverMinister.setAdminDivCode(DataHandUtil.getRegionCode(uploadRiverMinister.getTownId(), ministerLevel));
            } else if (StringUtil.isNotEmptyStr(uploadRiverMinister.getCountyId())) {
                ministerLevel = 3;
                uploadRiverMinister.setAdminDivCode(DataHandUtil.getRegionCode(uploadRiverMinister.getCountyId(), ministerLevel));
            } else if (StringUtil.isNotEmptyStr(uploadRiverMinister.getCityId())) {
                ministerLevel = 2;
                uploadRiverMinister.setAdminDivCode(DataHandUtil.getRegionCode(uploadRiverMinister.getCityId(), ministerLevel));
            }
            uploadRiverMinister.setMinisterLevel(DataHandUtil.getMinisterLevel(ministerLevel));
            String result = CallApiUtil.uploadRiverMinister(uploadRiverMinister);
            JSONObject jo = JSON.parseObject(result);
            if (jo != null) {
                if (jo.getBoolean("success") != true) {
                    errorList.add(uploadRiverMinister);
                } else {
                    idList.add(uploadRiverMinister.getMinisterID());
                }
                System.out.println(result);
                XxlJobLogger.log(result);
            } else {
                System.out.println(result);
            }
        }
        XxlJobLogger.log("成功上报:"+idList.size());
        XxlJobLogger.log("上报失败:"+errorList.size());
        XxlJobLogger.log(errorList.toString());
        if(!idList.isEmpty()) {
            Map<String,Object> entity = new HashMap<String, Object>();
            entity.put("uploadtime",date);
            entity.put("idList",idList);
            smUserService.updateUploadtime(entity);
        }
        return ReturnT.SUCCESS;
    }
}
