package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.MdAdminregion;

import java.util.List;
import java.util.Map;

public interface MdAdminregionService{


    /**
      * Get all
      *@author xu_zhu<br>2017/8/28 13:43
      *@version 1.8.2
      */
    List<MdAdminregion> find();

    /**
      *  Get parent regionId by regionId
      *@param
      *@return
      *@author xu_zhu<br>2017/8/28 13:43
      *@version 1.8.2
      */
    Long getParentIdByRegionId(Long regionId);

    /**
     * 根据行政区域名称跟等级查询行政区域id
     * @param param
     * @return
     */
    String findByregionName(Map<String, Object> param);

    MdAdminregion getRegionById(Map<String, Object> map);
}
