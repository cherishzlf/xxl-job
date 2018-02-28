package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.executor.domain.AmBenchmark;
import com.xxl.job.executor.service.first.AmBenchmarkService;
import com.xxl.job.executor.service.first.ExeWorklogPatrolService;
import com.xxl.job.executor.utils.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 当月巡查情况统计
 */
@Service
@JobHander(value="patrolJobHandler")
public class PatrolJobHandler extends IJobHandler {

    @Autowired
    ExeWorklogPatrolService exeWorklogPatrolService;

    @Autowired
    AmBenchmarkService amBenchmarkService;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {
        List<AmBenchmark> amBenchmarks = amBenchmarkService.findAmBenchmark();
        AmBenchmark provinceMark = getProvinceMark(amBenchmarks);
        statisticalThisMonthData(provinceMark);
        updateMark(amBenchmarks);
        exeWorklogPatrolService.updateRate();
        return ReturnT.SUCCESS;
    }

    /**
     * 根据省级标准统计数据
     */
    private void statisticalThisMonthData(AmBenchmark amBenchmark){
        Integer thisMonthData = exeWorklogPatrolService.countThisMonthData(CommonUtil.thisMonthFirstDay());
        if(thisMonthData != null && thisMonthData != 0) return ;
        Map<String,Object> params = setParams(amBenchmark, CommonUtil.thisMonthFirstDay(), CommonUtil.thisMonthLastDay());
        exeWorklogPatrolService.insertReachPatrol(params);
    }

    /**
     * 根据新标准更新对应数据
     */
    private void updateThisMonthData(AmBenchmark amBenchmark){
        Map<String,Object> params = setParams(amBenchmark, CommonUtil.thisMonthFirstDay(), CommonUtil.thisMonthLastDay());
        exeWorklogPatrolService.updateReachPatrol(params);
    }

    /**
     * 更新统计数据
     */
    private void updateMark(List<AmBenchmark> amBenchmarks){
        if(amBenchmarks.size() == 0) return ;
        for(AmBenchmark amb : amBenchmarks){
            updateThisMonthData(amb);
        }
    }

    /**
     * 获取省级巡查标准
     */
    private AmBenchmark getProvinceMark(List<AmBenchmark> amBenchmarks){
        AmBenchmark amBenchmark = new AmBenchmark();
        for(AmBenchmark amb : amBenchmarks){
            if(amb.getRegionId().toString().equals(amb.getProvinceId().toString())){
                amBenchmark = amb;
            }
        }
        return amBenchmark;
    }

    /**
     * 封装数据到Map中
     */
    private Map setParams(AmBenchmark amBenchmark, Date startTime, Date endTime){
        Map params = new HashMap<String,Object>();
        params.put("amb", amBenchmark);
        params.put("startTime",startTime);
        params.put("endTime",endTime);
        return params;
    }

}
