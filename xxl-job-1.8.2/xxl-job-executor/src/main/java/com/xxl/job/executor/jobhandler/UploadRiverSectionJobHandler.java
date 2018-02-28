package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.UpRiverSection;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.service.first.MdSectionService;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import com.xxl.job.executor.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 上报河道断面服务
 * 0 15 9 10 * ?
 * @author liruimin<br>2017/9/8
 * @version 1.8.2
 */
@JobHander(value = "uploadRiverSection")
@Service
public class UploadRiverSectionJobHandler extends IJobHandler {
    @Autowired
    private MdAdminregionService mdAdminregionService;
    @Autowired
    private MdSectionService mdSectionService;
    /**
     * 上报河道断面服务
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
        UpRiverSection firstUpSection = mdSectionService.getFirstSection(condition);
        if (firstUpSection == null) {
            isFirstUpload = true;
        }
        List<String> idList = new ArrayList<String>();
        List<UpRiverSection> upRiverSections = null;
        List<UpRiverSection> errorList = new ArrayList<UpRiverSection>();

        if (isFirstUpload == true) {
            upRiverSections = mdSectionService.getUpSectionList(condition);
        }else{
            Date lastUploadtime = firstUpSection.getUploadtime();
            condition.put("uploadtime",lastUploadtime);
            upRiverSections = mdSectionService.getUpSectionList(condition);
        }
        for (UpRiverSection upRiverSection:upRiverSections) {
            upRiverSection.setUserName(DataHandUtil.getUserNameByCity(upRiverSection.getCityId()));
            upRiverSection.setAdminDivCode(DataHandUtil.getRegionCode(upRiverSection.getCityId(),upRiverSection.getCountyId(),upRiverSection.getTownId(),null));
            upRiverSection.setSectionType(DataHandUtil.getSectionType(upRiverSection.getSectionType()));
            if(StringUtil.isNotEmptyStr(upRiverSection.getTargetWaterQuality())) {
                upRiverSection.setTargetWaterQuality(DataHandUtil.getTargetWaterQuality(Integer.valueOf(upRiverSection.getTargetWaterQuality()==null?"0":upRiverSection.getTargetWaterQuality())));
            }
            upRiverSection.setBadVIndex(DataHandUtil.getBadVIndex(upRiverSection.getBadVIndex()));
            String result = CallApiUtil.uploadRiverSection(upRiverSection);
            if(result.equals("true")){
                System.out.println("上报成功");
                idList.add(upRiverSection.getSectionID());
                continue;
            }
            errorList.add(upRiverSection);
        }
        XxlJobLogger.log(errorList.toString());

        Map<String,Object> entity = new HashMap<String, Object>();
        entity.put("uploadtime",date);
        entity.put("idList",idList);
        mdSectionService.updateUploadtime(entity);
        return ReturnT.SUCCESS;
    }
}
