package com.xxl.job.executor.service.first;


import com.xxl.job.executor.domain.UpProblemHandle;
import com.xxl.job.executor.domain.zhuji.UpEventHandler;

import java.util.List;
import java.util.Map;

public interface EhTacheService {
    /**
     * 获得最后一次上报的时间
     * @param condition
     * @return
     */
    UpProblemHandle getUpProblemHandle(Map<String, Object> condition);

    /**
     * 获取上报需要的事件处理数据
     * @param condition
     * @return
     */
    List<UpProblemHandle> getUpProblemHandleList(Map<String, Object> condition);

    /**
     * 更新uploadtime字段，根据idList
     * @param entity
     */
    void updateByIdList(Map<String, Object> entity);

    List<UpEventHandler> getZhuJiTache(Map<String, Object> condition);

    void update(Map<String, Object> param);
}
