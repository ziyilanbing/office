package com.glad.interceptor;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

import com.glad.aspect.TraceAdvice;
import com.glad.utils.ScreenUtils;

public class CustomHandlerInterceptorAdapter implements WebRequestInterceptor {

	/**
	 * slf4j logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TraceAdvice.class);

	@Override
	public void preHandle(WebRequest request) throws Exception {

	}

	/**
	 * 单项目check的message设定
	 */
	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {

		if (model != null) {
			for (String key : model.keySet()) {
				Object object = model.get(key);
				if (object instanceof BindingResult) {
					List<FieldError> fields = ((BindingResult) object).getFieldErrors();
					if (fields.size() > 0) {
						String code = fields.get(0).getCode();
						String message = fields.get(0).getDefaultMessage();
						model.put(ScreenUtils.DATA_KEY, message);
						break;
					}
				}
			}
		}
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {

	}
}
