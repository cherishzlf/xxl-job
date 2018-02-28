package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHander;
import com.xxl.job.core.log.XxlJobLogger;
import com.xxl.job.executor.domain.ExeEventChainIndex;
import com.xxl.job.executor.domain.MdAdminregion;
import com.xxl.job.executor.service.first.ExeEventChainIndexService;
import com.xxl.job.executor.service.first.MdAdminregionService;
import com.xxl.job.executor.vo.ExeEventChainiIndexVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
  *同年事件环比执行器
  *@author xu_zhu<br>2017/8/30 9:26
  *@version 1.8.2
  */
@Service
@JobHander(value = "eventChainIndexJobHandler")
public class EventChainIndexJobHandler extends IJobHandler {

    @Autowired
    private MdAdminregionService mdAdminregionService;

    @Autowired
    private ExeEventChainIndexService exeEventChainIndexService;

    @Override
    public ReturnT<String> execute(String... params) throws Exception {

        try {
            //get last year start time (Example: 2016-01-01)
            String lastStartTime = getLastStartTime();
            //get last year end time, but year is last, month is current (Example: 2016-08-01)
            String lastEndTime = getLastEndTime();
            //get this year start time (Example: 2017-01-01)
            String currentStartTime = getCurrentStartTime();
            //get this year end time, but month is current(Example： 2017-08-01)
            String currentEndTime = getCurrentEndTime();

            //Gets the number of the months of last year
            Map<String, Object> lastYearParams = new HashMap<>();
            lastYearParams.put("startTime", lastStartTime);
            lastYearParams.put("endTime", lastEndTime);

            //Gets the number of the months of this year
            Map<String, Object> currentYearParams = new HashMap<>();
            currentYearParams.put("startTime", currentStartTime);
            currentYearParams.put("endTime", currentEndTime);

            //find all region\area message
            List<MdAdminregion> mdAdminregionListForInsert = mdAdminregionService.find();
            for (MdAdminregion mdAdminregion : mdAdminregionListForInsert) {
                lastYearParams.put("regionId", mdAdminregion.getId());
                currentYearParams.put("regionId", mdAdminregion.getId());
                //add a new data
                List<ExeEventChainiIndexVO> lastExeEventChainiIndexVOList =
                        exeEventChainIndexService.findEventChainIndexDataByRegionIdAndStartEndTime(lastYearParams);
                for (ExeEventChainiIndexVO exeEventChainiIndexVO : lastExeEventChainiIndexVOList) {
                    int insert = exeEventChainIndexService.insert(
                            new ExeEventChainIndex(
                                    String.valueOf(UUID.randomUUID()),              //primary key,      String
                                    mdAdminregion.getId(),                          //region Id,        long
                                    exeEventChainiIndexVO.getYear(),                //last year,        int
                                    (exeEventChainiIndexVO.getYear() + 1),          //this year,        int
                                    exeEventChainiIndexVO.getMonth(),               //month,            int
                                    exeEventChainiIndexVO.getCount(),               //last year count,  int
                                    0,                                  //this year count,  int
                                    new Date()                                      //create time,      Date
                            )
                    );
                    if (insert == 1) {//success
                        XxlJobLogger.log("insert a new data： regionId=" + mdAdminregion.getId()
                                + " year=" + exeEventChainiIndexVO.getYear() + " month=" + exeEventChainiIndexVO.getMonth()
                                + " data=" + exeEventChainiIndexVO.getCount() + " success");
                    } else {//fail
                        XxlJobLogger.log("warning-----------------------------------------------------------------"
                                + "insert a new data： regionId=" + mdAdminregion.getId() + " year=" + exeEventChainiIndexVO.getYear()
                                + " month=" + exeEventChainiIndexVO.getMonth() + " data=" + exeEventChainiIndexVO.getCount()
                                + " fail");
                    }
                }

                //update
                List<ExeEventChainiIndexVO> currentExeEventChainiIndexVOList =
                        exeEventChainIndexService.findEventChainIndexDataByRegionIdAndStartEndTime(currentYearParams);

                for (ExeEventChainiIndexVO exeEventChainiIndexVO : currentExeEventChainiIndexVOList) {
                    Map<String, Object> getIdByLastYearParams = new HashMap<>();
                    getIdByLastYearParams.put("lastYear", exeEventChainiIndexVO.getYear() - 1);
                    getIdByLastYearParams.put("month", exeEventChainiIndexVO.getMonth());
                    getIdByLastYearParams.put("regionId", mdAdminregion.getId());
                    //get UID by last year number、month and regionId into databases
                    String UId = exeEventChainIndexService.findIdByLastYearAndMonth(getIdByLastYearParams);
                    //if UID is not exist, insert a new data
                    if (UId == null || UId.equals("")) {
                            int updateCount = exeEventChainIndexService.insert(
                                    new ExeEventChainIndex(
                                            String.valueOf(UUID.randomUUID()),              //primary key,      String
                                            mdAdminregion.getId(),                          //region Id,        long
                                            (exeEventChainiIndexVO.getYear() - 1),          //last year,        int
                                            exeEventChainiIndexVO.getYear(),                //this year,        int
                                            exeEventChainiIndexVO.getMonth(),               //month,            int
                                            0,                                     //last year count,  int
                                            exeEventChainiIndexVO.getCount(),               //this year count,  int
                                            new Date()                                      //create time,      Date
                                    )
                            );
                            if (updateCount == 1) {
                                XxlJobLogger.log("Last year data id not exit, will insert a new data： regionId=" + mdAdminregion.getId()
                                        + " year=" + exeEventChainiIndexVO.getYear() + " month=" + exeEventChainiIndexVO.getMonth()
                                        + " data=" + exeEventChainiIndexVO.getCount() + " success");
                            } else {
                                XxlJobLogger.log("warning-----------------------------------------------------------------"
                                        + "Last year data id not exit, to insert a new data： regionId" + mdAdminregion.getId()
                                        + " year=" + exeEventChainiIndexVO.getYear() + " month=" + exeEventChainiIndexVO.getMonth()
                                        + " data=" + exeEventChainiIndexVO.getCount() + " fail");
                            }
                    } else {//update
                            Map<String, Object> updateParams = new HashMap<>();
                            updateParams.put("currentYear", exeEventChainiIndexVO.getYear());
                            updateParams.put("currentCount", exeEventChainiIndexVO.getCount());
                            updateParams.put("id", UId);
                            int reInsert = exeEventChainIndexService.updateById(updateParams);
                            if (reInsert == 1) {
                                XxlJobLogger.log("update：Id=" + UId + " regionId=" + mdAdminregion.getId()
                                        + " year=" + exeEventChainiIndexVO.getYear() + " month=" + exeEventChainiIndexVO.getMonth()
                                        + " data=" + exeEventChainiIndexVO.getCount() + " success");
                            } else {
                                XxlJobLogger.log("warning-----------------------------------------------------------------"
                                        + "update：Id=" + UId + " regionId=" + mdAdminregion.getId()
                                        + " year=" + exeEventChainiIndexVO.getYear() + " month=" + exeEventChainiIndexVO.getMonth()
                                        + " data=" + exeEventChainiIndexVO.getCount() + " fail");

                            }
                    }
                }
            }

            for (int i = 0; i < 5; i++) {
                XxlJobLogger.log("beat at:" + i);
                TimeUnit.SECONDS.sleep(2);
            }

            return ReturnT.SUCCESS;
        } catch (Exception e) {
            return ReturnT.FAIL;
        }
    }


    private String getLastStartTime() {

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        /*Setting date of last year*/
        //Setting date year is last year
        calendar.add(Calendar.YEAR, -1);
        //The month is set for January
        calendar.set(Calendar.MONTH, 0);
        //The date days for the first day
        calendar.set(Calendar.DATE, 1);

        return simpleDateFormat.format(calendar.getTime());
    }

    private String getLastEndTime() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -1);
        //The month is set for next month
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 1);

        return simpleDateFormat.format(calendar.getTime());
    }

    private String getCurrentStartTime() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 0);
        calendar.set(Calendar.DATE, 1);

        return simpleDateFormat.format(calendar.getTime());
    }

    private String getCurrentEndTime() {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DATE, 1);

        return simpleDateFormat.format(calendar.getTime());
    }
}
