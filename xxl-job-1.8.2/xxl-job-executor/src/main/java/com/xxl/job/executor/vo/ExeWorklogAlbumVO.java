package com.xxl.job.executor.vo;

/**
  *区域随手拍工作日志数量表扩展类
  *@author xu_zhu<br>2017/8/28 13:39
  *@version 1.8.2
  */
public class ExeWorklogAlbumVO{

    private Long regionId;                              /** 区域id*/

    private Integer regionleval;                        /** 区域等级*/

    private String regionName;                          /** 区域名称*/

    private Integer uploadcount;                        /** 随手拍数量*/

    private Integer logcount;                           /** 工作日志数量*/

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Integer getRegionleval() {
        return regionleval;
    }

    public void setRegionleval(Integer regionleval) {
        this.regionleval = regionleval;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public Integer getUploadcount() {
        return uploadcount;
    }

    public void setUploadcount(Integer uploadcount) {
        this.uploadcount = uploadcount;
    }

    public Integer getLogcount() {
        return logcount;
    }

    public void setLogcount(Integer logcount) {
        this.logcount = logcount;
    }
}