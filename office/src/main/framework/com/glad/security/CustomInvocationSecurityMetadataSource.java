package com.glad.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import com.glad.aspect.TraceAdvice;

public class CustomInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	/**
	 * slf4j logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TraceAdvice.class);

	private Map<String, List<ConfigAttribute>> urlAuthority;
	// private UrlMatcher urlMatcher;

	/**
	 * 构造每一种资源所需要的角色权限
	 */
	public CustomInvocationSecurityMetadataSource() {
		super();
		this.urlAuthority = new HashMap<String, List<ConfigAttribute>>();
		// this.urlMatcher = new AntUrlPathMatcher();
		List<ConfigAttribute> list = new ArrayList<ConfigAttribute>();
		ConfigAttribute cb = new SecurityConfig("ROLE_ADMIN"); // 构造一个权限(角色)
		ConfigAttribute cbUser = new SecurityConfig("ROLE_USER"); // 构造一个权限(角色)
		ConfigAttribute cbManager = new SecurityConfig("ROLE_MANAGER"); // 构造一个权限(角色)
		ConfigAttribute cbAnonymous = new SecurityConfig("ROLE_ANONYMOUS"); // 构造一个权限(角色)
		list.add(cb);
		list.add(cbUser);
		list.add(cbManager);
		list.add(cbAnonymous);
		urlAuthority.put("/login/submit", list);
		urlAuthority.put("/dashboard/init", list);
		urlAuthority.put("/table/init", list);
		list.remove(2);
		urlAuthority.put("/Main2.jsp", list);
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {

		List<ConfigAttribute> list = new ArrayList<ConfigAttribute>();
		// USER 权限取得
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
			ConfigAttribute configAttribute = new SecurityConfig(grantedAuthority.getAuthority());
			list.add(configAttribute);
		}

		// DB 权限取得

		// 通过requestUrl 匹配数据库的权限分配表，返回权限List
		String requestUrl = ((FilterInvocation) object).getRequestUrl();

		// 返回结果包含requestUrl
		// return list

		// TODO delete
		Iterator<String> iter = this.urlAuthority.keySet().iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			return urlAuthority.get(temp);
		}

		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
