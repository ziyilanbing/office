package com.glad.aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;

import com.glad.annotation.ScreenId;
import com.glad.component.AbstractController;
import com.glad.controller.LoginController;
import com.glad.controller.LogoutController;
import com.glad.utils.DateUtils;

public class RequestAroundAdvice implements MethodInterceptor {

	private static final Logger logger = LoggerFactory.getLogger(RequestAroundAdvice.class);

	private RequestAroundAdvice() {

	}

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {

		logger.info("RequestAroundAdvice implements MethodInterceptor ");

		Class<?> controllerType = invocation.getThis().getClass();

		if (controllerType == LogoutController.class) {
			return invocation.proceed();
		}

		String redirectUrl = getRedirectUrlByLoginState(invocation, controllerType);

		if (redirectUrl != null) {
			return redirectUrl;
		}

		Model currentModel = getCurrentModel(invocation);

		if (currentModel == null) {
			throw new IllegalArgumentException("[RequestAroundAdvice] 'Model' must exist.");
		}

		String title = invocation.getThis().getClass().getAnnotation(ScreenId.class).value();
		currentModel.addAttribute("title", title);

		// TODO
		Date currentTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		currentModel.addAttribute("today", sdf.format(currentTime).toString());
		currentModel.addAttribute("firstday", DateUtils.getFirstDayMonth());

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
			// 权限信息取得
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();

			if (auth instanceof AnonymousAuthenticationToken) {
				logger.warn("AnonymousUser Need Login");
				Model curModel = getCurrentModel(invocation);
				curModel.asMap().clear();
				return AbstractController.getRedirectRequest(LoginController.class);

			}
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
