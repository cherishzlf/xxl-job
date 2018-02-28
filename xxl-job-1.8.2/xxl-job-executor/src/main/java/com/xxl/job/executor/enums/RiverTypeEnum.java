package com.xxl.job.executor.enums;

/**
 * 河道类型编码:
 * @author liruimin<br>2017/9/6
 * @version 1.8.2
 */
public enum RiverTypeEnum {
	/*public static final String REACH_TYPE1  = "958F8957-5859-4FA3-88CA-9FBC1A6FF477";// 省级河道
	public static final String REACH_TYPE2  = "340297D9-0EFE-448D-BA2A-36BAD0590C60";// 市级河道
	public static final String REACH_TYPE3  = "75E1B4F0-29B8-4804-B51C-E53913D019B5";// 县级河道
	public static final String REACH_TYPE4  = "052BB0C6-21BC-40E9-9A03-73EC38E04BE2";// 乡镇级河道
	public static final String REACH_TYPE5  = "0A817AB8-FB58-48B6-BD24-9D8F7B6DB89F";// 村级河道
*/	
	PROVINCE_REACH("958F8957-5859-4FA3-88CA-9FBC1A6FF477","省级河道")
	,CITY_REACH("340297D9-0EFE-448D-BA2A-36BAD0590C60","市级河道")
	,COUNTY_REACH("75E1B4F0-29B8-4804-B51C-E53913D019B5","县级河道")
	,TOWN_REACH("052BB0C6-21BC-40E9-9A03-73EC38E04BE2","乡镇级河道")
	,VILLAGE_REACH("0A817AB8-FB58-48B6-BD24-9D8F7B6DB89F","村级河道");
	private String code;
	private String remark;

	RiverTypeEnum(String code, String remark) {
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
