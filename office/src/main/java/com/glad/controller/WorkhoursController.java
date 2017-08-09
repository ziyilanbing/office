package com.glad.controller;

import java.util.HashMap;
import java.util.List;
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
import com.glad.base.BaseController;
import com.glad.entity.OdhWktmManage;
import com.glad.exp.OfficeException;
import com.glad.model.WorkhoursModel;
import com.glad.service.WorkhoursService;

/**
 * Created by CodeGenerator on 2017/07/28.
 */
@Controller
@RequestMapping("/workhours")
@SessionAttributes("workhoursModel") // session model
@ScreenId("glad.office.workhours")
public class WorkhoursController extends BaseController<WorkhoursModel> {

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

	@Override
	public void doInit(ModelMap model, WorkhoursModel commandForm) throws OfficeException {

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
		try {
			workhoursService.confirm(workhoursModel);
		} catch (Exception e) {
			handleException(model, result, e);
		}
		return "workhours/register";
	}

	@RequestMapping(value = {"/submit"}, method = {RequestMethod.POST})
	public String submit(ModelMap model, @ModelAttribute WorkhoursModel workhoursModel) throws Exception {

		workhoursService.submit(workhoursModel);

		workhoursModel.setWktmStarthm("");
		workhoursModel.setWktmEndhm("");
		workhoursModel.setComment("");

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
	public Map<String, Object> confirmAjax(ModelMap model, @RequestBody OdhWktmManage odhWktmManage, @ModelAttribute WorkhoursModel workhoursModel)
		throws Exception {

		Map<String, Object> rtnmap = new HashMap<String, Object>();
		odhWktmManage.setUserNo("00734");
		odhWktmManage.setRecNo(0001);
		odhWktmManage.setMemo(workhoursModel.getComment());

		workhoursModel.setComment("");
		workhoursModel.setOdhWktmManageChecked(odhWktmManage);
		return rtnmap;
	}

	@RequestMapping(value = {"/search"}, method = {RequestMethod.GET, RequestMethod.POST})
	public String search(ModelMap model, @ModelAttribute WorkhoursModel workhoursModel, OdhWktmManage odhWktmManage) throws Exception {

		System.out.println(odhWktmManage.getWktmStartYmdhm());
		System.out.println(odhWktmManage.getWktmEndYmdhm());
		List<OdhWktmManage> OdhWktmManageList = workhoursService.selectByTime(odhWktmManage);
		model.addAttribute("OdhWktmManageList", OdhWktmManageList);
		return "workhours/details";
	}

}
