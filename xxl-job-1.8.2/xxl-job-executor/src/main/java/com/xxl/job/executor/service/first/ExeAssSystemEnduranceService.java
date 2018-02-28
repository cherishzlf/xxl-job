package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.ExeAssSystemEndurance;
import com.xxl.job.executor.vo.ExeAssSystemEnduranceVO;

import java.util.List;

/**
 * 考核系统-Service接口
 * @author jiangjialiang<br>2017/6/28
 * @version 1.8.2
 */
public interface ExeAssSystemEnduranceService {

    /**
     * 获取统计截止时间
     * @return ExeAssSystemEndurance ExeAssSystemEndurance对象
     */
    ExeAssSystemEndurance getStatCutOffTime();

    /**
     * 调用考核统计存储过程，并返回结果集
     * @param assSystemEnduranceVO assSystemEnduranceVO扩展类
     * @return List<ExeAssSystemEndurance> ExeAssSystemEndurance对象集合
     */
    List<ExeAssSystemEndurance> callProcedureByCondition(ExeAssSystemEnduranceVO assSystemEnduranceVO);

    /**
     * 保存
     * @param assSystemEndurance assSystemEndurance对象
     * @return int 标识（0:失败 1:成功）
     */
    int save(ExeAssSystemEndurance assSystemEndurance);
}
