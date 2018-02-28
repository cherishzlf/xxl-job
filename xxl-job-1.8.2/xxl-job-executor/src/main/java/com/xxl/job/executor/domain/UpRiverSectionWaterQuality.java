package com.xxl.job.executor.domain;

import java.util.Date;

public class UpRiverSectionWaterQuality {
	private String userName;
	private String sectionID;
	private String year;
	private String mont;
	private String waterQuality;
	private String transparent;
	private String PH;
	private String DO;
	private String CODMn;
	private String TP;
	private String NH3N;
	private String TN;
	private String integratedPollutionIndex;
	private Date measureTime;
	private String remark;

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
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMont() {
		return mont;
	}
	public void setMont(String mont) {
		this.mont = mont;
	}
	public String getWaterQuality() {
		return waterQuality;
	}
	public void setWaterQuality(String waterQuality) {
		this.waterQuality = waterQuality;
	}
	public String getTransparent() {
		return transparent;
	}
	public void setTransparent(String transparent) {
		this.transparent = transparent;
	}
	public String getPH() {
		return PH;
	}
	public void setPH(String pH) {
		PH = pH;
	}
	public String getDO() {
		return DO;
	}
	public void setDO(String dO) {
		DO = dO;
	}
	public String getCODMn() {
		return CODMn;
	}
	public void setCODMn(String cODMn) {
		CODMn = cODMn;
	}
	public String getTP() {
		return TP;
	}
	public void setTP(String tP) {
		TP = tP;
	}
	public String getNH3N() {
		return NH3N;
	}
	public void setNH3N(String nH3N) {
		NH3N = nH3N;
	}
	public String getTN() {
		return TN;
	}
	public void setTN(String tN) {
		TN = tN;
	}
	public String getIntegratedPollutionIndex() {
		return integratedPollutionIndex;
	}
	public void setIntegratedPollutionIndex(String integratedPollutionIndex) {
		this.integratedPollutionIndex = integratedPollutionIndex;
	}

	public Date getMeasureTime() {
		return measureTime;
	}

	public void setMeasureTime(Date measureTime) {
		this.measureTime = measureTime;
	}

	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

}
