package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 河段考核表
 * @author jiangjialiang<br>2017/8/20
 * @version 1.8.2
 */
public class ExeAssReach implements Serializable {
    private Integer id;                 /** 主键id */
    private String reachId;             /** 河道id(外键) */
    private String reachName;           /** 河道名称 */
    private String reachLength;         /** 河道长度 */
    private Integer reachLevel;         /** 河道等级 1：省级；2：市级；3：县级；4：镇级；5：村级 */
    private String riverId;             /** 河流id(外键) */
    private String riverName;           /** 河流名称 */
    private String basinName;           /** 水系名称 */
    private Long provinceId;            /** 省id */
    private Long cityId;                /** 市id */
    private Long countyId;              /** 县id */
    private Long townId;                /** 镇id */
    private Long villageId;             /** 村id */
    private String chairmanId;          /** 河长id(外键) */
    private String chairmanName;        /** 河长名称 */
    private Integer chairmanLevel;      /** 河长级别 默认与河段等级一致 */
    private String patrolId;            /** 巡查id(外键) */
    private String worklogId;           /** 日志id(外键) */
    private String eventId;             /** 事件id(外键) */
    private Integer patrolNum;          /** 巡查次数 */
    private int logNum;                 /** 日志总数 */
    private int eventNum;               /** 事件总数 */
    private int eventProcessing;        /** 事件处理 */
    private int eventClosure;           /** 事件结案 */
    private Double eventClosureRate;    /** 事件结案率 */
    private int publicityCardNum;       /** 公示牌 */
    private int month;                  /** 月 */
    private int quarter;                /** 季度 */
    private int year;                   /** 年 */
    private Date createTime;            /** 创建时间 */
    private String remark;              /** 备注 */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getReachLength() {
        return reachLength;
    }

    public void setReachLength(String reachLength) {
        this.reachLength = reachLength;
    }

    public Integer getReachLevel() {
        return reachLevel;
    }

    public void setReachLevel(Integer reachLevel) {
        this.reachLevel = reachLevel;
    }

    public String getRiverId() {
        return riverId;
    }

    public void setRiverId(String riverId) {
        this.riverId = riverId;
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getBasinName() {
        return basinName;
    }

    public void setBasinName(String basinName) {
        this.basinName = basinName;
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

    public String getChairmanName() {
        return chairmanName;
    }

    public void setChairmanName(String chairmanName) {
        this.chairmanName = chairmanName;
    }

    public Integer getChairmanLevel() {
        return chairmanLevel;
    }

    public void setChairmanLevel(Integer chairmanLevel) {
        this.chairmanLevel = chairmanLevel;
    }

    public String getPatrolId() {
        return patrolId;
    }

    public void setPatrolId(String patrolId) {
        this.patrolId = patrolId;
    }

    public String getWorklogId() {
        return worklogId;
    }

    public void setWorklogId(String worklogId) {
        this.worklogId = worklogId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public Integer getPatrolNum() {
        return patrolNum;
    }

    public void setPatrolNum(Integer patrolNum) {
        this.patrolNum = patrolNum;
    }

    public int getLogNum() {
        return logNum;
    }

    public void setLogNum(int logNum) {
        this.logNum = logNum;
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
