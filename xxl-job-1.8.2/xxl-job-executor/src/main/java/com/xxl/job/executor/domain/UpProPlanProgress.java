package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

public class UpProPlanProgress implements Serializable {
	private String userName;
	private String progressID;
	private String planID;
	private Double investmentFund;
	private String projectStatus;
	private String description;
	private int reportMonth;
	private String extend;
	private String cityId;
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

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getProgressID() {
		return progressID;
	}
	public void setProgressID(String progressID) {
		this.progressID = progressID;
	}
	public String getPlanID() {
		return planID;
	}
	public void setPlanID(String planID) {
		this.planID = planID;
	}
	public Double getInvestmentFund() {
		return investmentFund;
	}
	public void setInvestmentFund(Double investmentFund) {
		this.investmentFund = investmentFund;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getReportMonth() {
		return reportMonth;
	}
	public void setReportMonth(int reportMonth) {
		this.reportMonth = reportMonth;
	}
	public String getExtend() {
		return extend;
	}
	public void setExtend(String extend) {
		this.extend = extend;
	}
	
}
