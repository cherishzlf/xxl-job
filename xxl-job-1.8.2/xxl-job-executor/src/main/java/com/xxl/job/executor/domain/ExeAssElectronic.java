package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/***
 * 河长履职电子化考核表
 *
 * @author xu_zhu<br>2017/10/26 10:28.
 */
public class ExeAssElectronic implements Serializable {

    private String Id;                              /** 主键 */
    private String userId;                          /** 用户Id */
    private Integer regionLevel;                    /** 用户区域级别 */
    private String userName;                        /** 用户姓名 */
    private String reachId;                         /** 用户所属河道Id*/
    private String reachName;                       /** 河道名称 */
    private String basicInformation;                /** 用户基本信息 */
    private Integer basicInformationScore;          /** 用户基本信息得分 */
    private String patrolStandardInformation;       /** 巡查达标信息 */
    private Integer patrolStandardInformationScore; /** 巡查达标信息得分 */
    private String patrolRiverRecord;               /** 巡河记录*/
    private Integer patrolRiverRecordScore;         /** 巡河记录得分 */
    private String validPatrolRiverTrack;           /** 有效巡河轨迹 */
    private Integer validPatrolRiverTrackScore;     /** 有效巡河轨迹得分 */
    private String eventDispose;                    /** 问题处理结案 */
    private Integer eventDisposeScore;              /** 问题处理结案得分 */
    private String additionItem;                    /** 附加项/特色项考核 */
    private float additionItemScore;              /** 附加项/特色项考核得分 */
    private String eventComplain;                   /** 公众投诉 */
    private Integer eventComplainScore;             /** 公众投诉得分 */
    private Integer totalScore;                     /** 总分 */
    private String provinceId;                      /** 省份 */
    private String cityId;                          /** 市 */
    private String countyId;                        /** 区县 */
    private String townId;                          /** 乡镇 */
    private String villageId;                       /** 村 */
    private String assessTime;                      /** 考核时间 */
    private Date createTime;                        /** 创建时间 */
    private Integer isUpload;                       /** 数据是否已上报 */
//上报数据使用字段
    private String platformName;
    private String description;                     /** 描述 */

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    /**  平台账号 */

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getReachId() {
        return reachId;
    }

    public void setReachId(String reachId) {
        this.reachId = reachId;
    }

    public String getReachName() {
        return reachName;
    }

    public void setReachName(String reachName) {
        this.reachName = reachName;
    }

    public String getBasicInformation() {
        return basicInformation;
    }

    public void setBasicInformation(String basicInformation) {
        this.basicInformation = basicInformation;
    }

    public Integer getBasicInformationScore() {
        return basicInformationScore;
    }

    public void setBasicInformationScore(Integer basicInformationScore) {
        this.basicInformationScore = basicInformationScore;
    }

    public String getPatrolStandardInformation() {
        return patrolStandardInformation;
    }

    public void setPatrolStandardInformation(String patrolStandardInformation) {
        this.patrolStandardInformation = patrolStandardInformation;
    }

    public Integer getPatrolStandardInformationScore() {
        return patrolStandardInformationScore;
    }

    public void setPatrolStandardInformationScore(Integer patrolStandardInformationScore) {
        this.patrolStandardInformationScore = patrolStandardInformationScore;
    }

    public String getPatrolRiverRecord() {
        return patrolRiverRecord;
    }

    public void setPatrolRiverRecord(String patrolRiverRecord) {
        this.patrolRiverRecord = patrolRiverRecord;
    }

    public Integer getPatrolRiverRecordScore() {
        return patrolRiverRecordScore;
    }

    public void setPatrolRiverRecordScore(Integer patrolRiverRecordScore) {
        this.patrolRiverRecordScore = patrolRiverRecordScore;
    }

    public String getValidPatrolRiverTrack() {
        return validPatrolRiverTrack;
    }

    public void setValidPatrolRiverTrack(String validPatrolRiverTrack) {
        this.validPatrolRiverTrack = validPatrolRiverTrack;
    }

    public Integer getValidPatrolRiverTrackScore() {
        return validPatrolRiverTrackScore;
    }

    public void setValidPatrolRiverTrackScore(Integer validPatrolRiverTrackScore) {
        this.validPatrolRiverTrackScore = validPatrolRiverTrackScore;
    }

    public String getEventDispose() {
        return eventDispose;
    }

    public void setEventDispose(String eventDispose) {
        this.eventDispose = eventDispose;
    }

    public Integer getEventDisposeScore() {
        return eventDisposeScore;
    }

    public void setEventDisposeScore(Integer eventDisposeScore) {
        this.eventDisposeScore = eventDisposeScore;
    }

    public String getAdditionItem() {
        return additionItem;
    }

    public void setAdditionItem(String additionItem) {
        this.additionItem = additionItem;
    }

    public float getAdditionItemScore() {
        return additionItemScore;
    }

    public void setAdditionItemScore(float additionItemScore) {
        this.additionItemScore = additionItemScore;
    }

    public String getEventComplain() {
        return eventComplain;
    }

    public void setEventComplain(String eventComplain) {
        this.eventComplain = eventComplain;
    }

    public Integer getEventComplainScore() {
        return eventComplainScore;
    }

    public void setEventComplainScore(Integer eventComplainScore) {
        this.eventComplainScore = eventComplainScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCountyId() {
        return countyId;
    }

    public void setCountyId(String countyId) {
        this.countyId = countyId;
    }

    public String getTownId() {
        return townId;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    public String getVillageId() {
        return villageId;
    }

    public void setVillageId(String villageId) {
        this.villageId = villageId;
    }

    public String getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(String assessTime) {
        this.assessTime = assessTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsUpload() {
        return isUpload;
    }

    public void setIsUpload(Integer isUpload) {
        this.isUpload = isUpload;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
