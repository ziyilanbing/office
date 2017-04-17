package com.glad.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

public class CustomInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	private Map<String, List<ConfigAttribute>> mp;
	// private UrlMatcher urlMatcher;

	/**
	 * 构造每一种资源所需要的角色权限
	 */
	public CustomInvocationSecurityMetadataSource() {
		super();
		this.mp = new HashMap<String, List<ConfigAttribute>>();
		// this.urlMatcher = new AntUrlPathMatcher();
		List<ConfigAttribute> list = new ArrayList<ConfigAttribute>();
		ConfigAttribute cb = new SecurityConfig("ROLE_ADMIN"); // 构造一个权限(角色)
		ConfigAttribute cbUser = new SecurityConfig("ROLE_USER"); // 构造一个权限(角色)
		ConfigAttribute cbManager = new SecurityConfig("ROLE_MANAGER"); // 构造一个权限(角色)
		ConfigAttribute cbAnonymous = new SecurityConfig("ROLE_ANONYMOUS"); // 构造一个权限(角色)
		list.add(cbAnonymous);
		list.add(cb);
		list.add(cbUser);
		list.add(cbManager);
		mp.put("/login/submit", list);
		mp.put("/top/init", list);
		mp.put("/table/init", list);
		list.remove(2);
		mp.put("/Main2.jsp", list);
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		Iterator<String> iter = this.mp.keySet().iterator();
		while (iter.hasNext()) {
			String temp = iter.next();
			return mp.get(temp);
		}

		return null;
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return true;
	}

}
