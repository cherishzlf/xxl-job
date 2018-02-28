package com.xxl.job.executor.service.second;

import com.xxl.job.executor.domain.MdAdminregion;

import java.util.List;
import java.util.Map;

public interface MdAdminregionSecondService {

    /**
     * 根据行政区域名称跟等级查询行政区域id
     * @param param
     * @return
     */
    String findByregionName(Map<String, Object> param);

    MdAdminregion getRegionById(Map<String, Object> map);
}
