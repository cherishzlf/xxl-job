package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 巡查标准表
 * @author fengtianpei<br>2017/8/21
 * @version 1.8.2
 */
public class AmBenchmark implements Serializable {
    private String id;              /** 主键 */
    private String title;           /** 标题 */
    private String type;            /** 类型 */
    private Integer provinceMark;   /** 省级河道巡河标准 */
    private Integer cityMark;       /** 市级河道巡河标准 */
    private Integer countyMark;     /** 县级河道巡河标准 */
    private Integer townMark;       /** 镇级河道巡河标准 */
    private Integer villageMark;    /** 村级河道巡河标准 */
    private Long regionId;          /** 区域ID */
    private Long provinceId;        /** 省区域ID */
    private Long cityId;            /** 市区域ID */
    private Long countyId;          /** 县区域ID */
    private Long townId;            /** 镇区域ID */
    private Long villageId;         /** 村区域ID */
    private Integer status;         /** 状态 */
    private Date createTime;        /** 创建时间 */
    private String userId;          /** 用户ID */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getProvinceMark() {
        return provinceMark;
    }

    public void setProvinceMark(Integer provinceMark) {
        this.provinceMark = provinceMark;
    }

    public Integer getCityMark() {
        return cityMark;
    }

    public void setCityMark(Integer cityMark) {
        this.cityMark = cityMark;
    }

    public Integer getCountyMark() {
        return countyMark;
    }

    public void setCountyMark(Integer countyMark) {
        this.countyMark = countyMark;
    }

    public Integer getTownMark() {
        return townMark;
    }

    public void setTownMark(Integer townMark) {
        this.townMark = townMark;
    }

    public Integer getVillageMark() {
        return villageMark;
    }

    public void setVillageMark(Integer villageMark) {
        this.villageMark = villageMark;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public Long getCountyId() {
        return countyId;
    }

    public void setCountyId(Long countyId) {
        this.countyId = countyId;
    }

    public Long getTownId() {
        return townId;
    }

    public void setTownId(Long townId) {
        this.townId = townId;
    }

    public Long getVillageId() {
        return villageId;
    }

    public void setVillageId(Long villageId) {
        this.villageId = villageId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
