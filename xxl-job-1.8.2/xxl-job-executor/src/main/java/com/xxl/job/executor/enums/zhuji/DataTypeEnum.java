package com.xxl.job.executor.enums.zhuji;

/**
 * Created by Administrator on 2017/9/29.
 */
public enum DataTypeEnum {
    REACH("ef83c1b65e9a119c015ea25833db3257","河道")
    ,LAKE("ef83c1b65e9a119c015ea258497d325e","湖泊")
    ,RESERVOIR("ef83c1b65e9a119c015ea2585ced3262","水库");
    private String code;
    private String remark;

    DataTypeEnum(String code, String remark) {
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
