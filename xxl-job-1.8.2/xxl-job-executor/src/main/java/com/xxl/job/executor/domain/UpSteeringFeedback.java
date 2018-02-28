package com.xxl.job.executor.domain;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UpSteeringFeedback implements Serializable {
	private String userName;
	private String listID;
	private String handleDetail;
	private Date feedbackTime;
	private List<File> photos;//图片路径
	private String cityid;
	private Date uploadtime;

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public String getCityid() {
		return cityid;
	}

	public void setCityid(String cityid) {
		this.cityid = cityid;
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getListID() {
		return listID;
	}
	public void setListID(String listID) {
		this.listID = listID;
	}
	public String getHandleDetail() {
		return handleDetail;
	}
	public void setHandleDetail(String handleDetail) {
		this.handleDetail = handleDetail;
	}
	
	public Date getFeedbackTime() {
		return feedbackTime;
	}
	public void setFeedbackTime(Date feedbackTime) {
		this.feedbackTime = feedbackTime;
	}
	public List<File> getPhotos() {
		return photos;
	}
	public void setPhotos(List<File> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "UpSteeringFeedback{" +
				"listID='" + listID + '\'' +
				'}';
	}
}
