package com.glad.base;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.glad.annotation.ScreenId;
import com.glad.component.AbstractController;
import com.glad.component.AbstractModel;
import com.glad.message.LocalizeMessageSource;

public abstract class BaseController<T extends AbstractModel> extends AbstractController {

	protected Logger logger = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected LocalizeMessageSource messageSource;

	/**
	 * 
	 * @return
	 */
	public void setScreenInfo(ModelMap model, T commandForm) {
		String screenId = this.getClass().getAnnotation(ScreenId.class).value();
		String screenName = messageSource.getMessage(screenId);

		commandForm.setScreenId(screenId);
		commandForm.setScreenName(screenName);
		model.addAttribute("title", screenId);

		logger.info("ScreenId : " + commandForm.getScreenId() + ", ScreenName : " + commandForm.getScreenName());
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
	@RequestMapping(value = { "", "/", "/init" }, method = { RequestMethod.GET, RequestMethod.POST })
	public String initLogin(ModelMap model, @ModelAttribute T commandForm, HttpServletRequest request)
			throws Exception {
		try {
			setScreenInfo(model, commandForm);

			doInit(model, commandForm);
		} catch (Exception e) {
			// getScreenId()
			handleException(logger, e, null);
		}
		return getDefaultView();
	}

	public abstract void doInit(ModelMap model, T commandForm);

}
