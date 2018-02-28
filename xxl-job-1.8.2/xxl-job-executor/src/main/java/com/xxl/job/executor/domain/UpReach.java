package com.xxl.job.executor.domain;


import java.io.Serializable;
import java.util.Date;

public class UpReach implements Serializable {
    private String userName;

    private String riverID;
    private String parentID;
    private String riverName;
    private String riverAlias;
    private String riverType;
    private String startPoint;
    private String endPoint;
    private String length;
    private String adminDivCode;
    private String townName;
    private int reachLevel;
    private String provinceId;
    private String cityId;
    private String countyId;
    private String townId;
    private String villageId;
    private Date uploadtime;
    private String parents;
    private String basinCode;

    public String getBasinCode() {
        return basinCode;
    }

    public void setBasinCode(String basinCode) {
        this.basinCode = basinCode;
    }

    public String getRiverID() {
        return riverID;
    }

    public void setRiverID(String riverID) {
        this.riverID = riverID;
    }

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getParentID() {
        return parentID;
    }

    public void setParentID(String parentID) {
        this.parentID = parentID;
    }


    public String getRiverAlias() {
        return riverAlias;
    }

    public void setRiverAlias(String riverAlias) {
        this.riverAlias = riverAlias;
    }

    public String getRiverType() {
        return riverType;
    }

    public void setRiverType(String riverType) {
        this.riverType = riverType;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getAdminDivCode() {
        return adminDivCode;
    }

    public void setAdminDivCode(String adminDivCode) {
        this.adminDivCode = adminDivCode;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }


    public int getReachLevel() {
        return reachLevel;
    }

    public void setReachLevel(int reachLevel) {
        this.reachLevel = reachLevel;
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
        return riverID+",";
    }
}


