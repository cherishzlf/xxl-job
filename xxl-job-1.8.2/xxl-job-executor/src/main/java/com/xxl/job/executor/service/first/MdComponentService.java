package com.xxl.job.executor.service.first;

import java.util.HashMap;

/**
 * 部件接口
 * @author jiangjialiang<br>2017/8/11
 * @version 1.8.2
 */
public interface MdComponentService {
    /**
     * 获取部件对象
     * @return MdComponentService 部件对象
     */
    MdComponentService get();

    /**
     * 根据条件获取部件总数
     * @param parameters HashMap参数列表
     * @return Integer 总数
     */
    Integer count(HashMap<String, Object> parameters);
}
