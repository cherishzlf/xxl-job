package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.MdSection;
import com.xxl.job.executor.domain.UpRiverSectionWaterQuality;
import com.xxl.job.executor.domain.WaterqualityMonthly;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.service.first.MdSectionService;
import com.xxl.job.executor.service.thrid.impl.WaterQuailtyDao;
import com.xxl.job.executor.utils.CallApiUtil;
import com.xxl.job.executor.utils.DataHandUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/9/29.
 */
@Service
@JobHander(value = "uploadWaterQuailtyJobHandler")
public class UploadWaterQuailtyJobHandler extends IJobHandler {
@Autowired
    private WaterQuailtyDao waterQuailtyDao;
    @Autowired
    private MdSectionService mdSectionService;
    @Autowired
    private MdAdminregionService mdAdminregionService;
    @Override
    /**
     * 断面水质上报服务
     * @param params 参数数组，用逗号隔开(若不加参数，默认为上报金华，衢州，丽水数据)
     * 1、params[0] String region 区域名称 (如金华市) 默认为空
     * 2、params[1] String regionLevel 区域等级 (1：省，2：市，3：县，4：镇，5：村) 默认为空
     * 3、params[2] String 水质上报时间(填入最小时间)
     * @return
     * @throws Exception
     */
    public ReturnT<String> execute(String... params) throws Exception {
        String region = "";
        int regionLevel = 0;
        String regionId = "";
        Date date = null;
        if (params != null && params.length >= 2) {
            region = params[0];
            regionLevel = Integer.parseInt(params[1]);
            Map<String, Object> param = new HashMap<String, Object>();
            param.put("region", region);
            param.put("regionLevel", regionLevel);
            regionId = mdAdminregionService.findByregionName(param);
            if(params.length >2) {
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                date = format.parse(params[2]);
            }
        }
        boolean isFirstUpload = true;
        Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("regionId", regionId);
        condition.put("regionLevel", regionLevel);
        List<MdSection> mdSections =mdSectionService.getUpSectionId(condition);
        List<String> mdSectionId = new ArrayList<String>();
        //如果传进来没有参数。那就传本月的水质数据
        if(date==null){
            date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
            cal.set(Calendar.SECOND, 0);
            cal.set(Calendar.MILLISECOND, 0);
            cal.set(Calendar.DAY_OF_MONTH,1);
            date = cal.getTime();
        }
        for (MdSection mdSection:mdSections) {
            mdSectionId.add(mdSection.getCode());
            List<WaterqualityMonthly> waterqualitys = waterQuailtyDao.findByCode(mdSection.getCode(),date.getTime());
            String result = "true";
            for (WaterqualityMonthly waterqualityMonthly:waterqualitys){
                UpRiverSectionWaterQuality upRiverSectionWaterQuality = DataHandUtil.setUpRiverSectionWaterQuality(waterqualityMonthly,mdSection);
                result = CallApiUtil.uploadRiverSectionWaterQuality(upRiverSectionWaterQuality);
                if (result.equals("true")) {
                    System.out.println(result +"断面code为:"+upRiverSectionWaterQuality.getSectionID());
                    continue;
                }
                XxlJobLogger.log(result);
            }
        }
//        List<WaterqualityMonthly> waterqualitys = waterQuailtyDao.findByCode("05314b9e0de311e689c9008cfae57770");
        return null;
    }
}
