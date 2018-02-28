package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 巡查轨迹表
 * @author jiangjialiang<br>2017/8/19
 * @version 1.8.2
 */
public class MdLocusrecord implements Serializable {
    private String id;              /** 主键id */
    private String userId;          /** 用户id */
    private Date createTime;        /** 创建时间 */
    private Date startTime;         /** 开始时间 */
    private Date endTime;           /** 结束时间 */
    private Integer year;           /** 年 */
    private Integer month;          /** 月 */
    private Integer day;            /** 日 */
    private String coords;          /** 坐标 */
    private Integer hour;           /** 时 */
    private Integer minute;         /** 分 */
    private String worklogId;       /** 工作日志id */
    private String reachId;         /** 河段id */
    private String beginPoint;      /** 起点 */
    private String endPoint;        /** 终点 */
    private Double distance;        /** 距离 */
    private Integer duration;       /** 期间 */
    private Integer dataSrcCode;    /** 数据编码 */
    private Integer datauUpFlag;    /** 数据标志 */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public String getCoords() {
        return coords;
    }

    public void setCoords(String coords) {
        this.coords = coords;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getWorklogId() {
        return worklogId;
    }

    public void setWorklogId(String worklogId) {
        this.worklogId = worklogId;
    }

    public String getReachId() {
        return reachId;
    }

    public void setReachId(String reachId) {
        this.reachId = reachId;
    }

    public String getBeginPoint() {
        return beginPoint;
    }

    public void setBeginPoint(String beginPoint) {
        this.beginPoint = beginPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDataSrcCode() {
        return dataSrcCode;
    }

    public void setDataSrcCode(Integer dataSrcCode) {
        this.dataSrcCode = dataSrcCode;
    }

    public Integer getDatauUpFlag() {
        return datauUpFlag;
    }

    public void setDatauUpFlag(Integer datauUpFlag) {
        this.datauUpFlag = datauUpFlag;
    }
}
