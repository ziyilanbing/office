package com.glad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.base.BaseController;
import com.glad.model.LoginModel;

/**
 * login page action control
 * 
 * @author zhongqs
 */
@Controller
@RequestMapping("/login")
@SessionAttributes("loginModel")
public class LoginController extends BaseController<LoginModel> {

	@ModelAttribute("loginModel")
	public LoginModel createLoginModel() {
		LoginModel loginModel = new LoginModel();
		return loginModel;
	}

	@Override
	public void doInit(ModelMap model, LoginModel commandForm) {

		System.out.println("init method " + this.getScreenId());
	}

}