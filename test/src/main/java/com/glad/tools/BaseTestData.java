/**
 * Copyright(c) Nomura Research Institute, Ltd. All Rights Reserved.
 */
package com.glad.tools;

/**
 * Base test data for all type of data
 */
public class BaseTestData implements ITestData {
	/**
	 * Data No
	 */
	private String dataNo;

	/**
	 * @return Data No
	 */
	public String getDataNo() {
		return dataNo;
	}

	/**
	 * @param Data No
	 */
	public void setDataNo(String dataNo) {
		this.dataNo = dataNo;
	}
}
