package com.glad.utils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间日期工具类
 * 
 * @author zhongqs
 */
public class DateUtils {

	/**
	 * 得到当前月份月初
	 * 
	 * @param date
	 * @return
	 */
	public static String getFirstDayMonth() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return format.format(calendar.getTime());
	}

	/**
	 * 工时计算
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static BigDecimal getWorkHours(Date startDate, Date endDate) {
		BigDecimal hoursDiff = new BigDecimal(endDate.getTime() - startDate.getTime()).divide(new BigDecimal(1000 * 60 * 60), 2, BigDecimal.ROUND_HALF_UP);
		// 减去休息时间
		BigDecimal workHours = hoursDiff.subtract(new BigDecimal(1));
		return workHours;
	}

	/**
	 * 工时计算
	 * 
	 * @param date
	 * @return
	 */
	public static String formatWorkHours(BigDecimal workHours) {
		// hours
		BigDecimal hours = workHours.divideAndRemainder(new BigDecimal(1))[0];
		// minutes
		BigDecimal minutes = workHours.divideAndRemainder(new BigDecimal(1))[1].multiply(new BigDecimal(60));
		return hours.setScale(0, BigDecimal.ROUND_HALF_UP) + "时" + minutes.setScale(0, BigDecimal.ROUND_HALF_UP) + "分";
	}

	/**
	 * 工时计算
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static String formatWorkHours(Date startDate, Date endDate) {
		BigDecimal hoursDiff = new BigDecimal(endDate.getTime() - startDate.getTime()).divide(new BigDecimal(1000 * 60 * 60), 2, BigDecimal.ROUND_HALF_UP);
		// 减去休息时间
		BigDecimal workHours = hoursDiff.subtract(new BigDecimal(1));
		// hours
		BigDecimal hours = workHours.divideAndRemainder(new BigDecimal(1))[0];
		// minutes
		BigDecimal minutes = workHours.divideAndRemainder(new BigDecimal(1))[1].multiply(new BigDecimal(60));
		return hours.setScale(0, BigDecimal.ROUND_HALF_UP) + "时" + minutes.setScale(0, BigDecimal.ROUND_HALF_UP) + "分";
	}
}
