package com.glad.dao;

import com.glad.entity.User;
import com.glad.framework.base.BaseDao;

public interface UserDao extends BaseDao<Integer, User> {

	public User findBySsoId(String ssoId);

}
