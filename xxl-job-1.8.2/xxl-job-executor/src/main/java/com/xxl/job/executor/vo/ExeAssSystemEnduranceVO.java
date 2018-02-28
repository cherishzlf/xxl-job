package com.xxl.job.executor.vo;

import com.xxl.job.executor.domain.ExeAssSystemEndurance;

/**
 * 考核系统扩展类
 * @author jiangjialiang<br>2017/7/17
 * @version 0.0.1
 */
public class ExeAssSystemEnduranceVO extends ExeAssSystemEndurance {

    private int monthorquarter;
    private String regionid;
    private int pageNumber;
    private int pageSize;

    public int getMonthorquarter() {
        return monthorquarter;
    }

    public void setMonthorquarter(int monthorquarter) {
        this.monthorquarter = monthorquarter;
    }

    public String getRegionid() {
        return regionid;
    }

    public void setRegionid(String regionid) {
        this.regionid = regionid;
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
