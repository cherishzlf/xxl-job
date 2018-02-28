package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

public class UpParolerecord implements Serializable {
	private String userName;
	private String patrolID;
	private String riverID;
	private String patrollerContact;
	private Double length;
	private Date startTime;
	private Date endTime;
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
	public String getPatrolID() {
		return patrolID;
	}
	public void setPatrolID(String patrolID) {
		this.patrolID = patrolID;
	}
	public String getRiverID() {
		return riverID;
	}
	public void setRiverID(String riverID) {
		this.riverID = riverID;
	}
	public String getPatrollerContact() {
		return patrollerContact;
	}
	public void setPatrollerContact(String patrollerContact) {
		this.patrollerContact = patrollerContact;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return
				patrolID;

	}
}
