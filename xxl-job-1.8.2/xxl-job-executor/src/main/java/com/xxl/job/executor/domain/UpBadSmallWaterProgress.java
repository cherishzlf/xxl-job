package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 小微水体进展
 */
public class UpBadSmallWaterProgress implements Serializable {
	private String userName;
	private String progressID;
	private String waterID;
	private String clearProgressSituation;
	private String isReachStandard;
	private int reportMonth;
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
	public String getWaterID() {
		return waterID;
	}
	public void setWaterID(String waterID) {
		this.waterID = waterID;
	}
	public String getClearProgressSituation() {
		return clearProgressSituation;
	}
	public void setClearProgressSituation(String clearProgressSituation) {
		this.clearProgressSituation = clearProgressSituation;
	}
	public String getIsReachStandard() {
		return isReachStandard;
	}
	public void setIsReachStandard(String isReachStandard) {
		this.isReachStandard = isReachStandard;
	}
	public int getReportMonth() {
		return reportMonth;
	}
	public void setReportMonth(int reportMonth) {
		this.reportMonth = reportMonth;
	}

	@Override
	public String toString() {
		return waterID;
	}
}
