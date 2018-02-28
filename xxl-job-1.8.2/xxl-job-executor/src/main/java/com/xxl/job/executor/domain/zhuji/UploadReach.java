package com.xxl.job.executor.domain.zhuji;

import java.io.Serializable;
import java.util.Date;

/**
 * 诸暨-绍兴接口（河道信息上报实体类）
 * @author liruimin<br>2017/9/28
 * @version 1.8.2
 */
public class UploadReach implements Serializable {
    private String riverId;
    private String riverName;
    private String riveralias;
    private Integer riverno;
    private String adCode;
    private String basin;
    private String dataType;
    private String riverType;
    private String length;
    private String origin;
    private String endPoint;
    private String userId;
    /** 上报时间 */
    private Date uploadtime;
    private String countyid;
    private String townid;
    private String villageid;
    private Integer reachLevel;
    private String srcid;

    public String getSrcid() {
        return srcid;
    }

    public void setSrcid(String srcid) {
        this.srcid = srcid;
    }

    public Integer getReachLevel() {
        return reachLevel;
    }

    public void setReachLevel(Integer reachLevel) {
        this.reachLevel = reachLevel;
    }

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

    public String getRiverName() {
        return riverName;
    }

    public void setRiverName(String riverName) {
        this.riverName = riverName;
    }

    public String getRiveralias() {
        return riveralias;
    }

    public void setRiveralias(String riveralias) {
        this.riveralias = riveralias;
    }

    public Integer getRiverno() {
        return riverno;
    }

    public void setRiverno(Integer riverno) {
        this.riverno = riverno;
    }

    public String getAdCode() {
        return adCode;
    }

    public void setAdCode(String adCode) {
        this.adCode = adCode;
    }

    public String getBasin() {
        return basin;
    }

    public void setBasin(String basin) {
        this.basin = basin;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getRiverType() {
        return riverType;
    }

    public void setRiverType(String riverType) {
        this.riverType = riverType;
    }

    public String getLength() {
        return length;
    }
    public void setLength(String length) {
        this.length = length;
    }
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
