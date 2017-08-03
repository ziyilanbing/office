package com.glad.startup;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.glad.exp.OfficeException;

/**
 * Hello world!
 */
public class AppContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent event) {
		System.out.println("AppContextListener contextInitialized ");
		ServletContext ctx = event.getServletContext();

		try {
			Application.init(new BootstrapConfig(), event);
		} catch (OfficeException e) {
			throw new IllegalStateException("application init failed");
		} catch (Exception e) {
			throw new IllegalStateException("application init failed");
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		Application.destroy();
		System.out.println("AppContextListener contextDestroyed ");
	}
}
