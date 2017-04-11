package com.glad.validator;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.regex.Pattern;

public class ConstraintsValidate {
	public static boolean notNull(String val) {
		return val != null;
	}

	public static boolean notEmpty(String val) {
		return notNull(val) && !"".equals(val);
	}

	public static boolean notBlank(String val) {
		return notNull(val) && !"".equals(val.trim());
	}

	public static boolean size(String val, int min, int max, Charset encode) {
		if (!notNull(val))
			return true;
		int len = val.getBytes(encode).length;
		return len >= min && len <= max;
	}

	public static boolean digits(String val) {
		if (!notNull(val))
			return true;
		Pattern reg = Pattern.compile("^\\d*$");
		return reg.matcher(val).matches();
	}

	public static boolean pattern(String val, String regexp) {
		if (!notNull(val))
			return true;
		Pattern reg = Pattern.compile(regexp);
		return reg.matcher(val).matches();
	}

	public static boolean halfWidth(String val, Charset encode) {
		if (!notNull(val))
			return true;
		for (Character c : val.toCharArray()) {
			if (c.toString().getBytes(encode).length != 1)
				return false;
		}
		return true;
	}

	public static boolean date(String val) {
		if (!notNull(val))
			return true;
		Pattern reg = Pattern.compile("^\\d{4}(0[1-9]|1[0-2])\\d{2}$");
		if (!reg.matcher(val).matches())
			return false;
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, Integer.valueOf(val.substring(0, 4)));
		time.set(Calendar.MONTH, Integer.valueOf(val.substring(4, 6)) - 1);
		return Integer.valueOf(val.substring(6, 8)) <= time.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static boolean dateISO(String val) {
		if (!notNull(val))
			return true;
		Pattern reg = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-\\d{2}$");
		if (!reg.matcher(val).matches())
			return false;
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, Integer.valueOf(val.substring(0, 4)));
		time.set(Calendar.MONTH, Integer.valueOf(val.substring(5, 7)) - 1);
		return Integer.valueOf(val.substring(8, 10)) <= time.getActualMaximum(Calendar.DAY_OF_MONTH);
	}

	public static boolean email(String val) {
		if (!notNull(val))
			return true;
		Pattern reg = Pattern.compile(
				"^[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$");
		return reg.matcher(val).matches();
	}

	public static boolean url(String val) {
		if (!notNull(val))
			return true;
		try {
			URL url = new URL(val);
			return true;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
