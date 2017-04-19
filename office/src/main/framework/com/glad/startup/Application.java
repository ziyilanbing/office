package com.glad.startup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glad.exp.OfficeException;

/**
 * Hello world!
 *
 */
public class Application {

	protected Logger logger = LoggerFactory.getLogger(Application.class);

	private static Application instance;

	private final BootstrapConfig config;

	protected Application(final BootstrapConfig config) throws OfficeException {

		loadProperties();
		this.config = config;
	}

	public static synchronized void init(final BootstrapConfig config) throws OfficeException {
		if (instance == null) {
			instance = new Application(config);
		}
	}

	public static Application getInstance() {
		return instance;
	}

	private void loadProperties() {
		// TODO Auto-generated method stub

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
