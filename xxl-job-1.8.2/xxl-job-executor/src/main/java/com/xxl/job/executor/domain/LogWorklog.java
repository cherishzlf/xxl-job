package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 工作日志表
 * @author jiangjialiang<br>2017/8/12
 * @version 1.8.2
 */
public class LogWorklog implements Serializable {
    private String id;                  /** 主键id */
    private String content;             /** 日志内容 */
    private Date logDate;               /** 日志生成时间 */
    private String chairmanId;          /** 河长id */
    private Date createDate;            /** 创建时间 */
    private Integer delayFlag;          /** 补填标示 */
    private Integer commentFlag;        /** 批示标志 */
    private Integer year ;              /** 年 */
    private Integer month ;             /** 月 */
    private Integer day ;               /** 日 */
    private Integer week ;              /** 周 */
    private Integer quarter ;           /** 季度 */
    private String title;               /** 标题 */
    private String reachId;             /** 河道id */
    private String weather;             /** 天气 */
    private Double distanceTotal;       /** 距离总数 */
    private Integer durationTotal;      /** 持续总数 */
    private String checkItems;          /** 检查项目 */
    private String reachName;           /** 河道名称 */
    private String beginPoint;          /** 起点 */
    private String endPoint;            /** 终点 */
    private Double reachLength;         /** 河道长度 */
    private Integer dataUpFlag;         /** 数据标志 */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getLogDate() {
        return logDate;
    }

    public void setLogDate(Date logDate) {
        this.logDate = logDate;
    }

    public String getChairmanId() {
        return chairmanId;
    }

    public void setChairmanId(String chairmanId) {
        this.chairmanId = chairmanId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getDelayFlag() {
        return delayFlag;
    }

    public void setDelayFlag(Integer delayFlag) {
        this.delayFlag = delayFlag;
    }

    public Integer getCommentFlag() {
        return commentFlag;
    }

    public void setCommentFlag(Integer commentFlag) {
        this.commentFlag = commentFlag;
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

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getReachId() {
        return reachId;
    }

    public void setReachId(String reachId) {
        this.reachId = reachId;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Double getDistanceTotal() {
        return distanceTotal;
    }

    public void setDistanceTotal(Double distanceTotal) {
        this.distanceTotal = distanceTotal;
    }

    public Integer getDurationTotal() {
        return durationTotal;
    }

    public void setDurationTotal(Integer durationTotal) {
        this.durationTotal = durationTotal;
    }

    public String getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(String checkItems) {
        this.checkItems = checkItems;
    }

    public String getReachName() {
        return reachName;
    }

    public void setReachName(String reachName) {
        this.reachName = reachName;
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

    public Double getReachLength() {
        return reachLength;
    }

    public void setReachLength(Double reachLength) {
        this.reachLength = reachLength;
    }

    public Integer getDataUpFlag() {
        return dataUpFlag;
    }

    public void setDataUpFlag(Integer dataUpFlag) {
        this.dataUpFlag = dataUpFlag;
    }
}
