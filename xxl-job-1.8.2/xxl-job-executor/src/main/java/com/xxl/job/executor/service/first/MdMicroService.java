package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.UpBadSmallWater;
import com.xxl.job.executor.domain.UpBadSmallWaterProgress;

import java.util.List;
import java.util.Map;

public interface MdMicroService {

    /**
     * 查询小微水体信息
     * @param condition
     * @return
     */
    List<UpBadSmallWater> getUpBadSmallWater(Map<String, Object> condition);
    /**
     * 更新uploadtime字段，根据idList
     * @param entity
     * @param idList
     */
    void updateByIdList(Map<String, Object> entity, List<String> idList);
    /**
     * 获得最后一次上报小微水体的时间
     * @param condition
     * @return
     */
    UpBadSmallWater getFirstBadSmallWater(Map<String, Object> condition);

    /**
     * 获得小微水体进展
     * @param condition
     * @return
     */
    List<UpBadSmallWaterProgress> getUpBadSmallWaterProgress(Map<String, Object> condition);

}
