package com.glad.framework.base;

import java.util.logging.Logger;

import org.slf4j.LoggerFactory;

import com.glad.framework.component.AbstractController;

public class BaseController extends AbstractController {

	protected Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	public String getScreenId() {
		String controllerName = this.getClass().getName();
		return controllerName.replaceAll("Controller$", "");
	}

	public String getxxxxx(Object obj) {
		String controllerName = this.getClass().getName();
		return controllerName.replaceAll("Controller$", "");
	}
}
