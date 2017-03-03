package com.glad.framework.exp;

public class AppFailedException extends BaseException {
	private static final long serialVersionUID = -366356600804451825L;

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
	public AppFailedException(String key, Object[] args, String errorFieldName) {
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
