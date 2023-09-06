package com.arc.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author 叶超
 * @since: 2019/8/6 14:49
 */
public class TestDate {
    /**
     * 获取某月的第一天
     */
    public static Date getFirstDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    /**
     * 获得该月第一天
     */
    public static String getFirstDayOfMonth(int year, int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, year);
        //设置月份
        cal.set(Calendar.MONTH, month - 1);
        //获取某月最小天数
        int firstDay = cal.getActualMinimum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);
        //初始化开始时间
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH), 00, 00, 00);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String firstDayOfMonth = sdf.format(cal.getTime());
        return firstDayOfMonth;
    }

    /**
     * 设置Calendar的小时、分钟、秒、毫秒
     *
     * @param calendar    日历
     * @param hour        小时
     * @param minute      分钟
     * @param second      秒
     * @param milliSecond 毫秒
     */
    public static void setCalender(Calendar calendar, int hour, int minute, int second, int milliSecond) {
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, milliSecond);
    }

    /**
     * 获取到上个月的第一天的开始
     *
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date getPrvMouthFirstDay() {
        Calendar calendar = Calendar.getInstance();//获取当前日期
        int i = calendar.get(calendar.MONTH);
        if (i == 0) {
            //说明此时是1月,这时我们需要获取到上一年的12月
            calendar.set(calendar.get(calendar.YEAR) - 1, 11, 01, 00, 00, 00);
        } else {
            //设置当前的月份减1即可
            calendar.set(calendar.get(calendar.YEAR), calendar.get(calendar.MONTH) - 1, 01, 00, 00, 00);
        }
        Date time = calendar.getTime();
        return time;

    }

    /**
     * 获取到上个月的最后一天的结束
     *
     * @return
     */
    @SuppressWarnings("static-access")
    public static Date getPrvMouthLastDay() {
        Calendar calendar = Calendar.getInstance();//获取当前日期
        int i = calendar.get(calendar.MONTH);
        if (i == 0) {
            //说明此时是1月,这时我们需要获取到上一年的12月
            calendar.set(calendar.get(calendar.YEAR) - 1, 11, 31, 23, 59, 59);
        } else {
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            calendar.add(Calendar.DATE, -1);
            calendar.set(calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH), 23, 59, 59);
        }
        Date time = calendar.getTime();
        return time;
    }

    public static void main(String[] args) {
        Date prvMouthLastDay = getPrvMouthLastDay();
        Date prvMouthFirstDay = getPrvMouthFirstDay();
        System.out.println(prvMouthFirstDay);
        System.out.println(prvMouthLastDay);
    }
}
