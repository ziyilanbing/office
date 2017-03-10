package com.glad.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.base.BaseController;
import com.glad.model.TopModel;

/**
 * 
 * @author zhongqs
 * @date 2017年3月9日
 */
@Controller
@RequestMapping("/top/**")
@SessionAttributes("topModel")
public class TopController extends BaseController<TopModel> {

	@ModelAttribute("topModel")
	public TopModel createTopModel() {
		TopModel topModel = new TopModel();
		return topModel;
	}

	@Override
	public void doInit(ModelMap model, TopModel commandForm) {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = principal instanceof UserDetails ? ((UserDetails) principal).getUsername()
				: principal.toString();
		model.addAttribute("user", userName);
		commandForm.setRedirectScreenId("top");
	}

}