package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.UpParolerecord;
import com.xxl.job.executor.domain.zhuji.UpPatrol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 巡查日志-Service接口
 * @author jiangjialiang<br>2017/8/19
 * @version 1.8.2
 */
public interface MdLocusrecordService {

    /**
     * 根据条件获取巡查次数
     * @param paramters HashMap列表
     * @return Integer 次数
     */
    Integer getLocusrecordCountByCondition(HashMap<String, Object> paramters);

    /**
     * 获得最后一次上报的时间
     * @param condition
     * @return
     */
    UpParolerecord getFirstParolerecord(Map<String, Object> condition);
    /**
     * 获取上报需要的河道巡查数据
     * @param condition
     * @return
     */
    List<UpParolerecord> getLocusrecordForUpload(Map<String, Object> condition);
    /**
     * 更新uploadtime字段，根据idList
     * @param entity
     */
    void updateUploadtime(Map<String, Object> entity);

    UpPatrol getFirstZhujiTrack(Map<String, Object> map);

    List<UpPatrol> getZhuJiTrack(Map<String, Object> condition);

    void update(Map<String, Object> param);
}
