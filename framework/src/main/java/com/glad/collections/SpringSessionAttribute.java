package com.glad.collections;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class SpringSessionAttribute<T> extends SessionAttribute<T> {

	protected SpringSessionAttribute() {
	}

	@SuppressWarnings("unchecked")
	protected SpringSessionAttribute(String key, final T... $REQUIRED_TYPE$) {
		super(key, $REQUIRED_TYPE$);
	}

	@SafeVarargs
	protected static <T> SessionAttribute<T> create(String key, final T... $REQUIRED_TYPE$) {
		return new SpringSessionAttribute<>(key, $REQUIRED_TYPE$);
	}

	protected @Override void refreshCache() {
		RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();

		if (cache != null) {
			if (cache.getId().equals(requestAttributes.getSessionId())) {
				return;
			}
		}

		HttpServletRequest servletRequest = ((ServletRequestAttributes) requestAttributes).getRequest();
		cache = servletRequest.getSession();
	}

	public synchronized static void clear() {
		new SpringSessionAttribute<>(null).refreshCache();
		cache.invalidate();
	}

}