package com.xxl.job.executor.vo;

import com.xxl.job.executor.domain.ExeAssSystem;

/**
 * 考核系统扩展类
 * @author jiangjialiang<br>2017/7/17
 * @version 0.0.1
 */
public class ExeAssSystemVO extends ExeAssSystem {

    private String searchway;   // 按月：1 按季：2 按年：3
    private int year;           // 年份
    private int monthOrQuarter; // 月份或季度
    private String userid;      // 河长id
    private int userlevel;      // 用户级别
    private Long regionid;      // 区域id
    private int regionlevel;    // 区域level
    private String inputuser;   // 河长姓名关键字

    private int pageNumber;
    private int pageSize;

    public String getSearchway() {
        return searchway;
    }

    public void setSearchway(String searchway) {
        this.searchway = searchway;
    }

    @Override
    public int getYear() {
        return year;
    }

    @Override
    public void setYear(int year) {
        this.year = year;
    }

    public int getMonthOrQuarter() {
        return monthOrQuarter;
    }

    public void setMonthOrQuarter(int monthOrQuarter) {
        this.monthOrQuarter = monthOrQuarter;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public int getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(int userlevel) {
        this.userlevel = userlevel;
    }

    public Long getRegionid() {
        return regionid;
    }

    public void setRegionid(Long regionid) {
        this.regionid = regionid;
    }

    public int getRegionlevel() {
        return regionlevel;
    }

    public void setRegionlevel(int regionlevel) {
        this.regionlevel = regionlevel;
    }

    public String getInputuser() {
        return inputuser;
    }

    public void setInputuser(String inputuser) {
        this.inputuser = inputuser;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
