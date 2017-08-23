package com.glad.startup;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glad.exp.OfficeException;

/**
 * Hello world!
 */
public class AppContextListener implements ServletContextListener {

	protected Logger logger = LoggerFactory.getLogger(AppContextListener.class);

	@Override
	public void contextInitialized(ServletContextEvent event) {
		logger.info("AppContextListener contextInitialized ");
		try {
			Application.init(event);
		} catch (OfficeException e) {
			throw new IllegalStateException("application init failed");
		} catch (Exception e) {
			throw new IllegalStateException("application init failed");
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		Application.destroy();
		logger.info("AppContextListener contextDestroyed ");
	}
}
