package com.glad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.framework.base.BaseController;
import com.glad.model.LoginModel;

@Controller
@RequestMapping("/login/**")
@SessionAttributes("loginModel")
public class LoginController extends BaseController {

	@ModelAttribute("loginModel")
	public LoginModel createloginModel() {
		LoginModel loginModel = new LoginModel();
		return loginModel;
	}

	@RequestMapping(value = { "/init" }, method = RequestMethod.GET)
	public String init(ModelMap map, @ModelAttribute LoginModel loginModel,
			HttpServletRequest request) {
		System.out.println("init method");

		return "login";
	}

	@RequestMapping(value = { "/init" }, method = RequestMethod.GET)
	public String initLogin(ModelMap map,
			@ModelAttribute LoginModel loginModel, HttpServletRequest request) {
		System.out.println("init method");

		return "login";
	}

	@RequestMapping(value = { "/submit" }, method = RequestMethod.POST)
	public String submitLogin(@ModelAttribute LoginModel loginModel,
			HttpServletRequest request) {

		return "top";
	}
}