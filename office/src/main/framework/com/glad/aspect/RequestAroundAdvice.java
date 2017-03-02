package com.glad.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glad.controller.HelloController;

public class RequestAroundAdvice implements MethodInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(RequestAroundAdvice.class);

	private RequestAroundAdvice() {

	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		Class<?> controllerType = invocation.getMethod().getDeclaringClass();

		String redirectUrl = getRedirectUrlByLoginState(invocation, controllerType);

		if (redirectUrl != null) {
			return redirectUrl;
		}

		Object a = invocation.getArguments();

		String servletPath = getServletPath();
		// val rootPath = get
		return null;
	}

	private String getServletPath() {

		return null;
	}

	private static String getRedirectUrlByLoginState(MethodInvocation invocation, Class<?> controllerType) {
		if (controllerType == HelloController.class) {

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
