package com.glad.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.framework.base.BaseController;
import com.glad.model.LoginModel;

/**
 * login page action control
 * 
 * @author zhongqs
 */
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
	@RequestMapping(value = { "/init" }, method = RequestMethod.GET)
	public String initLogin(ModelMap model, @ModelAttribute LoginModel loginModel, HttpServletRequest request) {
		System.out.println("init method" + this.getScreenId());
		return "login";
	}

	@RequestMapping(value = { "/", "top" }, method = RequestMethod.GET)
	public String initTop(ModelMap model, @ModelAttribute LoginModel loginModel, HttpServletRequest request) {
		System.out.println("init top" + this.getScreenId());
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = principal instanceof UserDetails ? ((UserDetails) principal).getUsername()
				: principal.toString();
		model.addAttribute("user", userName);
		return "top";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			securityContextLogoutHandle.logout(request, response, auth);
		}
		return "redirect:/login";
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
		System.out.println("authenticationFailure");
		request.setAttribute("authenticationFailureResult", "failure");
		return "login";
	}
}