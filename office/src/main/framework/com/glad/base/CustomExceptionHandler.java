package com.glad.base;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.glad.exp.AppErrorException;
import com.glad.exp.AppFailedException;
import com.glad.model.LoginModel;

@ControllerAdvice
public class CustomExceptionHandler {

	protected Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

	@ModelAttribute
	public LoginModel newUser() {
		System.out.println("============应用到所有@RequestMapping注解方法，在其执行之前把返回值放入Model");
		return new LoginModel();
	}

	@ExceptionHandler(AppErrorException.class)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processAppErrorException(HttpServletRequest request, HttpServletResponse response, Object handler, AppErrorException e) {
		System.out.println(request.toString());
		System.out.println(response.toString());
		System.out.println(handler.toString());
		System.out.println(e.toString());
		// 返回一个逻辑视图名
		// .replace("office/", "")
		return new ModelAndView(request.getRequestURI());
	}

	@ExceptionHandler(AppFailedException.class)
	@ResponseStatus(HttpStatus.OK)
	public ModelAndView processAppFailedException(HttpServletRequest request, HttpServletResponse response, Object handler, AppFailedException e) {
		System.out.println(request.toString());
		System.out.println(response.toString());
		System.out.println(handler.toString());
		System.out.println(e.toString());
		// 返回一个逻辑视图名
		// .replace("office/", "")
		return new ModelAndView(request.getRequestURI());
	}
}
