package com.glad.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.glad.exp.AppWarnException;
import com.glad.model.LoginModel;

@ControllerAdvice
public class CustomExceptionHandler {

	@ModelAttribute
	public LoginModel newUser() {
		System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
		return new LoginModel();
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器");
	}

	@ExceptionHandler(AppWarnException.class)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processAppWarnException(HttpServletRequest request, HttpServletResponse response, Object handler, AppWarnException e) {
		System.out.println("===========应用到所有@RequestMapping注解的方法，在其抛出UnauthenticatedException异常时执行");
		System.out.println(request.toString());
		System.out.println(response.toString());
		System.out.println(handler.toString());
		System.out.println(e.toString());
		// 返回一个逻辑视图名
		// .replace("office/", "")
		return new ModelAndView(request.getRequestURI());
	}
}
