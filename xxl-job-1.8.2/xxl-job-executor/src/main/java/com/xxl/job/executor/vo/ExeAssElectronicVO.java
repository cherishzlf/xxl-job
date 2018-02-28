package com.xxl.job.executor.vo;

import com.xxl.job.executor.domain.ExeAssElectronic;

import java.util.Date;

/**
 * @author xu_zhu<br>2017/10/27 15:53.
 */
public class ExeAssElectronicVO extends ExeAssElectronic{

    private String locusId;             /** 轨迹Id */
    private String eventId;             /** 事件Id */
    private String workLogId;           /** 工作日志Id */
    private String content;             /** 工作日志内容 */
    private String checkItems;          /** 工作日志内容涉及项 */
    private String accessoryUrl;        /** 工作日志内容影音附件URL */
    private String eventType;           /** 时间类型 */
    private String eventResource;       /** 事件来源 */
    private Date startTime;             /** 开始时间 */
    private Date endTime;               /** 结束时间 */

    public String getLocusId() {
        return locusId;
    }

    public void setLocusId(String locusId) {
        this.locusId = locusId;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getWorkLogId() {
        return workLogId;
    }

    public void setWorkLogId(String workLogId) {
        this.workLogId = workLogId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCheckItems() {
        return checkItems;
    }

    public void setCheckItems(String checkItems) {
        this.checkItems = checkItems;
    }

    public String getAccessoryUrl() {
        return accessoryUrl;
    }

    public void setAccessoryUrl(String accessoryUrl) {
        this.accessoryUrl = accessoryUrl;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getEventResource() {
        return eventResource;
    }

    public void setEventResource(String eventResource) {
        this.eventResource = eventResource;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
