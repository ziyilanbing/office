package com.glad.dao;

import com.glad.base.BaseDao;
import com.glad.entity.User;

/**
 * user
 * 
 * @author zhongqs
 * @date 2017年3月9日
 */
public interface UserDao extends BaseDao<Integer, User> {

	public User findByUserName(String userName);

}
