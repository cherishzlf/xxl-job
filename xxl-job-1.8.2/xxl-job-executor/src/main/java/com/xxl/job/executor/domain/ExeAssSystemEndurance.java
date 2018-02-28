package com.xxl.job.executor.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 考核系统表
 * @author jiangjialiang<br>2017/7/17
 * @version 1.8.2
 */
public class ExeAssSystemEndurance implements Serializable {
    private String id;
    private String chairmanid;              /** 河长id(外键 ) */
    private String chairmanname;            /** 河长名称 */
    private int chairmanlevel;              /** 河长级别 */
    private Integer appraisaltype;
    private Date appraisaldate;
    private String reachname;               /** 河道名称 */
    private Integer reachnum;               /** 河道总数 */
    private String reachids;                /** 河道id(外键) */
    private Integer patrolnum;              /** 巡查次数 */
    private Integer alpatrolnum;
    private Integer patrolrate;
    private Integer patrolscore;
    private Integer eventnum;               /** 事件总数 */
    private Integer eventprocessing;        /** 事件处理中 */
    private Integer eventcomplete;          /** 事件结案 */
    private Integer eventrate;              /** 事件结案率 */
    private Integer eventscore;
    private Integer lognum;                 /** 应填日志 */
    private Integer allognum;               /** 已填日志 */
    private Integer lograte;                /** 日志完成率 */
    private Integer logscore;
    private Integer filenum1;
    private Date filedate1;
    private Integer filescore1;
    private Integer filenum2;
    private Date filedate2;
    private Integer filescore2;
    private Integer waterlevel;
    private Integer waterqualityscore;
    private Integer publicitycardnum;       /** 公示牌 */
    private Date publicitydate;
    private Date chairmanchangedate;
    private Integer publicityrate;
    private Integer publicityscore;
    private Integer totalscore;
    private Integer ranking;
    private Date createtime;                /** 创建时间 */

    private Long provinceid;                /** 省id */
    private Long cityid;                    /** 市id */
    private Long countyid;                  /** 县id */
    private Long townid;                    /** 镇id */
    private Long villageid;                 /** 村id */

    private Integer month;                  /** 月 */
    private Integer quarter;                /** 季度 */
    private Integer year;                   /** 年 */
    private int asstype;                    /** 1:按月 2:按季 3:按年 */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChairmanid() {
        return chairmanid;
    }

    public void setChairmanid(String chairmanid) {
        this.chairmanid = chairmanid;
    }

    public String getChairmanname() {
        return chairmanname;
    }

    public void setChairmanname(String chairmanname) {
        this.chairmanname = chairmanname;
    }

    public int getChairmanlevel() {
        return chairmanlevel;
    }

    public void setChairmanlevel(int chairmanlevel) {
        this.chairmanlevel = chairmanlevel;
    }

    public Integer getAppraisaltype() {
        return appraisaltype;
    }

    public void setAppraisaltype(Integer appraisaltype) {
        this.appraisaltype = appraisaltype;
    }

    public Date getAppraisaldate() {
        return appraisaldate;
    }

    public void setAppraisaldate(Date appraisaldate) {
        this.appraisaldate = appraisaldate;
    }

    public String getReachname() {
        return reachname;
    }

    public void setReachname(String reachname) {
        this.reachname = reachname;
    }

    public Integer getReachnum() {
        return reachnum;
    }

    public void setReachnum(Integer reachnum) {
        this.reachnum = reachnum;
    }

    public String getReachids() {
        return reachids;
    }

    public void setReachids(String reachids) {
        this.reachids = reachids;
    }

    public Integer getPatrolnum() {
        return patrolnum;
    }

    public void setPatrolnum(Integer patrolnum) {
        this.patrolnum = patrolnum;
    }

    public Integer getAlpatrolnum() {
        return alpatrolnum;
    }

    public void setAlpatrolnum(Integer alpatrolnum) {
        this.alpatrolnum = alpatrolnum;
    }

    public Integer getPatrolrate() {
        return patrolrate;
    }

    public void setPatrolrate(Integer patrolrate) {
        this.patrolrate = patrolrate;
    }

