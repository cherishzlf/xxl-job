package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.MdReach;
import com.xxl.job.executor.domain.UpReach;
import com.xxl.job.executor.domain.zhuji.UploadReach;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 河道接口
 * @author jiangjialiang<br>2017/8/11
 * @version 1.8.2
 */
public interface MdReachService {

    /**
     * 根据id获取河段对象
     * @param paramters HashMap参数列表
     * @return MdReach 河段对象
     */
    MdReach getById(Map<String, Object> paramters);

    /**
     * 河段总数
     * @return Integer 总数
     */
    Integer count();

    /**
     * 根据条件获取河段对象
     * @param paramters HashMap对象
     * @return MdReach 河段对象
     */
    MdReach find(HashMap<String, Object> paramters);

    /**
     * 根据条件获取河段对焦集合
     * @param paramters HashMap参数列表
     * @return List<MdReach> 河段对象集合
     */
    List<MdReach> listMdReachByCondition(HashMap<String, Object> paramters);
    /**
     * 获得最后一次上报的时间
     * @param condition
     * @return
     */
    UpReach getFirstReach(Map<String, Object> condition);
    /**
     * 获取上报需要的河道数据
     * @param condition
     * @return
     */
    List<UpReach> getUpReachList(Map<String, Object> condition);
    /**
     * 更新uploadtime字段，根据idList
     * @param entity
     * @param idList
     */
    void updateByIdList(Map<String, Object> entity);

    UploadReach getFirstZhujiReach(Map<String, Object> map);

    List<UploadReach> getZhuJiReach(Map<String, Object> condition);

    void update(Map<String, Object> param);

    String getinvented(Map<String, Object> map);
}
