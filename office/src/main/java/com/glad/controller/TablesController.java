package com.glad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.annotation.ScreenId;
import com.glad.base.BaseController;
import com.glad.entity.Datatables;
import com.glad.model.TablesModel;
import com.glad.service.DataTablesService;

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

	@Autowired
	private DataTablesService dataTablesService;

	@Override
	public void doInit(ModelMap model, TablesModel commandForm) {
		Datatables datatables = new Datatables();
		datatables.setId(1);
		List<Datatables> datatablesList = dataTablesService.select(datatables);
		commandForm.setDatatablesList(datatablesList);
		for (Datatables data : datatablesList) {
			System.out.println(data.getBrowser());
		}
	}

}