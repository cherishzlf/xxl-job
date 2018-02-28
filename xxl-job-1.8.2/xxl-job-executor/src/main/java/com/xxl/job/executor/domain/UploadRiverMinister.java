package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 总河长实体类
 */
public class UploadRiverMinister implements Serializable {
    private String userName;
    private String ministerID;
    private String ministerName;
    private String ministerPosition;
    private String ministerPhone;
    private String adminDivCode;
    private String ministerLevel;
    private String provinceId;
    private String cityId;
    private String countyId;
    private String townId;
    private String villageId;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMinisterID() {
        return ministerID;
    }

    public void setMinisterID(String ministerID) {
        this.ministerID = ministerID;
    }

    public String getMinisterName() {
        return ministerName;
    }

    public void setMinisterName(String ministerName) {
        this.ministerName = ministerName;
    }

    public String getMinisterPosition() {
        return ministerPosition;
    }

    public void setMinisterPosition(String ministerPosition) {
        this.ministerPosition = ministerPosition;
    }

    public String getMinisterPhone() {
        return ministerPhone;
    }

    public void setMinisterPhone(String ministerPhone) {
        this.ministerPhone = ministerPhone;
    }

    public String getAdminDivCode() {
        return adminDivCode;
    }

    public void setAdminDivCode(String adminDivCode) {
        this.adminDivCode = adminDivCode;
    }

    public String getMinisterLevel() {
        return ministerLevel;
    }

    public void setMinisterLevel(String ministerLevel) {
        this.ministerLevel = ministerLevel;
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

    @Override
    public String toString() {
        return "ministerID ";
    }
}
