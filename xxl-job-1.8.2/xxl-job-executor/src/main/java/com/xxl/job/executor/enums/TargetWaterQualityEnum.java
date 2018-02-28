package com.xxl.job.executor.enums;
/**
 * 断面类型编码
 * @author Administrator
 *
 */
public enum TargetWaterQualityEnum {
/*	Ⅰ类
	public static final String WATERQUALITY_TYPE11="362599E6-5A00-4D35-8D8D-423B387B38CF";
	Ⅱ类
	public static final String WATERQUALITY_TYPE12="1514E2D1-DCC9-498A-9CD6-ED3BA1024E8E";
	Ⅲ类
	public static final String WATERQUALITY_TYPE13="A1DF0BFE-D3E6-4135-98AF-66828E456934";
	Ⅳ类
	public static final String WATERQUALITY_TYPE14="362599E6-5A00-4D35-8D8D-423B387B38CF";
	Ⅴ类
	public static final String WATERQUALITY_TYPE15="362599E6-5A00-4D35-8D8D-423B387B38CF";
	劣Ⅴ
	public static final String WATERQUALITY_TYPE16="362599E6-5A00-4D35-8D8D-423B387B38CF";
	*/
	WATERQUAL_ONE("362599E6-5A00-4D35-8D8D-423B387B38CF","Ⅰ类")
	,WATERQUAL_TWO("1514E2D1-DCC9-498A-9CD6-ED3BA1024E8E","Ⅱ类")
	,WATERQUAL_THREE("A1DF0BFE-D3E6-4135-98AF-66828E456934","Ⅲ类")
	,WATERQUAL_FOUR("57A001BB-A338-4545-8055-FE8F4B6632CC","Ⅳ类")
	,WATERQUAL_FIVE("272A5552-31EF-408E-AE40-DBA3D7B8B5E3","Ⅴ类")
	,WATERQUAL_BAD_FIVE("E8A5CCBD-C1A9-43D9-B1C3-287FA9023AC2","劣V");
	private String code;
	private String remark;

	TargetWaterQualityEnum(String code, String remark) {
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
