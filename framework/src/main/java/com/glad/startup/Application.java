package com.glad.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glad.exp.BaseException;

/**
 * Hello world!
 *
 */
public class Application {

	protected Logger logger = LoggerFactory.getLogger(Application.class);

	private static Application instance;

	private final BootstrapConfig config;

	protected Application(final BootstrapConfig config) throws BaseException {

		loadProperties();
		this.config = config;
	}

	public static synchronized void init(final BootstrapConfig config) throws BaseException {
		if (instance == null) {
			instance = new Application(config);

		}

	}

	private void loadProperties() {
		// TODO Auto-generated method stub

	}

}
