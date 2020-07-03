package com.tencent.matrix.trace.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TimeUtils
 *
 * @author <a href="http://www.trinea.cn" target="_blank">Trinea</a> 2013-8-24
 */
public class TimeUtil {

    public static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
    public static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss");
    public static final SimpleDateFormat SIMPLE_DAY_FORMAT = new SimpleDateFormat("yyyyMMdd");
    public static final SimpleDateFormat TIMEMILLS_FORMAT = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss:SSS");

    /**
     * long time to string
     *
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    public static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static long getCurrentTimeInLong() {
        return System.currentTimeMillis();
    }

    /**
     * get current time in milliseconds, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @return
     */
    public static String getCurrentTimeInDefaultString() {
        return getTime(getCurrentTimeInLong(), DEFAULT_DATE_FORMAT);
    }

    /**
     * get current time in milliseconds
     *
     * @return
     */
    public static String getCurrentTimeInSimpleString() {
        return getTime(getCurrentTimeInLong(), SIMPLE_DATE_FORMAT);
    }

    public static String getCurrentTimeInSimpleDayString() {
        return getTime(getCurrentTimeInLong(), SIMPLE_DAY_FORMAT);
    }

    public static String getCurrentTimeInTimemillsString() {
        return getTime(getCurrentTimeInLong(), TIMEMILLS_FORMAT);
    }
}

