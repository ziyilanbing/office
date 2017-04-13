package com.glad.interceptor;

import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import com.glad.util.ScreenUtils;

public class CustomHandlerInterceptorAdapter implements WebRequestInterceptor {

	@Override
	public void preHandle(WebRequest request) throws Exception {

	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		for (String key : model.keySet()) {

			Object object = model.get(key);
			System.out.println(key + "-------------------------" + object);

			if (object instanceof BindingResult) {
				List<FieldError> fields = ((BindingResult) object).getFieldErrors();
				if (fields.size() > 0) {
					String message = fields.get(0).getDefaultMessage();
					model.put(ScreenUtils.DATA_KEY, message);
					break;
				}
			}
		}

	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {

	}
}
