package com.xxl.job.executor.domain;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 实时水质
 * @author ruanrj
 *
 */
@Document(collection="WaterqualityMonthly")
public class Waterquality {
  
    /** 业务id **/
    private String uid;
    /** 断面code **/
    private String code;
    /** 河道名称 **/
    private String rivername;
    /** 断面名称 **/
    private String sectionname;
    /** 氨氮 **/
    private BigDecimal ammonium;
    /** 氨氮级别 **/
    private Integer ammoniumlevel;
    /** 总磷 **/
    private BigDecimal totalphosphorus; 
    /** 总磷级别**/
    private Integer plevel;
    /** 高锰酸盐含量 **/
    private BigDecimal permanganate;
    /** 高锰酸盐级别 **/
    private Integer kmnlevel;
    /** 溶解氧 **/
    private BigDecimal dissolvedoxygen;
    /** 化学需氧量 **/
    private BigDecimal cod;
    /** ph值 **/
    private BigDecimal ph;    
    /** 总有机碳 **/
    private BigDecimal toc;
    /** 电导率 **/
    private BigDecimal conductance;
    /** 浊度 **/
    private BigDecimal turbidity;
    
    // add by zdy 2015-12-09 begin
    /** 蓝绿藻 **/
    private BigDecimal bluegreen;
    /** 总叶绿素 **/
    private BigDecimal totalgreen;
    /** 流量 **/
    private BigDecimal ll;
    /** 叶绿素 **/
    private BigDecimal green;
    /** 流速 **/
    private BigDecimal ls;
    // add by zdy 2015-12-09 end
    
