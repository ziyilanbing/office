package com.glad.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glad.dao.OdhWktmManageMapper;
import com.glad.entity.OdhWktmManage;

/**
 * Created by CodeGenerator on 2017/07/28.
 */

@Service("WorkhoursService")
@Transactional
public class WorkhoursService {

	@Autowired
	private OdhWktmManageMapper odhWktmManageDao;

	public void insert(OdhWktmManage odhWktmManage) {
		odhWktmManageDao.insert(odhWktmManage);
	}

	public List<OdhWktmManage> selectAll(OdhWktmManage odhWktmManage) {
		return odhWktmManageDao.selectAll();
	}

	public List<OdhWktmManage> selectByTime(OdhWktmManage odhWktmManage) {
		return odhWktmManageDao.selectByTime(odhWktmManage);
	}

}
