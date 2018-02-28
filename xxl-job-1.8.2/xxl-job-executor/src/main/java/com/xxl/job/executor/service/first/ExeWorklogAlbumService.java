package com.xxl.job.executor.service.first;

import com.xxl.job.executor.domain.ExeWorklogAlbum;
import com.xxl.job.executor.vo.ExeWorklogAlbumVO;

import java.util.List;

public interface ExeWorklogAlbumService {


    /**
      * insert a new DATA (new ExeWorklogAlbum(params...))
      *@param record
      *@author xu_zhu<br>2017/8/28 13:42
      *@version 1.8.2
      */
    int insert(ExeWorklogAlbum record);

    /**
      * Get all data count
      *@author xu_zhu<br>2017/8/28 13:42
      *@version 1.8.2
      */
    int findAllCount();

     /**
       * statistics: Get the number of album and work logs in the lower area by regionId
       *@param regionId
       *@author xu_zhu<br>2017/8/28 13:42
       *@version 1.8.2
       */
     List<ExeWorklogAlbumVO> statisticsAlbumAndWorkLogByRegionId(Long regionId);
}