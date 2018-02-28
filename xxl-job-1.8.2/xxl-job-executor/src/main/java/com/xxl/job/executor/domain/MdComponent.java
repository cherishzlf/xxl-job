package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 部件表
 * @author jiangjialiang<br>2017/8/12
 * @version 0.0.1
 */
public class MdComponent implements Serializable {
	private String id;							/** 主键id */
	private Integer recver;						/** 行版本 */
	private String name;						/** 部件名称 */
	private String code;						/** 部件编码 */
    private String oldCode;						/** 部件旧编码 */
	private BigDecimal longitude;				/** 经度 */
	private BigDecimal latitude;				/** 纬度 */
	private String discription;					/** 描述 */
	private String imageId;						/** 图片id */
	private Long provinceId;					/** 省id */
	private Long cityId;						/** 市id */
	private Long countyId;						/** 县id */
	private Long townId;						/** 镇id */
	private Long villageId;						/** 村id */
	private String gridId;						/** 网格id */
	private Integer compLevel;					/** 部件级别，1：省级；2：市级；3：县级；4：镇级；5：村级 */
	private String mainClassId;					/** 部件大类id */
	private String subClassId;					/** 部件小类id */
	private String mainClassName;				/** 大类名称 */
	private String subClassName;				/** 小类名称 */
	private String batchNo;						/** 批次号 */
	private String batchExplain;				/** 批次说明 */
	private Integer source;						/** 来源，0：手工录入；1：手工导入；2：系统接入；3：数据同步获取 */
	private BigDecimal distanceFromRiver;		/** 离河距离 */
	private Integer status;						/** 状态，0：未审核；1：启用；2：停用 */
	private Integer showLevel;					/** 显示优先级，1：省级；2：市级；3：县级；4：镇级；5：村级 */
	private String createUserId;				/** 用户id - 创建 */
	private Date createTime;					/** 创建时间 */
	private String modifyUserId;				/** 用户id - 修改 */
	private Date modifyTime;					/** 修改时间 */
	private String auditUserId;					/** 用户id - 审核 */
	private Date auditTime;						/** 审核时间 */
	private String auditSuggestion;				/** 审核意见 */
	private Date effectTime;					/** 生效时间 */
	private String remark;						/** 备注 */
	private BigDecimal sortOrder;				/** 排序号 */
	private Integer attentionLevel;				/** 关注级别，0：普通；1：重点隐患点 */
	private String belongUnit;					/** 归属单位名称 */
	private String belongPerson;				/** 归属人 */
	private String belongPersonTel;				/** 归属人电话 */
	private Character writeType;				/** 读写类型 */
	private String funcDept;					/** 职能部门 */
	private String funcDeptPerson;				/** 职能部门联系人 */
	private String funcDeptPersonTel;			/** 职能部门联系电话 */
	private Integer mainClassProp;				/** 大类道具 */
	private String tableName;					/** 所关联的表名 */
	private String provinceReach;				/** 所属省级河道 */
	private String cityReach;					/** 所属市级河道 */
	private String countyReach;					/** 所属县级河道 */
	private String townReach;					/** 所属镇级河道 */
	private String villageReach;				/** 所属村级河道 */
	private String reachId;						/** 河道id */
	private Integer isBindRes;					/** 是否是结合物 */
	private Integer dataSrcCode;				/** 数据编码 */
	private Integer dataUpFlag;					/** 数据标志 */

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOldCode() {
		return oldCode;
	}

	public void setOldCode(String oldCode) {
		this.oldCode = oldCode;
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

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public String getImageId() {
		return imageId;
	}

	public void setImageId(String imageId) {
		this.imageId = imageId;
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

	public String getGridId() {
		return gridId;
	}

	public void setGridId(String gridId) {
		this.gridId = gridId;
	}

	public Integer getCompLevel() {
		return compLevel;
	}

	public void setCompLevel(Integer compLevel) {
		this.compLevel = compLevel;
	}

	public String getMainClassId() {
		return mainClassId;
	}

	public void setMainClassId(String mainClassId) {
		this.mainClassId = mainClassId;
	}

	public String getSubClassId() {
		return subClassId;
	}

	public void setSubClassId(String subClassId) {
		this.subClassId = subClassId;
	}

	public String getMainClassName() {
		return mainClassName;
	}

	public void setMainClassName(String mainClassName) {
		this.mainClassName = mainClassName;
	}

	public String getSubClassName() {
		return subClassName;
	}

	public void setSubClassName(String subClassName) {
		this.subClassName = subClassName;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getBatchExplain() {
		return batchExplain;
	}

	public void setBatchExplain(String batchExplain) {
		this.batchExplain = batchExplain;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public BigDecimal getDistanceFromRiver() {
		return distanceFromRiver;
	}

	public void setDistanceFromRiver(BigDecimal distanceFromRiver) {
		this.distanceFromRiver = distanceFromRiver;
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

	public Integer getAttentionLevel() {
		return attentionLevel;
	}

	public void setAttentionLevel(Integer attentionLevel) {
		this.attentionLevel = attentionLevel;
	}

	public String getBelongUnit() {
		return belongUnit;
	}

	public void setBelongUnit(String belongUnit) {
		this.belongUnit = belongUnit;
	}

	public String getBelongPerson() {
		return belongPerson;
	}

	public void setBelongPerson(String belongPerson) {
		this.belongPerson = belongPerson;
	}

	public String getBelongPersonTel() {
		return belongPersonTel;
	}

	public void setBelongPersonTel(String belongPersonTel) {
		this.belongPersonTel = belongPersonTel;
	}

	public Character getWriteType() {
		return writeType;
	}

	public void setWriteType(Character writeType) {
		this.writeType = writeType;
	}

	public String getFuncDept() {
		return funcDept;
	}

	public void setFuncDept(String funcDept) {
		this.funcDept = funcDept;
	}

	public String getFuncDeptPerson() {
		return funcDeptPerson;
	}

	public void setFuncDeptPerson(String funcDeptPerson) {
		this.funcDeptPerson = funcDeptPerson;
	}

	public String getFuncDeptPersonTel() {
		return funcDeptPersonTel;
	}

	public void setFuncDeptPersonTel(String funcDeptPersonTel) {
		this.funcDeptPersonTel = funcDeptPersonTel;
	}

	public Integer getMainClassProp() {
		return mainClassProp;
	}

	public void setMainClassProp(Integer mainClassProp) {
		this.mainClassProp = mainClassProp;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getProvinceReach() {
		return provinceReach;
	}

	public void setProvinceReach(String provinceReach) {
		this.provinceReach = provinceReach;
	}

	public String getCityReach() {
		return cityReach;
	}

	public void setCityReach(String cityReach) {
		this.cityReach = cityReach;
	}

	public String getCountyReach() {
		return countyReach;
	}

	public void setCountyReach(String countyReach) {
		this.countyReach = countyReach;
	}

	public String getTownReach() {
		return townReach;
	}

	public void setTownReach(String townReach) {
		this.townReach = townReach;
	}

	public String getVillageReach() {
		return villageReach;
	}

	public void setVillageReach(String villageReach) {
		this.villageReach = villageReach;
	}

	public String getReachId() {
		return reachId;
	}

	public void setReachId(String reachId) {
		this.reachId = reachId;
	}

	public Integer getIsBindRes() {
		return isBindRes;
	}

	public void setIsBindRes(Integer isBindRes) {
		this.isBindRes = isBindRes;
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
}
