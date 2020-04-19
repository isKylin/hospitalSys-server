package com.example.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Guo Jun
 * @date 2019/08/05
 */
public class DateUtil {

	/** 时间格式(yyyy-MM-dd) */
	public final static String DATE_PATTERN = "yyyy-MM-dd";
	/** 时间格式(yyyy-MM-dd HH:mm:ss) */
	public final static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	public static String dateFormat(Date date) {
		return format(date, DATE_PATTERN);
	}

	public static String dateTimeFormat(Date date) {
		return format(date, DATE_TIME_PATTERN);
	}

	public static String timeFormat(Date date) {

		String dateTimeStr = dateTimeFormat(date);
		return dateTimeStr.substring(11, dateTimeStr.length());

	}

	public static Date parshDateTimeFormat(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			System.out.println("日志格式转换异常" + e);
		}
		return date;
	}

	public static Date parshDateTime(String dateStr, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
//			System.out.println("日期格式转换异常" + e);
			Date date2 = new Date();
			return date2;
		}
	}

	public static Date parshDateFormat(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = sdf.parse(dateStr);
			return date;
		} catch (ParseException e) {
			System.out.println("日志格式转换异常" + e);
		}

		return date;
	}

	public static String format(Date date, String pattern) {
		if (date != null) {
			SimpleDateFormat df = new SimpleDateFormat(pattern);
			return df.format(date);
		}
		return null;
	}

	/**
	 * 判断字符串是否是指定格式的时间
	 * 
	 * @param str
	 * @param pattern
	 * @return
	 */
	public static boolean isValidTime(String str, String pattern) {
		boolean convertSuccess = true;
		// 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		try {
			// 设置lenient为false.
			// 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
			format.setLenient(false);
			format.parse(str);
		} catch (ParseException e) {
			// 如果throw java.text.ParseException或者NullPointerException，就说明格式不对
			convertSuccess = false;
		}
		return convertSuccess;
	}

	public static long compairWithDate(Date date) {

		Date now = new Date();
		long between = date.getTime() - now.getTime();

		return between;

	}

	public static long compairWithDate(Date compareDate, Date comparedDate) {
		long between = compareDate.getTime() - comparedDate.getTime();
		return between;
	}

	public static long compairTime(long compareTime, Date comparedDate) {
		long between = compareTime - comparedDate.getTime();
		return between;
	}

	/**
	 * 与当前日期比较，返回字符串差
	 * 
	 * @param date
	 * @return
	 */
	public static int compareWithNowDate(Date date) {
		Date now = new Date();
		String nowStr = format(now, "yyyy-MM-dd").toString();
		String dateStr = format(date, "yyyy-MM-dd").toString();
		return dateStr.compareTo(nowStr);

	}

	/**
	 * @param date
	 * @return 返回比较时间 - 当前时间的毫秒差
	 */
	public static long compairWithTime(Date date) {

		Date now = new Date();
		String nowDateStr = DateUtil.dateFormat(now);
		String timeStr = DateUtil.timeFormat(date);

		Date comparieDate = DateUtil.parshDateTimeFormat(nowDateStr + " " + timeStr);

		long between = comparieDate.getTime() - now.getTime();

		return between;

	}


	/**
	 * 当前日期是否在范围内
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	public static boolean inDateRange(Date start, Date end) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
		String nowStr = df.format(now);
		String startStr = df.format(start);
		String endStr = df.format(end);

		if (nowStr.compareTo(startStr) >= 0 && nowStr.compareTo(endStr) <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean inTimeRange(Date start, Date end) {
		if (compairWithTime(start) <= 0 && compairWithTime(end) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean inTimeRange(Date start, Date end, int aheadMinutes) {
		Date offsetedStartTime = new Date(start.getTime() - aheadMinutes * 60 * 1000);
		if (compairWithTime(offsetedStartTime) <= 0 && compairWithTime(end) >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public static String getStr() {
		return "hello";
	}
	
	public static String getCurMonthFirstTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance();    
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH,1); 
        String first = format.format(c.getTime())+" 00:00:00";
        
        System.out.println(first);
        return first;
	}
	
	public static String getLastMonthFirstTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar c = Calendar.getInstance();    
        c.add(Calendar.MONTH, -1);
        //设置为1号,当前日期既为本月第一天 
        c.set(Calendar.DAY_OF_MONTH,1);
        String first = format.format(c.getTime())+" 00:00:00";
        
        System.out.println(first);
        return first;
	}
	
	public static String getCurMonthCode() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMM"); 
		Calendar c = Calendar.getInstance();    
        c.add(Calendar.MONTH, 0);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH,1); 
        String first = format.format(c.getTime());
        return first;
	}
	public static String getLastMonthCode() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM"); 
		Calendar c = Calendar.getInstance();    
        c.add(Calendar.MONTH, -1);
        //设置为1号,当前日期既为本月第一天
        c.set(Calendar.DAY_OF_MONTH,1); 
        String first = format.format(c.getTime());
        return first;
	}
	
	public static String getWeekStartDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		String date = format.format(cal.getTime());
		return date;
		}
	
	public static String getLastWeekStartDate(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, -168);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		String date = format.format(cal.getTime());
		return date;
		}
	
	public static String getWeekStartDate2(){
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd"); 
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		cal.set(Calendar.HOUR_OF_DAY, -168);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		String date = format.format(cal.getTime());
		return date;
		}
	

	public static void main(String[] args) {
		System.out.println(dateTimeFormat(new Date()));
		System.out.println(DateUtil.dateTimeFormat(new Date(System.currentTimeMillis()-5*60*1000)));

	}

}