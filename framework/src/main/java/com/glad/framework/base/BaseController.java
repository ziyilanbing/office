package com.glad.framework.base;

import com.glad.framework.component.AbstractController;

public class BaseController extends AbstractController {

	private String screenId;

	// protected Logger logger = (Logger) LoggerFactory.getLogger(getClass());

	public String getScreenId() {
		screenId = this.getClass().getName().replaceAll("Controller$", "");
		return screenId;
	}

	public String getReict(Object obj) {
		String controllerName = this.getClass().getName();
		return controllerName.replaceAll("Controller$", "");
	}
}
