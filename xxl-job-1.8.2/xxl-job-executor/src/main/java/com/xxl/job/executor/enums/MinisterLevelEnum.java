package com.xxl.job.executor.enums;

/**
 * 总河长等级枚举
 * @author liruimin<br>2017/8/12
 * @version 1.8.2
 */
public enum MinisterLevelEnum {

	PROVINCE("1738FB74-37D2-4E3B-9C44-F2C2EA0CB4BA","省级河长")
	,CITY("4A9DCC6D-876A-4509-8075-7C0D8E7530D0","市级河长")
	,COUNTY("B9A68046-10AE-4BEE-8164-A37DDE1F9E19","县级河长")
	,TOWN("A8833839-A3D3-4DDE-A17D-668C754D32C5","乡镇级河长");
	private String code;
	private String remark;

	MinisterLevelEnum(String code, String remark) {
		this.code = code;
		this.remark = remark;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
