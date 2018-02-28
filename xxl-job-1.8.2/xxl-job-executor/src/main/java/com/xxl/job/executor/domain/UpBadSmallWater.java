package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

public class UpBadSmallWater implements Serializable {
	private String userName;
	private String waterID;
	private String waterName;
	private String waterType;
	private Date planEndTime;
	private Double planDredgingQuantity;
	private String mainCause;
	private String governObjectives;
	private String governMeasures;
	private String responsibilityUnit;
	private String responsibilityPerson;
	private String responsibilityPersonPosition;
	private String responsibilityPersonPhone;
	private int planYear;
	private String adminDivCode;
	private String townName;
	private String villageName;
	private String isCleared;
	private Double longitude;
	private Double latitude;
	private String cityId;
	private String countyid;
	private Date uploadtime;

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
	public String getCountyid() {
		return countyid;
	}
	public void setCountyid(String countyid) {
		this.countyid = countyid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getWaterID() {
		return waterID;
	}
	public void setWaterID(String waterID) {
		this.waterID = waterID;
	}
	public String getWaterName() {
		return waterName;
	}
	public void setWaterName(String waterName) {
		this.waterName = waterName;
	}
	public String getWaterType() {
		return waterType;
	}
	public void setWaterType(String waterType) {
		this.waterType = waterType;
	}
	public Double getPlanDredgingQuantity() {
		return planDredgingQuantity;
	}
	public void setPlanDredgingQuantity(Double planDredgingQuantity) {
		this.planDredgingQuantity = planDredgingQuantity;
	}

	public Date getPlanEndTime() {
		return planEndTime;
	}

	public void setPlanEndTime(Date planEndTime) {
		this.planEndTime = planEndTime;
	}

	public String getMainCause() {
		return mainCause;
	}
	public void setMainCause(String mainCause) {
		this.mainCause = mainCause;
	}
	public String getGovernObjectives() {
		return governObjectives;
	}
	public void setGovernObjectives(String governObjectives) {
		this.governObjectives = governObjectives;
	}
	public String getGovernMeasures() {
		return governMeasures;
	}
	public void setGovernMeasures(String governMeasures) {
		this.governMeasures = governMeasures;
	}
	public String getResponsibilityUnit() {
		return responsibilityUnit;
	}
	public void setResponsibilityUnit(String responsibilityUnit) {
		this.responsibilityUnit = responsibilityUnit;
	}
	public String getResponsibilityPerson() {
		return responsibilityPerson;
	}
	public void setResponsibilityPerson(String responsibilityPerson) {
		this.responsibilityPerson = responsibilityPerson;
	}
	public String getResponsibilityPersonPosition() {
		return responsibilityPersonPosition;
	}
	public void setResponsibilityPersonPosition(String responsibilityPersonPosition) {
		this.responsibilityPersonPosition = responsibilityPersonPosition;
	}
	public String getResponsibilityPersonPhone() {
		return responsibilityPersonPhone;
	}
	public void setResponsibilityPersonPhone(String responsibilityPersonPhone) {
		this.responsibilityPersonPhone = responsibilityPersonPhone;
	}
	public int getPlanYear() {
		return planYear;
	}
	public void setPlanYear(int planYear) {
		this.planYear = planYear;
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
	public String getVillageName() {
		return villageName;
	}
	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}
	public String getIsCleared() {
		return isCleared;
	}
	public void setIsCleared(String isCleared) {
		this.isCleared = isCleared;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	
	
}
