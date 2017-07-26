package com.glad.tools.generator;

import static com.glad.tools.generator.ProjectConfig.BASE_PACKAGE;
import static com.glad.tools.generator.ProjectConfig.CONTROLLER_PACKAGE;
import static com.glad.tools.generator.ProjectConfig.JDBC_DIVER_CLASS_NAME;
import static com.glad.tools.generator.ProjectConfig.JDBC_PASSWORD;
import static com.glad.tools.generator.ProjectConfig.JDBC_URL;
import static com.glad.tools.generator.ProjectConfig.JDBC_USERNAME;
import static com.glad.tools.generator.ProjectConfig.MAPPER_PACKAGE;
import static com.glad.tools.generator.ProjectConfig.MODEL_PACKAGE;
import static com.glad.tools.generator.ProjectConfig.SERVICE_IMPL_PACKAGE;
import static com.glad.tools.generator.ProjectConfig.SERVICE_PACKAGE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.CommentGeneratorConfiguration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultShellCallback;

//import org.mybatis.generator.config.Configuration;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

/**
 * 代码生成器，根据数据表名称生成对应的Model、Mapper、Service、Controller简化开发。
 */
public class CodeGeneratorByJava {
	// 项目在硬盘上的基础路径
	private static final String PROJECT_PATH = System.getProperty("user.dir");
	// 模板位置
	private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/main/resources/generator/template";
	// java文件路径
	private static final String JAVA_PATH = "/src/main/java";
	// 资源文件路径
	private static final String RESOURCES_PATH = "/src/main/resources";
	// Mapper插件基础接口的完全限定名
	public static final String MAPPER_INTERFACE_REFERENCE = BASE_PACKAGE + ".core.Mapper";
	// 生成的Service存放路径
	private static final String PACKAGE_PATH_SERVICE = packageConvertPath(SERVICE_PACKAGE);
	// 生成的Service实现存放路径
	private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(SERVICE_IMPL_PACKAGE);
	// 生成的Controller存放路径
	private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(CONTROLLER_PACKAGE);
	// @author
	private static final String AUTHOR = "CodeGenerator";
	// @date
	private static final String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());

	public static void main(String[] args) {
		genCode("country");
	}

	public static void genCode(String... tableNames) {
		for (String tableName : tableNames) {
			genModelAndMapper(tableName);
			// genService(tableName);
			// genController(tableName);
		}
	}

	public static void genModelAndMapper(String tableName) {
		Context context = new Context(ModelType.FLAT);
		context.setId("Potato");
		context.setTargetRuntime("MyBatis3Simple");

		// beginningDelimiter endingDelimiter MYSQL `
		context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
		context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

		JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
		jdbcConnectionConfiguration.setConnectionURL(JDBC_URL);
		jdbcConnectionConfiguration.setUserId(JDBC_USERNAME);
		jdbcConnectionConfiguration.setPassword(JDBC_PASSWORD);
		jdbcConnectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
		context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

		CommentGeneratorConfiguration commentGeneratorConfiguration = new CommentGeneratorConfiguration();
		commentGeneratorConfiguration.setConfigurationType("com.glad.tools.generator.config.CustomCommentGenerator");
		context.setCommentGeneratorConfiguration(commentGeneratorConfiguration);

		PluginConfiguration pluginConfiguration = new PluginConfiguration();
		// pluginConfiguration.setConfigurationType("org.mybatis.generator.plugins.MapperConfigPlugin");
		pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
		pluginConfiguration.addProperty("mappers", MAPPER_INTERFACE_REFERENCE);
		context.addPluginConfiguration(pluginConfiguration);

		JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
		javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
		javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE);
		context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

		SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
		sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH + RESOURCES_PATH);
		sqlMapGeneratorConfiguration.setTargetPackage("mapper");
		context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

		JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
		javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
		javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE);
		javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
		context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

		TableConfiguration tableConfiguration = new TableConfiguration(context);
		tableConfiguration.setTableName(tableName);
		tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
		context.addTableConfiguration(tableConfiguration);

		List<String> warnings;
		MyBatisGenerator generator;
		try {
			org.mybatis.generator.config.Configuration config = new org.mybatis.generator.config.Configuration();
			config.addContext(context);
			config.validate();

			boolean overwrite = true;
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			warnings = new ArrayList<String>();
			generator = new MyBatisGenerator(config, callback, warnings);
			generator.generate(null);
		} catch (Exception e) {
			throw new RuntimeException("生成Model和Mapper失败", e);
		}

		if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
			throw new RuntimeException("生成Model和Mapper失败：" + warnings);
		}

		String modelName = tableNameConvertUpperCamel(tableName);
		System.out.println(modelName + ".java 生成成功");
		System.out.println(modelName + "Mapper.java 生成成功");
		System.out.println(modelName + "Mapper.xml 生成成功");
	}

	public static void genService(String tableName) {
		try {
			freemarker.template.Configuration cfg = getConfiguration();

			Map<String, Object> data = new HashMap<>();
			data.put("date", DATE);
			data.put("author", AUTHOR);
			String modelNameUpperCamel = tableNameConvertUpperCamel(tableName);
			data.put("modelNameUpperCamel", modelNameUpperCamel);
			data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
			data.put("basePackage", BASE_PACKAGE);

			File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + modelNameUpperCamel + "Service.java");
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			cfg.getTemplate("service.ftl").process(data, new FileWriter(file));
			System.out.println(modelNameUpperCamel + "Service.java 生成成功");

			File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelNameUpperCamel + "ServiceImpl.java");
			if (!file1.getParentFile().exists()) {
				file1.getParentFile().mkdirs();
			}
			cfg.getTemplate("service-impl.ftl").process(data, new FileWriter(file1));
			System.out.println(modelNameUpperCamel + "ServiceImpl.java 生成成功");
		} catch (Exception e) {
			throw new RuntimeException("生成Service失败", e);
		}
	}

	public static void genController(String tableName) {
		try {
			freemarker.template.Configuration cfg = getConfiguration();

			Map<String, Object> data = new HashMap<>();
			data.put("date", DATE);
			data.put("author", AUTHOR);
			data.put("baseRequestMapping", tableNameConvertMappingPath(tableName));
			String modelNameUpperCamel = tableNameConvertUpperCamel(tableName);
			data.put("modelNameUpperCamel", modelNameUpperCamel);
			data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
			data.put("basePackage", BASE_PACKAGE);

			File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel + "Controller.java");
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			// cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));
			cfg.getTemplate("controller.ftl").process(data, new FileWriter(file));

			System.out.println(modelNameUpperCamel + "Controller.java 生成成功");
		} catch (Exception e) {
			throw new RuntimeException("生成Controller失败", e);
		}

	}

	private static freemarker.template.Configuration getConfiguration() throws IOException {
		Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
		cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
		cfg.setDefaultEncoding("UTF-8");
		cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
		return cfg;
	}

	private static String tableNameConvertLowerCamel(String tableName) {
		StringBuilder result = new StringBuilder();
		if (tableName != null && tableName.length() > 0) {
			tableName = tableName.toLowerCase();// 兼容使用大写的表名
			boolean flag = false;
			for (int i = 0; i < tableName.length(); i++) {
				char ch = tableName.charAt(i);
				if ("_".charAt(0) == ch) {
					flag = true;
				} else {
					if (flag) {
						result.append(Character.toUpperCase(ch));
						flag = false;
					} else {
						result.append(ch);
					}
				}
			}
		}
		return result.toString();
	}

	private static String tableNameConvertUpperCamel(String tableName) {
		String camel = tableNameConvertLowerCamel(tableName);
		return camel.substring(0, 1).toUpperCase() + camel.substring(1);

	}

	private static String tableNameConvertMappingPath(String tableName) {
		tableName = tableName.toLowerCase();// 兼容使用大写的表名
		return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
	}

	private static String packageConvertPath(String packageName) {
		return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
	}
}
