package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 考核系统表
 * @author jiangjialiang<br>2017/6/26
 * @version 1.8.2
 */
public class ExeAssSystem implements Serializable {
    private String id;                  /** 主键 */
    private String chairmanName;        /** 河长名称 */
    private int chairmanLevel;          /** 河长等级 */
    private String reachName;           /** 河道名称 */
    private int logOughtNum;            /** 应填日志 */
    private int logAlreadyNum;          /** 已填日志 */
    private Double logFinishingRate;    /** 日志完成率 */
    private int eventNum;               /** 事件总数 */
    private int eventProcessing;        /** 事件处理 */
    private int eventClosure;           /** 事件结案 */
    private Double eventClosureRate;    /** 事件结案率 */
    private int publicityCardNum;       /** 公示牌 */
    private Long provinceId;            /** 省id */
    private Long cityId;                /** 市id */
    private Long countyId;              /** 县id */
    private Long townId;                /** 镇id */
    private Long villageId;             /** 村id */
    private String chairmanId;          /** 河长id(外键) */
    private String reachId;             /** 河道id(外键) */
    private int month;                  /** 月 */
    private int quarter;                /** 季度 */
    private int year;                   /** 年 */
    private int regionLevel;            /** 地区等级 */
    private Date createTime;            /** 创建时间 */
    private String remark;              /** 备注 */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChairmanName() {
        return chairmanName;
    }

    public void setChairmanName(String chairmanName) {
        this.chairmanName = chairmanName;
    }

    public int getChairmanLevel() {
        return chairmanLevel;
    }

    public void setChairmanLevel(int chairmanLevel) {
        this.chairmanLevel = chairmanLevel;
    }

    public String getReachName() {
        return reachName;
    }

    public void setReachName(String reachName) {
        this.reachName = reachName;
    }

    public int getLogOughtNum() {
        return logOughtNum;
    }

    public void setLogOughtNum(int logOughtNum) {
        this.logOughtNum = logOughtNum;
    }

    public int getLogAlreadyNum() {
        return logAlreadyNum;
    }

    public void setLogAlreadyNum(int logAlreadyNum) {
        this.logAlreadyNum = logAlreadyNum;
    }

    public Double getLogFinishingRate() {
        return logFinishingRate;
    }

    public void setLogFinishingRate(Double logFinishingRate) {
        this.logFinishingRate = logFinishingRate;
    }

    public int getEventNum() {
        return eventNum;
    }

    public void setEventNum(int eventNum) {
        this.eventNum = eventNum;
    }

    public int getEventProcessing() {
        return eventProcessing;
    }

    public void setEventProcessing(int eventProcessing) {
        this.eventProcessing = eventProcessing;
    }

    public int getEventClosure() {
        return eventClosure;
    }

    public void setEventClosure(int eventClosure) {
        this.eventClosure = eventClosure;
    }

    public Double getEventClosureRate() {
        return eventClosureRate;
    }

    public void setEventClosureRate(Double eventClosureRate) {
        this.eventClosureRate = eventClosureRate;
    }

    public int getPublicityCardNum() {
        return publicityCardNum;
    }

    public void setPublicityCardNum(int publicityCardNum) {
        this.publicityCardNum = publicityCardNum;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public String getChairmanId() {
        return chairmanId;
    }

    public void setChairmanId(String chairmanId) {
        this.chairmanId = chairmanId;
    }

    public String getReachId() {
        return reachId;
    }

    public void setReachId(String reachId) {
        this.reachId = reachId;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(int regionLevel) {
        this.regionLevel = regionLevel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
