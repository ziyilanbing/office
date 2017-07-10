package com.glad.tools.generator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

public class MyBatisGeneratorStartUp {
	public static void main(String[] args) {
		try {
			List<String> warnings = new ArrayList<String>();
			boolean overwrite = true;
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			InputStream is = classloader.getResourceAsStream("generator/generatorConfig.xml");
			ConfigurationParser cp = new ConfigurationParser(warnings);
			Configuration config = cp.parseConfiguration(is);
			DefaultShellCallback callback = new DefaultShellCallback(overwrite);
			MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
			myBatisGenerator.generate(null);
			System.out.print("SCHEMA : ");
			System.out.println(config.getContexts().get(0).getTableConfigurations().get(0).getSchema().toUpperCase());

			System.out.print("TABLENAME : ");
			System.out.println(config.getContexts().get(0).getTableConfigurations().get(0).getTableName().toUpperCase());
			System.out.println("SUCCESS !!! ");
		} catch (Exception e) {
			throw new RuntimeException("Éú³ÉModelºÍMapperÊ§°Ü", e);
		}
	}
}