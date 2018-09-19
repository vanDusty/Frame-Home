package com.van.dusty.common.velocity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @program: Spring-Home
 * @description:
 * @author: Van
 * @create: 2018-09-03 13:42
 **/
public class DateUtils {
    public static final long SECONDSPERDAY = 86400L;

    public DateUtils() {
    }

    public static String parseDateFormat(Long longTime, String pattern) {
        if (StringUtils.isBlank(pattern)) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }

        Date date = new Date();
        date.setTime(longTime.longValue());
        return format(date, pattern);
    }

    public static String parseDateFormat(Long longTime) {
        return parseDateFormat(longTime, "");
    }

    public static String parseDateFormat(String longTime, String pattern) {
        try {
            Long.valueOf(longTime);
        } catch (Exception var3) {
            return "exception";
        }

        return parseDateFormat(Long.valueOf(longTime), pattern);
    }

    public static String parseDateFormat(String longTime) {
        try {
            Long.valueOf(longTime);
        } catch (Exception var2) {
            return "exception";
        }

        return parseDateFormat(longTime, "");
    }

    public static Date getCurDateTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    public static Date getCurDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return getShortDate(df.format(new Date()));
    }

    public static Date getShortDate(String strDate) {
        Date date = null;

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            date = df.parse(strDate);
            return date;
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static Date addHours(Date date, int hours) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(11, hours);
        return calendar.getTime();
    }

    public static Date addMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(12, minutes);
        return calendar.getTime();
    }

    public static Date addDay(Date date, int days) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, days);
        return calendar.getTime();
    }

    public static Date addMonth(Date date, int months) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(2, months);
        return calendar.getTime();
    }

    public static Date addYear(Date date, int years) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(1, years);
        return calendar.getTime();
    }

    public static Date getLongDate(String strDate) {
        Date date = null;

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = df.parse(strDate);
            return date;
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static Date getMiddleDate(String strDate) {
        Date date = null;

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            date = df.parse(strDate);
            return date;
        } catch (Exception var3) {
            throw new RuntimeException(var3);
        }
    }

    public static String format(Date date, String pattern) {
        if (date == null) {
            return "";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat(pattern);
            return formatter.format(date);
        }
    }

    public static String format(Date date, String pattern, String defaultIfNull) {
        return date == null ? defaultIfNull : format(date, pattern);
    }

    public static String toString(Date date) {
        return date == null ? "" : format(date, "yyyy-MM-dd HH:mm:ss");
    }

    public static int getIntervalDays(Date startDate, Date endDate) {
        long sl = startDate.getTime();
        long el = endDate.getTime();
        long ei = el - sl;
        return (int)(ei / 86400000L);
    }

    public static int getIntervalMonths(Date startDate, Date endDate) {
        long sl = startDate.getTime();
        long el = endDate.getTime();
        long ei = el - sl;
        return Math.round((float)ei / 2.6352E9F);
    }

    public static int getIntervalMonthsCeil(Date startDate, Date endDate) {
        long sl = startDate.getTime();
        long el = endDate.getTime();
        long ei = el - sl;
        return (int)Math.ceil((double)((float)ei / 2.6352E9F));
    }

    public static int getIntervalYears(Date startDate, Date endDate) {
        long sl = startDate.getTime();
        long el = endDate.getTime();
        long ei = el - sl;
        return Math.round((float)(ei / 86400000L / 365L));
    }

    public static int getIntervalYearsCeil(Date startDate, Date endDate) {
        long sl = startDate.getTime();
        long el = endDate.getTime();
        long ei = el - sl;
        return (int)Math.ceil((double)((float)(ei / 86400000L) / 365.0F));
    }

    public static int getIntervalMinutes(Date startDate, Date endDate) {
        long sl = startDate.getTime();
        long el = endDate.getTime();
        long ei = el - sl;
        return (int)(ei / 60000L);
    }

    public static int getIntervalSeconds(Date startDate, Date endDate) {
        long sl = startDate.getTime();
        long el = endDate.getTime();
        long ei = el - sl;
        return (int)(ei / 1000L);
    }

    public static int getIntervalMinutes(long startDate, long endDate) {
        long ei = endDate - startDate;
        return (int)(ei / 60000L);
    }

    public static int getIntervalHours(Date startDate, Date endDate) {
        long sl = startDate.getTime();
        long el = endDate.getTime();
        long ei = el - sl;
        return (int)(ei / 3600000L);
    }

    public static Date parse(String date, String time) {
        if (date != null && time != null) {
            return getLongDate(String.format("%s %s", date, time));
        } else {
            return date != null ? getShortDate(date) : null;
        }
    }

    public static Date parseDate(String strDate, String datePattern) {
        Date date = null;
        if (StringUtils.isNotEmpty(strDate)) {
            try {
                SimpleDateFormat df = new SimpleDateFormat(datePattern);
                date = df.parse(strDate);
            } catch (Exception var4) {
                throw new RuntimeException(var4);
            }
        }

        return date;
    }

    public static int getWeekDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(getCurDate());
        int dayOfWeek = calendar.get(7);
        return dayOfWeek - 1;
    }

    public static Date getCurrYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    public static Date getCurrYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1, year);
        calendar.roll(6, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }

    public static int getMonthofYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int month = calendar.get(2) + 1;
        return month;
    }

    public static String createTimestamp() {
        return Long.toString(System.currentTimeMillis());
    }

    public static String format(Long timestamp, String pattern) {
        Date d = new Date(timestamp.longValue());
        return format(d, pattern);
    }

    public static void main(String[] args) {
        String s1 = createTimestamp();

        try {
            Thread.sleep(5000L);
        } catch (InterruptedException var3) {
            var3.printStackTrace();
        }

        String s2 = createTimestamp();
        System.out.println(Long.valueOf(s2).longValue() - Long.valueOf(s1).longValue());
    }
}
