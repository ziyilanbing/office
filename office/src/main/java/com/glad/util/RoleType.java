package com.glad.util;

import org.apache.commons.lang.enums.Enum;

public final class RoleType extends Enum {

	private static final long serialVersionUID = -5285740843557358522L;

	protected RoleType(String value) {
		super(value);
	}

	public static final State USER = new State("USER");

	public static final State DBA = new State("DBA");

	public static final State ADMIN = new State("ADMIN");
}
