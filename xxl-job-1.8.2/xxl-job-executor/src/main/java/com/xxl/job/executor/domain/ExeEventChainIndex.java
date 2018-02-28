package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 事件环比表(本年同前年)
 * @author xu_zhu<br>2017/8/10
 * @version 1.8.2
 */
public class ExeEventChainIndex implements Serializable {
    private String Id;              /** 主键id */
    private long regionId;          /** 区域id */
    private int lastYear;           /** 去年年份 */
    private int currentYear;        /** 今年年份 */
    private int month;              /** 月份 */
    private int lastCount;          /** 去年同比数据 */
    private int currentCount;       /** 今年同比数据 */
    private Date createTime;        /** 创建时间 */

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public long getRegionId() {
        return regionId;
    }

    public void setRegionId(long regionId) {
        this.regionId = regionId;
    }

    public int getLastYear() {
        return lastYear;
    }

    public void setLastYear(int lastYear) {
        this.lastYear = lastYear;
    }

    public int getCurrentYear() {
        return currentYear;
    }

    public void setCurrentYear(int currentYear) {
        this.currentYear = currentYear;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getLastCount() {
        return lastCount;
    }

    public void setLastCount(int lastCount) {
        this.lastCount = lastCount;
    }

    public int getCurrentCount() {
        return currentCount;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public ExeEventChainIndex(){
        super();
    }

    public ExeEventChainIndex(String Id,
                              long regionId,
                              int lastYear,
                              int currentYear,
                              int month,
                              int lastCount,
                              int currentCount,
                              Date createTime){

        this.Id = Id;
        this.regionId = regionId;
        this.lastYear = lastYear;
        this.currentYear = currentYear;
        this.month = month;
        this.lastCount = lastCount;
        this.currentCount = currentCount;
        this.createTime = createTime;
    }
}
