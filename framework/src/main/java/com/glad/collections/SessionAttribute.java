package com.glad.collections;

import javax.servlet.http.HttpSession;

public class SessionAttribute<T> extends FrozenEntry<String, Class<T>> {

	protected static HttpSession cache;

	@SuppressWarnings("unchecked")
	protected SessionAttribute() {
		this(null);
		throw new UnsupportedOperationException("Unsupported in this class.");
	}

	@SuppressWarnings("unchecked")
	protected SessionAttribute(String key, final T... $REQUIRED_TYPE$) {
		super(key, (Class<T>) $REQUIRED_TYPE$.getClass().getComponentType());
	}

	protected void refreshCache() {
		throw new UnsupportedOperationException("This method must be implements.");
	}

	public synchronized T value() {
		this.refreshCache();

		@SuppressWarnings("unchecked")
		T result = (T) cache.getAttribute(this.getKey());

		return result;
	}

	public synchronized void value(T value) {
		this.refreshCache();
		cache.setAttribute(this.getKey(), value);
	}

	public synchronized void remove() {
		this.refreshCache();
		cache.removeAttribute(this.getKey());
	}

}