package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

public class UpRiverSection implements Serializable {
	private String userName;
	private String sectionID;
	private String sectionType;
	private String sectionName;
	private String waterFunctionArea;
	private String riverID;
	private String targetWaterQuality;
	private String adminDivCode;
	private String stationName;
	private String isTaiLakeImportantSection;
	private String isProvinceAssess;
	private String isNationImportant;
	private String badVIndex;
	private String responsiblePerson;
	private String cityId;
	private String countyId;
	private String townId;
	private Date uploadtime;
	private Double latitude;
	private Double longitude;

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
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

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSectionID() {
		return sectionID;
	}
	public void setSectionID(String sectionID) {
		this.sectionID = sectionID;
	}
	public String getSectionType() {
		return sectionType;
	}
	public void setSectionType(String sectionType) {
		this.sectionType = sectionType;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getWaterFunctionArea() {
		return waterFunctionArea;
	}
	public void setWaterFunctionArea(String waterFunctionArea) {
		this.waterFunctionArea = waterFunctionArea;
	}
	public String getRiverID() {
		return riverID;
	}
	public void setRiverID(String riverID) {
		this.riverID = riverID;
	}
	public String getTargetWaterQuality() {
		return targetWaterQuality;
	}
	public void setTargetWaterQuality(String targetWaterQuality) {
		this.targetWaterQuality = targetWaterQuality;
	}
	public String getAdminDivCode() {
		return adminDivCode;
	}
	public void setAdminDivCode(String adminDivCode) {
		this.adminDivCode = adminDivCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}

	public String getIsTaiLakeImportantSection() {
		return isTaiLakeImportantSection;
	}

	public void setIsTaiLakeImportantSection(String isTaiLakeImportantSection) {
		this.isTaiLakeImportantSection = isTaiLakeImportantSection;
	}

	public String getIsProvinceAssess() {
		return isProvinceAssess;
	}

	public void setIsProvinceAssess(String isProvinceAssess) {
		this.isProvinceAssess = isProvinceAssess;
	}

	public String getIsNationImportant() {
		return isNationImportant;
	}

	public void setIsNationImportant(String isNationImportant) {
		this.isNationImportant = isNationImportant;
	}

	public String getBadVIndex() {
		return badVIndex;
	}
	public void setBadVIndex(String badVIndex) {
		this.badVIndex = badVIndex;
	}
	public String getResponsiblePerson() {
		return responsiblePerson;
	}
	public void setResponsiblePerson(String responsiblePerson) {
		this.responsiblePerson = responsiblePerson;
	}

	@Override
	public String toString() {
		return sectionID;
	}
}
