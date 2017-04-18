package com.glad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glad.dao.DatatablesMapper;
import com.glad.entity.Datatables;

@Service("DataTablesService")
@Transactional
public class DataTablesService {

	@Autowired
	private DatatablesMapper datatablesDao;

	public List<Datatables> select(Datatables datatables) {
		return datatablesDao.selectAll();
	}

	public void delete(Datatables datatables) {
		datatablesDao.deleteByPrimaryKey(datatables.getId());
	}

	public void insert(Datatables datatables) {
		datatablesDao.insert(datatables);
	}

	public void update(Datatables datatables) {
		datatablesDao.updateByPrimaryKey(datatables);
	}
}
