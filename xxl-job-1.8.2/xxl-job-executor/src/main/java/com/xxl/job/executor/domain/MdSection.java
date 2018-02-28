package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MdSection implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Long recver;
    private String name;
    private String code;
    private String oldcode;
    private Integer type;
    private Long adminregionid;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private String descirption;
    private String imageid;
    private Long provinceid;
    private Long cityid;
    private Long countyid;
    private Long townid;
    private Long villageid;
    private Integer sectionlevel;
    private String batchno;
    private String batchexplain;
    private Integer source;
    private String unitid;
    private String unitprincipal;
    private String unitprincipaltel;
    private Integer status;
    private Integer showlevel;
    private String createuserid;
    private Date createtime;
    private String modifyuserid;
    private Date modifytime;
    private String audituserid;
    private Date audittime;
    private String auditsuggestion;
    private Date effecttime;
    private String remark;
    private String basinname;
    private String rivername;
    private Integer nowquality;
    private Date qualitytime;
    private Integer targetquality;
    private Integer reachlevel;
    private Integer basinid;
    //是否为交接断面，1为是，0为否
    private Integer isconnect;
    private String provincereachid;
    private String cityreachid;
    private String countyreachid;
    private String townreachid;
    private String villagereachid;


    private BigDecimal ammonium;
    private BigDecimal totalphosphorus;
    private BigDecimal permanganate;
    private BigDecimal dissolvedoxygen;
    private String src;

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    private String undercentralizedunit;                                      /** 归口管理单位 */
    private String isImportantWfarea;                                         /** 是否国家重要水功能区  是1，不是0 */
    private String isImportantSection;                                        /** 是否太湖流域重点监测断面 是1,不是0 */
    private String isAssessmentList;                                          /** 是否列入浙江省“十三五”考核名单 是1,不是0 */
    private String connectCategory;                                           /** 交接断面类别 */
    private String monitorFrequency;                                          /** 监测频率 */
    private String terminationSection;                                        /** 终止断面 */
    private String waterAreaName;                                             /** 水功能区名称 */
    private Integer datasrccode; //数据来源编码
    private Integer dataupflag;//数据更新

    public Integer getDatasrccode() {
        return datasrccode;
    }

    public void setDatasrccode(Integer datasrccode) {
        this.datasrccode = datasrccode;
    }

    public Integer getDataupflag() {
        return dataupflag;
    }

    public void setDataupflag(Integer dataupflag) {
        this.dataupflag = dataupflag;
    }

    public String getUndercentralizedunit() {
        return undercentralizedunit;
    }

    public String getAudituserid() {
        return audituserid;
    }

    public void setAudituserid(String audituserid) {
        this.audituserid = audituserid;
    }

    public void setUndercentralizedunit(String undercentralizedunit) {
        this.undercentralizedunit = undercentralizedunit;
    }

    public String getIsImportantWfarea() {
        return isImportantWfarea;
    }

    public void setIsImportantWfarea(String isImportantWfarea) {
        this.isImportantWfarea = isImportantWfarea;
    }

    public String getIsImportantSection() {
        return isImportantSection;
    }

    public void setIsImportantSection(String isImportantSection) {
        this.isImportantSection = isImportantSection;
    }

    public String getIsAssessmentList() {
        return isAssessmentList;
    }

    public void setIsAssessmentList(String isAssessmentList) {
        this.isAssessmentList = isAssessmentList;
    }

    public String getConnectCategory() {
        return connectCategory;
    }

    public void setConnectCategory(String connectCategory) {
        this.connectCategory = connectCategory;
    }

    public String getMonitorFrequency() {
        return monitorFrequency;
    }

    public void setMonitorFrequency(String monitorFrequency) {
        this.monitorFrequency = monitorFrequency;
    }

    public String getTerminationSection() {
        return terminationSection;
    }

    public void setTerminationSection(String terminationSection) {
        this.terminationSection = terminationSection;
    }

    public String getWaterAreaName() {
        return waterAreaName;
    }

    public void setWaterAreaName(String waterAreaName) {
        this.waterAreaName = waterAreaName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getRecver() {
        return recver;
    }

    public void setRecver(Long recver) {
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getAdminregionid() {
        return adminregionid;
    }

    public void setAdminregionid(Long adminregionid) {
        this.adminregionid = adminregionid;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getDescirption() {
        return descirption;
    }

    public void setDescirption(String descirption) {
        this.descirption = descirption;
    }

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public Long getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(Long provinceid) {
        this.provinceid = provinceid;
    }

    public Long getCityid() {
        return cityid;
    }

    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    public Long getCountyid() {
        return countyid;
    }

    public void setCountryid(Long countyid) {
        this.countyid = countyid;
    }

    public Long getTownid() {
        return townid;
    }

    public void setTownid(Long townid) {
        this.townid = townid;
    }

    public Long getVillageid() {
        return villageid;
    }

    public void setVillageid(Long villageid) {
        this.villageid = villageid;
    }

    public Integer getSectionlevel() {
        return sectionlevel;
    }

    public void setSectionlevel(Integer sectionlevel) {
        this.sectionlevel = sectionlevel;
    }

    public String getBatchno() {
        return batchno;
    }

    public void setBatchno(String batchno) {
        this.batchno = batchno;
    }

    public String getBatchexplain() {
        return batchexplain;
    }

    public void setBatchexplain(String batchexplain) {
        this.batchexplain = batchexplain;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
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

    public String getUnitprincipaltel() {
        return unitprincipaltel;
    }

    public void setUnitprincipaltel(String unitprincipaltel) {
        this.unitprincipaltel = unitprincipaltel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getShowlevel() {
        return showlevel;
    }

    public void setShowlevel(Integer showlevel) {
        this.showlevel = showlevel;
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

    public String getBasinname() {
        return basinname;
    }

    public void setBasinname(String basinname) {
        this.basinname = basinname;
    }

    public String getRivername() {
        return rivername;
    }

    public void setRivername(String rivername) {
        this.rivername = rivername;
    }

    public Integer getNowquality() {
        return nowquality;
    }

    public void setNowquality(Integer nowquality) {
        this.nowquality = nowquality;
    }

    public Integer getTargetquality() {
        return targetquality;
    }

    public void setTargetquality(Integer targetquality) {
        this.targetquality = targetquality;
    }

    public Integer getReachlevel() {
        return reachlevel;
    }

    public void setReachlevel(Integer reachlevel) {
        this.reachlevel = reachlevel;
    }

    public Integer getBasinid() {
        return basinid;
    }

    public void setBasinid(Integer basinid) {
        this.basinid = basinid;
    }

    public BigDecimal getAmmonium() {
        return ammonium;
    }

    public void setAmmonium(BigDecimal ammonium) {
        this.ammonium = ammonium;
    }

    public BigDecimal getTotalphosphorus() {
        return totalphosphorus;
    }

    public void setTotalphosphorus(BigDecimal totalphosphorus) {
        this.totalphosphorus = totalphosphorus;
    }

    public BigDecimal getPermanganate() {
        return permanganate;
    }

    public void setPermanganate(BigDecimal permanganate) {
        this.permanganate = permanganate;
    }

    public BigDecimal getDissolvedoxygen() {
        return dissolvedoxygen;
    }

    public void setDissolvedoxygen(BigDecimal dissolvedoxygen) {
        this.dissolvedoxygen = dissolvedoxygen;
    }

    public void setCountyid(Long countyid) {
        this.countyid = countyid;
    }

    public Integer getIsconnect() {
        return isconnect;
    }

    public void setIsconnect(Integer isconnect) {
        this.isconnect = isconnect;
    }

    public String getProvincereachid() {
        return provincereachid;
    }

    public void setProvincereachid(String provincereachid) {
        this.provincereachid = provincereachid;
    }

    public String getCityreachid() {
        return cityreachid;
    }

    public void setCityreachid(String cityreachid) {
        this.cityreachid = cityreachid;
    }

    public String getCountyreachid() {
        return countyreachid;
    }

    public void setCountyreachid(String countyreachid) {
        this.countyreachid = countyreachid;
    }

    public String getTownreachid() {
        return townreachid;
    }

    public void setTownreachid(String townreachid) {
        this.townreachid = townreachid;
    }

    public String getVillagereachid() {
        return villagereachid;
    }

    public void setVillagereachid(String villagereachid) {
        this.villagereachid = villagereachid;
    }

    public String getOldcode() {
        return oldcode;
    }

    public void setOldcode(String oldcode) {
        this.oldcode = oldcode;
    }

    public Date getQualitytime() {
        return qualitytime;
    }

    public void setQualitytime(Date qualitytime) {
        this.qualitytime = qualitytime;
    }
}
