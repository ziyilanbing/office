package com.glad.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.glad.base.BaseController;

public class RouteHandlerInterceptor implements HandlerInterceptor {

	protected Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// PJAX
		if (request.getHeader("X-PJAX") != null) {
			logger.info("Request X-PJAX");
			return true;
		}
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath + "/dashboard/init?redirectby=" + request.getRequestURI());
		logger.info("Redirect : " + request.getRequestURI());
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub

	}

}
