package com.glad.util;

import org.apache.commons.lang.enums.Enum;;

public final class State extends Enum {

	private static final long serialVersionUID = -8913170473227724296L;

	protected State(String value) {
		super(value);
	}

	public static final State ACTIVE = new State("Active");

	public static final State INACTIVE = new State("Inactive");

	public static final State DELETED = new State("Deleted");

	public static final State LOCKED = new State("Locked");

}
