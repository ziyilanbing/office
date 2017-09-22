/**
 * Copyright(c) Nomura Research Institute, Ltd. All Rights Reserved.
 */
package com.glad.tools;

import java.util.ArrayList;
import java.util.List;

/**
 * Test data group.
 */
public class TestDataGroup {
	/*
	 * Two values:Message and JavaBean
	 */
	private DataType dataType;

	/**
	 * test datas
	 */
	@SuppressWarnings({"rawtypes", "unchecked"})
	private List<? extends ITestData> datas = new ArrayList();

	/**
	 * @return test datas
	 */
	public List<? extends ITestData> getDatas() {
		return datas;
	}

	/**
	 * @param datas
	 */
	public void setDatas(List<? extends ITestData> datas) {
		this.datas = datas;
	}

	/**
	 * @return DataType
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * @param dataType
	 */
	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}

}
