package com.glad.tools.generator;

/**
 * 项目常量
 */
public final class ProjectConfig {

	// JDBC配置
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/world";
	public static final String JDBC_USERNAME = "root";
	public static final String JDBC_PASSWORD = "123456";
	public static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

	// 项目基础包名称
	public static final String BASE_PACKAGE = "com.glad";
	// Model所在包
	public static final String MODEL_PACKAGE = BASE_PACKAGE + ".entity";
	// Mapper所在包
	public static final String MAPPER_PACKAGE = BASE_PACKAGE + ".dao";
	// Service所在包
	public static final String SERVICE_PACKAGE = BASE_PACKAGE + ".service";
	// ServiceImpl所在包
	public static final String SERVICE_IMPL_PACKAGE = SERVICE_PACKAGE + ".impl";
	// Controller所在包
	public static final String CONTROLLER_PACKAGE = BASE_PACKAGE + ".web";
	// Mapper插件基础接口的完全限定名
	public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";

}
