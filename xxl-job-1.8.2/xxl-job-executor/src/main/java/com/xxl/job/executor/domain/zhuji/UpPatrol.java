package com.xxl.job.executor.domain.zhuji;

import java.io.Serializable;
import java.util.Date;

/**
 * 诸暨-绍兴接口（巡河轨迹上报实体类）
 * @author liruimin<br>2017/9/28
 * @version 1.8.2
 */
public class UpPatrol implements Serializable {
    private String id;
    private String patrolid;
    private String jsondata;
    private String map;
    /** 上报时间 */
    private Date uploadtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }
    public String getPatrolid() {
        return patrolid;
    }

    public void setPatrolid(String patrolid) {
        this.patrolid = patrolid;
    }

    public String getJsondata() {
        return jsondata;
    }

    public void setJsondata(String jsondata) {
        this.jsondata = jsondata;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
