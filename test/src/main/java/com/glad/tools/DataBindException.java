/**
 * Copyright(c) Nomura Research Institute, Ltd. All Rights Reserved.
 */

package com.glad.tools;

/**
 * {@code TestException} is the exceptions that can be thrown during the unit test operation.
 */
@SuppressWarnings("serial")
public class DataBindException extends RuntimeException {

	/**
	 * Specific details about the TestException.
	 *
	 * @serial
	 */
	private String testMsg = null;

	/**
	 * Constructs a new test exception with the specified detail message. The cause is not initialized, and may subsequently be initialized by a call to
	 * {@link #initCause}.
	 *
	 * @param message the detail message. The detail message is saved for later retrieval by the {@link #getMessage()} method.
	 */
	public DataBindException(String... message) {
		super();
		StringBuilder msg = new StringBuilder();
		for (String m : message) {
			msg.append(m);
		}
		testMsg = msg.toString();
	}

	/**
	 * Constructs a new test exception with the specified detail message and cause.
	 *
	 * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt> value is permitted, and indicates that
	 *            the cause is nonexistent or unknown.)
	 * @param message the detail message (which is saved for later retrieval by the {@link #getMessage()} method).
	 */
	public DataBindException(Throwable cause, String... message) {
		super(cause);
		StringBuilder msg = new StringBuilder();
		for (String m : message) {
			msg.append(m);
		}
		testMsg = msg.toString();
	}

	/**
	 * Constructs a new test exception with the specified cause .
	 *
	 * @param cause the cause (which is saved for later retrieval by the {@link #getCause()} method). (A <tt>null</tt> value is permitted, and indicates that
	 *            the cause is nonexistent or unknown.)
	 */
	public DataBindException(Throwable cause) {
		super(cause);
	}

	/**
	 * Returns the detail message string of this TestException.
	 *
	 * @return the detail message string of this {@code TestException} instance (which may be {@code null}).
	 */
	@Override
	public String getMessage() {
		return testMsg;
	}

}
