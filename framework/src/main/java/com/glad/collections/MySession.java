package com.glad.collections;

public final class MySession extends SpringSessionAttribute<Object> {

	// Exsample >>> public static final SessionAttribute<{session的值的类型}> {和session的key名相同} = create("session的key名");

	// Exsample >>> public static final SessionAttribute<Cart> = create("order.cart");

	/**
	 * Login UserId
	 */
	public static final SessionAttribute<String> LoginUserId = create("LoginUserId");

	/**
	 * Login Account
	 */
	public static final SessionAttribute<String> LoginAccount = create("LoginAccount");

	/**
	 * Login Ip
	 */
	public static final SessionAttribute<String> LoginIp = create("LoginIp");

	/**
	 * Login timestamp
	 */
	public static final SessionAttribute<String> LoginTimestamp = create("Logintimestamp");

	/**
	 * Login Operator Name
	 */
	public static final SessionAttribute<String> LoginOperatorName = create("LoginOperatorName");

	/**
	 * Exception
	 */
	public static final SessionAttribute<Exception> RglAjaxException = create("RglAjaxException");

}