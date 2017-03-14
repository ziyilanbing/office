package com.glad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glad.dao.TestTableDao;
import com.glad.entity.TestTable;

@Service("TestTableService")
@Transactional
public class TestTableService {

	@Autowired
	private TestTableDao testTableDao;

	public void select(TestTable t) {
		System.out.println(testTableDao.getEntityByKey(t).toString());
	}

	public void delete(TestTable t) {
		testTableDao.deleteEntity(t);
	}

	public void insert(TestTable t) {
		testTableDao.createEntity(t);
	}

	public void update(TestTable t) {
		testTableDao.updateEntity(t);
	}
}
