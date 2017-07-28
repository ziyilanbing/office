package com.glad.tools.generator;

import static com.glad.tools.generator.ProjectConfig.BASE_PACKAGE;
import static com.glad.tools.generator.ProjectConfig.CONTROLLER_PACKAGE;
import static com.glad.tools.generator.ProjectConfig.SERVICE_IMPL_PACKAGE;
import static com.glad.tools.generator.ProjectConfig.SERVICE_PACKAGE;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

//import org.mybatis.generator.config.Configuration;
import freemarker.template.Configuration;
import freemarker.template.TemplateExceptionHandler;

/**
 * 代码生成器，根据数据表名称生成对应的Model、Mapper、Service、Controller简化开发。
 */
public class CodeGeneratorByXml {
	// 项目在硬盘上的基础路径
	private static final String PROJECT_PATH = System.getProperty("user.dir");
	// 模板位置
	private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/main/resources/generator/template";
	// java文件路径
	private static final String JAVA_PATH = "/src/main/java";
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
		String moduleName = "WorkHours";
		genModelAndMapper();
		genController(moduleName);
		genService(moduleName);
	}

	public static void genModelAndMapper() {

		List<String> warnings = new ArrayList<String>();
		MyBatisGenerator myBatisGenerator;
		ClassLoader classloader = Thread.currentThread().getContextClassLoader();
		InputStream is = classloader.getResourceAsStream("generator/generatorConfig.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		org.mybatis.generator.config.Configuration config;
		try {
			config = cp.parseConfiguration(is);
			config.validate();
			boolean overwrite = true;
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);

		} catch (Exception e) {
			throw new RuntimeException("生成Model和Mapper失败", e);
		}

		for (String warning : warnings) {
			System.out.println(warning);
		}
		System.out.print("SCHEMA : " + config.getContexts().get(0).getTableConfigurations().get(0).getSchema().toUpperCase());
		System.out.println("  TABLENAME : " + config.getContexts().get(0).getTableConfigurations().get(0).getTableName().toUpperCase());
		System.out.println("---------- ModelAndMapper Generator End ----------");
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
		System.out.println("---------- Controller Generator End ----------");
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
		System.out.println("---------- Service Generator End ----------");
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
			// 兼容使用大写的表名
			tableName = tableName.toLowerCase();
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
		// 兼容使用大写的表名
		tableName = tableName.toLowerCase();
		return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
	}

	private static String packageConvertPath(String packageName) {
		return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
	}
}
