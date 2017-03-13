package com.glad.base;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.glad.framework.component.AbstractController;
import com.glad.framework.component.AbstractModel;

public class BaseController<T extends AbstractModel> extends AbstractController {

	private String screenId;

	protected Logger logger = LoggerFactory.getLogger(BaseController.class);

	public String getScreenId() {
		screenId = StringUtils.substringAfterLast(this.getClass().getName(), ".").replaceAll("Controller$", "");
		logger.info("getScreenId info ");
		logger.warn("getScreenId warn ");
		return screenId;
	}

	public String getReict(Object obj) {
		String controllerName = this.getClass().getName();
		return controllerName.replaceAll("Controller$", "");
	}

	/**
	 * init login page
	 * 
	 * @param model
	 * @param loginModel
	 * @param request
	 * @return Redirect Screen Id
	 * @throws Exception
	 */
	@RequestMapping(value = { "/", "/init" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String initLogin(ModelMap model, @ModelAttribute T commandForm, HttpServletRequest request)
			throws Exception {
		try {
			doInit(model, commandForm);
		} catch (Exception e) {
			// getScreenId()
			handleException(logger, e, getScreenId());
		}
		return commandForm.getRedirectScreenId();
	}

	public void doInit(ModelMap model, T commandForm) {
	}

}