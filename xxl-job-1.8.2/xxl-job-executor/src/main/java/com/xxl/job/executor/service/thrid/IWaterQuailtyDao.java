package com.xxl.job.executor.service.thrid;

import com.xxl.job.executor.domain.WaterqualityMonthly;

import java.util.List;

/**
 * Created by Administrator on 2017/9/29.
 */
public interface IWaterQuailtyDao {
    List<WaterqualityMonthly> findByCode(String mdSectionId, Long time);
}
