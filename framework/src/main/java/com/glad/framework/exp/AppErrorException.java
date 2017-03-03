package com.glad.framework.exp;

public class AppErrorException extends BaseException {
	private static final long serialVersionUID = 3641035922703182059L;

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
	public AppErrorException(String key, Object[] args, String errorFieldName) {
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
