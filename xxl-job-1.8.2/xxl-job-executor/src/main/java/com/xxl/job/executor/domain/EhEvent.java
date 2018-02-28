package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 事件表
 * @author jiangjialiang<br>2017/8/12
 * @version 1.8.2
 */
public class EhEvent implements Serializable {
    private String id;                      /** 主键id */
    private Integer recver;                 /** 行版本 */
    private String serialNo;                /** 事件编号 */
    private String type;                    /** 事件类型id */
    private String eventLevel;              /** 事件等级 */
    private String content;                 /** 事件内容 */
    private String eventResource;           /** 事件来源 */
    private String status;                  /** 事件状态 */
    private Date createTime;                /** 事件发生时间 */
    private String address;                 /** 事发地 */
    private BigDecimal longitude;           /** 经度 */
    private BigDecimal latitude;            /** 纬度 */
    private Date endTime;                   /** 事件结束时间 */
    private String eventBelongCity;         /** 事件归属市 */
    private String eventBelongCounty;       /** 事件归属县 */
    private String eventBelongTown;         /** 事件归属镇 */
    private String eventBelongVillage;      /** 事件归属村 */
    private Long eventOccurAreaId;          /** 事发行政区域id */
    private String partsId;                 /** 部件id */
    private String partsName;               /** 部件名称 */
    private String partsType;               /** 部件类型 */
    private String partsTableName;          /** 部件对应数据表 */
    private String reportPersonId;          /** 上报人id */
    private String reportPerson;            /** 上报人 */
    private Date reportTime;                /** 上报时间 */
    private String reportPhone;             /** 上报电话 */
    private String contactWay;              /** 上报人联系方式 */
    private Integer isPrivary;              /** 是否保密 */
    private String contactAddress;          /** 上报人联系地址 */
    private String acceptPersonId;          /** 接线员id (用户id) */
    private String acceptPerson;            /** 接线员 */
    private Date acceptDate;                /** 接线员处理时间 */
    private String handleUnitId;            /** 处理单位id */
    private String handleUnit;              /** 处理单位 */
    private String handleUnitArea;          /** 处理单位面积 */
    private Long handleUnitAreaId;          /** 处理单位面积id */
    private String isExposure;              /** 是否接触 */
    private String inspectorId;             /** 检查员id */
    private String inspector;               /** 检查员 */
    private Date inspectTime;               /** 检查时间 */
    private String inspectDesc;             /** 检查描述 */
    private String inspectStatus;           /** 检查状态 */
    private String eventBasinId;            /** 事件所属水系id */
    private String eventBasinName;          /** 事件所属水系名称 */
    private String eventRiverId;            /** 事件所属河流id */
    private String eventRiverName;          /** 事件所属河流名称 */
    private Integer eventRiverType;         /** 事件所属河流类型 */
    private String eventReachId;            /** 事件所属河道id */
    private String eventReachName;          /** 事件所属河道名称 */
    private String eventGridId;             /** 事件所属网格id */
    private String eventGridName;           /** 事件所属网格名称 */
    private String instructionStatus;       /** 批示状态 */
    private String typeName;                /** 事件类型名称 */
    private Date tacheHandleTime;           /** 最新环节处理时间 */
    private Date handleEndTime;             /** 待派单环节处理截至时间 */
    private Long eventBelongCityId;         /** 事件归属市id */
    private Long eventBelongCountyId;       /** 事件归属县id */
    private Long eventBelongTownId;         /** 事件归属镇id */
    private Long eventBelongVillageId;      /** 事件归属村id */
    private Float processingTime;           /** 事件处理时长 */
    private String isSupervise;             /** 是否监督 */
    private String provinceReachId;         /** 省级河道id */
    private String cityReachId;             /** 市级河道id */
    private String countyReachId;           /** 县级河道id */
    private String townReachId;             /** 镇级河道id */
    private String villageReachId;          /** 村级河道id */
    private String worklogId;               /** 工作日志id */
    private String patrolId;                /** 巡查轨迹id */
    private String componentId;             /** 部件id */
    private Integer dataSrcCode;			/** 数据编码 */
    private Integer dataUpFlag;             /** 数据标志 */
    private Date uploadTime;                /** 上报服务的上报时间 */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRecver() {
        return recver;
    }

