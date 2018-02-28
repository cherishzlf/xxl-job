package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 上报新增问题服务的实体类
 * @author liruimin<br>2017/8/12
 * @version 1.8.2
 */
public class UpProblem implements Serializable {
	private String userName;
	private String problemID;
	private String problemType;
	private String problemSource; //问题来源
	private String patrolID;
	private String itemList;
	private String riverID;
	private String handleStyle;
	private String reporterContact;
	private String reportTime;
	private String description;
	private String longitude;// 东经
	private String latitude;// 南纬
	private Date uploadtime;
	private String eventbelongcityid;
	private String checkedItem;

	public String getCheckedItem() {
		return checkedItem;
	}

	public void setCheckedItem(String checkedItem) {
		this.checkedItem = checkedItem;
	}

	public String getEventbelongcity() {
		return eventbelongcityid;
	}

	public void setEventbelongcity(String eventbelongcity) {
		this.eventbelongcityid = eventbelongcity;
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
	public String getProblemID() {
		return problemID;
	}
	public void setProblemID(String problemID) {
		this.problemID = problemID;
	}
	public String getProblemType() {
		return problemType;
	}
	public void setProblemType(String problemType) {
		this.problemType = problemType;
	}
	public String getProblemSource() {
		return problemSource;
	}
	public void setProblemSource(String problemSource) {
		this.problemSource = problemSource;
	}
	public String getPatrolID() {
		return patrolID;
	}
	public void setPatrolID(String patrolID) {
		this.patrolID = patrolID;
	}
	public String getItemList() {
		return itemList;
	}
	public void setItemList(String itemList) {
		this.itemList = itemList;
	}
	public String getRiverID() {
		return riverID;
	}
	public void setRiverID(String riverID) {
		this.riverID = riverID;
	}
	public String getHandleStyle() {
		return handleStyle;
	}
	public void setHandleStyle(String handleStyle) {
		this.handleStyle = handleStyle;
	}
	public String getReporterContact() {
		return reporterContact;
	}
	public void setReporterContact(String reporterContact) {
		this.reporterContact = reporterContact;
	}
	public String getReportTime() {
		return reportTime;
	}
	public void setReportTime(String reportTime) {
		this.reportTime = reportTime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
}
