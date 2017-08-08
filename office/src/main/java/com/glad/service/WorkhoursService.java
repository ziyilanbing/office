package com.glad.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glad.component.AbstractService;
import com.glad.dao.OdhWktmManageMapper;
import com.glad.entity.OdhWktmManage;
import com.glad.exp.AppWarnException;
import com.glad.model.WorkhoursModel;
import com.glad.utils.DateUtils;

/**
 * Created by CodeGenerator on 2017/07/28.
 */

@Service("WorkhoursService")
@Transactional
public class WorkhoursService extends AbstractService<OdhWktmManage> {

	@Autowired
	private OdhWktmManageMapper odhWktmManageDao;

	public List<OdhWktmManage> selectAll(OdhWktmManage odhWktmManage) {
		return odhWktmManageDao.selectAll();
	}

	public List<OdhWktmManage> selectByTime(OdhWktmManage odhWktmManage) {
		return odhWktmManageDao.selectByTime(odhWktmManage);
	}

	public void confirm(WorkhoursModel workhoursModel) throws AppWarnException {
		// format check add TODO

		this.checkTime(workhoursModel.getWktmStarthm(), workhoursModel.getWktmEndhm());

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		OdhWktmManage odhWktmManage = new OdhWktmManage();
		odhWktmManage.setUserNo(auth.getName());
		odhWktmManage.setMemo(workhoursModel.getComment());
		odhWktmManage.setWktmStartYmdhm(new Date(workhoursModel.getWktmStartYmd() + " " + workhoursModel.getWktmStarthm()));
		odhWktmManage.setWktmEndYmdhm(new Date(workhoursModel.getWktmEndYmd() + " " + workhoursModel.getWktmEndhm()));
		odhWktmManage.setWktmTimes(DateUtils.getWorkHours(odhWktmManage.getWktmStartYmdhm(), odhWktmManage.getWktmEndYmdhm()));
		odhWktmManage.setWktmType(workhoursModel.getWktmType());
		odhWktmManage.setWktmSubtype(workhoursModel.getWktmSubtype());
		odhWktmManage.setProjectStage(workhoursModel.getProjectStage());
		odhWktmManage.setMemo(workhoursModel.getComment());
		workhoursModel.setOdhWktmManageChecked(odhWktmManage);
	}

	private void checkTime(String wktmStarthm, String wktmEndhm) throws AppWarnException {
		if (StringUtils.isBlank(wktmStarthm))
			throw new AppWarnException("OFE0001MW", new String[]{"1", "2"}, "wktmStarthm");
		if (StringUtils.isBlank(wktmEndhm))
			throw new AppWarnException("OFE0001MW", new String[]{"1", "2"}, "wktmEndhm");
	}

	public void submit(WorkhoursModel workhoursModel) {
		this.entityInit(workhoursModel.getOdhWktmManageChecked());
		odhWktmManageDao.insert(workhoursModel.getOdhWktmManageChecked());
	}

}
