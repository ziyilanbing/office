package com.glad.base;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glad.framework.component.AbstractController;

public class BaseController extends AbstractController {

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

}
