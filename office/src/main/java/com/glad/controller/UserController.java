package com.glad.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.glad.annotation.ScreenId;
import com.glad.base.BaseController;
import com.glad.model.DefaultModel;

/**
 * Created by CodeGenerator on 2017/07/28.
 */
@Controller
@RequestMapping("/admin/user")
@ScreenId("glad.office.user")
public class UserController extends BaseController<DefaultModel> {

	@RequestMapping(method = {RequestMethod.GET})
	public String details(ModelMap model) throws Exception {

		return getIndexView();
	}

}
