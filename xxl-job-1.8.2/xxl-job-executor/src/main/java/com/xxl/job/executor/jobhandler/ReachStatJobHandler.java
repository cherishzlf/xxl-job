package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.domain.*;
import com.xxl.job.executor.service.first.*;
import com.xxl.job.executor.utils.UhopeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 河段考核统计
 * @author jiangjialiang<br>2017/8/18
 * @version 0.0.1
 */
@JobHander(value = "reachStatJobHandler")
@Service
public class ReachStatJobHandler extends IJobHandler {

    @Autowired
    private MdReachService mdReachService;

    @Autowired
    private MdLocusrecordService mdLocusrecordService;

    @Autowired
    private EhEventService ehEventService;

    @Autowired
    private MdComponentService mdComponentService;

    @Autowired
    private LogWorkLogService logWorkLogServicek;

    @Autowired
    private MdReachchairmanService mdReachchairmanService;

    @Autowired
    private ExeAssReachService exeAssReachService;

    /**
     * 执行器方法
     * @param params 参数数组
     * 2、params[0] Integer year 年 默认当前年份
     * 3、params[1] Integer month 月 默认当前月份
     * 参数数组; params[2017, 8] (默认值)
     * @return ReturnT.SUCCESS
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String... params) throws Exception {

        Integer year = null;        // 年
        Integer month = null;       // 月
        String startTime = null;    // 开始时间
        String endTime = null;      // 结束时间

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 获取东八区时间
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        year = calendar.get(Calendar.YEAR);   	        // 获取当前年份 (默认值)
        month = calendar.get(Calendar.MONTH) + 1;   	// 获取当前月份，0表示1月份 (默认值)

        /** 0、参数（根据时间段统计） */
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                if (UhopeUtil.isNumeric(params[i])) {
                    switch (i) {
                        case 0:
                            // 年份最小值不小于1970，最大值不大于当前年份，否则直接使用年份默认值
                            year = (Integer.valueOf(params[0]) >= 1970 && Integer.valueOf(params[0]) <= year ? Integer.valueOf(params[0]) : year);
                            System.out.println("year: " + year);
                            break;
                        case 1:
                            // 月份最小值不小于1，最大值不大于12，否则直接使用月份默认值
                            month = (Integer.valueOf(params[1]) >= 1 && Integer.valueOf(params[1]) <= 12 ? Integer.valueOf(params[1]) : month);
                            System.out.println("month: " + month);
                            break;
                        default:
                    }
                }
            }
        }

        // 设置年份
        calendar.set(calendar.YEAR, year);

        // 设置月份
        calendar.set(calendar.MONTH, month - 1);    // 月份默认+1

        // 获取当月第一天 （格式: 2017-08-01）
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1); // 设置为1号,当前日期既为本月第一天
        startTime = sdf.format(calendar.getTime());

        // 获取下月第一天 （格式: 2017-09-01）
        calendar.set(calendar.MONTH, month);
        calendar.add(Calendar.MONTH, 0);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        endTime = sdf.format(calendar.getTime());

        /** 1、先获取所有河段 */
        HashMap<String, Object> reachParams = new HashMap<String, Object>();
        reachParams.put("orderBy", "createtime");
        List<ExeAssReach> exeAssReachList = new ArrayList<ExeAssReach>();
        List<MdReach> reachList = mdReachService.listMdReachByCondition(reachParams);
        for (int i = 0; i < reachList.size(); i++) {
            ExeAssReach exeAssReach = new ExeAssReach();
            MdReach mdReach = new MdReach();
            mdReach = reachList.get(i);
            String reachId = mdReach.getId();
            // 保存河段相关信息
            exeAssReach.setReachId(reachId);
            exeAssReach.setReachName(mdReach.getName());
            exeAssReach.setReachLength(mdReach.getLength());
            exeAssReach.setReachLevel(mdReach.getReachLevel());
            exeAssReach.setRiverId(mdReach.getRiverId());
            exeAssReach.setRiverName(mdReach.getRiverName());
            exeAssReach.setBasinName(mdReach.getBasinName());
            exeAssReach.setProvinceId(mdReach.getProvinceId());
            exeAssReach.setCityId(mdReach.getCityId());
            exeAssReach.setCountyId(mdReach.getCountyId());
            exeAssReach.setTownId(mdReach.getTownId());
            exeAssReach.setVillageId(mdReach.getVillageId());
            /** 2、统计河段的巡查轨迹（md_locusrecord表）reachId */
            MdLocusrecord mdLocusrecord = new MdLocusrecord();
            HashMap<String, Object> locusrecordParams = new HashMap<String, Object>();
            mdLocusrecord.setReachId(reachId);
            locusrecordParams.put("condition", mdLocusrecord);
            locusrecordParams.put("startTime", startTime);
            locusrecordParams.put("endTime", endTime);
            Integer locusrecordCount = mdLocusrecordService.getLocusrecordCountByCondition(locusrecordParams);
            // 保存河段巡查次数
            exeAssReach.setPatrolNum(locusrecordCount);

            /** 3、统计河段的日志信息（log_worklog表）reachId */
            HashMap<String, Object> worklogParams = new HashMap<String, Object>();
            LogWorklog logWorklog = new LogWorklog();
            logWorklog.setReachId(reachId);
            locusrecordParams.put("condition", logWorklog);
            locusrecordParams.put("startTime", startTime);
            locusrecordParams.put("endTime", endTime);
            Integer worklogCount = logWorkLogServicek.getLogWorkLogCountByTimeQuantum(worklogParams);
            // 保存河段日志数
            exeAssReach.setLogNum(worklogCount);

            /** 4、统计河段的事件信息（eh_event表）reachId */
            // 通过 河道id 获取事件相关的统计数据(事件总数、事件处理中、事件结案)
            EhEvent ehEvent = new EhEvent();
            ehEvent.setEventReachId(reachId);
            ehEvent.setStatus("Z");
            HashMap<String, Object> eventParams = new HashMap<String, Object>();
            eventParams.put("startTime", startTime);
            eventParams.put("endTime", endTime);
            eventParams.put("status", "X");
            eventParams.put("condition", ehEvent);
            ExeAssSystem eventSystem = ehEventService.getEventStatDataByReachId(eventParams);
            Integer eventNum = 0, eventProcessing = 0, eventClosure = 0;
            if(eventSystem != null){
                eventNum = eventSystem.getEventNum();
                eventProcessing = eventSystem.getEventProcessing();
                eventClosure = eventSystem.getEventClosure();
            }
            exeAssReach.setEventNum(eventNum);
            exeAssReach.setEventProcessing(eventProcessing);
            exeAssReach.setEventClosure(eventClosure);
            // 事件结案率
            // 不保留小数点后两位，不采用四舍五入
            DecimalFormat df = new DecimalFormat("###");
            df.setRoundingMode(RoundingMode.FLOOR);
            float eventClosureRate = eventNum == 0 ? 100 : (float)eventClosure/eventNum*100;
            String eventClosureRateStr = df.format(eventClosureRate);
            exeAssReach.setEventClosureRate(Double.valueOf(eventClosureRateStr));

            /** 5、统计河段的公示牌（md_component表）reachId */
            // 通过 河道id 获取部件(公示牌)
            MdComponent mdComponent = new MdComponent();
            String subClassId = "70010000000000000000000000000000";
            mdComponent.setReachId(reachId);
            mdComponent.setSubClassId(subClassId);
            HashMap<String, Object> componentParams = new HashMap<String, Object>();
            componentParams.put("condition", mdComponent);
            Integer publicityCardNum = mdComponentService.count(componentParams);
            exeAssReach.setPublicityCardNum(publicityCardNum);

            /** 6、关联河段的河长信息（sm_user表）chairmanId */
            HashMap<String, Object> reachchairmanParams = new HashMap<String, Object>();
            MdReachchairman mdReachchairman = new MdReachchairman();
            mdReachchairman.setReachId(reachId);
            mdReachchairman.setChairmanLevel(mdReach.getReachLevel()); // 河段等级 = 河长级别
            reachchairmanParams.put("condition", mdReachchairman);
            ExeAssReach assReach = mdReachchairmanService.findChairmanByCondition(reachchairmanParams);
            // 保存河长相关信息
            if (assReach != null) {
                exeAssReach.setChairmanId(assReach.getChairmanId());
                exeAssReach.setChairmanName(assReach.getChairmanName());
                exeAssReach.setChairmanLevel(assReach.getChairmanLevel());
            }
            // 保存河段统计时间
            exeAssReach.setCreateTime(new Date());
            exeAssReach.setYear(year);
            exeAssReach.setMonth(month);
            exeAssReach.setQuarter(UhopeUtil.getQuarter(month));

            exeAssReachService.save(exeAssReach);
        }

        return ReturnT.SUCCESS;
    }

}
