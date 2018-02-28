package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author xu_zhu<br>2017/10/26 13:37.
 */
public class SmUser implements Serializable {
    private java.lang.String id;
    private java.lang.Integer recver;
    private java.lang.String username;
    private java.lang.String password;
    private java.lang.String callpassword;
    private java.lang.String name;
    private java.lang.Integer gender;
    private java.lang.String email;
    private java.lang.String jobnumber;
    private java.lang.String birthday;
    private java.lang.String cellphone;
    private java.lang.String telephone;
    private java.lang.String fax;
    private java.lang.Integer status;
    private java.util.Date logintime;
    private java.lang.Long provinceid;
    private java.lang.String provinceName;
    private java.lang.Long cityid;
    private java.lang.String cityName;
    private java.lang.Long countyid;
    private java.lang.String countyName;
    private java.lang.Long townid;
    private java.lang.String townName;
    private java.lang.Long villageid;
    private java.lang.String villageName;
    private java.lang.String unitid;
    private java.lang.String unitprincipal;
    private java.lang.String departmentid;
    private java.lang.String departmentprincipal;
    private java.lang.String duty;
    private java.lang.String description;
    private java.lang.String imageurl;
    private java.util.Date expiredate;
    private java.lang.String createuserid;
    private java.util.Date createtime;
    private java.lang.String modifyuserid;
    private java.util.Date modifytime;
    private java.lang.String audituserid;
    private java.util.Date audittime;
    private java.lang.String auditsuggestion;
    private java.util.Date effecttime;
    private java.lang.String remark;
    private java.math.BigDecimal sortorder;
    private java.lang.Integer usertype;
    private java.lang.String sipphone;
    private java.lang.String regionpath;
    private java.lang.Integer chairmanlevel;
    private java.lang.String assistantid;
    private java.lang.String unitname;
    private String contactunit;                /* 联系单位 */
    private String reachIds;
    private java.lang.Integer accounttype;     /* 账号状态 0 可销毁 */
    private java.util.Date existtime;          /* 账号存在时间 */
    private java.lang.String newfunc;           /* 为了不影响其他的树所以创建一个newfunc字段用于区分 */
    private java.lang.String src;               /* 接受数据来源 */
    private java.lang.String srcid;             /* 数据来源id */
    private java.lang.String identityCard;      /* 身份证号 */

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCallpassword() {
        return callpassword;
    }

    public void setCallpassword(String callpassword) {
        this.callpassword = callpassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getJobnumber() {
        return jobnumber;
    }

    public void setJobnumber(String jobnumber) {
        this.jobnumber = jobnumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    public Long getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Long provinceid) {
        this.provinceid = provinceid;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getCountyid() {
        return countyid;
    }

    public void setCountyid(Long countyid) {
        this.countyid = countyid;
    }

    public String getCountyName() {
        return countyName;
    }

    public void setCountyName(String countyName) {
        this.countyName = countyName;
    }

    public Long getTownid() {
        return townid;
    }

    public void setTownid(Long townid) {
        this.townid = townid;
    }

    public String getTownName() {
        return townName;
    }

    public void setTownName(String townName) {
        this.townName = townName;
    }

    public Long getVillageid() {
        return villageid;
    }

    public void setVillageid(Long villageid) {
        this.villageid = villageid;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getUnitprincipal() {
        return unitprincipal;
    }

    public void setUnitprincipal(String unitprincipal) {
        this.unitprincipal = unitprincipal;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public String getDepartmentprincipal() {
        return departmentprincipal;
    }

    public void setDepartmentprincipal(String departmentprincipal) {
        this.departmentprincipal = departmentprincipal;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public Date getExpiredate() {
        return expiredate;
    }

    public void setExpiredate(Date expiredate) {
        this.expiredate = expiredate;
    }

    public String getCreateuserid() {
        return createuserid;
    }

    public void setCreateuserid(String createuserid) {
        this.createuserid = createuserid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getModifyuserid() {
        return modifyuserid;
    }

    public void setModifyuserid(String modifyuserid) {
        this.modifyuserid = modifyuserid;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }

    public String getAudituserid() {
        return audituserid;
    }

    public void setAudituserid(String audituserid) {
        this.audituserid = audituserid;
    }

    public Date getAudittime() {
        return audittime;
    }

    public void setAudittime(Date audittime) {
        this.audittime = audittime;
    }

    public String getAuditsuggestion() {
        return auditsuggestion;
    }

    public void setAuditsuggestion(String auditsuggestion) {
        this.auditsuggestion = auditsuggestion;
    }

    public Date getEffecttime() {
        return effecttime;
    }

    public void setEffecttime(Date effecttime) {
        this.effecttime = effecttime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getSortorder() {
        return sortorder;
    }

    public void setSortorder(BigDecimal sortorder) {
        this.sortorder = sortorder;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public String getSipphone() {
        return sipphone;
    }

    public void setSipphone(String sipphone) {
        this.sipphone = sipphone;
    }

    public String getRegionpath() {
        return regionpath;
    }

    public void setRegionpath(String regionpath) {
        this.regionpath = regionpath;
    }

    public Integer getChairmanlevel() {
        return chairmanlevel;
    }

    public void setChairmanlevel(Integer chairmanlevel) {
        this.chairmanlevel = chairmanlevel;
    }

    public String getAssistantid() {
        return assistantid;
    }

    public void setAssistantid(String assistantid) {
        this.assistantid = assistantid;
    }

    public String getUnitname() {
        return unitname;
    }

    public void setUnitname(String unitname) {
        this.unitname = unitname;
    }

    public String getContactunit() {
        return contactunit;
    }

    public void setContactunit(String contactunit) {
        this.contactunit = contactunit;
    }

    public String getReachIds() {
        return reachIds;
    }

    public void setReachIds(String reachIds) {
        this.reachIds = reachIds;
    }

    public Integer getAccounttype() {
        return accounttype;
    }

    public void setAccounttype(Integer accounttype) {
        this.accounttype = accounttype;
    }

    public Date getExisttime() {
        return existtime;
    }

    public void setExisttime(Date existtime) {
        this.existtime = existtime;
    }

    public String getNewfunc() {
        return newfunc;
    }

    public void setNewfunc(String newfunc) {
        this.newfunc = newfunc;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getSrcid() {
        return srcid;
    }

    public void setSrcid(String srcid) {
        this.srcid = srcid;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }
}
