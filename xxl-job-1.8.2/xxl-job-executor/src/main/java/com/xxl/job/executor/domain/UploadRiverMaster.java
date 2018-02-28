package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2017/9/25.
 */
public class UploadRiverMaster implements Serializable {
    private String userName;
    private String masterID;
    private String masterName;
    private String masterPosition;
    private String masterMobile;
    private String masterLevel;
    private String contactUnit;
    private String contactNumber;
    private String organizationName;
    private String riverID;
    private String cityId;
    private Date uploadtime;
    private Integer chairmanLevel;
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getMasterID() {
        return masterID;
    }

    public void setMasterID(String masterID) {
        this.masterID = masterID;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getMasterPosition() {
        return masterPosition;
    }

    public void setMasterPosition(String masterPosition) {
        this.masterPosition = masterPosition;
    }

    public String getMasterMobile() {
        return masterMobile;
    }

    public void setMasterMobile(String masterMobile) {
        this.masterMobile = masterMobile;
    }

    public String getMasterLevel() {
        return masterLevel;
    }

    public void setMasterLevel(String masterLevel) {
        this.masterLevel = masterLevel;
    }

    public Integer getChairmanLevel() {
        return chairmanLevel;
    }

    public void setChairmanLevel(Integer chairmanLevel) {
        this.chairmanLevel = chairmanLevel;
    }

    public String getContactUnit() {
        return contactUnit;
    }

    public void setContactUnit(String contactUnit) {
        this.contactUnit = contactUnit;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getRiverID() {
        return riverID;
    }

    public void setRiverID(String riverID) {
        this.riverID = riverID;
    }
}
