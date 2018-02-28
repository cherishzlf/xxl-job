package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.ExeWorklogAlbum;
import com.xxl.job.executor.domain.MdAdminregion;
import com.xxl.job.executor.service.first.ExeWorklogAlbumService;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.vo.ExeWorklogAlbumVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
  *工作日志与随手拍调度执行器
  *@author xu_zhu<br>2017/8/28 13:45
  *@version 1.8.2
  */
@JobHander(value = "worklogAlbumJobHandler")
@Service
public class WorklogAlbumJobHandler extends IJobHandler {

    @Autowired
    private MdAdminregionService mdAdminregionService;

    @Autowired
    private ExeWorklogAlbumService exeWorklogAlbumService;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {

        try {
            Long current = System.currentTimeMillis();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            XxlJobLogger.log("The regional work log and the album executor are executed：current time=======>" + simpleDateFormat.format(new Date()));

            int count = 0;
            //Gets all region data
            List<MdAdminregion> mdAdminregionList = mdAdminregionService.find();
            XxlJobLogger.log("A total of " + mdAdminregionList.size() + " data was found");
            for (MdAdminregion mdAdminregion : mdAdminregionList) {
                XxlJobLogger.log("Currently executing the " + (++count) + "th data");

                //Gets Album and work logs message of target region by regionId
                List<ExeWorklogAlbumVO> exeWorklogAlbumVOList = exeWorklogAlbumService.statisticsAlbumAndWorkLogByRegionId(mdAdminregion.getId());
                for (ExeWorklogAlbumVO exeWorklogAlbumVO : exeWorklogAlbumVOList) {
                    int msg = exeWorklogAlbumService.insert(
                            new ExeWorklogAlbum(
                                    String.valueOf(UUID.randomUUID()),      //primary key, UUID
                                    exeWorklogAlbumVO.getRegionId(),        //region id, long
                                    exeWorklogAlbumVO.getRegionleval(),     //region level, int
                                    exeWorklogAlbumVO.getRegionName(),      //region name, String
                                    mdAdminregion.getId(),                  //parent region id, long
                                    new Date(),                             //create time, date
                                    exeWorklogAlbumVO.getUploadcount(),     //album count, int
                                    exeWorklogAlbumVO.getLogcount()         //work logs count, int
                            )
                    );
                    if (msg == 1)
                        XxlJobLogger.log(exeWorklogAlbumVO.getRegionName() + "insert a new work logs: " + exeWorklogAlbumVO.getLogcount() + " album:" + exeWorklogAlbumVO.getUploadcount() + " success");
                }
            }

            Long now = System.currentTimeMillis();
            XxlJobLogger.log("The regional work log and the album executor are completed：current time=======>" + simpleDateFormat.format(new Date()));
            XxlJobLogger.log("It took：" + (now - current) + " milliseconds----add " + exeWorklogAlbumService.findAllCount() + " data");

            for (int i = 0; i < 5; i++) {
                XxlJobLogger.log("beat at:" + i);
                TimeUnit.SECONDS.sleep(2);
            }

            return ReturnT.SUCCESS;
        } catch (Exception e) {
            return ReturnT.FAIL;
        }
    }
}
