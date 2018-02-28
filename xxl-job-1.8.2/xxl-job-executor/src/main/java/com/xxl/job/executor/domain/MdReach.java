package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 河段表
 * @author jiangjialiang<br>2017/8/12
 * @version 1.8.2
 */
public class MdReach implements Serializable {
    private String id;                          /** 主键id */
    private Integer recver;                     /** Unix时间戳，用于手机数据同步 */
    private String code;                        /** 河道编码 */
    private String name;                        /** 河道名称 */
    private String length;                      /** 河道长度 */
    private String overview;                    /** 河道描述 */
    private String parents;                     /** 父节点Parents+"|"+本节点ID，如果父节点为空，则直接为本节点ID */
	private String startPoint;                  /** 起点 */
    private BigDecimal langiofStartPoint;       /** 起点经度 */
    private BigDecimal latiofStartPoint;        /** 起点纬度 */
    private String endPoint;                    /** 终点 */
    private BigDecimal langiofEndPoint;         /** 终点经度 */
    private BigDecimal latiofEndPoint;          /** 终点纬度 */
    private String basinName;                   /** 所属水系名称 */
    private String riverId;                     /** 所属河流ID */
    private String riverName;                   /** 所属河流名称 */
    private Integer riverType;                  /** 河流类型 */
    private Long provinceId;                    /** 所在省ID */
    private Long cityId;                        /** 所在市ID */
    private Long countyId;                      /** 所在县ID */
    private Long townId;                        /** 所在镇ID */
    private Long villageId;                     /** 所在村ID */
    private String flowThrough;                 /** 流经区域 */
    private Integer riverFul;                   /** 河浜数 */
    private Integer relateWithSection;          /** 是否涉及处境交接断面 */
    private Integer reachLevel;                 /** 河道等级，1：省级；2：市级；3：县级；4：镇级；5：村级 */
    private Integer waterLevel;                 /** 水质级别 */
    private Integer silty;                      /** 淤积情况，0：通畅；1：淤积；2：严重淤积 */
    private String otherProblems;               /** 其他问题 */
    private String remark;                      /** 备注 */
    private BigDecimal sortOrder;               /** 排序号 */
    private Integer status;                     /** 状态，0：未审核；1：启用；2：停用 */
    private Integer showLevel;                  /** 显示优先级，0：省级；1：市级；2：县级；3：镇级；4：村级 */
    private String createUserId;                /** 用户id - 创建 */
    private Date createTime;                    /** 创建时间 */
    private String modifyUserId;                /** 用户id - 修改 */
    private Date modifyTime;                    /** 修改时间 */
    private String auditUserId;                 /** 用户id - 审核 */
    private Date auditTime;                     /** 审核时间 */
    private String auditSuggestion;             /** 审核意见 */
    private Date effectTime;                    /** 生效时间 */
    private BigDecimal centerLng;               /** 中心点经度 */
    private BigDecimal centerLat;               /** 中心点纬度 */
    private Integer reachStatus;                /** 河道状态 */
    private Date governTime;                    /** 治理时间 */
    private Long adminregionId;                 /** 所属行政区域id */
    private String chairman;                    /** 负责人（河长），河长名称，多个用逗号隔开，与chairmanid对应 */
    private Long widthOfBuffer;                 /** 缓冲区宽度，默认为0，单位为米 */
    private String filePathOfReach;             /** 一河一档文件路径 */
    private String filePathOfPolicy;            /** 一河一策文件路径 */
    private String linePoints;                  /** 线坐标点集合 */
    private String ogc;
    private String managementTarget;            /** 管理目标 */
    private String chairmanDuty;                /** 河长职责 */
    private String superviseTel;                /** 监督电话 */
    private String qrcode;                      /** 二维码 */
    private String reachPoliceId;               /** 河道检查员id */
    private String upperSectionId;              /** 上节断面id */
    private Integer dataUpFlag;                 /** 数据标志 */
    private Integer isVirtual;                  /** 是否虚拟河道 */
    private String chairmanId;                  /** 冗余河长id,多个河长用逗号隔开 */
    private String conDept;                     /** 联系部门 */
    private String conTel;                      /** 联系电话 */
    private String mainBody;
    private Integer cn;                         /** 收藏数 */
    private String src;                         /**  数据来源 */

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }



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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public BigDecimal getLangiofStartPoint() {
        return langiofStartPoint;
    }

    public void setLangiofStartPoint(BigDecimal langiofStartPoint) {
        this.langiofStartPoint = langiofStartPoint;
    }

    public BigDecimal getLatiofStartPoint() {
        return latiofStartPoint;
    }

    public void setLatiofStartPoint(BigDecimal latiofStartPoint) {
        this.latiofStartPoint = latiofStartPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public BigDecimal getLangiofEndPoint() {
        return langiofEndPoint;
    }

    public void setLangiofEndPoint(BigDecimal langiofEndPoint) {
        this.langiofEndPoint = langiofEndPoint;
    }

    public BigDecimal getLatiofEndPoint() {
        return latiofEndPoint;
    }

    public void setLatiofEndPoint(BigDecimal latiofEndPoint) {
        this.latiofEndPoint = latiofEndPoint;
    }

    public String getBasinName() {
        return basinName;
    }

    public void setBasinName(String basinName) {
        this.basinName = basinName;
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

    public Integer getRiverType() {
        return riverType;
    }

    public void setRiverType(Integer riverType) {
        this.riverType = riverType;
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

    public String getFlowThrough() {
        return flowThrough;
    }

    public void setFlowThrough(String flowThrough) {
        this.flowThrough = flowThrough;
    }

    public Integer getRiverFul() {
        return riverFul;
    }

    public void setRiverFul(Integer riverFul) {
        this.riverFul = riverFul;
    }

    public Integer getRelateWithSection() {
        return relateWithSection;
    }

    public void setRelateWithSection(Integer relateWithSection) {
        this.relateWithSection = relateWithSection;
    }

    public Integer getReachLevel() {
        return reachLevel;
    }

    public void setReachLevel(Integer reachLevel) {
        this.reachLevel = reachLevel;
    }

    public Integer getWaterLevel() {
        return waterLevel;
    }

    public void setWaterLevel(Integer waterLevel) {
        this.waterLevel = waterLevel;
    }

    public Integer getSilty() {
        return silty;
    }

    public void setSilty(Integer silty) {
        this.silty = silty;
    }

    public String getOtherProblems() {
        return otherProblems;
    }

    public void setOtherProblems(String otherProblems) {
        this.otherProblems = otherProblems;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(BigDecimal sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getShowLevel() {
        return showLevel;
    }

    public void setShowLevel(Integer showLevel) {
        this.showLevel = showLevel;
    }

    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifyUserId() {
        return modifyUserId;
    }

    public void setModifyUserId(String modifyUserId) {
        this.modifyUserId = modifyUserId;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public String getAuditSuggestion() {
        return auditSuggestion;
    }

    public void setAuditSuggestion(String auditSuggestion) {
        this.auditSuggestion = auditSuggestion;
    }

    public Date getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(Date effectTime) {
        this.effectTime = effectTime;
    }

    public BigDecimal getCenterLng() {
        return centerLng;
    }

    public void setCenterLng(BigDecimal centerLng) {
        this.centerLng = centerLng;
    }

    public BigDecimal getCenterLat() {
        return centerLat;
    }

    public void setCenterLat(BigDecimal centerLat) {
        this.centerLat = centerLat;
    }

    public Integer getReachStatus() {
        return reachStatus;
    }

    public void setReachStatus(Integer reachStatus) {
        this.reachStatus = reachStatus;
    }

    public Date getGovernTime() {
        return governTime;
    }

    public void setGovernTime(Date governTime) {
        this.governTime = governTime;
    }

    public Long getAdminregionId() {
        return adminregionId;
    }

    public void setAdminregionId(Long adminregionId) {
        this.adminregionId = adminregionId;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public Long getWidthOfBuffer() {
        return widthOfBuffer;
    }

    public void setWidthOfBuffer(Long widthOfBuffer) {
        this.widthOfBuffer = widthOfBuffer;
    }

    public String getFilePathOfReach() {
        return filePathOfReach;
    }

    public void setFilePathOfReach(String filePathOfReach) {
        this.filePathOfReach = filePathOfReach;
    }

    public String getFilePathOfPolicy() {
        return filePathOfPolicy;
    }

    public void setFilePathOfPolicy(String filePathOfPolicy) {
        this.filePathOfPolicy = filePathOfPolicy;
    }

    public String getLinePoints() {
        return linePoints;
    }

    public void setLinePoints(String linePoints) {
        this.linePoints = linePoints;
    }

    public String getOgc() {
        return ogc;
    }

    public void setOgc(String ogc) {
        this.ogc = ogc;
    }

    public String getManagementTarget() {
        return managementTarget;
    }

    public void setManagementTarget(String managementTarget) {
        this.managementTarget = managementTarget;
    }

    public String getChairmanDuty() {
        return chairmanDuty;
    }

    public void setChairmanDuty(String chairmanDuty) {
        this.chairmanDuty = chairmanDuty;
    }

    public String getSuperviseTel() {
        return superviseTel;
    }

    public void setSuperviseTel(String superviseTel) {
        this.superviseTel = superviseTel;
    }

    public String getQrcode() {
        return qrcode;
    }

    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    public String getReachPoliceId() {
        return reachPoliceId;
    }

    public void setReachPoliceId(String reachPoliceId) {
        this.reachPoliceId = reachPoliceId;
    }

    public String getUpperSectionId() {
        return upperSectionId;
    }

    public void setUpperSectionId(String upperSectionId) {
        this.upperSectionId = upperSectionId;
    }

    public Integer getDataUpFlag() {
        return dataUpFlag;
    }

    public void setDataUpFlag(Integer dataUpFlag) {
        this.dataUpFlag = dataUpFlag;
    }

    public Integer getIsVirtual() {
        return isVirtual;
    }

    public void setIsVirtual(Integer isVirtual) {
        this.isVirtual = isVirtual;
    }

    public String getChairmanId() {
        return chairmanId;
    }

    public void setChairmanId(String chairmanId) {
        this.chairmanId = chairmanId;
    }

    public String getConDept() {
        return conDept;
    }

    public void setConDept(String conDept) {
        this.conDept = conDept;
    }

    public String getConTel() {
        return conTel;
    }

    public void setConTel(String conTel) {
        this.conTel = conTel;
    }

    public String getMainBody() {
        return mainBody;
    }

    public void setMainBody(String mainBody) {
        this.mainBody = mainBody;
    }

    public Integer getCn() {
        return cn;
    }

    public void setCn(Integer cn) {
        this.cn = cn;
    }
}
