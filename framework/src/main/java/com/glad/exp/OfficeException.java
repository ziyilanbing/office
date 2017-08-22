package com.glad.exp;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class OfficeException extends Exception {

	private String key;

	private Object[] args;

	private static final long serialVersionUID = 1962548119973635013L;

	private static final String BUNDLENAME = "com.glad.ErrorResources";

	public OfficeException(String key) {
		super();
		this.key = key;
	}

	public OfficeException(String key, Object[] args) {
		super();
		this.key = key;
		this.args = args;
	}

	public String getKey() {
		return key;
	}

	public Object[] getArgs() {
		return args;
	}

	public String getLocalizedMessage() {

		ResourceBundle bundle = ResourceBundle.getBundle(	BUNDLENAME, Locale.CHINA,
															ResourceBundle.Control.getNoFallbackControl(ResourceBundle.Control.FORMAT_DEFAULT));

		MessageFormat format = new MessageFormat(bundle.getString(getKey()));

		return format.format(getArgs());
	}

}
