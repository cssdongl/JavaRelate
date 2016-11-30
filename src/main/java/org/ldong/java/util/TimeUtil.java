package org.ldong.java.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Title: TimeUtil.java
 * @Copyright: Copyright (c) 2015
 * @Description: <br>
 *               时间工具类 <br>
 * @Created on 2015年6月19日 下午1:34:41
 * @author cssdongl@gmail.com
 */
public final class TimeUtil {
	/*
	 * 默认的时间格式
	 */
	public final static String DEFAULT_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
	/*
	 * 默认截取自然天时间格式
	 */
	public final static String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd";

	/**
	 * @Description: 返回当前时间
	 * @param style:
	 *            返回时间字符串格式
	 * @return: 当前时间
	 */
	public static String getNow(String style) {
		String timeStyle = null;
		if (null == style || style.trim().length() == 0) {
			timeStyle = DEFAULT_DATE_PATTERN;
		} else {
			timeStyle = style;
		}
		SimpleDateFormat format = new SimpleDateFormat(timeStyle);
		Calendar instance = Calendar.getInstance();
		return format.format(instance.getTime());
	}

	public static String getCommonDay(String style, Integer leaveToToday) {
		String defaultStyle = "yyyy-MM-dd";
		if (null != style && style.length() > 1) {
			defaultStyle = style;
		}
		SimpleDateFormat format = new SimpleDateFormat(defaultStyle);
		Calendar instance = Calendar.getInstance();
		instance.set(Calendar.DATE, instance.get(instance.DATE) + leaveToToday);
		return format.format(instance.getTime());
	}

	public static String getCommonDay(String time, String style, Integer leaveToToday) {
		String defaultStyle = "yyyy-MM-dd";
		if (null != style && style.length() > 1) {
			defaultStyle = style;
		}
		Date date = getFormatDate(time, defaultStyle);
		SimpleDateFormat format = new SimpleDateFormat(defaultStyle);
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		instance.set(Calendar.DAY_OF_MONTH, instance.get(instance.DAY_OF_MONTH) + leaveToToday);
		return format.format(instance.getTime());
	}

	public static String getCommonHour(String time, String style, Integer plus) {
		String defaultStyle = "yyyy-MM-dd HH";
		if (null != style && style.length() > 1) {
			defaultStyle = style;
		}
		Date date = getFormatDate(time, defaultStyle);
		SimpleDateFormat format = new SimpleDateFormat(defaultStyle);
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		instance.set(Calendar.HOUR, instance.get(instance.HOUR) + plus);
		return format.format(instance.getTime());
	}

	public static Date getFormatDate(String time, String pattern) {
		if (null == time || "".equals(time)) {
			return null;
		}
		if (null == pattern || "".equals(pattern)) {
			pattern = TimeUtil.DEFAULT_DATE_PATTERN;
		}
		DateFormat format = new SimpleDateFormat(pattern);
		try {
			return format.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		System.out.println(getCommonDay("2015-07-25", "yyyy-MM-dd", -30));
		Date formatDate = getFormatDate("2015-07-25 12:30:40", "yyyy-MM-dd");
		System.out.println(formatDate.getTime());
	}

	/**
	 * @param starttime
	 * @param style
	 * @param i
	 * @return
	 */
	public static String getCommonMinute(String starttime, String style, int i) {
		String defaultStyle = "yyyy-MM-dd HH:mm:ss";
		if (null != style && style.length() > 1) {
			defaultStyle = style;
		}
		Date date = getFormatDate(starttime, defaultStyle);
		SimpleDateFormat format = new SimpleDateFormat(defaultStyle);
		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		instance.set(Calendar.MINUTE, instance.get(instance.MINUTE) + i);
		return format.format(instance.getTime());
	}
}
