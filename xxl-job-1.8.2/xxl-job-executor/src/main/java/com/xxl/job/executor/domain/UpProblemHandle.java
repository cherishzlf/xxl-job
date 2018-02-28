package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

public class UpProblemHandle implements Serializable {
	private String userName;
	private String handleID;
	private String problemID;
	private String handlerContact;
	private String handlerOrg;
	private String handleTime;
	private String description;
	private String status;
	private String eventbelongcityid;
	private Date uploadtime;
	private Date begintime;

	public Date getBegintime() {
		return begintime;
	}

	public void setBegintime(Date begintime) {
		this.begintime = begintime;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getEventbelongcity() {
		return eventbelongcityid;
	}

	public void setEventbelongcity(String eventbelongcity) {
		this.eventbelongcityid = eventbelongcity;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHandleID() {
		return handleID;
	}
	public void setHandleID(String handleID) {
		this.handleID = handleID;
	}
	public String getProblemID() {
		return problemID;
	}
	public void setProblemID(String problemID) {
		this.problemID = problemID;
	}
	public String getHandlerContact() {
		return handlerContact;
	}
	public void setHandlerContact(String handlerContact) {
		this.handlerContact = handlerContact;
	}
	public String getHandlerOrg() {
		return handlerOrg;
	}
	public void setHandlerOrg(String handlerOrg) {
		this.handlerOrg = handlerOrg;
	}
	public String getHandleTime() {
		return handleTime;
	}
	public void setHandleTime(String handleTime) {
		this.handleTime = handleTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return problemID;
	}
}
