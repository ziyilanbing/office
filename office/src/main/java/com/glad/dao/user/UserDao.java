package com.glad.dao.user;

import com.glad.entity.User;
import com.glad.framework.base.BaseDao;

/**
 * user
 * 
 * @author zhongqs
 * @date 2017年3月9日
 */
public interface UserDao extends BaseDao<Integer, User> {

	public User findByUserName(String userName);

}
