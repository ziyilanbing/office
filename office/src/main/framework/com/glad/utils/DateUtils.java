package com.glad.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {

	/**
	 * 得到当前月份月初 getEarlierThisMonth()
	 * 
	 * @param date
	 * @return
	 */
	public static String getFirstDay() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return format.format(calendar.getTime());
	}

}
