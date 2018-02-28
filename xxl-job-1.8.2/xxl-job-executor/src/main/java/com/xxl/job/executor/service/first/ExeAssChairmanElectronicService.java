package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.ExeAssChairmanElectronic;
import com.xxl.job.executor.domain.ExeAssElectronic;

import java.util.List;
import java.util.Map;

public interface ExeAssChairmanElectronicService  {

    /**
     * 新增数据
     * @author xu_zhu<br/> 2017/11/27 9:23
     */
    void insert(Map<String, Object> params);

    /**
     * 通过考核日期删除数据
     * @param
     * @return
     * @author xu_zhu<br/> 2017/11/27 9:23
     */
    void deleteByAssessTime(String assessTime);

    /**
     * 获取上报的考核数据(未上报的)
     * @param condition
     * @return
     */
    List<ExeAssChairmanElectronic > getPurposeCheck(Map condition);

    void updateUploadByIdList(Map<String, Object> entity);
}
