package com.glad.demo;

import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.glad.base.JunitBase;
import com.glad.exp.AppWarnException;
import com.glad.model.WorkhoursModel;
import com.glad.service.WorkhoursService;
import com.glad.tools.TestDataLoader;

public class DemoTest extends JunitBase {

	private static Map<String, String> caseDataRole = null;
	@Autowired
	private BasicDataSource dataSource;
	@Autowired
	private WorkhoursService testClass;

	private static String TEST_DATA = "./src/test/resources/ServicesData/WorkhoursService/test_JUnitTestData.xlsx";

	@BeforeClass
	public static void beforeAll() throws Exception {
		DB_BK_PATH = "./src/test/resources/ServicesData/WorkhoursService/TableBK/";
		DB_IN_PATH = "./src/test/resources/ServicesData/WorkhoursService/TableDataIN/";
		DB_COM_PATH = "./src/test/resources/ServicesData/WorkhoursService/ResultCompare/";

		tableNames = new String[]{"a"};
		tableOrderby = new String[]{"id"};
		tableIgnoreColumns = new String[][]{{}, {}};
		// 环境初期化
		initOnline();
		// dbBackUp();

		// loading file Xxxxxxxx_JunitTestData.xlsx
		testData = TestDataLoader.load(TEST_DATA);
	}

	@Before
	public void beforeEveyTest() throws Exception {
		connection = dataSource.getConnection();
		// dbClear();
	}

	@AfterClass
	public static void afterAll() throws Exception {
	}

	@Test
	public void test01_dataIn() throws Exception {
		dbDataIn("TEST_001_in.xlsx");
	}

	@Test
	public void test02SelectAll() throws Exception {
		caseDataRole = getCaseDataRole("001");
		dbDataIn(caseDataRole);

		Object output;
		output = testClass.selectAll();

		// 预想结果比较
		// compareDto((String) output, new String[]{"tradeNo", "sysDateTime"}, caseDataRole, JStockExEntryLogicOutDto.class);
	}

	@Test
	public void test03MyDao() throws Exception {
		WorkhoursModel workhoursModel = new WorkhoursModel();
		try {
			testClass.confirm(workhoursModel);
		} catch (AppWarnException e) {
			System.out.println(e.getLocalizedMessage());
			// compareException(e, caseDataRole);
		} finally {
			// compareDBwithExecl(caseDataRole);
		}
	}

}
