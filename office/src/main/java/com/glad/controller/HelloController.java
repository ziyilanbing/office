package com.glad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.model.HelloModel;

@Controller
@RequestMapping("/hello")
@SessionAttributes("helloModel")
public class HelloController {

	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld(Model model, @ModelAttribute("helloModel") HelloModel helloModel) {
		helloModel.setMessage("abc");
		return "hello";
	}
}