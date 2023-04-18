package com.qinhu.demo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	public static String getTime() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(date);
	}

	public static String getTime(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		return dateFormat.format(date);
	}

	public static String getDate() {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	public static String getDate(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return dateFormat.format(date);
	}

	public static Date getDate(String s, String pattren) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattren);
		return dateFormat.parse(s);
	}

	public static String getSpecifiedDayBefor(String specifiedDay, int number) {
		Calendar instance = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		instance.setTime(date);

		int day = instance.get(5);

		instance.set(5, day - number);

		return new SimpleDateFormat("yyyy-MM-dd").format(instance.getTime());
	}

	/**
	 * 获取当前时间距离明天凌晨还有多少秒
	 *
	 * @return
	 */
	public static int getRefreshTime() {
		Calendar calendar = Calendar.getInstance();
		long now = calendar.getTimeInMillis();
		calendar.add(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		long refresh = calendar.getTimeInMillis();
		return (int) ((refresh - now) / 1000);
	}

	/**
	 * 获取当前月份的第一天:格式为yyyy-MM-dd
	 */
	public static String getMonthFirstday() {
		Calendar cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 0);
		cale.set(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String firstday = format.format(cale.getTime());
		return firstday;
	}

	/**
	 * 获取当前月份的最后一天:格式为yyyy-MM-dd
	 */
	public static String getMonthEndday() {
		Calendar cale = Calendar.getInstance();
		cale = Calendar.getInstance();
		cale.add(Calendar.MONTH, 1);
		cale.set(Calendar.DAY_OF_MONTH, 0);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String lastday = format.format(cale.getTime());
		return lastday;
	}

	public static void main(String[] args) {
		System.out.println(getSpecifiedDayBefor("2020-7-31", 1));
	}

}