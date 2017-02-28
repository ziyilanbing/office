package com.glad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.model.HelloModel;

@Controller
@RequestMapping("/hello")
@SessionAttributes("helloModel")
public class HelloController {

	@ModelAttribute("loginModel")
	public HelloModel createLoginModel() {
		HelloModel loginModel = new HelloModel();
		return loginModel;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String initModel(@ModelAttribute("helloModel") HelloModel loginModel) {
		System.out.println("aaaa");
		return "hello";
	}

	@RequestMapping(value = { "/init", "complete" }, method = RequestMethod.GET)
	public String helloWorld(ModelMap map, HelloModel helloModel,
			HttpServletRequest request) {
		System.out.println("aaaaa");
		helloModel.setMessage("abc");
		return "hello";
	}
}