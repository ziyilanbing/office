package com.glad.startup;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Hello world!
 *
 */
public class AppContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		ServletContext ctx = event.getServletContext();

		String enterpriseId = ctx.getInitParameter("enterpriseId");
		Application.init();

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub

	}
}
