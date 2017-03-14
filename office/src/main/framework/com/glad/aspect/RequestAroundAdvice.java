package com.glad.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

import com.glad.controller.LoginController;

public class RequestAroundAdvice implements MethodInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(RequestAroundAdvice.class);

	private RequestAroundAdvice() {

	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		logger.info("RequestAroundAdvice implements MethodInterceptor ");

		Class<?> controllerType = invocation.getMethod().getDeclaringClass();

		String redirectUrl = getRedirectUrlByLoginState(invocation, controllerType);

		if (redirectUrl != null) {
			return redirectUrl;
		}

		// Model currentModel = getCurrentModel(invocation);
		//
		// if (currentModel == null) {
		// throw new IllegalArgumentException("'Model' must exist.");
		// }

		Object controller = invocation.getThis();

		String servletPath = getServletPath();
		// val rootPath = get
		return invocation.proceed();
	}

	private Model getCurrentModel(MethodInvocation invocation) {

		// TODO Auto-generated method stub
		return null;
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
		// else {
		// }

		return null;
	}

}
