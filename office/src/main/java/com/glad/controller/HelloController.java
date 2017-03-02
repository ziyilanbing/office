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
@RequestMapping("/login")
@SessionAttributes("loginModel")
public class HelloController extends BaseController {

	@ModelAttribute("loginModel")
	public LoginModel createloginModel() {
		LoginModel loginModel = new LoginModel();
		return loginModel;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initModel(ModelMap map) {
		System.out.println(this.getScreenId());
		System.out.println("defaut method");
		return "login";
	}

	@RequestMapping(value = { "/init" }, method = RequestMethod.GET)
	public String helloWorld(ModelMap map, @ModelAttribute LoginModel loginModel, HttpServletRequest request) {
		System.out.println("init method");
		loginModel.setUsername("test");
		loginModel.setPassword("test");
		loginModel.setMessage("abc");
		return "hello";
	}

	@RequestMapping(value = { "/submit" }, method = RequestMethod.POST)
	public String helloWorldaaa(@ModelAttribute LoginModel loginModel, HttpServletRequest request) {
		return "show";
	}
}