package com.glad;

import java.security.NoSuchAlgorithmException;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

public class PwdTest {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		MessageDigestPasswordEncoder md5 = new MessageDigestPasswordEncoder("MD5", true);
		// 使用动态加密盐的只需要在注册用户的时候将第二个参数换成用户名即可
		String pwd = md5.encodePassword("1", "admin");
		System.out.println("MD5 SystemWideSaltSource: " + pwd + " len=" + pwd.length());
	}

}
