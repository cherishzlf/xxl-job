package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.ExeAssSystem;
import com.xxl.job.executor.domain.zhuji.UpWorkLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 日志接口
 * @author jiangjialiang<br>2017/8/11
 * @version 1.8.2
 */
public interface LogWorkLogService {
    /**
     * 获取日志对象
     * @return LogWorkLogService LogWorkLogService对象
     */
    LogWorkLogService get();

    /**
     * 日志总数
     * @return Integer 总数
     */
    Integer count();

    /**
     * 根据时间段获取日志列表
     * @param parameters HashMap参数列表
     * @return List<ExeAssSystem> ExeAssSystem对象集合
     */
    List<ExeAssSystem> listLogWorkLogByTimeQuantum(HashMap<String, Object> parameters);

    /**
     * 根据时间段和河段id获取日志数
     * @param parameters HashMap参数列表
     * @return Integer 日志数
     */
    Integer getLogWorkLogCountByTimeQuantum(HashMap<String, Object> parameters);

    UpWorkLog getFirstZhujiWorklog(Map<String, Object> map);

    List<UpWorkLog> getZhuJiWorkLogs(Map<String, Object> condition);

    void update(Map<String, Object> param);
}
