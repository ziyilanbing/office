package com.glad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.annotation.ScreenId;
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
@ScreenId("glad.office.Login")
public class LoginController extends BaseController<LoginModel> {

	@ModelAttribute("loginModel")
	public LoginModel createLoginModel() {
		LoginModel loginModel = new LoginModel();
		return loginModel;
	}

	@Override
	public void doInit(ModelMap model, LoginModel loginModel) {
		System.out.println(loginModel.getScreenId());
		System.out.println(loginModel.getUsername());

	}

	/**
	 * login Failure
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/authenticationFailure", method = RequestMethod.GET)
	public String authenticationFailure(ModelMap model, LoginModel loginModel, HttpServletRequest request) {

		model.addAttribute("title", "glad.office.Login");
		model.addAttribute("authenticationFailureResult", "failure");

		return "login";
	}

}