package com.glad.validator;

import java.util.Calendar;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.glad.annotation.Time;

public class TimeValidator implements ConstraintValidator<Time, String> {
	@Override
	public void initialize(Time constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Pattern reg = Pattern.compile("^([0-1][0-9]|[2][0-3]):([0-5][0-9])$");
		if (!reg.matcher(value).matches())
			return false;
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, Integer.valueOf(value.substring(0, 4)));
		time.set(Calendar.MONTH, Integer.valueOf(value.substring(5, 7)) - 1);
		return Integer.valueOf(value.substring(8, 10)) <= time.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}
