package com.xxl.job.executor.enums;

/**
 * 问题类型枚举
 * @author liruimin<br>2017/8/12
 * @version 1.8.2
 */
public enum ProblemTypeEnum {
	/*public static final String PROBLEM_TYPE1 = "1F36CDF4-A247-47F8-BF69-99EDF292BE3F";// 巡查上报
	public static final String PROBLEM_TYPE2 = "74ED980C-3352-4EF0-B41A-E1883FED4027";// 投诉
*/	
	REPORT("1F36CDF4-A247-47F8-BF69-99EDF292BE3F","巡查上报")
	,COMPLAINTS("74ED980C-3352-4EF0-B41A-E1883FED4027","投诉");
	private String code;
	private String remark;

	ProblemTypeEnum(String code, String remark) {
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
