package com.glad.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.glad.annotation.NotBlank;
import com.glad.annotation.NotEmpty;
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
				if (annotation instanceof NotNull) {
					String errorCode = "testcode";
					String m = localizeMessageSource.getMessage(errorCode);
					if (!notNull(val))
						errors.rejectValue(fied.getName(), errorCode, m);
				}
				if (annotation instanceof NotEmpty) {
					String errorCode = "testcode";
					String m = localizeMessageSource.getMessage(errorCode);
					if (!notEmpty(val))
						errors.rejectValue(fied.getName(), errorCode, m);
				}
				if (annotation instanceof NotBlank) {
					String errorCode = "testcode";
					if (!notBlank(val))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
			}
		}
	}

	private boolean notNull(String val) {
		return val == null;
	}

	private boolean notEmpty(String val) {
		return val == null || "".equals(val);
	}

	private boolean notBlank(String val) {
		return val == null || "".equals(val.trim());
	}

}
