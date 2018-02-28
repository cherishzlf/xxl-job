package com.xxl.job.executor.service.first;

import java.util.Date;
import java.util.Map;

/**
 * 巡查统计接口
 * @author fengtianpei<br>2017/8/21
 * @version 1.8.2
 */
public interface ExeWorklogPatrolService {

    /**
     * 插入本月巡查数据
     * @param params 包含巡查数据Map
     */
    Integer insertReachPatrol(Map<String, Object> params);

    /**
     * 修改本月查询数据
     * @param params 包含巡查数据的Map
     */
    Integer updateReachPatrol(Map<String, Object> params);

    /**
     * 计算巡查达标率
     */
    Integer updateRate();

    /**
     * 获取本月巡查次数
     * @param startTime 开始时间
     */
    Integer countThisMonthData(Date startTime);

}
