/**
 * Copyright(c) Nomura Research Institute, Ltd. All Rights Reserved.
 */
package com.glad.tools;

public enum DataType {
	/**
	 * Type - MQ DATA.
	 */
	MQ_DATA("MQ DATA"),
	/**
	 * Type - BEAN DATA.
	 */
	BEAN_DATA("BEAN DATA");

	/** The Enum type. */
	private final String type;

	/**
	 * @param type
	 */
	private DataType(String type) {
		this.type = type;
	}

	/**
	 * Gets the type.
	 * 
	 * @return the type
	 */
	public String getType() {
		return this.type;
	}

}
