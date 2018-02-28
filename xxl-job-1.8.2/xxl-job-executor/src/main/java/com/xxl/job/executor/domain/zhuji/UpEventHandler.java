package com.xxl.job.executor.domain.zhuji;

import java.util.Date;

/**
 * Created by Administrator on 2017/11/15.
 */
public class UpEventHandler {
    private String id;
    private String problemid;
    private String handleuserid;
    private Date handletime;
    private String result;
    private String photo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProblemid() {
        return problemid;
    }

    public void setProblemid(String problemid) {
        this.problemid = problemid;
    }

    public String getHandleuserid() {
        return handleuserid;
    }

    public void setHandleuserid(String handleuserid) {
        this.handleuserid = handleuserid;
    }

    public Date getHandletime() {
        return handletime;
    }

    public void setHandletime(Date handletime) {
        this.handletime = handletime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
