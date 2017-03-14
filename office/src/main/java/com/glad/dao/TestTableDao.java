package com.glad.dao;

import com.glad.entity.TestTable;

public interface TestTableDao {

	public TestTable getEntityByKey(TestTable key);

	public void createEntity(TestTable entity);

	public void updateEntity(TestTable entity);

	public void deleteEntity(TestTable entity);
}
