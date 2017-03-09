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
 * 
 * @author zhongqs
 * @date 2017年3月9日
 */
@Controller
@RequestMapping("/top/**")
@SessionAttributes("loginModel")
public class TopController extends BaseController {

	@ModelAttribute("loginModel")
	public LoginModel createloginModel() {
		LoginModel loginModel = new LoginModel();
		return loginModel;
	}

	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public String initTop(ModelMap model, HttpServletRequest request) {
		System.out.println("init top ScreenId : " + this.getScreenId());
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = principal instanceof UserDetails ? ((UserDetails) principal).getUsername()
				: principal.toString();
		model.addAttribute("user", userName);
		return "top";
	}

}