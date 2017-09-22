/**
 * Copyright(c) Nomura Research Institute, Ltd. All Rights Reserved.
 */
package com.glad.tools;

import java.util.Map;

/**
 * Test data for java bean
 */
public class BeanData extends BaseTestData {
	/**
	 * Represent a testing data record
	 */
	private Map<String, String> values;

	/**
	 * @return Map<String, String>
	 */
	public Map<String, String> getValues() {
		return values;
	}

	/**
	 * @param Map<String, String>
	 */
	public void setValues(Map<String, String> values) {
		this.values = values;
	}

}
