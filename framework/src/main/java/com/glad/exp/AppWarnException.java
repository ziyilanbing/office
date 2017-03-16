package com.glad.exp;

public class AppWarnException extends BaseException {

	private static final long serialVersionUID = -3322198173300185785L;

	private String errorFieldName;

	/**
	 * 
	 * @param module
	 *            system id
	 * @param key
	 *            error message's key
	 * @param args
	 *            error message's change item name
	 * @param errorFieldName
	 *            error item
	 */
	public AppWarnException(String key, Object[] args, String errorFieldName) {
		super(key, args);
		this.errorFieldName = errorFieldName;
	}

	/**
	 * 
	 * @return
	 */
	public String getErrorFieldName() {
		return errorFieldName;
	}
}
