package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.MdAdminregion;
import com.xxl.job.executor.domain.UpReach;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.service.first.MdReachService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import com.xxl.job.executor.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 上报河道信息服务
 * @author liruimin<br>2017/9/7
 * @version 1.8.2
 */
@JobHander(value = "uploadReachJobHandler")
@Service

public class UploadReachJobHandler extends IJobHandler {
    @Autowired
    private MdAdminregionService mdAdminregionService;
    @Autowired
    private MdReachService mdReachService;
    /**
     * 上报河道信息服务
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
        UpReach firstUpReach = mdReachService.getFirstReach(condition);
        if (firstUpReach == null) {
            isFirstUpload = true;
        }
        List<String> idList = new ArrayList<String>();
        List<UpReach> reaches = null;
        List<UpReach> errorList = new ArrayList<UpReach>();

        if (isFirstUpload == true) {
            reaches = mdReachService.getUpReachList(condition);
        }else{
            Date lastUploadtime = firstUpReach.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            reaches = mdReachService.getUpReachList(condition);
        }
        for (UpReach reach:reaches) {
            reach.setUserName(DataHandUtil.getUserNameByCity(reach.getCityId()));
            if(reach.getUserName().equals("jxpt")&&reach.getBasinCode()==null){
                reach.setBasinCode("运河");
            }
            reach.setRiverType(DataHandUtil.getReachType(reach.getReachLevel()));
            reach.setBasinCode(DataHandUtil.getBasin(reach.getBasinCode()));
            reach.setAdminDivCode(DataHandUtil.getRegionCode(reach));
            if(StringUtil.isNotEmptyStr(reach.getLength())) {
                if (reach.getLength().contains("-") || reach.getLength().contains("—")) {
                    reach.setLength("0");
                }
            }else{
                reach.setLength("0");
            }

            if(reach.getReachLevel()>3){
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", reach.getTownId());
                MdAdminregion mdAdminregion = mdAdminregionService.getRegionById(map);
                if(mdAdminregion!=null){
                    reach.setTownName(mdAdminregion.getName());
                }
            }
            if(reach.getParents().indexOf("|")>-1&&reach.getReachLevel()>2) {
                List<String> parent = Arrays.asList(reach.getParents().split("\\|"));

                if (parent.size() >= 2) {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("id", parent.get(parent.size() - 2));
                    String a = mdReachService.getinvented(map);
                    if (StringUtil.isNotEmptyStr(a)) {
                        if (!a.contains("虚拟")) {
                            reach.setParentID(parent.get(parent.size() - 2));
                        }
                    }else {
                        reach.setParentID(parent.get(parent.size() - 2));
                    }
                }
            }
            if(StringUtil.isEmptyStr(reach.getRiverAlias())){
                reach.setRiverAlias(reach.getRiverName());
            }
            if(reach.getUserName()==null){
                continue;
            }
            String result = CallApiUtil.uploadReach(reach);
            if(result.contains("未找到上级河流")){
                reach.setParentID(null);
                result = CallApiUtil.uploadReach(reach);
            }
            if("true".equals(result)){
                idList.add(reach.getRiverID());
                continue;
            }
            errorList.add(reach);
        }

        XxlJobLogger.log(errorList.toString());
        XxlJobLogger.log("\n成功上报："+idList.size());
        if(!idList.isEmpty()) {
            Map<String, Object> entity = new HashMap<String, Object>();
            entity.put("uploadtime", date);
            entity.put("idList", idList);
            mdReachService.updateByIdList(entity);
        }
        return ReturnT.SUCCESS;
    }
}
