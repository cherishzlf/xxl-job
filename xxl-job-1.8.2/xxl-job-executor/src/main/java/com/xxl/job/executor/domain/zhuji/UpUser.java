package com.xxl.job.executor.domain.zhuji;

import java.io.Serializable;
import java.util.Date;

/**
 * 诸暨-绍兴接口（河长信息上报实体类）
 * @author liruimin<br>2017/9/28
 * @version 1.8.2
 */
public class UpUser implements Serializable {
    private String userId;
    private String objectName;
    private String adCode;
    private Integer type;
    private String phone;
    private String duty;
    private String unit;
    /** 上报时间 */
    private Date uploadtime;

    private String srcid;
    private String countyid;
    private String townid;
    private String villageid;

    public String getCountyid() {
        return countyid;
    }

    public void setCountyid(String countyid) {
        this.countyid = countyid;
    }

    public String getTownid() {
        return townid;
    }

    public void setTownid(String townid) {
        this.townid = townid;
    }

    public String getVillageid() {
        return villageid;
    }

    public void setVillageid(String villageid) {
        this.villageid = villageid;
    }

    public String getSrcid() {
        return srcid;
    }

    public void setSrcid(String srcid) {
        this.srcid = srcid;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
