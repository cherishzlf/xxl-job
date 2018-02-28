package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 区域表
 * @author xu_zhu<br>2017/8/22
 * @version 1.8.2
 */
public class MdAdminregion implements Serializable {
    private Long id;                    /** 主键:区域id */
    private String name;                /** 区域name */
    private String parents;             /** 父级区域拼接id */
    private Integer regionLevel;        /** 区域级别 */
    private BigDecimal longiTude;       /** 经度 */
    private BigDecimal latiTude;        /** 维度 */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParents() {
        return parents;
    }

    public void setParents(String parents) {
        this.parents = parents;
    }

    public Integer getRegionLevel() {
        return regionLevel;
    }

    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    public BigDecimal getLongiTude() {
        return longiTude;
    }

    public void setLongiTude(BigDecimal longiTude) {
        this.longiTude = longiTude;
    }

    public BigDecimal getLatiTude() {
        return latiTude;
    }

    public void setLatiTude(BigDecimal latiTude) {
        this.latiTude = latiTude;
    }
}
