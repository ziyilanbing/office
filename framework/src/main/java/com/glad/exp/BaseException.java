package com.glad.exp;

import java.util.Locale;
import java.util.ResourceBundle;

public class BaseException extends Exception {

	private String key;
	// private Object[] args;
	private static final long serialVersionUID = 1962548119973635013L;

	public BaseException(String key, Object[] args) {
		super();
		this.key = key;
	}

	public String getLocalizedMessage() {

		String bundleName = "com.glad.ErrorResources";
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, Locale.CHINESE,
				ResourceBundle.Control.getNoFallbackControl(ResourceBundle.Control.FORMAT_DEFAULT));

		return bundle.getString(getKey());

	}

	private String getKey() {
		return key;
	}
}
