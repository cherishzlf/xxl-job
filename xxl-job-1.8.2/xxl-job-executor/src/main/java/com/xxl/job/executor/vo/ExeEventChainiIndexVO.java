package com.xxl.job.executor.vo;

/**
  *事件环比表(本年同前年)扩展类
  *@author xu_zhu<br>2017/8/28 13:38
  *@version 1.8.2
  */
public class ExeEventChainiIndexVO {

    private int year;
    private int month;
    private int count;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
