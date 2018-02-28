package com.xxl.job.executor.vo;

import com.xxl.job.executor.domain.SmUser;

/**
 * @author xu_zhu<br>2017/10/26 13:44.
 */
public class SmUserVO extends SmUser {

    private String chairmanUnit;        /* 河长单位 */
    private String contactDepartment;   /* 河长联系部门 */
    private String unitCellPhone;       /* 河长单位电话 */
    private String reachId;             /* 河长所属河道ID */
    private String reachName;           /* 河长所属河道名称 */

    public String getChairmanUnit() {
        return chairmanUnit;
    }

    public void setChairmanUnit(String chairmanUnit) {
        this.chairmanUnit = chairmanUnit;
    }

    public String getContactDepartment() {
        return contactDepartment;
    }

    public void setContactDepartment(String contactDepartment) {
        this.contactDepartment = contactDepartment;
    }

    public String getUnitCellPhone() {
        return unitCellPhone;
    }

    public void setUnitCellPhone(String unitCellPhone) {
        this.unitCellPhone = unitCellPhone;
    }

    public String getReachId() {
        return reachId;
    }

    public void setReachId(String reachId) {
        this.reachId = reachId;
    }

    public String getReachName() {
        return reachName;
    }

    public void setReachName(String reachName) {
        this.reachName = reachName;
    }
}
