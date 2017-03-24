package com.glad.exp;

import java.util.Locale;
import java.util.ResourceBundle;

public class BaseException extends Exception {

	private String key;

	private Object[] args;

	private static final long serialVersionUID = 1962548119973635013L;

	private static final String BUNDLENAME = "com.glad.ErrorResources";

	public BaseException(String key, Object[] args) {
		super();
		this.key = key;
		this.args = args;
	}

	public String getLocalizedMessage() {

		ResourceBundle bundle = ResourceBundle.getBundle(BUNDLENAME, Locale.CHINESE,
				ResourceBundle.Control.getNoFallbackControl(ResourceBundle.Control.FORMAT_DEFAULT));

		return bundle.getString(getKey());

	}

	private String getKey() {
		return key;
	}

}
