package com.xxl.job.executor.domain.zhuji;

import java.io.Serializable;
import java.util.Date;

/**
 * 诸暨-绍兴接口（事件上报实体类）
 * @author liruimin<br>2017/9/28
 * @version 1.8.2
 */
public class UpEvent implements Serializable {
    private String id;
    private String patrolid;
    private Date createdate;
    private String problems;
    private String description;
    private String photo;
    private String lng;
    private String lat;
    private String location;
    private String map;
    private Date uploadtime;

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatrolid() {
        return patrolid;
    }

    public void setPatrolid(String patrolid) {
        this.patrolid = patrolid;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
