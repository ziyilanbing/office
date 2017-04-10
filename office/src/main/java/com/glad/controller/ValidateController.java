package com.glad.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.glad.base.BaseController;
import com.glad.exp.BaseException;
import com.glad.model.ValidateModel;

/**
 * 
 * @author zhongqs
 * @date 2017年3月9日
 */
@Controller
@RequestMapping(value = "/validate/")
@SessionAttributes("validateModel")
public class ValidateController extends BaseController<ValidateModel> {

	@ModelAttribute("validateModel")
	public ValidateModel createValidateModel() {
		ValidateModel validateModel = new ValidateModel();
		return validateModel;
	}

	@Override
	public void doInit(ModelMap model, ValidateModel validateModel) throws BaseException {

		System.out.println(validateModel.getTextInput());

	}

	@RequestMapping(value = "/get", method = { RequestMethod.GET })
	public String doGet(ModelMap model, ValidateModel validateModel) {
		return this.getDefaultView();
	}

	@RequestMapping(value = "/post", method = { RequestMethod.POST })
	public String doPost(ModelMap model, @Valid @ModelAttribute ValidateModel validateModel, BindingResult result) {

		if (result.hasErrors()) {
			result.getAllErrors();
		}
		return this.getDefaultView();
	}

}