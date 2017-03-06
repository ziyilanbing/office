package com.glad.service;

import com.glad.entity.User;

public interface UserService {

	public User findById(int id);

	public User findBySsoId(String ssoId);
}