    public Integer getPatrolscore() {
        return patrolscore;
    }

    public void setPatrolscore(Integer patrolscore) {
        this.patrolscore = patrolscore;
    }

    public Integer getEventnum() {
        return eventnum;
    }

    public void setEventnum(Integer eventnum) {
        this.eventnum = eventnum;
    }

    public Integer getEventprocessing() {
        return eventprocessing;
    }

    public void setEventprocessing(Integer eventprocessing) {
        this.eventprocessing = eventprocessing;
    }

    public Integer getEventcomplete() {
        return eventcomplete;
    }

    public void setEventcomplete(Integer eventcomplete) {
        this.eventcomplete = eventcomplete;
    }

    public Integer getEventrate() {
        return eventrate;
    }

    public void setEventrate(Integer eventrate) {
        this.eventrate = eventrate;
    }

    public Integer getEventscore() {
        return eventscore;
    }

    public void setEventscore(Integer eventscore) {
        this.eventscore = eventscore;
    }

    public Integer getLognum() {
        return lognum;
    }

    public void setLognum(Integer lognum) {
        this.lognum = lognum;
    }

    public Integer getAllognum() {
        return allognum;
    }

    public void setAllognum(Integer allognum) {
        this.allognum = allognum;
    }

    public Integer getLograte() {
        return lograte;
    }

    public void setLograte(Integer lograte) {
        this.lograte = lograte;
    }

    public Integer getLogscore() {
        return logscore;
    }

    public void setLogscore(Integer logscore) {
        this.logscore = logscore;
    }

    public Integer getFilenum1() {
        return filenum1;
    }

    public void setFilenum1(Integer filenum1) {
        this.filenum1 = filenum1;
    }

    public Date getFiledate1() {
        return filedate1;
    }

    public void setFiledate1(Date filedate1) {
        this.filedate1 = filedate1;
    }

    public Integer getFilescore1() {
        return filescore1;
    }

    public void setFilescore1(Integer filescore1) {
        this.filescore1 = filescore1;
    }

    public Integer getFilenum2() {
        return filenum2;
    }

    public void setFilenum2(Integer filenum2) {
        this.filenum2 = filenum2;
    }

    public Date getFiledate2() {
        return filedate2;
    }

    public void setFiledate2(Date filedate2) {
        this.filedate2 = filedate2;
    }

    public Integer getFilescore2() {
        return filescore2;
    }

    public void setFilescore2(Integer filescore2) {
        this.filescore2 = filescore2;
    }

    public Integer getWaterlevel() {
        return waterlevel;
    }

    public void setWaterlevel(Integer waterlevel) {
        this.waterlevel = waterlevel;
    }

    public Integer getWaterqualityscore() {
        return waterqualityscore;
    }

    public void setWaterqualityscore(Integer waterqualityscore) {
        this.waterqualityscore = waterqualityscore;
    }

    public Integer getPublicitycardnum() {
        return publicitycardnum;
    }

    public void setPublicitycardnum(Integer publicitycardnum) {
        this.publicitycardnum = publicitycardnum;
    }

    public Date getPublicitydate() {
        return publicitydate;
    }

    public void setPublicitydate(Date publicitydate) {
        this.publicitydate = publicitydate;
    }

    public Date getChairmanchangedate() {
        return chairmanchangedate;
    }

    public void setChairmanchangedate(Date chairmanchangedate) {
        this.chairmanchangedate = chairmanchangedate;
    }

    public Integer getPublicityrate() {
        return publicityrate;
    }

    public void setPublicityrate(Integer publicityrate) {
        this.publicityrate = publicityrate;
    }

    public Integer getPublicityscore() {
        return publicityscore;
    }

    public void setPublicityscore(Integer publicityscore) {
        this.publicityscore = publicityscore;
    }

    public Integer getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Integer totalscore) {
        this.totalscore = totalscore;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
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

    public void setCountyid(Long countyid) {
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

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public int getAsstype() {
        return asstype;
    }

    public void setAsstype(int asstype) {
        this.asstype = asstype;
    }
}
