package com.glad.startup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.glad.entity.OdhCodeManage;
import com.glad.exp.OfficeException;
import com.glad.service.OdhCodeManageService;

/**
 * Application
 */
public class Application {

	protected Logger logger = LoggerFactory.getLogger(Application.class);

	private static Application instance;

	private static ApplicationContext context;

	private ServletContext servletContext;

	protected Application(ServletContextEvent event) throws OfficeException {
		servletContext = event.getServletContext();
		context = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);
		loadCodes();
		loadProperties();
	}

	public static synchronized void init(ServletContextEvent event) throws OfficeException {
		if (instance == null) {
			instance = new Application(event);
		}
	}

	public static Application getInstance() {
		return instance;
	}

	public static ApplicationContext getApplicationContext() {
		return context;
	}

	/**
	 * 加载属性文件
	 */
	private void loadProperties() {

	}

	/**
	 * 代码管理表加载到ServletContext的Attribute中
	 */
	private void loadCodes() {
		OdhCodeManageService testCodeService = context.getBean(OdhCodeManageService.class);
		List<String> attribIdList = testCodeService.selectDistinctAll();
		for (String attribId : attribIdList) {
			List<OdhCodeManage> attribValueList = testCodeService.selectByAttribIdOrderOrdinal(attribId);
			Map<String, String> map = new HashMap<String, String>();
			for (OdhCodeManage attribValue : attribValueList) {
				map.put(attribValue.getAttribVal(), attribValue.getAttribExpla());
			}
			servletContext.setAttribute(attribId, map);
			System.out.println(attribId + " //// " + map.toString());
		}
	}

	public static void destroy() {
		if (instance != null) {
			instance.cleanup();
			instance = null;
		}
	}

	/**
	 * cleanup application
	 */
	private void cleanup() {

	}

}
