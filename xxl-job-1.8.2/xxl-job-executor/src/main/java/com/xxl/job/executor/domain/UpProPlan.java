package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 上报重点项目计划服务
 * @author Administrator
 *
 */
public class UpProPlan implements Serializable {
	private String userName;
	private String projectTypeID;
	private String planID;
	private String projectName;
	private Double planInvestmentFund;
	private String description;
	private String leaderUnit;
	private String timeLimitDescription;
	private String needFinishThisYear;
	private String progressRequireDesc;
	private String responsibleUnit;
	private int planYear;
	private String adminDivCode;
	private Boolean isBad5Project;
	private String extend;
	private String cityId;
	private String countyId;
	private String townId;
	private int planendtime;
	private Date uploadtime;

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public int getPlanendtime() {
		return planendtime;
	}

	public void setPlanendtime(int planendtime) {
		this.planendtime = planendtime;
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
	public String getProjectTypeID() {
		return projectTypeID;
	}
	public void setProjectTypeID(String projectTypeID) {
		this.projectTypeID = projectTypeID;
	}
	public String getPlanID() {
		return planID;
	}
	public void setPlanID(String planID) {
		this.planID = planID;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public Double getPlanInvestmentFund() {
		return planInvestmentFund;
	}
	public void setPlanInvestmentFund(Double planInvestmentFund) {
		this.planInvestmentFund = planInvestmentFund;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLeaderUnit() {
		return leaderUnit;
	}
	public void setLeaderUnit(String leaderUnit) {
		this.leaderUnit = leaderUnit;
	}
	public String getTimeLimitDescription() {
		return timeLimitDescription;
	}
	public void setTimeLimitDescription(String timeLimitDescription) {
		this.timeLimitDescription = timeLimitDescription;
	}
	public String getNeedFinishThisYear() {
		return needFinishThisYear;
	}
	public void setNeedFinishThisYear(String needFinishThisYear) {
		this.needFinishThisYear = needFinishThisYear;
	}
	public String getProgressRequireDesc() {
		return progressRequireDesc;
	}
	public void setProgressRequireDesc(String progressRequireDesc) {
		this.progressRequireDesc = progressRequireDesc;
	}
	public String getResponsibleUnit() {
		return responsibleUnit;
	}
	public void setResponsibleUnit(String responsibleUnit) {
		this.responsibleUnit = responsibleUnit;
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
	public Boolean isBad5Project() {
		return isBad5Project;
	}
	public void setBad5Project(Boolean isBad5Project) {
		this.isBad5Project = isBad5Project;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	
}
