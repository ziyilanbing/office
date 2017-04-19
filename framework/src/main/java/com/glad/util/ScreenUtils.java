package com.glad.util;

import org.apache.commons.lang.StringUtils;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import com.glad.exp.AppErrorException;
import com.glad.exp.AppWarnException;
import com.glad.exp.OfficeException;

public class ScreenUtils {

	public static final String DATA_KEY = "value";

	public static void setErrorMessage(ModelMap model, BindingResult result, OfficeException cause) {
		String errorField;
		try {
			throw cause;
		} catch (AppWarnException e) {
			// screen message out
			// log out
			errorField = ((AppWarnException) e).getErrorFieldName();
		} catch (AppErrorException e) {
			errorField = ((AppErrorException) e).getErrorFieldName();
		} catch (Exception e) {
			errorField = null;
		}

		if (StringUtils.isNotEmpty(errorField)) {
			result.rejectValue(errorField, "dumy_key", cause.getLocalizedMessage());
		}

		model.putAll(result.getModel());
		model.put(DATA_KEY, result.getFieldErrors());

		result.addError(new FieldError(errorField, "dumy_key", cause.getLocalizedMessage()));
	}
}
