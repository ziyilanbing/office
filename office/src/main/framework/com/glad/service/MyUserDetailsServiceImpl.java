package com.glad.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.glad.aspect.RequestAroundAdvice;
import com.glad.entity.Role;
import com.glad.entity.User;
import com.glad.util.State;

@Service("myUserDetailsService")
public class MyUserDetailsServiceImpl implements UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(RequestAroundAdvice.class);

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userService.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException("UserName : " + userName + " not found !");
		}

		logger.info("UserID : " + user.getId() + ", UserName : " + user.getUserName());

		// 账号是否为活动状态
		boolean enabled = user.getState().equals(State.ACTIVE.getName());
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoleList()) {
			logger.info("role : " + role.getRoleType());
			authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleType()));
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), enabled,
				true, true, true, authorities);
	}
}
