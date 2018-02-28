package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.*;
import com.xxl.job.executor.service.first.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 考核统计业务逻辑
 * @author jiangjialiang<br>2017/8/11
 * @version 1.8.2
 */
@JobHander(value = "assessJobHandler")
@Service
public class AssessJobHandler extends IJobHandler {

    @Autowired
    private LogWorkLogService logWorkLogService;

    @Autowired
    private EhEventService ehEventService;

    @Autowired
    MdComponentService mdComponentService;

    @Autowired
    MdReachchairmanService mdReachchairmanService;

    @Autowired
    AmBenchmarkService amBenchmarkService;

    @Autowired
    private ExeAssSystemService exeAssSystemService;

    @Autowired
    MdReachService mdReachService;

    /**
     * 初始化 系统考核 统计数据
     * 以“工作日志表(log_worklog)”为中心，去关联河道、事件、部件(公示牌)数据
     * @param params
     * @return
     * @throws Exception
     */
    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        XxlJobLogger.log("----- Begin AssessJobhandler -----");
        HashMap<String, Object> parameters = new HashMap<String, Object>();
        String startTime = "2017-01-01 00:00:00";
        String endTime = "2017-01-31 23:59:59";
        parameters.put("startTime", startTime);
        parameters.put("endTime", endTime);
        // 获取指定时间段的日志列表数据
        List<ExeAssSystem> list = logWorkLogService.listLogWorkLogByTimeQuantum(parameters);
        List<ExeAssSystem> exeAssSystemList = new ArrayList<ExeAssSystem>();
        // 遍历日志列表
        for (int i = 0; i < list.size(); i++) {
            ExeAssSystem exeAssSystem = new ExeAssSystem();
            exeAssSystem = list.get(i);
            String chairmanId = exeAssSystem.getChairmanId();       // 河长id
            String reachId = exeAssSystem.getReachId();             // 河道id
            String reachName = exeAssSystem.getReachName();         // 河道名称

            // 获取 河道名称
            if (reachName == null || reachName.equals("")) {
                HashMap<String, Object> reachParams = new HashMap<String, Object>();
                reachParams.put("id", reachId);
                MdReach mdReach = mdReachService.getById(reachParams);
                if (mdReach != null && mdReach.getName() != null) {
                    exeAssSystem.setReachName(mdReach.getName());
                }
            }

            // 获取 河道河长 相关数据(河长等级)
            MdReachchairman mdReachchairman = new MdReachchairman();
            mdReachchairman.setChairmanId(chairmanId);
            mdReachchairman.setReachId(reachId);
            HashMap<String, Object> reachChairmanParams = new HashMap<String, Object>();
            reachChairmanParams.put("condition", mdReachchairman);
            mdReachchairman = mdReachchairmanService.find(reachChairmanParams);
            Integer chairmanLevel = null;
            if (mdReachchairman != null) {
                chairmanLevel = mdReachchairman.getChairmanLevel();
                exeAssSystem.setChairmanLevel(chairmanLevel);
            }

            // 通过 河长等级 获取 应填日志数
            AmBenchmark amBenchmark = new AmBenchmark();
            String type = "RZ";
            Integer status = 1;
            amBenchmark.setType(type);
            amBenchmark.setStatus(status);
            HashMap<String, Object> markParams = new HashMap<String, Object>();
            markParams.put("chairmanLevel", chairmanLevel);
            markParams.put("condition", amBenchmark);
            Integer logOughtNum = amBenchmarkService.getLogNumByChairmanLevel(markParams);
            exeAssSystem.setLogOughtNum(logOughtNum);

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
            exeAssSystem.setEventNum(eventNum);
            exeAssSystem.setEventProcessing(eventProcessing);
            exeAssSystem.setEventClosure(eventClosure);

            // 通过 河道id 获取部件(公示牌)
            MdComponent mdComponent = new MdComponent();
            String subClassId = "70010000000000000000000000000000";
            mdComponent.setReachId(reachId);
            mdComponent.setSubClassId(subClassId);
            HashMap<String, Object> componentParams = new HashMap<String, Object>();
            componentParams.put("condition", mdComponent);
            Integer publicityCardNum = mdComponentService.count(componentParams);
            exeAssSystem.setPublicityCardNum(publicityCardNum);

            // 日志完成率 / 事件结案率
            // 不保留小数点后两位，不采用四舍五入
            DecimalFormat df = new DecimalFormat("###");
            df.setRoundingMode(RoundingMode.FLOOR);
            float eventClosureRate = eventNum == 0 ? 100 : (float)eventClosure/eventNum*100;
            float logFinishingRate = logOughtNum == 0 ? 100 : (float)exeAssSystem.getLogAlreadyNum()/logOughtNum*100;
            String eventClosureRateStr = df.format(eventClosureRate);
            String logFinishingRateStr = df.format(logFinishingRate);
            exeAssSystem.setLogFinishingRate(Double.valueOf(logFinishingRateStr));
            exeAssSystem.setEventClosureRate(Double.valueOf(eventClosureRateStr));

            exeAssSystemService.save(exeAssSystem);
        }

        XxlJobLogger.log("list size: "+list.size());
        XxlJobLogger.log("----- End AssessJobhandler -----");
        return ReturnT.SUCCESS;
    }
}
