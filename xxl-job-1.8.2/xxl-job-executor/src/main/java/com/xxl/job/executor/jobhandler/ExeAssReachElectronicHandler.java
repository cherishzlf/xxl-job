package com.xxl.job.executor.jobhandler;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.AmTemplateElectronic;
import com.xxl.job.executor.domain.ExeAssElectronic;
import com.xxl.job.executor.service.first.AmTemplateElectronicService;
import com.xxl.job.executor.service.first.ExeAssElectronicService;
import com.xxl.job.executor.service.first.SmUserService;
import com.xxl.job.executor.utils.StringUtil;
import com.xxl.job.executor.vo.ExeAssElectronicVO;
import com.xxl.job.executor.vo.SmUserVO;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
@JobHander(value = "exeAssReachElectronicHandler")
public class ExeAssReachElectronicHandler extends IJobHandler {

    @Autowired
    private SmUserService smUserService;

    @Autowired
    private ExeAssElectronicService exeAssElectronicService;

    @Autowired
    private AmTemplateElectronicService amTemplateElectronicService;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        try {
            //考核时间
            String assessTime = getCurrentYearAndMonth();
            //获取电子化考核模板主键
            String amTemplateElectronicId = params[0];
            //获取电子化考核分数模板
            AmTemplateElectronic amTemplateElectronic = amTemplateElectronicService.getById(amTemplateElectronicId);
            //删除本月电子考核数据
            exeAssElectronicService.deleteByAssessTime(assessTime);
            //全部河长基本信息
            List<SmUserVO> smUserVOList = smUserService.findUserListWhereRoleOnlyIsHZ();
            for (SmUserVO smUserVO : smUserVOList) {
                ExeAssElectronic exeAssElectronic = new ExeAssElectronic();
                //获取用户基本信息
                getBasicInformation(assessTime, smUserVO, exeAssElectronic, amTemplateElectronic);
                XxlJobLogger.log("==>insert a NEW data chairMan: " + exeAssElectronic.getUserName() + " reachName: " + exeAssElectronic.getReachName());

//                if (exeAssElectronic.getUserName().equals("浦雪甫") && exeAssElectronic.getReachName().equals("杨园坝港海洲街道段")){
//                    System.out.println("---------------------");
//                }

                //河长本月巡河轨迹信息
                Map<String, Object> map = getFindLogLocusRecordMapParams(smUserVO);
                List<ExeAssElectronicVO> exeAssElectronicVOList = exeAssElectronicService.findLogLocusRecordByUserIdAndReachId(map);
                if (exeAssElectronicVOList.size() > 0) {
                    getHzPatrolInformation(exeAssElectronic, exeAssElectronicVOList);
                }

                //河长巡查达标信息,河长巡查记录信息,河长巡查有效信息
                getHzPatrolInfo(exeAssElectronic);

                //未结案事件
                int untreatedCount = 0;
                int untreatedScore = amTemplateElectronic.getEventdispose();
                Map<String, Object> eventMaps = new HashMap<>();
                eventMaps.put("reachId", smUserVO.getReachId());
                eventMaps.put("eventInterval", amTemplateElectronic.getEventInterval() - 1);
                List<ExeAssElectronicVO> exeAssElectronicVOList2 = exeAssElectronicService.findUntreatedEventByReachId(eventMaps);
                for (ExeAssElectronicVO exeAssElectronicVO : exeAssElectronicVOList2) {
                    boolean isUntreated = getDayRemainder(exeAssElectronicVO.getCreateTime(), exeAssElectronicVO.getEndTime(), amTemplateElectronic);
                    if (isUntreated) {
                        untreatedCount++;
                        untreatedScore -= amTemplateElectronic.getEventMarks();
                    }
                }
                exeAssElectronic.setEventDispose("<h4>未结案事件：" + untreatedCount + "件</h4>");
                exeAssElectronic.setEventDisposeScore(untreatedScore < 0 ? 0 : untreatedScore);
                exeAssElectronic.setCreateTime(new Date());

                //判断河长周期巡查得分
                exeAssElectronic = getHzPatrolScore(assessTime, exeAssElectronic, amTemplateElectronic);

                Map<String, Object> entity = new HashMap<>();
                entity.put("entity", exeAssElectronic);
                exeAssElectronicService.insert(entity);
                XxlJobLogger.log("-->Success");
            }

            for (int i = 0; i < 5; i++) {
                XxlJobLogger.log("beat at:" + i);
                TimeUnit.SECONDS.sleep(2);
            }
            return ReturnT.SUCCESS;
        } catch (Exception e) {
            XxlJobLogger.log("-->Fail");
            XxlJobLogger.log("Exception:===========>\r" + e.getMessage());
            return ReturnT.FAIL;
        }
    }


    /* 获取巡查记录参数 */
    private Map<String, Object> getFindLogLocusRecordMapParams(SmUserVO smUserVO) {

        Map<String, Object> map = new HashMap<>();
        map.put("userId", smUserVO.getId());
        map.put("reachId", smUserVO.getReachId());

        return map;
    }


    /* 获取用户基本信息及得分 */
    private ExeAssElectronic getBasicInformation(String assessTime,
                                                 SmUserVO smUserVO,
                                                 ExeAssElectronic exeAssElectronic,
                                                 AmTemplateElectronic amTemplateElectronic) {

        //基本信息总分数
        String basicInformation = "";
        int basicInformationScore = amTemplateElectronic.getBaseinfo();
        exeAssElectronic.setId(getUUID());
        exeAssElectronic.setUserId(smUserVO.getId());
        exeAssElectronic.setUserName(smUserVO.getName());
        exeAssElectronic.setRegionLevel(smUserVO.getChairmanlevel());
        exeAssElectronic.setReachId(smUserVO.getReachId());
        exeAssElectronic.setReachName(smUserVO.getReachName());
        String provinceId = String.valueOf(smUserVO.getProvinceid() == null ? null : smUserVO.getProvinceid());
        String cityId = String.valueOf(smUserVO.getCityid() == null ? null : smUserVO.getCityid());
        String countyId = String.valueOf(smUserVO.getCountyid() == null ? null : smUserVO.getCountyid());
        String townId = String.valueOf(smUserVO.getTownid() == null ? null : smUserVO.getTownid());
        String villageId = String.valueOf(smUserVO.getVillageid() == null ? null : smUserVO.getVillageid());
        exeAssElectronic.setProvinceId(provinceId.equals("null") ? null : provinceId);
        exeAssElectronic.setCityId(cityId.equals("null") ? null : cityId);
        exeAssElectronic.setCountyId(countyId.equals("null") ? null : countyId);
        exeAssElectronic.setTownId(townId.equals("null") ? null : townId);
        exeAssElectronic.setVillageId(villageId.equals("null") ? null : villageId);

        if (smUserVO.getName() == null || smUserVO.getName().equals("")) {
            basicInformationScore -= amTemplateElectronic.getBaseName();
            basicInformation += "无姓名 ";
        }
        if (smUserVO.getChairmanlevel() == null || smUserVO.getChairmanlevel().equals("")) {
            basicInformationScore -= amTemplateElectronic.getBaseLevel();
            basicInformation += "无级别 ";
        } else {
            //村镇级别河长级别小于4,可无部门
            if (smUserVO.getChairmanlevel() < 4) {
                if (smUserVO.getContactDepartment() == null || smUserVO.getContactDepartment().equals("")) {
                    basicInformationScore -= amTemplateElectronic.getBaseDepartment();
                    basicInformation += "无部门 ";
                }
                if (smUserVO.getUnitCellPhone() == null || smUserVO.getUnitCellPhone().equals("")) {
                    basicInformationScore -= amTemplateElectronic.getBaseDepartmentphone();
                    basicInformation += "无部门电话 ";
                }
            }
        }

        if (smUserVO.getChairmanUnit() == null || smUserVO.getChairmanUnit().equals("")) {
            basicInformationScore -= amTemplateElectronic.getBaseUnit();
            basicInformation += "无单位 ";
        }
        if (smUserVO.getDuty() == null || smUserVO.getDuty().equals("")) {
            basicInformationScore -= amTemplateElectronic.getBaseDuty();
            basicInformation += "无职务 ";
        }
        if (smUserVO.getCellphone() == null || smUserVO.getCellphone().equals("")) {
            basicInformationScore -= amTemplateElectronic.getBasePhone();
            basicInformation += "无手机号码 ";
        }

        exeAssElectronic.setAssessTime(assessTime);
        exeAssElectronic.setBasicInformation(basicInformation);
        exeAssElectronic.setBasicInformationScore(basicInformationScore);

        return exeAssElectronic;
    }


    /**
     * 两段时间相减取天数
     *
     * @author xu_zhu<br>2017/10/28 15:07
     */
    private boolean getDayRemainder(Date start, Date end, AmTemplateElectronic amTemplateElectronic) {

        if (end == null)
            end = new Date();

        long remainder = (end.getTime() - start.getTime()) / (60000 * 24);

        return remainder > amTemplateElectronic.getEventInterval() ? true : false;
    }

    /**
     * 获取河长巡查信息
     *
     * @return
     * @params
     * @author xu_zhu<br/> 2017/11/17 11:28
     */
    private ExeAssElectronic getHzPatrolInformation(ExeAssElectronic exeAssElectronic,
                                                    List<ExeAssElectronicVO> exeAssElectronicVOList) {

        //获取河长本月重复巡查日志idList
        List<String> workLogIdList = new ArrayList<>();
        for (ExeAssElectronicVO exeAssElectronicVO : exeAssElectronicVOList) {
            if (!workLogIdList.contains(exeAssElectronicVO.getWorkLogId()))
                workLogIdList.add(exeAssElectronicVO.getWorkLogId());
        }

        //获取本月巡查轨迹日志Id
        List removeObj = new ArrayList();
        JSONArray workLogJsonArr = new JSONArray();
        JSONArray jsonArray = getWorkLogIdFromLocus(workLogIdList, exeAssElectronicVOList);
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            JSONObject workLogObj = new JSONObject();
            ExeAssElectronicVO exeAssElectronicVO = exeAssElectronicService.getPatrolContentByWorkLogId(jsonObject.getString("workLogId"));
            if (exeAssElectronicVO == null)
                continue;
            List<String> accessoryUrlList = exeAssElectronicService.findAccessoryUrlByWorkLogId(jsonObject.getString("workLogId"));
            workLogObj.put("workLogId", jsonObject.getString("workLogId"));
            workLogObj.put("isAccessory", isAccessory(accessoryUrlList));
            workLogObj.put("createTime", exeAssElectronicVO.getCreateTime());
            workLogObj.put("dataStr", dateTransitionToString(exeAssElectronicVO.getCreateTime()));
            workLogObj.put("checkItems", exeAssElectronicVO.getCheckItems());
            workLogObj.put("isContent", isContent(exeAssElectronicVO.getContent()));
            workLogObj.put("isValidDuration", jsonObject.getString("isValidDuration"));

            //排除同一天存在多条日志的数据,将数据进行合并
            for (Object o1 : workLogJsonArr) {
                JSONObject jsonObject1 = (JSONObject) o1;
                if (jsonObject1.getString("dataStr").equals(workLogObj.getString("dataStr"))){
                    if (jsonObject1.getBoolean("isAccessory")){
                        workLogObj.put("isAccessory", jsonObject1.getBoolean("isAccessory"));
                    }
                    if (jsonObject1.getBoolean("isContent")){
                        workLogObj.put("isContent", jsonObject1.getBoolean("isContent"));
                    }
                    if (jsonObject1.getBoolean("isValidDuration")){
                        workLogObj.put("isValidDuration", jsonObject1.getBoolean("isValidDuration"));
                    }
                    removeObj.add(o1);
                }
            }
            workLogJsonArr.add(workLogObj);
        }
        workLogJsonArr.removeAll(removeObj);
        exeAssElectronic.setPatrolStandardInformation(workLogJsonArr.toString());

        return exeAssElectronic;
    }

    /**
     * 判断是否有工作内容
     *
     * @author xu_zhu<br/> 2017/11/17 14:27
     */
    private boolean isContent(String content) {

        boolean isContent = false;
        if (content != null && !content.equals("")) {
            isContent = true;
        }
        return isContent;
    }

    /**
     * 判断附件是否涉及影音设备
     *
     * @author xu_zhu<br/> 2017/11/17 14:18
     */
    private boolean isAccessory(List<String> accessoryUrlList) {

        boolean isAccessory = false;
        for (String accessoryUrl : accessoryUrlList) {
            //不需要判断类型，只需要判断附件路径是否存在即可 liruimin 2017/12/7
            /*if (accessoryUrl.endsWith(".jpg") || accessoryUrl.endsWith(".mp3") || accessoryUrl.endsWith(".mp4")) {
                isAccessory = true;
            }*/
            if (StringUtil.isNotEmptyStr(accessoryUrl)) {
                isAccessory = true;
                break;
            }
        }
        return isAccessory;
    }

    /**
     * 获取本月巡查轨迹日志Id
     *
     * @return
     * @params
     * @author xu_zhu<br/> 2017/11/17 13:25
     */
    private JSONArray getWorkLogIdFromLocus(List<String> workLogIdList,
                                            List<ExeAssElectronicVO> exeAssElectronicVOList) {

        JSONArray jsonArray = new JSONArray();
        for (String workLogId : workLogIdList) {
            //巡河持续时长
            long durationTotal = 0;
            for (ExeAssElectronicVO exeAssElectronicVO : exeAssElectronicVOList) {
                if (workLogId.equals(exeAssElectronicVO.getWorkLogId())) {
                    durationTotal += getMinuteRemainder(exeAssElectronicVO.getStartTime(), exeAssElectronicVO.getEndTime());
                }
            }
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("workLogId", workLogId);
            jsonObject.put("isValidDuration", durationTotal > 4 ? true : false);
            jsonArray.add(jsonObject);
        }

        return jsonArray;
    }

    /**
     * 河长巡查得分情况
     *
     * @author xu_zhu<br/> 2017/11/17 14:11
     */
    private ExeAssElectronic getHzPatrolInfo(ExeAssElectronic exeAssElectronic) {

        //获取信息
        String patrolStandardInformation = exeAssElectronic.getPatrolStandardInformation();
        if (patrolStandardInformation == null || patrolStandardInformation.equals("[]")) {
            exeAssElectronic.setPatrolStandardInformation("");
            exeAssElectronic.setPatrolRiverRecord("");
            exeAssElectronic.setValidPatrolRiverTrack("");
        } else {
            JSONArray workLogJsonArr = JSONArray.parseArray(patrolStandardInformation);
            //巡河达标信息
            exeAssElectronic = patrolStandardDeductMarks(workLogJsonArr, exeAssElectronic);
            for (Object o : workLogJsonArr) {
                JSONObject jsonObject = (JSONObject) o;
                //巡河记录信息
                exeAssElectronic = patrolRiverRecordDeductMarks(jsonObject, exeAssElectronic);
                //有效巡河信息
                exeAssElectronic = validPatrolRiverTrackDeductMarks(jsonObject, exeAssElectronic);
            }
        }

        return exeAssElectronic;
    }

    /**
     * 巡河达标信息
     *
     * @author xu_zhu<br/> 2017/11/17 14:48
     */
    private ExeAssElectronic patrolStandardDeductMarks(JSONArray workLogJsonArr,
                                                       ExeAssElectronic exeAssElectronic) {

        //获取巡河时间,将获取的所有时间以","做分隔
        String patrolStandardTime = null;
        for (Object o : workLogJsonArr) {
            JSONObject jsonObject = (JSONObject) o;
            patrolStandardTime = patrolStandardTime == null ?
                    jsonObject.getString("dataStr") : patrolStandardTime + "|" + dateTransitionToString(jsonObject.getDate("createTime"));
            /*dateTransitionToString(jsonObject.getDate("createTime")) :*/
        }
        exeAssElectronic.setPatrolStandardInformation(patrolStandardTime);

        return exeAssElectronic;
    }


    /**
     * 巡河记录信息
     *
     * @author xu_zhu<br/> 2017/11/17 15:31
     */
    private ExeAssElectronic patrolRiverRecordDeductMarks(JSONObject jsonObject,
                                                          ExeAssElectronic exeAssElectronic) {


        String patrolRiverRecordInfo = jsonObject.getString("dataStr") + " ";/*dateTransitionToString(jsonObject.getDate("createTime"))*/
        boolean isContent = jsonObject.getBoolean("isContent");
        if (!isContent)
            patrolRiverRecordInfo += "巡河内容：无文字记录 ";
        boolean isAccessory = jsonObject.getBoolean("isAccessory");
        if (!isAccessory)
            patrolRiverRecordInfo += "巡河设备：无影音设备 ";

        String checkItems = jsonObject.getString("checkItems");
        if (checkItems == null || !checkItems.matches("(.*)水体水岸(.*)"))
            patrolRiverRecordInfo += "内容涉及: 无水体水岸边 ";

        if (checkItems == null || !checkItems.matches("(.*)涉水活动(.*)"))
            patrolRiverRecordInfo += "内容涉及: 无涉水活动 ";

        if (checkItems == null || !checkItems.matches("(.*)水工建筑物(.*)"))
            patrolRiverRecordInfo += "内容涉及: 无水工建筑物 ";

        if (checkItems == null || !checkItems.matches("(.*)其他(.*)"))
            patrolRiverRecordInfo += "内容涉及: 无其他四类 ";

        patrolRiverRecordInfo = exeAssElectronic.getPatrolRiverRecord() == null ?
                patrolRiverRecordInfo : exeAssElectronic.getPatrolRiverRecord() + "|" + patrolRiverRecordInfo;

        exeAssElectronic.setPatrolRiverRecord(patrolRiverRecordInfo);
        return exeAssElectronic;
    }

    /**
     * 有效巡河信息
     *
     * @author xu_zhu<br/> 2017/11/17 16:31
     */
    private ExeAssElectronic validPatrolRiverTrackDeductMarks(JSONObject jsonObject,
                                                              ExeAssElectronic exeAssElectronic) {

        String validPatrolRiverTrackInfo = jsonObject.getString("dataStr") + " ";/*dateTransitionToString(jsonObject.getDate("createTime"))*/
        boolean isValidDuration = jsonObject.getBoolean("isValidDuration");
        if (!isValidDuration)
            validPatrolRiverTrackInfo += "巡查轨迹: 无效";
        else
            validPatrolRiverTrackInfo += "巡查轨迹: 有效";

        validPatrolRiverTrackInfo = exeAssElectronic.getValidPatrolRiverTrack() == null ?
                validPatrolRiverTrackInfo : exeAssElectronic.getValidPatrolRiverTrack() + "|" + validPatrolRiverTrackInfo;

        exeAssElectronic.setValidPatrolRiverTrack(validPatrolRiverTrackInfo);
        return exeAssElectronic;
    }


    /**
     * 获取当前年月日期:2017-11
     *
     * @author xu_zhu<br/> 2017/11/15 15:18
     */
    private String getCurrentYearAndMonth() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM");
        Calendar calendar = Calendar.getInstance();
        //加上这句意为取上月份
        //calendar.add(Calendar.MONTH, -1);

        return simpleDateFormat.format(calendar.getTime());
