package com.glad.validation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.URL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.glad.annotation.Date;
import com.glad.annotation.DateISO;
import com.glad.annotation.HalfWidth;
import com.glad.annotation.NotBlank;
import com.glad.annotation.NotEmpty;
import com.glad.aspect.RequestAroundAdvice;
import com.glad.component.AbstractModel;
import com.glad.message.LocalizeMessageSource;
import com.glad.validator.ConstraintsValidate;

public class FormValidator implements Validator {

	private static final Logger logger = LoggerFactory.getLogger(RequestAroundAdvice.class);

	private String encode;

	public String getEncode() {
		return encode;
	}

	public void setEncode(String encode) {
		this.encode = encode;
	}

	private Charset charset_encode;

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
		charset_encode = Charset.forName(encode);
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
					if (!ConstraintsValidate.notNull(val))
						errors.rejectValue(fied.getName(), errorCode, m);
				}
				if (annotation instanceof NotEmpty) {
					String errorCode = "testcode";
					String m = localizeMessageSource.getMessage(errorCode);
					if (!ConstraintsValidate.notEmpty(val))
						errors.rejectValue(fied.getName(), errorCode, m);
				}
				if (annotation instanceof NotBlank) {
					String errorCode = "testcode";
					if (!ConstraintsValidate.notBlank(val))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
				if (annotation instanceof Size) {
					String errorCode = "testcode";
					if (!ConstraintsValidate.size(val, ((Size) annotation).min(), ((Size) annotation).max(),
							charset_encode))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
				if (annotation instanceof Digits) {
					String errorCode = "testcode";
					if (!ConstraintsValidate.digits(val))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
				if (annotation instanceof Pattern) {
					String errorCode = "testcode";
					if (!ConstraintsValidate.pattern(val, ((Pattern) annotation).regexp()))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
				if (annotation instanceof HalfWidth) {
					String errorCode = "testcode";
					if (!ConstraintsValidate.halfWidth(val, charset_encode))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
				if (annotation instanceof Date) {
					String errorCode = "testcode";
					if (!ConstraintsValidate.date(val))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
				if (annotation instanceof DateISO) {
					String errorCode = "testcode";
					if (!ConstraintsValidate.dateISO(val))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
				if (annotation instanceof Email) {
					String errorCode = "testcode";
					if (!ConstraintsValidate.email(val))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
				if (annotation instanceof URL) {
					String errorCode = "testcode";
					if (!ConstraintsValidate.url(val))
						errors.rejectValue(fied.getName(), errorCode, localizeMessageSource.getMessage(errorCode));
				}
			}
		}
	}

}
