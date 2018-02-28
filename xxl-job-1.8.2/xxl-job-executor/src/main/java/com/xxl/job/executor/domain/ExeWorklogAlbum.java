package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 区域随手拍工作日志数量表
 * @author xu_zhu<br>2017/8/9
 * @version 1.8.2
 */
public class ExeWorklogAlbum implements Serializable{
    private String id;                                  /** 主键id */
    private Long regionId;                              /** 区域id */
    private Integer regionLeval;                        /** 区域等级 */
    private String regionName;                          /** 区域名称 */
    private Long parentsId;                             /** 父级区域id */
    private Date createTime;                            /** 创建时间 */
    private Integer uploadCount;                        /** 随手拍数量 */
    private Integer logCount;                           /** 工作日志数量 */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getRegionId() {
        return regionId;
    }

    public void setRegionId(Long regionId) {
        this.regionId = regionId;
    }

    public Integer getRegionLeval() {
        return regionLeval;
    }

    public void setRegionLeval(Integer regionLeval) {
        this.regionLeval = regionLeval;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public Long getParentsId() {
        return parentsId;
    }

    public void setParentsId(Long parentsId) {
        this.parentsId = parentsId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUploadCount() {
        return uploadCount;
    }

    public void setUploadCount(Integer uploadCount) {
        this.uploadCount = uploadCount;
    }

    public Integer getLogCount() {
        return logCount;
    }

    public void setLogCount(Integer logCount) {
        this.logCount = logCount;
    }

    public ExeWorklogAlbum(){
        super();
    }

    public ExeWorklogAlbum(String id,
                           Long regionId,
                           Integer regionLeval,
                           String regionName,
                           Long parentsId,
                           Date createTime,
                           Integer uploadCount,
                           Integer logCount){

        this.id = id;
        this.regionId = regionId;
        this.regionLeval = regionLeval;
        this.regionName = regionName;
        this.parentsId = parentsId;
        this.createTime = createTime;
        this.uploadCount = uploadCount;
        this.logCount = logCount;
    }
}