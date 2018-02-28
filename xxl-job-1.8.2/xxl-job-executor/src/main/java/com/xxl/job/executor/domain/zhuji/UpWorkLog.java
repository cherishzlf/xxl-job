package com.xxl.job.executor.domain.zhuji;

import java.io.Serializable;
import java.util.Date;

/**
 * 诸暨-绍兴接口（巡河记录(河长日志)上报实体类）
 * @author liruimin<br>2017/9/28
 * @version 1.8.2
 */
public class UpWorkLog implements Serializable {
    private String id;
    private String riverId;
    private String userId;
    private Date starttime;
    private Date endtime;
    private Integer distance;
    private Integer step;
    private Integer aespeed;
    /** 发现问题个数 */
    private Integer problem;
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

    public String getRiverId() {
        return riverId;
    }

    public void setRiverId(String riverId) {
        this.riverId = riverId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public Integer getAespeed() {
        return aespeed;
    }

    public void setAespeed(Integer aespeed) {
        this.aespeed = aespeed;
    }

    public Integer getProblem() {
        return problem;
    }

    public void setProblem(Integer problem) {
        this.problem = problem;
    }
}
