package com.glad.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.resource.DefaultServletHttpRequestHandler;

public class RouteHandlerInterceptor extends HandlerInterceptorAdapter {

	protected Logger logger = LoggerFactory.getLogger(RouteHandlerInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// PJAX
		if (request.getHeader("X-PJAX") != null) {
			logger.info("Request X-PJAX");
			return true;
		}
		// AJAX
		if ("XMLHttpRequest".equals(request.getHeader("X-Requested-With"))) {
			logger.info("Request AJAX");
			return true;
		}
		// 找不到对应的HandlerMapping / 静态资源
		if (handler instanceof DefaultServletHttpRequestHandler) {
			return true;
		}
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/dashboard/init?redirectby=" + request.getRequestURI());
		logger.info("Redirect : " + request.getRequestURI());
		return false;
	}
}
