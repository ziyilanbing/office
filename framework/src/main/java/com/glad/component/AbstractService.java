package com.glad.component;

import java.util.Date;

import com.glad.collections.MySession;

public abstract class AbstractService<T extends AbstractDto> {

	/**
	 * 删除标记位 0：未删除
	 */
	private static String DELETE_STATE_0 = "0";

	protected void entityInit(T entity) {
		Date date = new Date();
		entity.setLoginNo(MySession.LoginUserId.value());
		entity.setLoginIp(MySession.LoginIp.value());
		entity.setRecInsertTime(date);
		entity.setDeleteState(DELETE_STATE_0);
		entity.setUpdateNo(MySession.LoginUserId.value());
		entity.setUpdateIp(MySession.LoginIp.value());
		entity.setRecUpdateTime(date);
	}

}
