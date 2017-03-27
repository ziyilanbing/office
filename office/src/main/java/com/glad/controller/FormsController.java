package com.glad.controller;

import java.lang.reflect.Field;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.annotation.ScreenId;
import com.glad.base.BaseController;
import com.glad.exp.BaseException;
import com.glad.model.FormsModel;

/**
 * 
 * @author zhongqs
 * @date 2017年3月9日
 */
@Controller
@RequestMapping("/forms/")
@SessionAttributes("formsModel")
@ScreenId("glad.office.Forms")
public class FormsController extends BaseController<FormsModel> {

	@ModelAttribute("formsModel")
	public FormsModel createFormsModel() {
		FormsModel formsModel = new FormsModel();
		return formsModel;
	}

	@Override
	public void doInit(ModelMap model, FormsModel formsModel) throws BaseException {

		System.out.println(formsModel.getTextInput());

	}

	@RequestMapping(value = "/input", method = { RequestMethod.GET, RequestMethod.POST })
	public String exceptionTest(ModelMap model, @ModelAttribute FormsModel formsModel, BindingResult result)
			throws Exception {
		try {

			System.out.println(formsModel.getTextInput());

			for (Field Field : formsModel.getClass().getFields()) {

			}
		} catch (Exception e) {
			handleException(model, result, e);
		}
		return this.getDefaultView();
	}

}