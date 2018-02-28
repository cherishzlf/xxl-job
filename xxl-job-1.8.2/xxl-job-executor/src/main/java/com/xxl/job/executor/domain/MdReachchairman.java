package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 河段河长表
 * @author jiangjialiang<br>2017/8/12
 * @version 1.8.2
 */
public class MdReachchairman implements Serializable {
    private String id;					/** 主键id */
    private Integer recver;				/** 行版本 */
    private String chairmanId;			/** 河长id */
    private String reachId;				/** 河道id */
    private Integer reachLevel;			/** 河道级别，1：省级；2：市级；3：县级；4：镇级；5：村级 */
    private Integer chairmanLevel;		/** 河长等级，默认与河道级别一致 */
    private Integer chairmanType;		/** 河长类型，0：正河长；1：副河长 */
    private Integer status;				/** 状态，0：未审核；1：启用；2：停用 */
    private String createUserId;		/** 用户id - 创建 */
    private Date createTime;			/** 创建时间 */
    private String modifyUserId;		/** 用户id - 修改 */
    private Date modifyTime;			/** 修改时间 */
    private String auditUserId;			/** 用户id - 审核 */
    private Date auditTime;				/** 审核时间 */
    private String auditSuggestion;		/** 审核意见 */
    private Date effectTime;			/** 生效时间 */

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

	public String getChairmanId() {
		return chairmanId;
	}

	public void setChairmanId(String chairmanId) {
		this.chairmanId = chairmanId;
	}

	public String getReachId() {
		return reachId;
	}

	public void setReachId(String reachId) {
		this.reachId = reachId;
	}

	public Integer getReachLevel() {
		return reachLevel;
	}

	public void setReachLevel(Integer reachLevel) {
		this.reachLevel = reachLevel;
	}

	public Integer getChairmanLevel() {
		return chairmanLevel;
	}

	public void setChairmanLevel(Integer chairmanLevel) {
		this.chairmanLevel = chairmanLevel;
	}

	public Integer getChairmanType() {
		return chairmanType;
	}

	public void setChairmanType(Integer chairmanType) {
		this.chairmanType = chairmanType;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
}