//        return "2017-11";
    }

    /**
     * 两段事件相减,取分钟数
     *
     * @author xu_zhu<br/> 2017/11/17 11:38
     */
    private long getMinuteRemainder(Date start, Date end) {

        if (start == null || end == null)
            return 0;

        long remainder = (end.getTime() - start.getTime()) / (60000);

        return remainder;
    }

    /**
     * 日期转String 年-月-日
     *
     * @author xu_zhu<br>2017/10/31 9:50
     */
    private String dateTransitionToString(Date date) {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        return simpleDateFormat.format(date);
    }

    /* 获取32位UUID */
    private String getUUID() {

        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }

    /**
     * 判断str中包含patternStr的个数
     *
     * @param str
     * @param patternStr
     * @return counter
     */
    private int countStr(String str, String patternStr) {

        int count = 0;
        while (patternStr.lastIndexOf(str) > 0) {
            count++;
            patternStr = patternStr.substring(0, patternStr.lastIndexOf(str));
        }
        return count;
    }


    /**
     * @param
     * @return
     * @author xu_zhu<br/> 2017/12/6 17:21
     */
    private ExeAssElectronic getHzPatrolScore(String assessTime,
                                              ExeAssElectronic exeAssElectronic,
                                              AmTemplateElectronic amTemplateElectronic) {

        //巡查周期
        int period = 0;
        if (exeAssElectronic.getRegionLevel() == 3)
            period = amTemplateElectronic.getPatrolCountyperiod();
        else if (exeAssElectronic.getRegionLevel() == 4)
            period = amTemplateElectronic.getPatrolTownperiod();
        else if (exeAssElectronic.getRegionLevel() == 5)
            period = amTemplateElectronic.getPatrolVillageperiod();
        //巡查时间
        String patrolTimeArr[] = exeAssElectronic.getPatrolStandardInformation().replace("|", ",").split(",");
        //巡河记录内容
        String patrolRecordArr[] = exeAssElectronic.getPatrolRiverRecord().replace("|", ",").split(",");
        //巡查记录有效性
        String patrolValidArr[] = exeAssElectronic.getValidPatrolRiverTrack().replace("|", ",").split(",");

        //获取巡查周期数据
        List list = getPeriodTime(period, assessTime);
        JSONObject jsonObject = new JSONObject();
        jsonObject = getPatrolPeriodInfo(list, jsonObject, patrolTimeArr, patrolRecordArr, patrolValidArr);

        //判断是否存在河长应巡查周期无巡查,若有则赋空值
        for (Object o : list) {
            if (jsonObject.get(String.valueOf(o)) == null) {
                jsonObject.put(String.valueOf(o), "");
            }
        }

        int patrolStandardScore = amTemplateElectronic.getPatrolstandar();
        int patrolRecord = amTemplateElectronic.getPatrolrecord();
        int patrolValid = amTemplateElectronic.getValidlocus();
        //
        String description = "<h4>河长：</h4><p>" + exeAssElectronic.getUserName() + "</p>";
        description += "<h4>河道：</h4><p>" + exeAssElectronic.getReachName() + "</p>";
        description += "<h4>基本信息：</h4>";
        String baseInfo = exeAssElectronic.getBasicInformation().equals("") ? "基本信息完整" : exeAssElectronic.getBasicInformation();
        description += "<p>" + baseInfo + "</p>";
        description += "<h4>巡查信息：</h4>";
        for (Object o : list) {
            String patrolInfo = (String) jsonObject.get(String.valueOf(o));
            description += "<p style='color: black;'>" + String.valueOf(o).replace("|", "~") + ":" + "</p>";
            if (patrolInfo.equals("")) {
                //巡查达标
                patrolStandardScore += patrolStandardDeductMarks(period, amTemplateElectronic);
                //有效巡查扣分
                patrolValid += patrolValidDeductMarks(period, patrolInfo, amTemplateElectronic);
                //巡查内容扣分
                patrolRecord += patrolRecordDeductMarks(patrolInfo, amTemplateElectronic);
                continue;
            }
            if (patrolInfo.indexOf("|") > 0) {
                String patrolInfoArr[] = patrolInfo.replace("|", ",").split(",");
                int deductMarks = 0;
                int patrolValidDeductMarks = 0;
                int patrolRecordDeductMarks = 0;
                for (String s : patrolInfoArr) {
                    description += "<span>" + s + "</span>";
                    if (!patrolInfo.matches("(.*)√(.*)")) {
                        //有效巡查扣分
                        patrolValidDeductMarks = patrolValidDeductMarks(period, s, amTemplateElectronic);
                        //巡查内容扣分
                        patrolRecordDeductMarks = patrolRecordDeductMarks(s, amTemplateElectronic);
                        if (deductMarks == 0) {
                            deductMarks = patrolValidDeductMarks + patrolRecordDeductMarks;
                        } else {
                            if (deductMarks < (patrolValidDeductMarks + patrolRecordDeductMarks)) {
                                deductMarks = patrolValidDeductMarks + patrolRecordDeductMarks;
                            }
                        }
                    }
                }
                //有效巡查扣分
                patrolValid += patrolValidDeductMarks;
                //巡查内容扣分
                patrolRecord += patrolRecordDeductMarks;
            } else {
                description += "<span>" + patrolInfo + "</span>";
                if (!patrolInfo.matches("(.*)√(.*)")) {
                    //有效巡查扣分
                    patrolValid += patrolValidDeductMarks(period, patrolInfo, amTemplateElectronic);
                    //巡查内容扣分
                    patrolRecord += patrolRecordDeductMarks(patrolInfo, amTemplateElectronic);
                }
            }
        }
        description += exeAssElectronic.getEventDispose();
        float additionScore = 0;
        if (patrolRecord == amTemplateElectronic.getPatrolrecord() && patrolValid == amTemplateElectronic.getValidlocus()) {
            int countStr = countStr("√", description);
            additionScore = amTemplateElectronic.getAdditionitem() * countStr;
            //若附加项大于最大分数则为最大分数
            if (additionScore > amTemplateElectronic.getMaxadditionitem()) {
                additionScore = amTemplateElectronic.getMaxadditionitem();
            }
        }
        description += "<h4>附加项分数：" + additionScore + "分</h4>";

        patrolStandardScore = patrolStandardScore < 0 ? 0 : patrolStandardScore;
        patrolValid = patrolValid < 0 ? 0 : patrolValid;
        patrolRecord = patrolRecord < 0 ? 0 : patrolRecord;

        exeAssElectronic.setPatrolStandardInformationScore(patrolStandardScore);
        exeAssElectronic.setValidPatrolRiverTrackScore(patrolValid);
        exeAssElectronic.setPatrolRiverRecordScore(patrolRecord);
        exeAssElectronic.setAdditionItemScore(additionScore);
        exeAssElectronic.setDescription(description);

        int totalScore = exeAssElectronic.getBasicInformationScore() + exeAssElectronic.getPatrolStandardInformationScore()
                + exeAssElectronic.getPatrolRiverRecordScore() + exeAssElectronic.getValidPatrolRiverTrackScore()
                + Math.round(exeAssElectronic.getAdditionItemScore()) + exeAssElectronic.getEventDisposeScore();

        exeAssElectronic.setTotalScore(totalScore);

        return exeAssElectronic;

    }

    /**
     * @param
     * @return
     * @author xu_zhu<br/> 2017/12/6 19:06
     */
    private int patrolStandardDeductMarks(int period,
                                          AmTemplateElectronic amTemplateElectronic) {
        int deductMarks = 0;
        if (period == 2) {
            deductMarks += -1 * amTemplateElectronic.getPatrolCounty();
        } else if (period == 3) {
            deductMarks += -1 * amTemplateElectronic.getPatrolTown();
        } else if (period == 4) {
            deductMarks += -1 * amTemplateElectronic.getPatrolVillage();
        }
        return deductMarks;
    }

    /**
     * 巡查无效扣分
     *
     * @param
     * @return
     * @author xu_zhu<br/> 2017/12/6 17:53
     */
    private int patrolValidDeductMarks(int period,
                                       String patrolInfo,
                                       AmTemplateElectronic amTemplateElectronic) {

        int deductMarks = 0;
        if (patrolInfo.equals("") || patrolInfo.matches("(.*)无效(.*)")) {
            if (period == 3) {
                deductMarks += -1 * amTemplateElectronic.getValidCounty();
            } else if (period == 4) {
                deductMarks += -1 * amTemplateElectronic.getValidTown();
            } else if (period == 5) {
                deductMarks += -1 * amTemplateElectronic.getValidVillage();
            }
        }
        return deductMarks;
    }

    /**
     * 巡查内容扣分
     *
     * @param
     * @return
     * @author xu_zhu<br/> 2017/12/6 18:36
     */
    private int patrolRecordDeductMarks(String patrolInfo,
                                        AmTemplateElectronic amTemplateElectronic) {

        int deductMarks = 0;
        if (patrolInfo.equals("") || patrolInfo.matches("(.*)巡河内容(.*)")) {
            deductMarks += -1 * amTemplateElectronic.getRecordContent();
        }
        if (patrolInfo.equals("") || patrolInfo.matches("(.*)巡河设备(.*)")) {
            deductMarks += -1 * amTemplateElectronic.getRecordDevice();
        }
        if (patrolInfo.equals("")) {
            if (amTemplateElectronic.getRecordLcountunit() == 1) {
                deductMarks += -1 * 4 * amTemplateElectronic.getRecordCheckitems();
            } else {
                deductMarks += -1 * amTemplateElectronic.getRecordCheckitems();
            }
        } else if (patrolInfo.matches("(.*)内容涉及(.*)")) {
            int countStr = countStr("内容涉及", patrolInfo);
            if (amTemplateElectronic.getRecordLcountunit() == 1) {
                deductMarks += -1 * countStr * amTemplateElectronic.getRecordCheckitems();
            } else {
                deductMarks += -1 * amTemplateElectronic.getRecordCheckitems();
            }
        }

        return deductMarks;
    }

    /**
     * @param
     * @return
     * @author xu_zhu<br/> 2017/12/6 17:38
     */
    private JSONObject getPatrolPeriodInfo(List list,
                                           JSONObject jsonObject,
                                           String patrolTimeArr[],
                                           String patrolRecordArr[],
                                           String patrolValidArr[]) {

        for (String dateStr : patrolTimeArr) {
            try {
                //若无巡查则跳过
                if (dateStr.equals("")) {
                    continue;
                }
                //获取区间时间
                String patrol = "";
                String scopeStr = getPeriodScope(dateStr, list);
                //判断该区间时间是否已存在
                if (jsonObject.getString(scopeStr) != null)
                    patrol += jsonObject.getString(scopeStr) + "|";
                patrol += dateStr;
                //获取巡查轨迹有效或无效
                boolean isValid = false;
                for (String valid : patrolValidArr) {
                    if (valid.matches("(.*)" + dateStr + "(.*)")) {
                        patrol += " " + valid.substring(dateStr.length());
                        //若包含有效两个字则表示本次巡河轨迹有效
                        if (valid.matches("(.*)有效(.*)"))
                            isValid = true;
                    }
                }
                //获取巡查记录内容文字记录,影音设备及涉及项
                for (String record : patrolRecordArr) {
                    if (record.matches("(.*)" + dateStr + "(.*)")) {
                        patrol += " " + record.substring(dateStr.length());
                        if (isValid && record.substring(dateStr.length()).equals(" ") && !record.matches("(.*)巡河内容(.*)")
                                && !record.matches("(.*)巡河设备(.*)") && !record.matches("(.*)内容涉及(.*)")) {
                            patrol += "<i>√</i> ";
                        }
                    }
                }
                jsonObject.put(scopeStr, patrol);
            } catch (Exception e) {
                //区间时间段获取异常
                XxlJobLogger.log("区间时间段获取异常==>" + e.getMessage());
            }
        }

        return jsonObject;
    }

    /**
     * 获取河长巡查周期段
     *
     * @param period  河长巡查周期数
     * @param dateStr 日期字符串,格式:yyyy-MM
     * @return
     * @author xu_zhu<br/> 2017/12/5 17:52
     */
    private List getPeriodTime(int period,
                               String dateStr) {

        List list = new ArrayList();
        try {
            //获取注定月份最大天数
            int maxDaysOfMonth = getMaxDaysOfMonth(dateStr);
            //标记上个天数
            String last = null;
            //平均天数
            int average = (int) Math.rint((float) maxDaysOfMonth / period);
            for (int i = 1; i < period; ++i) {
                //周期时间
                String theDay;
                if ((i * average + "").length() == 1)
                    theDay = dateStr + "-0" + i * average;
                else
                    theDay = dateStr + "-" + i * average;
                if (last == null)
                    last = dateStr + "-01";

                list.add(last + "|" + theDay);
                last = theDay;
            }
            //获取下月第一天日期字符串
            Date date = new SimpleDateFormat("yyyy-MM").parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.add(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            String firstDayOfNextMonth = new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime());
            list.add(last + "|" + firstDayOfNextMonth);
        } catch (Exception e) {
            XxlJobLogger.log("获取某月日期周期时间失败=====>" + e.getMessage());
        }
        return list;
    }

    /**
     * 获取指定月份的最大天数
     *
     * @param dateStr 日期字符串,格式:yyyy-MM
     * @author xu_zhu<br/> 2017/12/5 17:10
     */
    private int getMaxDaysOfMonth(String dateStr) {

        int maxDaysOfMonth = 0;
        try {
            Date date = new SimpleDateFormat("yyyy-MM").parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            maxDaysOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        } catch (Exception e) {
            XxlJobLogger.log("获取月份最大天数失败=====>" + e.getMessage());
        }
        return maxDaysOfMonth;
    }

    /**
     * 获取时间所属周期范围
     *
     * @param dateStr
     * @param list
     * @author xu_zhu<br/> 2017/12/6 14:33
     */
    private String getPeriodScope(String dateStr,
                                  List list) throws ParseException {

        String scopeStr = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date t = simpleDateFormat.parse(dateStr);
        for (Object o : list) {
            scopeStr = (String) o;
            String scopeArr[] = scopeStr.replace("|", ",").split(",");
            Date d1 = simpleDateFormat.parse(scopeArr[0]);
            Date d2 = simpleDateFormat.parse(scopeArr[1]);
            //判断巡查时间是否在巡查区间内
            if (t.compareTo(d1) >= 0 && t.compareTo(d2) < 0)
                break;
        }
        return scopeStr;
    }
}