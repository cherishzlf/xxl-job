package com.xxl.job.executor.service.first;


import com.xxl.job.executor.domain.EhEvent;
import com.xxl.job.executor.domain.ExeAssSystem;
import com.xxl.job.executor.domain.UpProblem;
import com.xxl.job.executor.domain.zhuji.UpEvent;
import com.xxl.job.executor.domain.zhuji.UpWorkLog;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 事件接口
 * @author liruimin<br>2017/8/11
 * @version 1.8.2
 */
public interface EhEventService {

    /**
     * 获取EhEvent对象
     * @return EhEvent EhEvent对象
     */
    EhEvent get();

    /**
     * 事件总数
     * @return Integer 总数
     */
    Integer count();

    /**
     * 根据河段id获取事件统计数据
     * @param paramters HashMap参数列表
     * @return ExeAssSystem ExeAssSystem对象
     */
    ExeAssSystem getEventStatDataByReachId(HashMap<String, Object> paramters);

    /**
     * 获得最后一次上报的时间
     * @param condition
     * @return
     */
    UpProblem getFirstEvent(Map<String, Object> condition);
    /**
     * 获得对应的事件数据
     * @param condition 含有regionid，最后一次上传的日期
     * @return
     */
    List<UpProblem> getUpEvenList(Map<String, Object> condition);

    /**
     * 更新uploadtime
     * @param entity 含有uploadtime的实体类
     */
    void updateByIdList(Map<String, Object> entity);

    /**
     * 获得诸暨对应的事件数据
     * @param map 含有regionid，最后一次上传的日期
     * @return
     */
    UpEvent getFirstZhujiEvent(Map<String, Object> map);

    List<UpEvent> getZhuJiEvent(Map<String, Object> condition);

    void update(Map<String, Object> param);
}
