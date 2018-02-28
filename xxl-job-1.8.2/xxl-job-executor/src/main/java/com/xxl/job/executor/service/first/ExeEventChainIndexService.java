package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.ExeEventChainIndex;
import com.xxl.job.executor.vo.ExeEventChainiIndexVO;

import java.util.List;
import java.util.Map;

public interface ExeEventChainIndexService {


    /**
      * insert a new DATA (new ExeEventChainIndex(params...))
      *@param exeEventChainiIndex
      *@author xu_zhu<br>2017/8/28 13:40
      *@version 1.8.2
      */
    int insert(ExeEventChainIndex exeEventChainiIndex);

    /**
      * update by id, condition:currentYear、currentCount、id
      *@param params
      *@author xu_zhu<br>2017/8/28 13:40
      *@version 1.8.2
      */
    int updateById(Map<String, Object> params);


    /**
      * find id by last year(type:number) and month(type: number)
      *@param params
      *@author xu_zhu<br>2017/8/28 13:41
      *@version 1.8.2
      */
    String findIdByLastYearAndMonth(Map<String, Object> params);

    /**
      * gets the number of months of the target year by regionId
      *@param params
      *@author xu_zhu<br>2017/8/28 13:41
      *@version 1.8.2
      */
    List<ExeEventChainiIndexVO> findEventChainIndexDataByRegionIdAndStartEndTime(Map<String, Object> params);
}
