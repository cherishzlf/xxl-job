package com.xxl.job.executor.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 公用工具类
 */
public class CommonUtil {

    /**
     * 获取当天起始时间
     */
    public static Date thisDayStart(){
        Calendar c = Calendar.getInstance();
        initDay(c,0,0,0,0);
        return c.getTime();
    }

    /**
     * 获取当天截止时间
     */
    public static Date thisDayEnd(){
        Calendar c = Calendar.getInstance();
        initDay(c,23,59,59,0);
        return c.getTime();
    }

    /**
     * 获取当月第一天时间
     */
    public static Date thisMonthFirstDay(){
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        initDay(c,0,0,0,0);
        return c.getTime();
    }

    /**
     * 获取当月最后一天时间
     */
    public static Date thisMonthLastDay(){
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        initDay(ca,23,59,59,0);
        return ca.getTime();
    }

    /**
     * 初始化一天时间 设为当前0时0分0秒0毫秒
     */
    private static void initDay(Calendar calendar,int hour,int minute,int second,int millisecond){
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
    }
}
