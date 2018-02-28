package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.ExeAssReach;
import com.xxl.job.executor.domain.MdReachchairman;

import java.util.HashMap;

/**
 * 河长河道接口
 * @author jiangjialiang<br>2017/8/11
 * @version 1.8.2
 */
public interface MdReachchairmanService {
    /**
     * 获取河段河长对象
     * @return MdReachchairman 河段河长对象
     */
    MdReachchairman get();

    /**
     * 河段河长总数
     * @return Integer 总数
     */
    Integer count();

    /**
     * 根据条件获取河段河长对象
     * @param paramters HashMap参数列表
     * @return MdReachchairman 河段河长对象
     */
    MdReachchairman find(HashMap<String, Object> paramters);

    /**
     * 根据条件获取河长相关信息
     * @param paramters HashMap参数列表
     * @return ExeAssReach 河段考核对象
     */
    ExeAssReach findChairmanByCondition(HashMap<String, Object> paramters);
}
