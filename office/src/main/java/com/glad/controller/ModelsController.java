package com.glad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.glad.annotation.ScreenId;
import com.glad.base.BaseController;
import com.glad.dao.OdhModlInfoMapper;

/**
 * Created by CodeGenerator on 2017/07/28.
 */
@Controller
@RequestMapping("/admin")
@ScreenId("glad.office.models")
public class ModelsController extends BaseController {

	@Autowired
	private OdhModlInfoMapper odhModlInfoDao;

	@RequestMapping(value = {"/models"}, method = {RequestMethod.GET})
	public String details(ModelMap model) throws Exception {

		System.out.println(odhModlInfoDao.selectAll().toString());
		model.addAttribute("odhModlInfoList", odhModlInfoDao.selectAll());
		return getIndexView();
	}

}
