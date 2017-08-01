package com.glad.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
@SessionAttributes("workhoursModel") // session model
@ScreenId("glad.office.workhours")
public class WorkhoursController {

	@Autowired
	private WorkhoursService workhoursService;

	/**
	 * session model
	 * 
	 * @return
	 */
	@ModelAttribute("workhoursModel")
	public WorkhoursModel createWorkhoursModel() {
		return new WorkhoursModel();
	}

	@RequestMapping(value = {"/*"}, method = {RequestMethod.GET})
	public String init(ModelMap model, @ModelAttribute WorkhoursModel workhoursModel) throws Exception {
		workhoursModel = new WorkhoursModel();
		return "workhours/register";
	}

	/**
	 * Post demo
	 * 
	 * @param model
	 * @param workhoursModel
	 * @param result
	 * @return
	 * @throws Exception
	 */
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

	/**
	 * Ajax Post Demo
	 * 
	 * @param model
	 * @param aaa
	 * @param workhoursModel
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/confirmajax")
	@ResponseBody
	public Map<String, Object> confirmAjax(ModelMap model, @RequestBody Map<String, Object> aaa, @ModelAttribute WorkhoursModel workhoursModel)
		throws Exception {

		Map<String, Object> rtnmap = new HashMap<String, Object>();
		OdhWktmManage odhWktmManage = new OdhWktmManage();
		odhWktmManage.setUserNo("00734");
		odhWktmManage.setRecNo(0001);
		odhWktmManage.setMemo(workhoursModel.getComment());

		workhoursModel.setComment("");
		workhoursModel.setOdhWktmManageChecked(odhWktmManage);
		return rtnmap;
	}

	@RequestMapping(value = {"/submit"}, method = {RequestMethod.POST})
	public String submit(ModelMap model, @ModelAttribute WorkhoursModel workhoursModel) throws Exception {

		workhoursService.insert(workhoursModel.getOdhWktmManageChecked());
		workhoursModel.setOdhWktmManageChecked(null);
		return "workhours/register";
	}

}
