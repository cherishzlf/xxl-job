package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.AmBenchmark;

import java.util.HashMap;
import java.util.List;

/**
 * 考核标记-Service接口
 * @author jiangjialiang<br>2017/8/11
 * @version 1.8.2
 */
public interface AmBenchmarkService {
    /**
     * 获取考核标记对象数据
     * @return AmBenchmark 考核标记对象
     */
    AmBenchmark get();

    /**
     * 考核标记总数
     * @return Integer 总数
     */
    Integer count();

    /**
     * 根据条件获取考核标记对象数据
     * @param paramters HashMap参数列表
     * @return AmBenchmark 考核标记对象
     */
    AmBenchmark find(HashMap<String, Object> paramters);

    /**
     * 根据河长等级获取应填日志数
     * @param paramters HashMap参数列表
     * @return Integer 应填日志数
     */
    Integer getLogNumByChairmanLevel(HashMap<String, Object> paramters);

    /**
     * 获取所有巡查标准数据
     * @return  List<AmBenchmark> 考核标记对象集合
     */
    List<AmBenchmark> findAmBenchmark();
}
