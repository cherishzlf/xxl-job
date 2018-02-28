package com.xxl.job.executor.domain;

import java.io.Serializable;

public class AmTemplateSpecial implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private Integer score;
    private String parentid;
    private Integer countyscore;
    private Integer townscore;
    private Integer villagescore;
    private Integer sortorder;
    private Integer status;
    private java.util.Date createtime;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public Integer getCountyscore() {
        return countyscore;
    }

    public void setCountyscore(Integer countyscore) {
        this.countyscore = countyscore;
    }

    public Integer getTownscore() {
        return townscore;
    }

    public void setTownscore(Integer townscore) {
        this.townscore = townscore;
    }

    public Integer getVillagescore() {
        return villagescore;
    }

    public void setVillagescore(Integer villagescore) {
        this.villagescore = villagescore;
    }

    public Integer getSortorder() {
        return sortorder;
    }

    public void setSortorder(Integer sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public java.util.Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
