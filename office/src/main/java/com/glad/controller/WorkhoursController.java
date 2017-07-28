package com.glad.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.annotation.ScreenId;
import com.glad.entity.OdhWktmManage;
import com.glad.model.WorkhoursModel;
import com.glad.service.WorkhoursService;

/**
 * Created by CodeGenerator on 2017/07/28.
 */
@Controller
@RequestMapping("/workhours")
@SessionAttributes("workhoursModel")
@ScreenId("glad.office.workhours")
public class WorkhoursController {

	@Autowired
	private WorkhoursService workhoursService;

	@ModelAttribute("workhoursModel")
	public WorkhoursModel createWorkhoursModel() {
		return new WorkhoursModel();
	}

	@RequestMapping(value = {"/*"}, method = {RequestMethod.GET})
	public String init(ModelMap model) throws Exception {

		return "workhours/register";
	}

	@RequestMapping(value = {"/confirm"}, method = {RequestMethod.POST})
	public String confirm(ModelMap model, @Valid @ModelAttribute WorkhoursModel workhoursModel, BindingResult result) throws Exception {

		OdhWktmManage odhWktmManage = new OdhWktmManage();
		odhWktmManage.setUserNo("00734");
		odhWktmManage.setRecNo(0001);
		odhWktmManage.setMemo(workhoursModel.getComment());

		workhoursModel.setComment("");
		workhoursModel.setOdhWktmManageChecked(odhWktmManage);

		return "workhours/register";
	}

	@RequestMapping(value = {"/submit"}, method = {RequestMethod.POST})
	public String submit(ModelMap model, @ModelAttribute WorkhoursModel workhoursModel) throws Exception {

		workhoursService.insert(workhoursModel.getOdhWktmManageChecked());
		workhoursModel.setOdhWktmManageChecked(null);
		return "workhours/register";
	}

}
