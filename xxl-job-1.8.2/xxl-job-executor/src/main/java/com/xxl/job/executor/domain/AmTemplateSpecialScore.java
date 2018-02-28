package com.xxl.job.executor.domain;

import java.io.Serializable;

public class AmTemplateSpecialScore implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String chairmanaeeseeid;
    private String majortermid;
    private String minortermid;
    private String title;
    private String termparentsid;
    private Integer scoretype;
    private Integer scoretimes;
    private Integer singlescore;
    private Integer score;
    private String assesstime;
    private java.util.Date createtime;
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChairmanaeeseeid() {
        return chairmanaeeseeid;
    }

    public void setChairmanaeeseeid(String chairmanaeeseeid) {
        this.chairmanaeeseeid = chairmanaeeseeid;
    }

    public String getMajortermid() {
        return majortermid;
    }

    public void setMajortermid(String majortermid) {
        this.majortermid = majortermid;
    }

    public String getMinortermid() {
        return minortermid;
    }

    public void setMinortermid(String minortermid) {
        this.minortermid = minortermid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTermparentsid() {
        return termparentsid;
    }

    public void setTermparentsid(String termparentsid) {
        this.termparentsid = termparentsid;
    }

    public Integer getScoretype() {
        return scoretype;
    }

    public void setScoretype(Integer scoretype) {
        this.scoretype = scoretype;
    }

    public Integer getScoretimes() {
        return scoretimes;
    }

    public void setScoretimes(Integer scoretimes) {
        this.scoretimes = scoretimes;
    }

    public Integer getSinglescore() {
        return singlescore;
    }

    public void setSinglescore(Integer singlescore) {
        this.singlescore = singlescore;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getAssesstime() {
        return assesstime;
    }

    public void setAssesstime(String assesstime) {
        this.assesstime = assesstime;
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
