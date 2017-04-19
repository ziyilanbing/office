package com.glad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glad.dao.UserDao;
import com.glad.entity.User;

@Service("userService")
@Transactional
public class UserService {

	@Autowired
	private UserDao userDao;

	public User findById(int id) {
		return userDao.getEntityByKey(id);
	}

	public User findByUserName(String userName) {
		return userDao.findByUserName(userName);
	}

}
