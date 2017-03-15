package com.glad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.base.BaseController;
import com.glad.model.LoginModel;

/**
 * login page action control
 * 
 * @author zhongqs
 */
@Controller
@RequestMapping("/login/**")
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

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = principal instanceof UserDetails ? ((UserDetails) principal).getUsername()
				: principal.toString();
		model.addAttribute("user", userName);
		return "accessDenied";
	}

	/**
	 * login Failure
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/authenticationFailure", method = RequestMethod.GET)
	public String authenticationFailure(HttpServletRequest request) {
		request.setAttribute("authenticationFailureResult", "failure");
		logger.info("login failed");
		return "login";
	}

}