package com.xxl.job.executor.jobhandler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.*;
import com.xxl.job.executor.service.first.*;
import com.xxl.job.executor.utils.Encrypt;
import com.xxl.job.executor.vo.ExeAssElectronicVO;
import com.xxl.job.executor.vo.SmUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 河长履职电子考核执行器
 *
 * @author xu_zhu<br>2017/10/26 11:19.
 */
@Service
@JobHander(value = "exeAssChairmanElectronicHandler")
public class ExeAssChairmanElectronicHandler extends IJobHandler {

    @Autowired
    private ExeAssElectronicService exeAssElectronicService;

    @Autowired
    private AmTemplateElectronicService amTemplateElectronicService;

    @Autowired
    private AmTemplateSpecialService amTemplateSpecialService;

    @Autowired
    private AmTemplateSpecialScoreService amTemplateSpecialScoreService;

    @Autowired
    private ExeAssChairmanElectronicService exeAssChairmanElectronicService;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        try {
            //获取电子化考核模板主键
            String amTemplateElectronicId = params[0];
            //获取特色考核模板主键id
            String amSpecialTemplateElectronicId = params[1];
            //考核日期
            String assessTime = getCurrentYearAndMonth();
            //删除本月已统计的河长考核分数数据
            exeAssChairmanElectronicService.deleteByAssessTime(assessTime);
            //删除本月已统计河长考核特色分数
            amTemplateSpecialScoreService.removeByAssessTime(assessTime);
            //获取电子化考核分数模板
            AmTemplateElectronic amTemplateElectronic = amTemplateElectronicService.getById(amTemplateElectronicId);

            //通过考核日期获取所有考核用户id
            List<String> userIdList = exeAssElectronicService.findUserIdByAssessTime(assessTime);
            for (String userId : userIdList) {
                //通过用户id与考核日期查询本月河长考核分数
                Map<String, String> maps = new HashMap<>();
                maps.put("userId", userId);
                maps.put("assessTime", assessTime);
                List<ExeAssElectronic> exeAssElectronic = exeAssElectronicService.findByUserIdAndAssessTime(maps);
                insertExeAssChairmanElectronic(exeAssElectronic, amSpecialTemplateElectronicId, assessTime, amTemplateElectronic);
                XxlJobLogger.log(">>> SUCCESS");
            }

            for (int i = 0; i < 5; i++) {
                XxlJobLogger.log("beat at:" + i);
                TimeUnit.SECONDS.sleep(2);
            }
            return ReturnT.SUCCESS;
        } catch (Exception e) {
            XxlJobLogger.log(">>> FAIL");
            XxlJobLogger.log("Exception:===========>\r" + e.getMessage());
            return ReturnT.FAIL;
        }
    }


    /**
     * 获取本月日期: yyyy-MM
     *
     * @author xu_zhu<br/> 2017/11/23 9:54
     */
    private String getCurrentYearAndMonth() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();

        return simpleDateFormat.format(calendar.getTime());
    }


    /**
     * 遍历List取相同列分数的总分数取平均值
     *
     * @return
     * @params
     * @author xu_zhu<br/> 2017/11/23 10:19
     */
    private void insertExeAssChairmanElectronic(List<ExeAssElectronic> exeAssElectronic,
                                                String amSpecialTemplateElectronicId,
                                                String assessTime,
                                                AmTemplateElectronic amTemplateElectronic) {

        String chairmanId = null;//用户id
        String chairmanName = null;//用户姓名
        int chairmanLevel = 0;//用户级别
        int basicInformationScore = 0;//基本信息总分数
        int patrolStandardInformationScore = 0;//巡查达标总分数
        int patrolRiverRecordScore = 0;//巡查记录总分数
        int validPatrolRiverTrackScore = 0;//巡查轨迹总分数
        int eventDisposeScore = 0;//问题处置总分数
        int additionItemScore = 0;//附加项、超额完成总分数
        long provinceId = 0;
        long cityId = 0;
        long countyId = 0;
        long townId = 0;
        long villageId = 0;
        for (ExeAssElectronic assElectronic : exeAssElectronic) {
            chairmanId = chairmanId == null ? assElectronic.getUserId() : chairmanId;
            chairmanName = chairmanName == null ? assElectronic.getUserName() : chairmanName;
            chairmanLevel = chairmanLevel == 0 ? assElectronic.getRegionLevel() : chairmanLevel;
            basicInformationScore += assElectronic.getBasicInformationScore();
            patrolStandardInformationScore += assElectronic.getPatrolStandardInformationScore();
            patrolRiverRecordScore += assElectronic.getPatrolRiverRecordScore();
            validPatrolRiverTrackScore += assElectronic.getValidPatrolRiverTrackScore();
            eventDisposeScore += assElectronic.getEventDisposeScore();
            additionItemScore += assElectronic.getAdditionItemScore();

            if (assElectronic.getProvinceId() != null && !assElectronic.getProvinceId().equals("null")) {
                provinceId = provinceId == 0 ? Long.valueOf(assElectronic.getProvinceId()) : provinceId;
            }
            if (assElectronic.getCityId() != null && !assElectronic.getCityId().equals("null")) {
                cityId = cityId == 0 ? Long.valueOf(assElectronic.getCityId()) : cityId;
            }
            if (assElectronic.getCountyId() != null && !assElectronic.getCountyId().equals("null")) {
                countyId = countyId == 0 ? Long.valueOf(assElectronic.getCountyId()) : countyId;
            }
            if (assElectronic.getTownId() != null && !assElectronic.getTownId().equals("null")) {
                townId = townId == 0 ? Long.valueOf(assElectronic.getTownId()) : townId;
            }
            if (assElectronic.getVillageId() != null && !assElectronic.getVillageId().equals("null")) {
                villageId = villageId == 0 ? Long.valueOf(assElectronic.getVillageId()) : villageId;
            }
        }

        //所有分数四舍五入取整
        int listSize = exeAssElectronic.size();
        basicInformationScore = (int) Math.rint((float) basicInformationScore / listSize);
        patrolStandardInformationScore = (int) Math.rint((float) patrolStandardInformationScore / listSize);
        patrolRiverRecordScore = (int) Math.rint((float) patrolRiverRecordScore / listSize);
        validPatrolRiverTrackScore = (int) Math.rint((float) validPatrolRiverTrackScore / listSize);
        eventDisposeScore = (int) Math.rint((float) eventDisposeScore / listSize);
        additionItemScore = additionItemScore > amTemplateElectronic.getMaxadditionitem() ? amTemplateElectronic.getMaxadditionitem() : additionItemScore;

        Map<String, String> maps = new HashMap<>();
        maps.put("id", amSpecialTemplateElectronicId);
        int specialScore = amTemplateSpecialService.getById(maps).getScore();

        int totalScore = basicInformationScore + patrolStandardInformationScore + patrolRiverRecordScore + validPatrolRiverTrackScore + eventDisposeScore + additionItemScore + specialScore;

        ExeAssChairmanElectronic exeAssChairmanElectronic = new ExeAssChairmanElectronic();
        exeAssChairmanElectronic.setChairmanid(chairmanId);
        exeAssChairmanElectronic.setChairmanname(chairmanName);
        exeAssChairmanElectronic.setChairmanlevel(chairmanLevel);
        exeAssChairmanElectronic.setBasicinformationscore(basicInformationScore);
        exeAssChairmanElectronic.setPatrolstandardinformationscore(patrolStandardInformationScore);
        exeAssChairmanElectronic.setPatrolriverrecordscore(patrolRiverRecordScore);
        exeAssChairmanElectronic.setValidpatrolrivertrackscore(validPatrolRiverTrackScore);
        exeAssChairmanElectronic.setAdditionitemscore(additionItemScore);
        exeAssChairmanElectronic.setEventdisposescore(eventDisposeScore);
        exeAssChairmanElectronic.setSpecialscore(specialScore);
        exeAssChairmanElectronic.setTotalscore(totalScore);
        exeAssChairmanElectronic.setProvinceid(provinceId);
        exeAssChairmanElectronic.setCityid(cityId);
        exeAssChairmanElectronic.setCountyid(countyId);
        exeAssChairmanElectronic.setTownid(townId);
        exeAssChairmanElectronic.setVillageid(villageId);
        exeAssChairmanElectronic.setAssesstime(assessTime);
        exeAssChairmanElectronic.setCreatetime(new Date());
        exeAssChairmanElectronic.setUploadcode(Encrypt.encrypt(exeAssChairmanElectronic.getChairmanid()+exeAssChairmanElectronic.getAssesstime(),"MD5"));

        XxlJobLogger.log("insert a NEW data: chairmanName: " + exeAssChairmanElectronic.getChairmanname() + "... totalScore: " + totalScore + " >>>");

        Map<String, Object> map = new HashMap<>();
        map.put("entity", exeAssChairmanElectronic);
        exeAssChairmanElectronicService.insert(map);

        getamTemplateSpecial(chairmanId, assessTime, chairmanLevel, amSpecialTemplateElectronicId);
    }

    /**
     * 新增特色考核分数
     * @param
     * @return
     * @author xu_zhu<br/> 2017/12/14 10:28
     */
    private void getamTemplateSpecial(String chairmanId,
                                    String assessTime,
                                    int chairmanLevel,
                                    String amSpecialTemplateElectronicId){

        List<AmTemplateSpecial> amTemplateSpecialList = amTemplateSpecialService.findSpecialTemplateByParentPk(amSpecialTemplateElectronicId);
        for (AmTemplateSpecial amTemplateSpecial : amTemplateSpecialList) {
            insertSpecialScore(chairmanId, assessTime, chairmanLevel, amTemplateSpecial);
            List<AmTemplateSpecial> amTemplateSpecialList1 = amTemplateSpecialService.findSpecialTemplateByParentPk(amTemplateSpecial.getId());
            for (AmTemplateSpecial templateSpecial : amTemplateSpecialList1) {
                insertSpecialScore(chairmanId, assessTime, chairmanLevel, templateSpecial);
            }
        }
    }

    private void insertSpecialScore(String chairmanId,
                                    String assessTime,
                                    int chairmanLevel,
                                    AmTemplateSpecial amTemplateSpecial){

        boolean isMinorTerm = false;
        String parentId = amTemplateSpecial.getParentid();
        if (parentId.lastIndexOf("|") > 33)
            isMinorTerm = true;

        AmTemplateSpecialScore amTemplateSpecialScore = new AmTemplateSpecialScore();
        amTemplateSpecialScore.setChairmanaeeseeid(chairmanId);
        amTemplateSpecialScore.setTitle(amTemplateSpecial.getName());
        amTemplateSpecialScore.setTermparentsid(amTemplateSpecial.getParentid());
        amTemplateSpecialScore.setScoretype(1);
        amTemplateSpecialScore.setScore(amTemplateSpecial.getScore());
        amTemplateSpecialScore.setAssesstime(assessTime);
        amTemplateSpecialScore.setCreatetime(new Date());
        amTemplateSpecialScore.setDescription(amTemplateSpecial.getDescription());

        if (isMinorTerm){
            int singleScore = 0;
            if (chairmanLevel == 3){
                singleScore = amTemplateSpecial.getCountyscore();
            } else if (chairmanLevel == 4){
                singleScore = amTemplateSpecial.getTownscore();
            } else if (chairmanLevel == 5){
                singleScore = amTemplateSpecial.getVillagescore();
            }
            amTemplateSpecialScore.setSinglescore(singleScore);
            int times = (int) Math.ceil((double)amTemplateSpecialScore.getScore()/singleScore);
            amTemplateSpecialScore.setScoretimes(times);
            amTemplateSpecialScore.setMinortermid(amTemplateSpecial.getId());
        } else
            amTemplateSpecialScore.setMajortermid(amTemplateSpecial.getId());

        Map<String, Object> entity = new HashMap<>();
        entity.put("entity", amTemplateSpecialScore);

        amTemplateSpecialScoreService.insert(entity);
    }
}