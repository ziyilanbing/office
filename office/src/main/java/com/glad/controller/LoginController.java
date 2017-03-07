package com.glad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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

	@Autowired
	private SecurityContextLogoutHandler securityContextLogoutHandle;

	@ModelAttribute("loginModel")
	public LoginModel createloginModel() {
		LoginModel loginModel = new LoginModel();
		return loginModel;
	}

	// init
	@RequestMapping(value = { "/", "/init**" }, method = RequestMethod.GET)
	public String initLogin(ModelMap map, @ModelAttribute LoginModel loginModel, HttpServletRequest request) {
		System.out.println("init method");
		logger.info("logger.info");
		logger.info(this.getScreenId());
		return "login";
	}

	@RequestMapping(value = { "/submit" }, method = RequestMethod.POST)
	public String submitLogin(@ModelAttribute LoginModel loginModel, HttpServletRequest request) {

		System.out.println("Username" + loginModel.getUsername());
		return "top";
	}
}