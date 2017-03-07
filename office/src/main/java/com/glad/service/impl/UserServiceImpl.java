package com.glad.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glad.dao.user.UserDao;
import com.glad.entity.User;
import com.glad.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User findById(int id) {
		return userDao.getEntityByKey(id);
	}

	@Override
	public User findBySsoId(String ssoId) {
		return userDao.findBySsoId(ssoId);
	}

}
