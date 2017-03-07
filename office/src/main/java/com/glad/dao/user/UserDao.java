package com.glad.dao.user;

import com.glad.entity.User;
import com.glad.framework.base.BaseDao;

public interface UserDao extends BaseDao<Integer, User> {

	public User findBySsoId(String ssoId);

}
