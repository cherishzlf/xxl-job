package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.UploadRiverMaster;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.service.first.SmUserService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 河长信息上报服务
 * 0 15 9 10 * ?
 * @author liruimin<br>2017/9/8
 * @version 1.8.2
 */
@JobHander(value = "uploadRiverMasterJobHandler")
@Service
public class UploadRiverMasterJobHandler extends IJobHandler {
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
        UploadRiverMaster firstUpMaster = smUserService.getFirstMaster(condition);
        if (firstUpMaster == null) {
            isFirstUpload = true;
        }
        List<String> idList = new ArrayList<String>();
        List<UploadRiverMaster> uploadRiverMasters = null;
        List<UploadRiverMaster> errorList = new ArrayList<UploadRiverMaster>();

                if (isFirstUpload == true) {
                    uploadRiverMasters = smUserService.getUpMasterList(condition);
                }else{
                    Date lastUploadtime = firstUpMaster.getUploadtime();
                    condition.put("uploadtime",lastUploadtime);
                    uploadRiverMasters = smUserService.getUpMasterList(condition);
                }
                for (UploadRiverMaster uploadRiverMaster:uploadRiverMasters) {
                    uploadRiverMaster.setUserName(DataHandUtil.getUserNameByCity(uploadRiverMaster.getCityId()));
                    uploadRiverMaster.setMasterLevel(DataHandUtil.getUserLevel(uploadRiverMaster.getChairmanLevel()));
                    String result = CallApiUtil.uploadRiverMaster(uploadRiverMaster);
                    if(result.equals("true")){
                        System.out.println("上报成功");
                idList.add(uploadRiverMaster.getMasterID());
                continue;
            }
            errorList.add(uploadRiverMaster);
        }
        XxlJobLogger.log(errorList.toString());

        Map<String,Object> entity = new HashMap<String, Object>();
        entity.put("uploadtime",date);
        entity.put("idList",idList);
        smUserService.updateUploadtime(entity);
        return ReturnT.SUCCESS;
    }
}
