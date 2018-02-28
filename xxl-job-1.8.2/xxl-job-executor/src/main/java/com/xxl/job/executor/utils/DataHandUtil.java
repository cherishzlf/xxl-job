package com.xxl.job.executor.utils;



import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xxl.job.executor.constants.*;
import com.xxl.job.executor.domain.MdSection;
import com.xxl.job.executor.domain.UpReach;
import com.xxl.job.executor.domain.UpRiverSectionWaterQuality;
import com.xxl.job.executor.domain.WaterqualityMonthly;
import com.xxl.job.executor.enums.*;
import com.xxl.job.executor.enums.zhuji.ReachLevelEnum;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class DataHandUtil {
    /**
     * 根据cityid获取对应的平台用户名
     * @param cityId
     * @return
     */
    public static String getUserNameByCity(String cityId){
        if(cityId.equals("330700000000")||cityId.contains("金华")){
            return UpUserNameConstant.JINHUA;
        }
        if(cityId.equals("330800000000")||cityId.contains("衢州")){
            return UpUserNameConstant.QUZHOU;
        }
        if(cityId.equals("330400000000")||cityId.contains("嘉兴")){
            return UpUserNameConstant.JIAXIN;
        }
        return null;
    }

    /**
     * 根据事件id获取对应的uuid
     * @param typeId
     * @return
     */
    public static  String getItemList(String typeId){
        List<String> itemList = new ArrayList<>();
        String[] checkeItems = typeId.split(",");
        for (String checkeItem:checkeItems) {
            if(checkeItem.equals("100000007")||checkeItem.equals("100000008")||checkeItem.equals("100000034")){
                itemList.add(ProblemItemConstant.ITEM_ID1);
            }
            if(checkeItem.equals("100000011")||checkeItem.equals("100000012")||checkeItem.equals("100000035")||checkeItem.equals("100000036")){
                itemList.add(ProblemItemConstant.ITEM_ID2);
            }
            if(checkeItem.equals("100000009")||checkeItem.equals("100000010")||checkeItem.equals("100000037")){
                itemList.add(ProblemItemConstant.ITEM_ID3);
            }
            if(checkeItem.equals("100000019")||checkeItem.equals("100000021")){
                itemList.add(ProblemItemConstant.ITEM_ID4);
            }
            if(checkeItem.equals("100000020")){
                itemList.add(ProblemItemConstant.ITEM_ID5);
            }
            if(checkeItem.equals("100000016")){
                itemList.add(ProblemItemConstant.ITEM_ID6);
            }
            if(checkeItem.equals("100000013")||checkeItem.equals("100000041")){
                itemList.add(ProblemItemConstant.ITEM_ID7);
            }
            if(checkeItem.equals("100000014")||checkeItem.equals("100000042")){
                itemList.add(ProblemItemConstant.ITEM_ID8);
            }
            if(checkeItem.equals("100000015")||checkeItem.equals("100000043")){
                itemList.add(ProblemItemConstant.ITEM_ID9);
            }
            if(checkeItem.equals("100000023")||checkeItem.equals("100000024")||checkeItem.equals("100000025")||checkeItem.equals("100000044")){
                itemList.add(ProblemItemConstant.ITEM_ID10);
            }
            if(checkeItem.equals("100000045")){
                itemList.add(ProblemItemConstant.ITEM_ID11);
            }
            if(checkeItem.equals("100000046")){
                itemList.add(ProblemItemConstant.ITEM_ID12);
            }
            if(checkeItem.equals("100000047")||checkeItem.equals("100000048")||checkeItem.equals("100000049")){
                itemList.add(ProblemItemConstant.ITEM_ID13);
            }
        }
        if(itemList.size()>0){
            return itemList.toString().replace("[","").replace("]","");
        }else{
            return null;
        }

    }

    /**
     * 根据事件类型获取对应的uuid
     * @param problemSource
     * @return
     */
    public static String getProblemType(String problemSource){
        if(problemSource.equals("B")||problemSource.equals("C")||problemSource.equals("D")){
            return ProblemTypeEnum.COMPLAINTS.getCode();
        }else{
            return ProblemTypeEnum.REPORT.getCode();
        }
    }
    /**
     * 根据事件来源获取对应的uuid
     * @param problemSource
     * @return
     */
    public static String getProblemSource(String problemSource) {
        if(problemSource.equals("A")){
            return "河长APP";
        }
        if(problemSource.equals("B")){
            return "电话上报";
        }
        if(problemSource.equals("C")){
            return "公众APP";
        }
        if(problemSource.equals("D")){
            return "微信";
        }
            return "曝光台";

    }
    /**
     * 根据河道等级返回河道类型编码
     */
    public static String getReachType(int reachLevel){
        if(reachLevel==1){
            return RiverTypeEnum.PROVINCE_REACH.getCode();
        }else if(reachLevel==2){
            return RiverTypeEnum.CITY_REACH.getCode();
        }else if(reachLevel==3){
            return RiverTypeEnum.COUNTY_REACH.getCode();
        }else if(reachLevel==4){
            return RiverTypeEnum.TOWN_REACH.getCode();
        }else{
            return RiverTypeEnum.VILLAGE_REACH.getCode();
        }
    }

    /**
     * 根据传入的UpReach对象来返回行政区域编码
     * @param reach
     * @return
     */
    public static String getRegionCode(UpReach reach) {
        if(reach.getReachLevel()>=4){
            if(reach.getTownId()!=null) {
                return reach.getTownId().substring(0, 9);
            }
        }
        if(reach.getReachLevel()==3){
            if(reach.getCountyId()!=null) {
                return reach.getCountyId().substring(0, 6);
            }
        }
        if(reach.getReachLevel()>=1){
            if(reach.getCityId()!=null) {
                return reach.getCityId().substring(0, 4);
            }
        }
        return null;
    }

    /**
     * 根据行政区域编码和等级截取对应行政区编码并返回
     * @param regionCode
     * @param level
     * @return
     */
    public static String getRegionCode(String regionCode,int level){
        if(level<=2){
            return regionCode.substring(0,4);
        }
        if(level==3){
            return regionCode.substring(0,6);
        }
        return regionCode.substring(0,9);
    }
    public static String getRegionCode(String cityId,String countyId,String townId,String villageId){
        if(StringUtil.isNotEmptyStr(villageId)){
            return villageId;
        }
        if(StringUtil.isNotEmptyStr(townId)){
            return townId.substring(0,9);
        }
        if(StringUtil.isNotEmptyStr(countyId)){
            return countyId.substring(0,6);
        }
        return cityId.substring(0,4);
    }

    public static Integer getRegionLevel(String cityId,String countyId,String townId,String villageId){
        if(StringUtil.isNotEmptyStr(villageId)){
            return 5;
        }
        if(StringUtil.isNotEmptyStr(townId)){
            return 4;
        }
            return 3;
    }
    /**
     * 根据传入的waterType获取对应的uuid
     * @param waterType
     * @return
     */
    public static String getWaterType(String waterType) {
        if(StringUtil.isNotEmptyStr(waterType)){
            if(waterType.equals("3")){
                return WaterTypeEnum.POOL.getCode();
            }
            /*if(waterType.contains("内河")){
                return WaterTypeEnum.RIVER.getCode();
            }*/
            if(waterType.equals("2")){
                return WaterTypeEnum.DITCH.getCode();
            }
            if(waterType.equals("1")){
                return WaterTypeEnum.STREAM.getCode();
            }
        }
        return WaterTypeEnum.OTHER.getCode();
    }
    public static String getSectionType(String sectionType){
        if(sectionType.equals("11")){
            return SectionTypeConstant.SECTION_TYPE1;
        }
        if(sectionType.equals("1")){
            return SectionTypeConstant.SECTION_TYPE2;
        }
        if(sectionType.equals("2")){
            return SectionTypeConstant.SECTION_TYPE3;
        }
        if(sectionType.equals("3")){
            return SectionTypeConstant.SECTION_TYPE3;
        }
        if(sectionType.equals("4")){
            return SectionTypeConstant.SECTION_TYPE3;
        }
        return SectionTypeConstant.SECTION_TYPE3;
    }
    public static String getTargetWaterQuality(int targetWaterQuality){
        if(targetWaterQuality==1){
            return TargetWaterQualityEnum.WATERQUAL_ONE.getCode();
        }
        if(targetWaterQuality==2){
            return TargetWaterQualityEnum.WATERQUAL_TWO.getCode();
        }
        if(targetWaterQuality==3||targetWaterQuality==0){
            return TargetWaterQualityEnum.WATERQUAL_THREE.getCode();
        }
        if(targetWaterQuality==4){
            return TargetWaterQualityEnum.WATERQUAL_FOUR.getCode();
        }
        if(targetWaterQuality==5){
            return TargetWaterQualityEnum.WATERQUAL_FIVE.getCode();
        }
        return TargetWaterQualityEnum.WATERQUAL_BAD_FIVE.getCode();
    }

    public static String getProjectType(String projectTypeID) {
        if(projectTypeID.equals("河湖管理范围划界确权工程")){
            return PlanTypeConstant.PLAN_TYPE11;
        }
        if(projectTypeID.equals("清理整治侵占水域岸线、非法采砂等工程")){
            return PlanTypeConstant.PLAN_TYPE12;
        }
        if(projectTypeID.equals("清水河道建设工程")){
            return PlanTypeConstant.PLAN_TYPE13;
        }
        if(projectTypeID.equals("河湖水环境综合整治工程")){
            return PlanTypeConstant.PLAN_TYPE21;
        }
        if(projectTypeID.equals("饮用水源保护工程")){
            return PlanTypeConstant.PLAN_TYPE22;
        }
        if(projectTypeID.equals("防洪和排涝工程建设工程")){
            return PlanTypeConstant.PLAN_TYPE31;
        }
        if(projectTypeID.equals("河湖库塘清淤")){
            return PlanTypeConstant.PLAN_TYPE32;
        }
        if(projectTypeID.equals("河湖生态修复工程")){
            return PlanTypeConstant.PLAN_TYPE33;
        }
        if(projectTypeID.equals("工业污染治理工程")){
            return PlanTypeConstant.PLAN_TYPE41;
        }
        if(projectTypeID.equals("农业面源污染治理工程")){
            return PlanTypeConstant.PLAN_TYPE42;
        }
        if(projectTypeID.equals("水产养殖污染治理工程")){
            return PlanTypeConstant.PLAN_TYPE43;
        }
        if(projectTypeID.equals("污水处理等基础设施建设工程")){
            return PlanTypeConstant.PLAN_TYPE44;
        }
        if(projectTypeID.equals("改造器具工程")){
            return PlanTypeConstant.PLAN_TYPE51;
        }
        if(projectTypeID.equals("工业节水改造六大工程")){
            return PlanTypeConstant.PLAN_TYPE52;
        }
        if(projectTypeID.equals("节水型载体创建工程")){
            return PlanTypeConstant.PLAN_TYPE53;
        }
        if(projectTypeID.equals("农业节水改造工程")){
            return PlanTypeConstant.PLAN_TYPE54;
        }
        if(projectTypeID.equals("一户一表")){
            return PlanTypeConstant.PLAN_TYPE55;
        }
        if(projectTypeID.equals("雨水收集利用工程")){
            return PlanTypeConstant.PLAN_TYPE56;
        }
        return PlanTypeConstant.PLAN_TYPE61;
    }

    public static String getProStatus(String getProStatus){
        if(getProStatus.equals("项建编制")){
            return ProjectStatusConstant.PROJECT_STATUS1;
        }
        if(getProStatus.equals("可研论证")){
            return ProjectStatusConstant.PROJECT_STATUS2;
        }
        if(getProStatus.equals("初步设计")){
            return ProjectStatusConstant.PROJECT_STATUS3;
        }
        if(getProStatus.equals("招投标")){
            return ProjectStatusConstant.PROJECT_STATUS4;
        }
        if(getProStatus.equals("开工")){
            return ProjectStatusConstant.PROJECT_STATUS5;
        }
        if(getProStatus.equals("停工")){
            return ProjectStatusConstant.PROJECT_STATUS6;
        }
        if(getProStatus.equals("完工")){
            return ProjectStatusConstant.PROJECT_STATUS7;
        }
        return ProjectStatusConstant.PROJECT_STATUS8;
    }

    /**
     * 根据流域名称获得流域的uuid
     * @param basinCode
     * @return
     */
    public static String getBasin(String basinCode) {
        if(basinCode.contains("运河")){
            return BasinConstant.BASIN_TYPE11;
        }
        if(basinCode.contains("椒江")){
            return BasinConstant.BASIN_TYPE12;
        }
        if(basinCode.contains("曹娥江")){
            return BasinConstant.BASIN_TYPE13;
        }
        if(basinCode.contains("瓯江")){
            return BasinConstant.BASIN_TYPE14;
        }
        if(basinCode.contains("鳌江")){
            return BasinConstant.BASIN_TYPE15;
        }
        if(basinCode.contains("苕溪")){
            return BasinConstant.BASIN_TYPE16;
        }
        if(basinCode.contains("甬江")){
            return BasinConstant.BASIN_TYPE17;
        }
        if(basinCode.contains("钱塘江")){
            return BasinConstant.BASIN_TYPE18;
        }
        if(basinCode.contains("飞云江")) {
            return BasinConstant.BASIN_TYPE19;
        }
        return BasinConstant.BASIN_TYPE20;
    }

    public static String getUserLevel(Integer chairmanLevel) {
        if(chairmanLevel==1){
            return ChairmanLevelEnum.PROVINCE.getCode();
        }
        if(chairmanLevel==2){
            return ChairmanLevelEnum.CITY.getCode();
        }
        if(chairmanLevel==3){
            return ChairmanLevelEnum.COUNTY.getCode();
        }
        if(chairmanLevel==4){
            return ChairmanLevelEnum.TOWN.getCode();
        }
            return ChairmanLevelEnum.VILLAGE.getCode();

    }

    //以下为诸暨-绍兴的数据处理
    public static  String getAdCodeByid(String countyid,String townid,String villageid){
        if(StringUtil.isNotEmptyStr(villageid)){
            return villageid;
        }
        if(StringUtil.isNotEmptyStr(townid)){
            return townid;
        }
        return countyid;
    }

    public static String getBadVIndex(String badVIndex) {
        String result = "";
        if(StringUtil.isNotEmptyStr(badVIndex)) {
            if (badVIndex.contains("高锰酸盐")) {
                result += " 高锰酸盐 ";
            }
            if (badVIndex.contains("总磷")) {
                result += " 总磷 ";
            }
            if (badVIndex.contains("氨氮")) {
                result += " 氨氮 ";
            }
            result = result.trim().replace(" ", ",");
        }
        return result;
    }

    public static String getToken(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String nowDay =  sdf.format(date);
        return Encrypt.encrypt(UpUserNameConstant.USERKEY+Encrypt.encrypt(UpUserNameConstant.PWD,"MD5").toLowerCase()+nowDay,"MD5").toLowerCase();
    }

    public static String getRiverTypeCode(Integer reachLevel) {
        if(reachLevel==3){
            return ReachLevelEnum.COUNTY_REACH.getCode();
        }
        if(reachLevel==4){
            return ReachLevelEnum.TOWN_REACH.getCode();
        }
        return ReachLevelEnum.VILLAGE_REACH.getCode();
    }

    public static UpRiverSectionWaterQuality setUpRiverSectionWaterQuality(WaterqualityMonthly waterqualityMonthly, MdSection mdSection) {
        UpRiverSectionWaterQuality upRiverSectionWaterQuality = new UpRiverSectionWaterQuality();
        upRiverSectionWaterQuality.setUserName(DataHandUtil.getUserNameByCity(mdSection.getCityid().toString()));
        upRiverSectionWaterQuality.setSectionID(mdSection.getCode());
        Calendar c = Calendar.getInstance();
        c.setTime(waterqualityMonthly.getStatisticaltime());
        upRiverSectionWaterQuality.setYear(String.valueOf(c.get(Calendar.YEAR)));
        upRiverSectionWaterQuality.setMont(String.valueOf(c.get(Calendar.MONTH)));

        upRiverSectionWaterQuality.setWaterQuality(getTargetWaterQuality(waterqualityMonthly.getWaterlevel()));

        upRiverSectionWaterQuality.setTransparent(String.valueOf(waterqualityMonthly.getTurbidity()==null?"":waterqualityMonthly.getTurbidity()));

        upRiverSectionWaterQuality.setPH(waterqualityMonthly.getPh()==null?"":waterqualityMonthly.getPh().toString());

        upRiverSectionWaterQuality.setDO(String.valueOf(waterqualityMonthly.getDissolvedoxygen()==null?"":waterqualityMonthly.getDissolvedoxygen()));

        upRiverSectionWaterQuality.setCODMn(String.valueOf(waterqualityMonthly.getPermanganate()==null?"":waterqualityMonthly.getPermanganate()));

        upRiverSectionWaterQuality.setTP(String.valueOf(waterqualityMonthly.getTotalphosphorus()==null?"":waterqualityMonthly.getTotalphosphorus()));

        upRiverSectionWaterQuality.setNH3N(String.valueOf(waterqualityMonthly.getAmmonium()==null?"":waterqualityMonthly.getAmmonium()));

        upRiverSectionWaterQuality.setMeasureTime(waterqualityMonthly.getStatisticaltime());

        return upRiverSectionWaterQuality;
    }

    /**
     * 根据事件类型的json进行遍历
     * @param checkItem
     * @return 被选中的事件类型id
     */
    public static String getCheckItem(String checkItem) {
        JSONArray jsonArray = JSON.parseArray(checkItem);
        List<String> problemType = new ArrayList<>();
        for(int i = 0 ;i<jsonArray.size();i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            JSONArray items = jsonObject.getJSONArray("items");
            for(int j = 0 ;j<items.size();j++){
                JSONObject item = items.getJSONObject(j);
                Integer value = item.getInteger("value");
                if(value==1){
                    problemType.add(item.getString("id"));
                }
            }
        }
        if(problemType.size()==0){
            return null;
        }else{
            return problemType.toString().replace("[","").replace("]","");
        }
    }

    public static String getMinisterLevel(Integer ministerLevel) {
        if (ministerLevel == 1) {
            return MinisterLevelEnum.PROVINCE.getCode();
        }
        if (ministerLevel == 2) {
            return MinisterLevelEnum.CITY.getCode();
        }
        if (ministerLevel == 3) {
            return MinisterLevelEnum.COUNTY.getCode();
        } else {
            return MinisterLevelEnum.TOWN.getCode();
        }
    }
}
