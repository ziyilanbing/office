package com.glad.validator;

import java.nio.charset.Charset;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.glad.annotation.HalfWidth;

public class HalfWidthValidator implements ConstraintValidator<HalfWidth, String> {
	private Charset encode;

	@Override
	public void initialize(HalfWidth constraintAnnotation) {
		encode = Charset.forName(constraintAnnotation.encode());
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		for (Character c : value.toCharArray()) {
			if (c.toString().getBytes(encode).length != 1)
				return false;
		}
		return true;
	}
}