    /** 水质级别**/
    private Integer waterlevel;
    /** 统计时间**/
    @JSONField (format="yyyy-MM-dd HH:mm:ss") 
    private Date statisticaltime;
    /** 流向 **/
    private String lx;
    /** 水温(摄氏度)**/
    private Float wt;
    /** 透明度(米) **/
    private Float dipany;
    /** 溶解氧判定 **/
    private String dopd;
    /** 高锰酸盐指数值判定**/
    private String codmnpd;
    /** 氨氮判定**/
    private String nh4npd;
    /** 总磷判定 **/
    private String tppd;
    /** 综合判定 **/
    private String totalpd;
    /** 备注 **/
    private String remark;
    /** 时间戳 **/
    private Long timestamp;
    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }
    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }
    /**
     * @return the rivername
     */
    public String getRivername() {
        return rivername;
    }
    /**
     * @return the sectionname
     */
    public String getSectionname() {
        return sectionname;
    }
    /**
     * @return the ammonium
     */
    public BigDecimal getAmmonium() {
        return ammonium;
    }
    /**
     * @return the ammoniumlevel
     */
    public Integer getAmmoniumlevel() {
        return ammoniumlevel;
    }
    /**
     * @return the totalphosphorus
     */
    public BigDecimal getTotalphosphorus() {
        return totalphosphorus;
    }
    /**
     * @return the plevel
     */
    public Integer getPlevel() {
        return plevel;
    }
    /**
     * @return the permanganate
     */
    public BigDecimal getPermanganate() {
        return permanganate;
    }
    /**
     * @return the kmnlevel
     */
    public Integer getKmnlevel() {
        return kmnlevel;
    }
    /**
     * @return the dissolvedoxygen
     */
    public BigDecimal getDissolvedoxygen() {
        return dissolvedoxygen;
    }
    /**
     * @return the cod
     */
    public BigDecimal getCod() {
        return cod;
    }
    /**
     * @return the ph
     */
    public BigDecimal getPh() {
        return ph;
    }
    /**
     * @return the waterlevel
     */
    public Integer getWaterlevel() {
        return waterlevel;
    }
    /**
     * @return the statisticaltime
     */
    public Date getStatisticaltime() {
        return statisticaltime;
    }
    /**
     * @return the lx
     */
    public String getLx() {
        return lx;
    }
    /**
     * @return the wt
     */
    public Float getWt() {
        return wt;
    }
    /**
     * @return the dipany
     */
    public Float getDipany() {
        return dipany;
    }
    /**
     * @return the dopd
     */
    public String getDopd() {
        return dopd;
    }
    /**
     * @return the codmnpd
     */
    public String getCodmnpd() {
        return codmnpd;
    }
    /**
     * @return the nh4npd
     */
    public String getNh4npd() {
        return nh4npd;
    }
    /**
     * @return the tppd
     */
    public String getTppd() {
        return tppd;
    }
    /**
     * @return the totalpd
     */
    public String getTotalpd() {
        return totalpd;
    }
    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }
    /**
     * @return the timestamp
     */
    public Long getTimestamp() {
        return timestamp;
    }
    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }
    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     * @param rivername the rivername to set
     */
    public void setRivername(String rivername) {
        this.rivername = rivername;
    }
    /**
     * @param sectionname the sectionname to set
     */
    public void setSectionname(String sectionname) {
        this.sectionname = sectionname;
    }
    /**
     * @param ammonium the ammonium to set
     */
    public void setAmmonium(BigDecimal ammonium) {
        this.ammonium = ammonium;
    }
    /**
     * @param ammoniumlevel the ammoniumlevel to set
     */
    public void setAmmoniumlevel(Integer ammoniumlevel) {
        this.ammoniumlevel = ammoniumlevel;
    }
    /**
     * @param totalphosphorus the totalphosphorus to set
     */
    public void setTotalphosphorus(BigDecimal totalphosphorus) {
        this.totalphosphorus = totalphosphorus;
    }
    /**
     * @param plevel the plevel to set
     */
    public void setPlevel(Integer plevel) {
        this.plevel = plevel;
    }
    /**
     * @param permanganate the permanganate to set
     */
    public void setPermanganate(BigDecimal permanganate) {
        this.permanganate = permanganate;
    }
    /**
     * @param kmnlevel the kmnlevel to set
     */
    public void setKmnlevel(Integer kmnlevel) {
        this.kmnlevel = kmnlevel;
    }
    /**
     * @param dissolvedoxygen the dissolvedoxygen to set
     */
    public void setDissolvedoxygen(BigDecimal dissolvedoxygen) {
        this.dissolvedoxygen = dissolvedoxygen;
    }
    /**
     * @param cod the cod to set
     */
    public void setCod(BigDecimal cod) {
        this.cod = cod;
    }
    /**
     * @param ph the ph to set
     */
    public void setPh(BigDecimal ph) {
        this.ph = ph;
    }
    /**
     * @param waterlevel the waterlevel to set
     */
    public void setWaterlevel(Integer waterlevel) {
        this.waterlevel = waterlevel;
    }
    /**
     * @param statisticaltime the statisticaltime to set
     */
    public void setStatisticaltime(Date statisticaltime) {
        this.statisticaltime = statisticaltime;
    }
    /**
     * @param lx the lx to set
     */
    public void setLx(String lx) {
        this.lx = lx;
    }
    /**
     * @param wt the wt to set
     */
    public void setWt(Float wt) {
        this.wt = wt;
    }
    /**
     * @param dipany the dipany to set
     */
    public void setDipany(Float dipany) {
        this.dipany = dipany;
    }
    /**
     * @param dopd the dopd to set
     */
    public void setDopd(String dopd) {
        this.dopd = dopd;
    }
    /**
     * @param codmnpd the codmnpd to set
     */
    public void setCodmnpd(String codmnpd) {
        this.codmnpd = codmnpd;
    }
    /**
     * @param nh4npd the nh4npd to set
     */
    public void setNh4npd(String nh4npd) {
        this.nh4npd = nh4npd;
    }
    /**
     * @param tppd the tppd to set
     */
    public void setTppd(String tppd) {
        this.tppd = tppd;
    }
    /**
     * @param totalpd the totalpd to set
     */
    public void setTotalpd(String totalpd) {
        this.totalpd = totalpd;
    }
    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }
    /**
     * @param timestamp the timestamp to set
     */
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }    
    /**
     * @return the toc
     */
    public BigDecimal getToc() {
        return toc;
    }
    /**
     * @return the conductance
     */
    public BigDecimal getConductance() {
        return conductance;
    }
    /**
     * @return the turbidity
     */
    public BigDecimal getTurbidity() {
        return turbidity;
    }
    /**
     * @param toc the toc to set
     */
    public void setToc(BigDecimal toc) {
        this.toc = toc;
    }
    /**
     * @param conductance the conductance to set
     */
    public void setConductance(BigDecimal conductance) {
        this.conductance = conductance;
    }
    /**
     * @param turbidity the turbidity to set
     */
    public void setTurbidity(BigDecimal turbidity) {
        this.turbidity = turbidity;
    }
    public BigDecimal getBluegreen() {
		return bluegreen;
	}
	public void setBluegreen(BigDecimal bluegreen) {
		this.bluegreen = bluegreen;
	}
	public BigDecimal getTotalgreen() {
		return totalgreen;
	}
	public void setTotalgreen(BigDecimal totalgreen) {
		this.totalgreen = totalgreen;
	}
	public BigDecimal getLl() {
		return ll;
	}
	public void setLl(BigDecimal ll) {
		this.ll = ll;
	}
	public BigDecimal getGreen() {
		return green;
	}
	public void setGreen(BigDecimal green) {
		this.green = green;
	}
	public BigDecimal getLs() {
		return ls;
	}
	public void setLs(BigDecimal ls) {
		this.ls = ls;
	}
	/* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Waterquality [uid=" + uid + ", code=" + code + ", rivername=" + rivername + ", sectionname="
                + sectionname + ", ammonium=" + ammonium + ", ammoniumlevel=" + ammoniumlevel + ", totalphosphorus="
                + totalphosphorus + ", plevel=" + plevel + ", permanganate=" + permanganate + ", kmnlevel=" + kmnlevel
                + ", dissolvedoxygen=" + dissolvedoxygen + ", cod=" + cod + ", ph=" + ph + ", toc=" + toc
                + ", conductance=" + conductance + ", turbidity=" + turbidity + ", bluegreen=" + bluegreen 
                + ", totalgreen=" + totalgreen + ", ll=" + ll + ", green=" + green + ", ls=" + ls 
                + ", waterlevel=" + waterlevel + ", statisticaltime=" + statisticaltime + ", lx=" + lx 
                + ", wt=" + wt + ", dipany=" + dipany + ", dopd=" + dopd + ", codmnpd=" + codmnpd + ", nh4npd=" 
                + nh4npd + ", tppd=" + tppd + ", totalpd=" + totalpd + ", remark=" + remark + ", timestamp=" + timestamp + "]";
    }
    
    
}
