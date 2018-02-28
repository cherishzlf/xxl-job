package com.xxl.job.executor.domain;

import java.io.Serializable;

/**
 * 电子化考核模板
 * @author xu_zhu<br/> 2017/11/22 10:35
 */
public class AmTemplateElectronic implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;                          /** 主键 */
    private String title;                       /** 标题 */
    private Integer baseinfo;                   /** 河长基本信息分数 */
    private Integer baseName;                   /** 河长姓名分数 */
    private Integer baseLevel;                  /** 河长级别分数 */
    private Integer baseUnit;                   /** 河长单位分数 */
    private Integer baseDuty;                   /** 河长职务分数 */
    private Integer basePhone;                  /** 河长电话分数 */
    private Integer baseDepartment;             /** 河长部门分数 */
    private Integer baseDepartmentphone;        /** 河长部门电话 */
    private Integer patrolstandar;              /** 巡查达标分数 */
    private Integer patrolCounty;               /** 县级巡查少一次扣分数 */
    private Integer patrolCountyperiod;         /** 县级巡查周期/月 */
    private Integer patrolTown;                 /** 镇级巡查少一次扣分数 */
    private Integer patrolTownperiod;           /** 镇级巡查周期/月 */
    private Integer patrolVillage;              /** 村级巡查少一次扣分数 */
    private Integer patrolVillageperiod;        /** 村级巡查周期/月 */
    private Integer patrolrecord;               /** 巡查记录内容分数 */
    private Integer recordCheckitems;           /** 巡查记录涉及项扣分数 */
    private Integer recordLcountunit;           /** 巡查记录内容扣分数单位 1:项 0:次*/
    private Integer recordDevice;               /** 巡查影音设备扣分数 */
    private Integer recordContent;              /** 巡查内容扣分数 */
    private Integer validlocus;                 /** 有效轨迹分数 */
    private Integer validCounty;                /** 县级无效一次扣分数 */
    private Integer validTown;                  /** 镇级无效依稀扣分数 */
    private Integer validVillage;               /** 村级无效一次扣分数 */
    private Integer eventdispose;               /** 事件处理分数 */
    private Integer eventMarks;                 /** 事件一次未处理扣分数 */
    private Integer eventInterval;              /** 事件周期数 */
    private Float additionitem;                 /** 附加项分数 */
    private Integer maxadditionitem;            /** 附加项最大分数 */
    private String specialid;                   /**特设考核id*/

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

    public Integer getBaseinfo() {
        return baseinfo;
    }

    public void setBaseinfo(Integer baseinfo) {
        this.baseinfo = baseinfo;
    }

    public Integer getBaseName() {
        return baseName;
    }

    public void setBaseName(Integer baseName) {
        this.baseName = baseName;
    }

    public Integer getBaseLevel() {
        return baseLevel;
    }

    public void setBaseLevel(Integer baseLevel) {
        this.baseLevel = baseLevel;
    }

    public Integer getBaseUnit() {
        return baseUnit;
    }

    public void setBaseUnit(Integer baseUnit) {
        this.baseUnit = baseUnit;
    }

    public Integer getBaseDuty() {
        return baseDuty;
    }

    public void setBaseDuty(Integer baseDuty) {
        this.baseDuty = baseDuty;
    }

    public Integer getBasePhone() {
        return basePhone;
    }

    public void setBasePhone(Integer basePhone) {
        this.basePhone = basePhone;
    }

    public Integer getBaseDepartment() {
        return baseDepartment;
    }

    public void setBaseDepartment(Integer baseDepartment) {
        this.baseDepartment = baseDepartment;
    }

    public Integer getBaseDepartmentphone() {
        return baseDepartmentphone;
    }

    public void setBaseDepartmentphone(Integer baseDepartmentphone) {
        this.baseDepartmentphone = baseDepartmentphone;
    }

    public Integer getPatrolstandar() {
        return patrolstandar;
    }

    public void setPatrolstandar(Integer patrolstandar) {
        this.patrolstandar = patrolstandar;
    }

    public Integer getPatrolCounty() {
        return patrolCounty;
    }

    public void setPatrolCounty(Integer patrolCounty) {
        this.patrolCounty = patrolCounty;
    }

    public Integer getPatrolCountyperiod() {
        return patrolCountyperiod;
    }

    public void setPatrolCountyperiod(Integer patrolCountyperiod) {
        this.patrolCountyperiod = patrolCountyperiod;
    }

    public Integer getPatrolTown() {
        return patrolTown;
    }

    public void setPatrolTown(Integer patrolTown) {
        this.patrolTown = patrolTown;
    }

    public Integer getPatrolTownperiod() {
        return patrolTownperiod;
    }

    public void setPatrolTownperiod(Integer patrolTownperiod) {
        this.patrolTownperiod = patrolTownperiod;
    }

    public Integer getPatrolVillage() {
        return patrolVillage;
    }

    public void setPatrolVillage(Integer patrolVillage) {
        this.patrolVillage = patrolVillage;
    }

    public Integer getPatrolVillageperiod() {
        return patrolVillageperiod;
    }

    public void setPatrolVillageperiod(Integer patrolVillageperiod) {
        this.patrolVillageperiod = patrolVillageperiod;
    }

    public Integer getPatrolrecord() {
        return patrolrecord;
    }

    public void setPatrolrecord(Integer patrolrecord) {
        this.patrolrecord = patrolrecord;
    }

    public Integer getRecordCheckitems() {
        return recordCheckitems;
    }

    public void setRecordCheckitems(Integer recordCheckitems) {
        this.recordCheckitems = recordCheckitems;
    }

    public Integer getRecordLcountunit() {
        return recordLcountunit;
    }

    public void setRecordLcountunit(Integer recordLcountunit) {
        this.recordLcountunit = recordLcountunit;
    }

    public Integer getRecordDevice() {
        return recordDevice;
    }

    public void setRecordDevice(Integer recordDevice) {
        this.recordDevice = recordDevice;
    }

    public Integer getRecordContent() {
        return recordContent;
    }

    public void setRecordContent(Integer recordContent) {
        this.recordContent = recordContent;
    }

    public Integer getValidlocus() {
        return validlocus;
    }

    public void setValidlocus(Integer validlocus) {
        this.validlocus = validlocus;
    }

    public Integer getValidCounty() {
        return validCounty;
    }

    public void setValidCounty(Integer validCounty) {
        this.validCounty = validCounty;
    }

    public Integer getValidTown() {
        return validTown;
    }

    public void setValidTown(Integer validTown) {
        this.validTown = validTown;
    }

    public Integer getValidVillage() {
        return validVillage;
    }

    public void setValidVillage(Integer validVillage) {
        this.validVillage = validVillage;
    }

    public Integer getEventdispose() {
        return eventdispose;
    }

    public void setEventdispose(Integer eventdispose) {
        this.eventdispose = eventdispose;
    }

    public Integer getEventMarks() {
        return eventMarks;
    }

    public void setEventMarks(Integer eventMarks) {
        this.eventMarks = eventMarks;
    }

    public Integer getEventInterval() {
        return eventInterval;
    }

    public void setEventInterval(Integer eventInterval) {
        this.eventInterval = eventInterval;
    }

    public Float getAdditionitem() {
        return additionitem;
    }

    public void setAdditionitem(Float additionitem) {
        this.additionitem = additionitem;
    }

    public Integer getMaxadditionitem() {
        return maxadditionitem;
    }

    public void setMaxadditionitem(Integer maxadditionitem) {
        this.maxadditionitem = maxadditionitem;
    }

    public String getSpecialid() {
        return specialid;
    }

    public void setSpecialid(String specialid) {
        this.specialid = specialid;
    }
}