    public void setRecver(Integer recver) {
        this.recver = recver;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventLevel() {
        return eventLevel;
    }

    public void setEventLevel(String eventLevel) {
        this.eventLevel = eventLevel;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEventResource() {
        return eventResource;
    }

    public void setEventResource(String eventResource) {
        this.eventResource = eventResource;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEventBelongCity() {
        return eventBelongCity;
    }

    public void setEventBelongCity(String eventBelongCity) {
        this.eventBelongCity = eventBelongCity;
    }

    public String getEventBelongCounty() {
        return eventBelongCounty;
    }

    public void setEventBelongCounty(String eventBelongCounty) {
        this.eventBelongCounty = eventBelongCounty;
    }

    public String getEventBelongTown() {
        return eventBelongTown;
    }

    public void setEventBelongTown(String eventBelongTown) {
        this.eventBelongTown = eventBelongTown;
    }

    public String getEventBelongVillage() {
        return eventBelongVillage;
    }

    public void setEventBelongVillage(String eventBelongVillage) {
        this.eventBelongVillage = eventBelongVillage;
    }

    public Long getEventOccurAreaId() {
        return eventOccurAreaId;
    }

    public void setEventOccurAreaId(Long eventOccurAreaId) {
        this.eventOccurAreaId = eventOccurAreaId;
    }

    public String getPartsId() {
        return partsId;
    }

    public void setPartsId(String partsId) {
        this.partsId = partsId;
    }

    public String getPartsName() {
        return partsName;
    }

    public void setPartsName(String partsName) {
        this.partsName = partsName;
    }

    public String getPartsType() {
        return partsType;
    }

    public void setPartsType(String partsType) {
        this.partsType = partsType;
    }

    public String getPartsTableName() {
        return partsTableName;
    }

    public void setPartsTableName(String partsTableName) {
        this.partsTableName = partsTableName;
    }

    public String getReportPersonId() {
        return reportPersonId;
    }

    public void setReportPersonId(String reportPersonId) {
        this.reportPersonId = reportPersonId;
    }

    public String getReportPerson() {
        return reportPerson;
    }

    public void setReportPerson(String reportPerson) {
        this.reportPerson = reportPerson;
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportPhone() {
        return reportPhone;
    }

    public void setReportPhone(String reportPhone) {
        this.reportPhone = reportPhone;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay;
    }

    public Integer getIsPrivary() {
        return isPrivary;
    }

    public void setIsPrivary(Integer isPrivary) {
        this.isPrivary = isPrivary;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getAcceptPersonId() {
        return acceptPersonId;
    }

    public void setAcceptPersonId(String acceptPersonId) {
        this.acceptPersonId = acceptPersonId;
    }

    public String getAcceptPerson() {
        return acceptPerson;
    }

    public void setAcceptPerson(String acceptPerson) {
        this.acceptPerson = acceptPerson;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getHandleUnitId() {
        return handleUnitId;
    }

    public void setHandleUnitId(String handleUnitId) {
        this.handleUnitId = handleUnitId;
    }

    public String getHandleUnit() {
        return handleUnit;
    }

    public void setHandleUnit(String handleUnit) {
        this.handleUnit = handleUnit;
    }

    public String getHandleUnitArea() {
        return handleUnitArea;
    }

    public void setHandleUnitArea(String handleUnitArea) {
        this.handleUnitArea = handleUnitArea;
    }

    public Long getHandleUnitAreaId() {
        return handleUnitAreaId;
    }

    public void setHandleUnitAreaId(Long handleUnitAreaId) {
        this.handleUnitAreaId = handleUnitAreaId;
    }

    public String getIsExposure() {
        return isExposure;
    }

    public void setIsExposure(String isExposure) {
        this.isExposure = isExposure;
    }

    public String getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(String inspectorId) {
        this.inspectorId = inspectorId;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public Date getInspectTime() {
        return inspectTime;
    }

    public void setInspectTime(Date inspectTime) {
        this.inspectTime = inspectTime;
    }

    public String getInspectDesc() {
        return inspectDesc;
    }

    public void setInspectDesc(String inspectDesc) {
        this.inspectDesc = inspectDesc;
    }

    public String getInspectStatus() {
        return inspectStatus;
    }

    public void setInspectStatus(String inspectStatus) {
        this.inspectStatus = inspectStatus;
    }

    public String getEventBasinId() {
        return eventBasinId;
    }

    public void setEventBasinId(String eventBasinId) {
        this.eventBasinId = eventBasinId;
    }

    public String getEventBasinName() {
        return eventBasinName;
    }

    public void setEventBasinName(String eventBasinName) {
        this.eventBasinName = eventBasinName;
    }

    public String getEventRiverId() {
        return eventRiverId;
    }

    public void setEventRiverId(String eventRiverId) {
        this.eventRiverId = eventRiverId;
    }

    public String getEventRiverName() {
        return eventRiverName;
    }

    public void setEventRiverName(String eventRiverName) {
        this.eventRiverName = eventRiverName;
    }

    public Integer getEventRiverType() {
        return eventRiverType;
    }

    public void setEventRiverType(Integer eventRiverType) {
        this.eventRiverType = eventRiverType;
    }

    public String getEventReachId() {
        return eventReachId;
    }

    public void setEventReachId(String eventReachId) {
        this.eventReachId = eventReachId;
    }

    public String getEventReachName() {
        return eventReachName;
    }

    public void setEventReachName(String eventReachName) {
        this.eventReachName = eventReachName;
    }

    public String getEventGridId() {
        return eventGridId;
    }

    public void setEventGridId(String eventGridId) {
        this.eventGridId = eventGridId;
    }

    public String getEventGridName() {
        return eventGridName;
    }

    public void setEventGridName(String eventGridName) {
        this.eventGridName = eventGridName;
    }

    public String getInstructionStatus() {
        return instructionStatus;
    }

    public void setInstructionStatus(String instructionStatus) {
        this.instructionStatus = instructionStatus;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Date getTacheHandleTime() {
        return tacheHandleTime;
    }

    public void setTacheHandleTime(Date tacheHandleTime) {
        this.tacheHandleTime = tacheHandleTime;
    }

    public Date getHandleEndTime() {
        return handleEndTime;
    }

    public void setHandleEndTime(Date handleEndTime) {
        this.handleEndTime = handleEndTime;
    }

    public Long getEventBelongCityId() {
        return eventBelongCityId;
    }

    public void setEventBelongCityId(Long eventBelongCityId) {
        this.eventBelongCityId = eventBelongCityId;
    }

    public Long getEventBelongCountyId() {
        return eventBelongCountyId;
    }

    public void setEventBelongCountyId(Long eventBelongCountyId) {
        this.eventBelongCountyId = eventBelongCountyId;
    }

    public Long getEventBelongTownId() {
        return eventBelongTownId;
    }

    public void setEventBelongTownId(Long eventBelongTownId) {
        this.eventBelongTownId = eventBelongTownId;
    }

    public Long getEventBelongVillageId() {
        return eventBelongVillageId;
    }

    public void setEventBelongVillageId(Long eventBelongVillageId) {
        this.eventBelongVillageId = eventBelongVillageId;
    }

    public Float getProcessingTime() {
        return processingTime;
    }

    public void setProcessingTime(Float processingTime) {
        this.processingTime = processingTime;
    }

    public String getIsSupervise() {
        return isSupervise;
    }

    public void setIsSupervise(String isSupervise) {
        this.isSupervise = isSupervise;
    }

    public String getProvinceReachId() {
        return provinceReachId;
    }

    public void setProvinceReachId(String provinceReachId) {
        this.provinceReachId = provinceReachId;
    }

    public String getCityReachId() {
        return cityReachId;
    }

    public void setCityReachId(String cityReachId) {
        this.cityReachId = cityReachId;
    }

    public String getCountyReachId() {
        return countyReachId;
    }

    public void setCountyReachId(String countyReachId) {
        this.countyReachId = countyReachId;
    }

    public String getTownReachId() {
        return townReachId;
    }

    public void setTownReachId(String townReachId) {
        this.townReachId = townReachId;
    }

    public String getVillageReachId() {
        return villageReachId;
    }

    public void setVillageReachId(String villageReachId) {
        this.villageReachId = villageReachId;
    }

    public String getWorklogId() {
        return worklogId;
    }

    public void setWorklogId(String worklogId) {
        this.worklogId = worklogId;
    }

    public String getPatrolId() {
        return patrolId;
    }

    public void setPatrolId(String patrolId) {
        this.patrolId = patrolId;
    }

    public String getComponentId() {
        return componentId;
    }

    public void setComponentId(String componentId) {
        this.componentId = componentId;
    }

    public Integer getDataSrcCode() {
        return dataSrcCode;
    }

    public void setDataSrcCode(Integer dataSrcCode) {
        this.dataSrcCode = dataSrcCode;
    }

    public Integer getDataUpFlag() {
        return dataUpFlag;
    }

    public void setDataUpFlag(Integer dataUpFlag) {
        this.dataUpFlag = dataUpFlag;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }
}
