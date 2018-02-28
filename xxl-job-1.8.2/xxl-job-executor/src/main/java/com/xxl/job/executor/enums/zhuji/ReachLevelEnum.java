package com.xxl.job.executor.enums.zhuji;

/**
 * Created by Administrator on 2017/9/29.
 */
public enum  ReachLevelEnum {
    COUNTY_REACH("4029c48753ef2b09015408353ead0230","县级河道")
    ,TOWN_REACH("4029c48753ef2b09015408355da90231","乡镇级河道")
    ,VILLAGE_REACH("4029c48753ef2b090154083576c20232","村级河道");
    private String code;
    private String remark;

    ReachLevelEnum(String code, String remark) {
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
