package com.glad.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.glad.annotation.NotNullOrEmpty;
import com.glad.annotation.NullOrEmpty;
import com.glad.aspect.RequestAroundAdvice;
import com.glad.component.AbstractModel;
import com.glad.message.LocalizeMessageSource;

public class FormValidator implements Validator {

	private static final Logger logger = LoggerFactory.getLogger(RequestAroundAdvice.class);

	@Autowired
	protected LocalizeMessageSource localizeMessageSource;

	@Override
	public boolean supports(Class<?> clazz) {
		return AbstractModel.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		String val;
		Class<?> cls = target.getClass();
		for (Field fied : cls.getDeclaredFields()) {
			for (Annotation annotation : fied.getAnnotations()) {
				try {
					val = (String) cls
							.getMethod(
									"get" + fied.getName().substring(0, 1).toUpperCase() + fied.getName().substring(1))
							.invoke(target);
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException
						| NoSuchMethodException | SecurityException e) {
					e.printStackTrace();
					continue;
				}
				if (annotation instanceof NullOrEmpty) {
					String errorCode = "testcode";
					if (!nullOrEmptyImp(val))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
				if (annotation instanceof NotNullOrEmpty) {
					String errorCode = "testcode";
					String m = localizeMessageSource.getMessage(errorCode);
					if (!notNullOrEmptyImp(val))
						errors.rejectValue(fied.getName(), errorCode, m);
				}
			}
		}
	}

	private boolean nullOrEmptyImp(String val) {
		return val == null || "".equals(val);
	}

	private boolean notNullOrEmptyImp(String val) {
		return !nullOrEmptyImp(val);
	}

}
