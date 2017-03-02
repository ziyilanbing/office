package com.glad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.framework.base.BaseController;
import com.glad.model.HelloModel;

@Controller
@RequestMapping("/hello")
@SessionAttributes("helloModel")
public class HelloController extends BaseController {
	//
	// @ModelAttribute("helloModel")
	// public HelloModel createHelloModel() {
	// HelloModel helloModel = new HelloModel();
	// return helloModel;
	// }

	@RequestMapping(method = RequestMethod.GET)
	public String initModel(ModelMap map) {
		System.out.println(this.getScreenId());
		System.out.println("defaut method");
		return "login";
	}

	@RequestMapping(value = { "/init" }, method = RequestMethod.GET)
	public String helloWorld(ModelMap map, @ModelAttribute HelloModel helloModel, HttpServletRequest request) {
		System.out.println("init method");
		helloModel.setUsername("test");
		helloModel.setPassword("test");
		helloModel.setMessage("abc");
		return "hello";
	}

	@RequestMapping(value = { "/submit" }, method = RequestMethod.POST)
	public String helloWorldaaa(@ModelAttribute HelloModel helloModel, HttpServletRequest request) {
		return "show";
	}
}