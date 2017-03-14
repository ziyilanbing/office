package com.glad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.base.BaseController;
import com.glad.entity.TestTable;
import com.glad.model.TopModel;
import com.glad.service.TestTableService;

/**
 * 
 * @author zhongqs
 * @date 2017年3月9日
 */
@Controller
@RequestMapping("/top/**")
@SessionAttributes("topModel")
public class TopController extends BaseController<TopModel> {

	@Autowired
	private TestTableService testTableService;

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

	@RequestMapping("/top/**/insert")
	public String insert(ModelMap model) {
		TestTable t = new TestTable();
		t.setColA("cola");
		t.setColB("colb");
		t.setColC("colc");
		t.setKeyA("keya");
		t.setKeyB(123);
		testTableService.insert(t);
		return "login";
	}

	@RequestMapping("/top/**/update")
	public String update(ModelMap model) {
		TestTable t = new TestTable();
		t.setColA("colb");
		t.setColB("colc");
		t.setColC("cold");
		t.setKeyA("keya");
		t.setKeyB(123);
		testTableService.update(t);
		return "login";
	}

	@RequestMapping("/top/**/select")
	public String select(ModelMap model) {
		TestTable t = new TestTable();
		t.setKeyA("keya");
		t.setKeyB(123);
		testTableService.select(t);
		return "login";
	}

	@RequestMapping("/top/**/delete")
	public String delete(ModelMap model) {
		TestTable t = new TestTable();
		t.setKeyA("keya");
		t.setKeyB(123);
		testTableService.delete(t);
		return "login";
	}
}