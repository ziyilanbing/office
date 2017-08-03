package com.glad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glad.dao.OdhCodeManageMapper;
import com.glad.entity.OdhCodeManage;

/**
 * Created by CodeGenerator on 2017/07/28.
 */

@Service("OdhCodeManageService")
@Transactional
public class OdhCodeManageService {

	@Autowired
	private OdhCodeManageMapper OdhCodeManageDao;

	public void insert(OdhCodeManage odhCodeManage) {
		OdhCodeManageDao.insert(odhCodeManage);
	}

	public void selectAll(OdhCodeManage odhCodeManage) {
		OdhCodeManageDao.selectAll();
	}

	public List<String> selectDistinctAll() {
		return OdhCodeManageDao.selectDistinctAll();
	}

	public List<OdhCodeManage> selectByAttribIdOrderOrdinal(String attribId) {
		return OdhCodeManageDao.selectByAttribIdOrderOrdinal(attribId);
	}

}
