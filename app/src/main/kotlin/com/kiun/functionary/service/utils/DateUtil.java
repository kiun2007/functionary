package com.kiun.functionary.service.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static String format(String pattern, Date date){
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static String format(String pattern){
        return format(pattern, new Date());
    }

    public static Date dateFrom(String pattern, String value) throws ParseException {
        DateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.parse(value);
    }

    public static String weekNow(){
        String[] weeks = new String[]{"","7","1","2","3","4","5","6"};
        return weeks[Calendar.getInstance().get(Calendar.DAY_OF_WEEK)];
    }

    public static Date getMonthStart(Date date){
        Calendar calendar = Calendar.getInstance();

        if (date != null){
            calendar.setTime(date);
        }
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        return calendar.getTime();
    }

    public static Date getMonthEnd(Date date){
        Calendar calendar = Calendar.getInstance();
        if (date != null){
            calendar.setTime(date);
        }
        calendar.add(Calendar.MONTH, 1);
        calendar.set(Calendar.DAY_OF_MONTH, 0);

        if (Calendar.getInstance().before(calendar)){
            calendar = Calendar.getInstance();
        }
        return calendar.getTime();
    }

    public static float getHours(Date start, Date end){

        return (end.getTime() - start.getTime()) / (3600*1000);
    }

    public static boolean weekIn(String weeks){
        if (weeks == null){
            return false;
        }
        String[] weekArray = weeks.split(",");

        if (weekArray.length < 0){
            return false;
        }

        String now = weekNow();
        for (int i = 0; i < weekArray.length; i++) {
            if (weekArray[i].equals(now)){
                return true;
            }
        }
        return false;
    }

    /**
     * 增加N天.
     * @param date
     * @param days
     * @return
     */
    public static Date addDay(Date date, int days){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 一天的开始.
     * @param date
     * @return
     */
    public static Date getDayStart(Date date){
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        return date;
    }

    /**
     * 一周的开始.
     * @param date
     * @return
     */
    public static Date getWeekStart(Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 1);
        return getDayStart(c.getTime());
    }

    /**
     * 一周的最后一秒.
     * @param date
     * @return
     */
    public static Date getWeekEnd(Date date){

        Calendar c = Calendar.getInstance();
        c.setTime(date);

        int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
        if (day_of_week == 0)
            day_of_week = 7;
        c.add(Calendar.DATE, -day_of_week + 7);
        return getDayEnd(c.getTime());
    }

    /**
     * 一天中的最后一秒.
     * @param date
     * @return
     */
    public static Date getDayEnd(Date date){
        date.setHours(23);
        date.setMinutes(59);
        date.setSeconds(59);
        return date;
    }
}
