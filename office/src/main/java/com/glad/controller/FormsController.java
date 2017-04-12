package com.glad.controller;

import javax.validation.Valid;

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
		return new FormsModel();
	}

	@Override
	public void doInit(ModelMap model, FormsModel formsModel) throws BaseException {

		// 初期值设定
		formsModel.setTextInput("1");
		formsModel.setTextInputwithPlaceholder("22");
		formsModel.setTextarea("333");
		formsModel.setCheckbox1("1");
		formsModel.setCheckbox2("1");
		formsModel.setCheckbox3("1");
		formsModel.setRadioButtons("2");

	}

	@RequestMapping(value = "/input", method = { RequestMethod.GET, RequestMethod.POST })
	public String exceptionTest(ModelMap model, @Valid @ModelAttribute FormsModel formsModel, BindingResult result)
			throws Exception {

		logger.info(formsModel.fetchFieldValue());
		if (result.hasErrors()) {
			return this.getDefaultView();
		}

		try {
			// 業務處理

		} catch (Exception e) {
			handleException(model, result, e);
		}
		return this.getDefaultView();
	}

}