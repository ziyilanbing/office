package com.glad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.annotation.ScreenId;
import com.glad.base.BaseController;
import com.glad.model.TablesModel;

/**
 * 
 * @author zhongqs
 * @date 2017年3月9日
 */
@Controller
@RequestMapping("/tables/**")
@SessionAttributes("commandForm")
@ScreenId("glad.office.Tables")
public class TablesController extends BaseController<TablesModel> {

	@Override
	public void doInit(ModelMap model, TablesModel commandForm) {

	}

}