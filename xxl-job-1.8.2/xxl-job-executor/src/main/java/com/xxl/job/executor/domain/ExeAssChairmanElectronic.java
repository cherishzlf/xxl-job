package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

public class ExeAssChairmanElectronic implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.String id;
    private java.lang.String chairmanid;
    private java.lang.String chairmanname;
    private java.lang.Integer chairmanlevel;
    private java.lang.Integer basicinformationscore;
    private java.lang.Integer patrolstandardinformationscore;
    private java.lang.Integer patrolriverrecordscore;
    private java.lang.Integer validpatrolrivertrackscore;
    private java.lang.Integer additionitemscore;
    private java.lang.Integer eventdisposescore;
    private java.lang.Integer specialscore;
    private java.lang.Integer totalscore;
    private java.lang.Long provinceid;
    private java.lang.Long cityid;
    private java.lang.Long countyid;
    private java.lang.Long townid;
    private java.lang.Long villageid;
    private java.lang.String assesstime;
    private java.util.Date createtime;
    //上报数据使用字段
    private String platformName;
    private java.lang.String uploadcode;
    private Date uploadtime;

    public String getUploadcode() {
        return uploadcode;
    }

    public void setUploadcode(String uploadcode) {
        this.uploadcode = uploadcode;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getChairmanid() {
        return chairmanid;
    }

    public void setChairmanid(java.lang.String chairmanid) {
        this.chairmanid = chairmanid;
    }

    public java.lang.String getChairmanname() {
        return chairmanname;
    }

    public void setChairmanname(java.lang.String chairmanname) {
        this.chairmanname = chairmanname;
    }

    public java.lang.Integer getChairmanlevel() {
        return chairmanlevel;
    }

    public void setChairmanlevel(java.lang.Integer chairmanlevel) {
        this.chairmanlevel = chairmanlevel;
    }

    public java.lang.Integer getBasicinformationscore() {
        return basicinformationscore;
    }

    public void setBasicinformationscore(java.lang.Integer basicinformationscore) {
        this.basicinformationscore = basicinformationscore;
    }

    public java.lang.Integer getPatrolstandardinformationscore() {
        return patrolstandardinformationscore;
    }

    public void setPatrolstandardinformationscore(java.lang.Integer patrolstandardinformationscore) {
        this.patrolstandardinformationscore = patrolstandardinformationscore;
    }

    public java.lang.Integer getPatrolriverrecordscore() {
        return patrolriverrecordscore;
    }

    public void setPatrolriverrecordscore(java.lang.Integer patrolriverrecordscore) {
        this.patrolriverrecordscore = patrolriverrecordscore;
    }

    public java.lang.Integer getValidpatrolrivertrackscore() {
        return validpatrolrivertrackscore;
    }

    public void setValidpatrolrivertrackscore(java.lang.Integer validpatrolrivertrackscore) {
        this.validpatrolrivertrackscore = validpatrolrivertrackscore;
    }

    public java.lang.Integer getAdditionitemscore() {
        return additionitemscore;
    }

    public void setAdditionitemscore(java.lang.Integer additionitemscore) {
        this.additionitemscore = additionitemscore;
    }

    public java.lang.Integer getEventdisposescore() {
        return eventdisposescore;
    }

    public void setEventdisposescore(java.lang.Integer eventdisposescore) {
        this.eventdisposescore = eventdisposescore;
    }

    public java.lang.Integer getSpecialscore() {
        return specialscore;
    }

    public void setSpecialscore(java.lang.Integer specialscore) {
        this.specialscore = specialscore;
    }

    public java.lang.Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(java.lang.Integer totalscore) {
        this.totalscore = totalscore;
    }

    public java.lang.Long getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(java.lang.Long provinceid) {
        this.provinceid = provinceid;
    }

    public java.lang.Long getCityid() {
        return cityid;
    }

    public void setCityid(java.lang.Long cityid) {
        this.cityid = cityid;
    }

    public java.lang.Long getCountyid() {
        return countyid;
    }

    public void setCountyid(java.lang.Long countyid) {
        this.countyid = countyid;
    }

    public java.lang.Long getTownid() {
        return townid;
    }

    public void setTownid(java.lang.Long townid) {
        this.townid = townid;
    }

    public java.lang.Long getVillageid() {
        return villageid;
    }

    public void setVillageid(java.lang.Long villageid) {
        this.villageid = villageid;
    }

    public java.lang.String getAssesstime() {
        return assesstime;
    }

    public void setAssesstime(java.lang.String assesstime) {
        this.assesstime = assesstime;
    }

    public java.util.Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(java.util.Date createtime) {
        this.createtime = createtime;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }
}
