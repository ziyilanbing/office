package com.glad.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import com.glad.annotation.ScreenId;
import com.glad.controller.LoginController;

public class RequestAroundAdvice implements MethodInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(RequestAroundAdvice.class);

	private RequestAroundAdvice() {

	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		logger.info("RequestAroundAdvice implements MethodInterceptor ");

		// Class<?> controllerType = invocation.getMethod().getDeclaringClass();
		//
		// String redirectUrl = getRedirectUrlByLoginState(invocation,
		// controllerType);
		//
		// if (redirectUrl != null) {
		// return redirectUrl;
		// }

		Model currentModel = getCurrentModel(invocation);

		if (currentModel == null) {
			throw new IllegalArgumentException("'Model' must exist.");
		}

		String title = invocation.getThis().getClass().getAnnotation(ScreenId.class).value();
		currentModel.addAttribute("title", title);

		// String servletPath = getServletPath();
		// val rootPath = get
		return invocation.proceed();
	}

	private String getServletPath() {

		return null;
	}

	private static String getRedirectUrlByLoginState(MethodInvocation invocation, Class<?> controllerType) {
		if (controllerType == LoginController.class) {

		}
		// sessionTimeOut
		// else if (false) {
		// logger.info("sessionTimeOut");
		// }
		else {
			Model curModel = getCurrentModel(invocation);
			curModel.asMap().clear();

		}

		return null;
	}

	private static Model getCurrentModel(MethodInvocation invocation) {
		for (Object arg : invocation.getArguments()) {
			if (arg instanceof BindingAwareModelMap) {
				return (Model) arg;
			}
		}
		return null;
	}

}
