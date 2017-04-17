package com.glad.security;

import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import com.glad.aspect.TraceAdvice;

public class CustomAccessDecisionManager implements AccessDecisionManager {

	/**
	 * slf4j logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TraceAdvice.class);

	/**
	 * 通过传递的参数来决定用户是否有访问对应受保护对象的权限
	 * 
	 * @param authentication
	 *            当前正在请求受包含对象的Authentication
	 * @param object
	 *            受保护对象，其可以是一个MethodInvocation、JoinPoint、FilterInvocation。
	 * @param configAttributes
	 *            与正在请求的受保护对象相关联的配置属性
	 */
	@Override
	public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		Iterator<ConfigAttribute> iter = configAttributes.iterator();
		while (iter.hasNext()) {
			String accessResourceNeedRole = ((SecurityConfig) iter.next()).getAttribute();
			logger.info("Access Resource Need Role : " + accessResourceNeedRole);
			for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
				String userOwnRole = grantedAuthority.getAuthority();
				if (accessResourceNeedRole.equals(userOwnRole)) {
					logger.info("User Own Role : " + userOwnRole);
					return;
				}
			}
		}
		throw new AccessDeniedException("访问被拒绝!");
	}

	/**
	 * 表示当前AccessDecisionManager支持对应的ConfigAttribute
	 */
	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	/**
	 * 当前AccessDecisionManager支持对应的受保护对象类型
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

}
