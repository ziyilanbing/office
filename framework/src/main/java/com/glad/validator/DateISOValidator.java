package com.glad.validator;

import java.util.Calendar;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.glad.annotation.DateISO;

public class DateISOValidator implements ConstraintValidator<DateISO, String> {
	@Override
	public void initialize(DateISO constraintAnnotation) {
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		Pattern reg = Pattern.compile("^\\d{4}-(0[1-9]|1[0-2])-\\d{2}$");
		if (!reg.matcher(value).matches())
			return false;
		Calendar time = Calendar.getInstance();
		time.clear();
		time.set(Calendar.YEAR, Integer.valueOf(value.substring(0, 4)));
		time.set(Calendar.MONTH, Integer.valueOf(value.substring(5, 7)) - 1);
		return Integer.valueOf(value.substring(8, 10)) <= time.getActualMaximum(Calendar.DAY_OF_MONTH);
	}
}
