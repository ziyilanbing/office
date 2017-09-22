package com.glad.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.glad.exp.AppFailedException;
import com.glad.exp.AppWarnException;
import com.glad.exp.OfficeException;
import com.glad.tools.BeanData;
import com.glad.tools.DbunitUtils;
import com.glad.tools.TestDataGroup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/root-context.xml"})
public class JunitBase {

	public static String USER = "";
	public static String SCHEMA = "office";

	// Test data
	protected static Map<String, TestDataGroup> testData = null;

	protected static String environmentLocale = "zh";

	protected static String schemaBase = null;

	// 备份，入力，比较文件路径
	protected static String DB_BK_PATH = "";
	protected static String DB_IN_PATH = "";
	protected static String DB_COM_PATH = "";

	protected static String[] tableNames = new String[]{};
	protected static String[] tableOrderby = new String[]{};
	protected static String[][] tableIgnoreColumns = new String[][]{};
	protected static Connection connection = null;

	protected static String DBBK_TRD_TABLE = "TABLE_bk.xlsx";

	// ------------------------------------INIT------------------------------------
	/**
	 * Initialize Online environment
	 * 
	 * @throws Exception
	 */
	public static void initOnline() throws Exception {
		// ServletContextEvent event = null;
		// Application.init(event);
		schemaBase = JunitBase.SCHEMA;
	}

	/**
	 * Backup database to Excel
	 * 
	 * @throws Exception
	 */
	public static void dbBackUp() throws Exception {
		if (tableNames.length > 0) {
			String bkPath1 = DB_BK_PATH + DBBK_TRD_TABLE;
			DbunitUtils.exportTableData2Excel(connection, schemaBase, tableNames, bkPath1);
		}
	}

	/**
	 * Clear database
	 * 
	 * @throws Exception
	 */
	public static void dbClear() throws Exception {
		if (tableNames.length > 0) {
			DbunitUtils.deleteAllData(connection, schemaBase, tableNames);
		}
	}

	/**
	 * Insert database from Excel
	 * 
	 * @param fileName String
	 * @throws Exception
	 */
	public static void dbDataIn(String fileName) throws Exception {
		if (tableNames.length > 0) {
			String inPath1 = DB_IN_PATH + fileName;
			DbunitUtils.loadDataFromExcelCleanInsertMode(connection, schemaBase, inPath1);
		}
	}

	/**
	 * Insert database from Excel by caseDataRole
	 * 
	 * @param caseDataRole Map<String, String>
	 * @throws Exception
	 */
	public static void dbDataIn(Map<String, String> caseDataRole) throws Exception {
		if (tableNames.length > 0) {
			String inPath1 = DB_IN_PATH + caseDataRole.get(Constants.DB_FILE_NAME);
			DbunitUtils.loadDataFromExcelCleanInsertMode(connection, schemaBase, inPath1);
		}
	}

	/**
	 * Compare expected Exception with actual
	 * 
	 * @param e Exception
	 * @param caseDataRole Map<String, String>
	 * @throws Exception
	 */
	public void compareException(Exception e, Map<String, String> caseDataRole) throws Exception {
		compareException(null, e, caseDataRole);
	}

	/**
	 * Compare expected Exception with actual
	 * 
	 * @param message String
	 * @param e Exception
	 * @param caseDataRole Map<String, String>
	 * @throws Exception
	 */
	public void compareException(String message, Exception e, Map<String, String> caseDataRole) throws Exception {
		if (e.getClass().equals(AppWarnException.class)) {
			TrdErrorData errorExpt = (TrdErrorData) loadExcelCaseData(	caseDataRole.get(Constants.EXPT_ERROR.DATA_GROUP_ID),
																		caseDataRole.get(Constants.EXPT_ERROR.DATA_NO), TrdErrorData.class);
			AppWarnException ex = (AppWarnException) e;
			Assert.assertEquals(message, errorExpt.getErrorCode(), ex.getKey());
			if ("en".equals(environmentLocale)) {
				Assert.assertEquals(message, errorExpt.getErrorMessageEN(), ex.getLocalizedMessage());
			} else {
				Assert.assertEquals(message, errorExpt.getErrorMessageJA(), ex.getLocalizedMessage());
			}
			Assert.assertEquals(errorExpt.getErrorFieldName(), ex.getErrorFieldName());
		} else if (e.getClass().equals(AppFailedException.class)) {
			TrdErrorData errorExpt = (TrdErrorData) loadExcelCaseData(	caseDataRole.get(Constants.EXPT_ERROR.DATA_GROUP_ID),
																		caseDataRole.get(Constants.EXPT_ERROR.DATA_NO), TrdErrorData.class);
			AppFailedException ex = (AppFailedException) e;
			Assert.assertEquals(message, errorExpt.getErrorCode(), ex.getKey());
			if ("en".equals(environmentLocale)) {
				Assert.assertEquals(message, errorExpt.getErrorMessageEN(), ex.getLocalizedMessage());
			} else {
				Assert.assertEquals(message, errorExpt.getErrorMessageJA(), ex.getLocalizedMessage());
			}
			Assert.assertEquals(errorExpt.getErrorFieldName(), ex.getErrorFieldName());
		} else if (e.getClass().equals(OfficeException.class)) {
			Assert.assertTrue(message, true);
		} else if (e.getClass().equals(DataAccessException.class)) {
			Assert.assertTrue(message, true);
		} else {
			throw e;
		}
	}

	/**
	 * Get caseDataRole by caseNo
	 * 
	 * @param caseNo String
	 * @return Map<String, String>
	 * @throws Exception
	 */
	public Map<String, String> getCaseDataRole(String caseNo) throws Exception {
		return loadExcelCaseData(Constants.CASE_DATA_ROLE.DATA_GROUP_ID, caseNo);
	}

	/**
	 * Read data from Excel to Dto
	 * 
	 * @param caseId String
	 * @param dataNo String
	 * @param outClass Class<?>
	 * @return Object
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Object loadExcelCaseData(String caseId, String dataNo, Class<?> outClass) throws Exception {
		Object dto = null;
		Constructor[] constructor = outClass.getConstructors();
		Class<?>[] classParm = constructor[0].getParameterTypes();
		if (classParm.length == 0) {
			dto = constructor[0].newInstance(new Object[]{});
		} else {
			Object[] parmObj = new Object[classParm.length];
			dto = constructor[0].newInstance(parmObj);
		}
		return loadExcelCaseData(caseId, dataNo, dto);
	}

	/**
	 * Read data from Excel to List<Dto>
	 * 
	 * @param caseId String
	 * @param dto Object
	 * @return List<?>
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<?> loadExcelCaseData(String caseId, Object dto) throws Exception {
		TestDataGroup caseData = testData.get(caseId);
		List<BeanData> dataList = (List<BeanData>) caseData.getDatas();
		List<Object> outList = new ArrayList<Object>();

		for (int i = 0; i < dataList.size(); i++) {
			outList.add(loadExcelCaseData(caseId, String.valueOf(i + 1), dto));
		}

		return outList;
	}

	/**
	 * Read data from Excel to List<Dto>
	 * 
	 * @param caseId String
	 * @param outClass Class<?>
	 * @return List<?>
	 * @throws Exception
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public List<?> loadExcelCaseData(String caseId, Class<?> outClass) throws Exception {
		TestDataGroup caseData = testData.get(caseId);
		List<BeanData> dataList = (List<BeanData>) caseData.getDatas();
		List<Object> outList = new ArrayList<Object>();

		for (int i = 0; i < dataList.size(); i++) {
			Object dto = null;
			Constructor[] constructor = outClass.getConstructors();
			Class<?>[] classParm = constructor[0].getParameterTypes();
			if (classParm.length == 0) {
				dto = constructor[0].newInstance(new Object[]{});
			} else {
				Object[] parmObj = new Object[classParm.length];
				dto = constructor[0].newInstance(parmObj);
			}
			outList.add(loadExcelCaseData(caseId, String.valueOf(i + 1), dto));
		}

		return outList;
	}

	/**
	 * Read data from Excel to Map
	 * 
	 * @param caseId String
	 * @param dataNo String
	 * @return Map<String, String>
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public Map<String, String> loadExcelCaseData(String caseId, String dataNo) throws Exception {

		TestDataGroup caseData = testData.get(caseId);
		List<BeanData> dataList = (List<BeanData>) caseData.getDatas();

		int dataRowNo = Integer.parseInt(dataNo) - 1;

		BeanData bean = (BeanData) dataList.get(dataRowNo);
		Map<String, String> map = bean.getValues();

		return map;

	}

	// ------------------------------------EXCEL------------------------------------
	/**
	 * Read data from Excel to Dto
	 * 
	 * @param caseId String
	 * @param dataNo String
	 * @param dto Object
	 * @return Object
	 * @throws Exception
	 */
	@SuppressWarnings({"unchecked", "rawtypes"})
	public Object loadExcelCaseData(String caseId, String dataNo, Object dto) throws Exception {

		TestDataGroup caseData = testData.get(caseId);
		List<BeanData> dataList = (List<BeanData>) caseData.getDatas();

		int dataRowNo = Integer.parseInt(dataNo) - 1;

		BeanData bean = (BeanData) dataList.get(dataRowNo);
		Map<String, String> map = bean.getValues();

		// BeanDataUtils.bind(bean.getValues(), dto, null);

		// set List
		for (Field field : dto.getClass().getDeclaredFields()) {
			if (field.getType().isAssignableFrom(List.class)) {
				Type fg = field.getGenericType();
				ParameterizedType pt = (ParameterizedType) fg;
				Type rawType = pt.getActualTypeArguments()[0];
				if (!String.class.equals(rawType)	&& !Integer.class.equals(rawType) && !Long.class.equals(rawType) && !Double.class.equals(rawType)
					&& !Date.class.equals(rawType) && !BigDecimal.class.equals(rawType)) {
					String listDataGroupId = map.get(field.getName() + "_DataGroupId");
					if (listDataGroupId != null) {
						if ("".equals(listDataGroupId)) {
							List<Object> setList = new ArrayList<Object>();
							String setterName = Xetter.set.getMethodName(field.getName());
							Method setter = dto.getClass().getMethod(setterName, new Class[]{field.getType()});
							setter.invoke(dto, new Object[]{setList});
						} else if (StringUtils.isNotBlank(listDataGroupId)) {
							Class<?> classObj = (Class<?>) rawType;
							List<?> setList = loadExcelCaseData(listDataGroupId, classObj);
							// List<Object> setList = new ArrayList<Object>();
							String setterName = Xetter.set.getMethodName(field.getName());
							Method setter = dto.getClass().getMethod(setterName, new Class[]{field.getType()});
							setter.invoke(dto, new Object[]{setList});
						}
					}
				}
			} else {
				// if (!field.getType().isPrimitive()) {
				// // set dto in dto
				// String dtoDataGroupId = map.get(field.getName() + "_DataGroupId");
				// String dtoDataNo = dataNo;
				// if (StringUtils.isNotBlank(map.get(field.getName() + "_DataNo"))) {
				// dtoDataNo = map.get(field.getName() + "_DataNo");
				// }
				// if (StringUtils.isNotBlank(dtoDataGroupId)) {
				// Object dtoDto = null;
				// Constructor[] constructor = dto.getClass().getSuperclass().getConstructors();
				// Class<?>[] classParm = constructor[0].getParameterTypes();
				// if (classParm.length == 0) {
				// dtoDto = constructor[0].newInstance(new Object[]{});
				// } else {
				// Object[] parmObj = new Object[classParm.length];
				// dtoDto = constructor[0].newInstance(parmObj);
				// }
				// dtoDto = loadExcelCaseData(dtoDataGroupId, dtoDataNo, dtoDto);
				// BeanUtils.setProperty(bean, field.getName(), dtoDto);
				// }
				// }
			}
		}
		return dto;
	}

	/**
	 * method names of POJO
	 */
	private enum Xetter {
		get, set;
		/**
		 * get setter method name of a field
		 * 
		 * @param name the field name
		 * @return the setter method name
		 */
		public String getMethodName(String fieldName) {
			fieldName = parseFieldName(fieldName);
			StringBuilder xetter = new StringBuilder();
			xetter.append(name()).append(String.valueOf(fieldName.charAt(0)).toUpperCase()).append(fieldName.substring(1));
			return xetter.toString();
		}
	}

	/**
	 * get common field name
	 * 
	 * @param name the field name
	 * @return the common field name
	 */
	private static String parseFieldName(String fieldName) {
		if (fieldName.indexOf(Constants.UNDER_LINE) == 1) {
			return fieldName.substring(fieldName.indexOf(Constants.UNDER_LINE) + 1);
		}
		return fieldName;
	}

	/**
	 * Compare DB with Excel
	 * 
	 * @param message String
	 * @param caseNo String
	 * @throws Exception
	 */
	public void compareDBwithExecl(String message, String caseNo) throws Exception {
		String acntng_tableName;
		String acntng_orderBy;
		String[] acntng_ignoreColumns;
		String acntng_expectXlsFile;
		if (tableNames.length > 0) {
			for (int i = 0; i < tableNames.length; i++) {
				acntng_tableName = tableNames[i];
				acntng_orderBy = tableOrderby[i];
				acntng_ignoreColumns = tableIgnoreColumns[i];
				acntng_expectXlsFile = DB_COM_PATH + acntng_tableName + "_com_" + caseNo + ".xlsx";
				Assert
					.assertTrue(message,
								DbunitUtils.compareData(connection, schemaBase, acntng_tableName, acntng_orderBy, acntng_expectXlsFile, acntng_ignoreColumns));
			}
		}
	}

	/**
	 * Compare DB with Excel
	 * 
	 * @param caseNo String
	 * @throws Exception
	 */
	public void compareDBwithExecl(String caseNo) throws Exception {
		String acntng_tableName;
		String acntng_orderBy;
		String[] acntng_ignoreColumns;
		String acntng_expectXlsFile;
		if (tableNames.length > 0) {
			for (int i = 0; i < tableNames.length; i++) {
				acntng_tableName = tableNames[i];
				acntng_orderBy = tableOrderby[i];
				acntng_ignoreColumns = tableIgnoreColumns[i];
				acntng_expectXlsFile = DB_COM_PATH + acntng_tableName + "_com_" + caseNo + ".xlsx";
				Assert
					.assertTrue(DbunitUtils.compareData(connection, schemaBase, acntng_tableName, acntng_orderBy, acntng_expectXlsFile, acntng_ignoreColumns));
			}
		}
	}

	/**
	 * Compare DB with Excel
	 * 
	 * @param caseDataRole Map<String, String>
	 * @throws Exception
	 */
	public void compareDBwithExecl(Map<String, String> caseDataRole) throws Exception {
		String acntng_tableName;
		String acntng_orderBy;
		String[] acntng_ignoreColumns;
		String acntng_expectXlsFile;
		if (tableNames.length > 0) {
			for (int i = 0; i < tableNames.length; i++) {
				acntng_tableName = tableNames[i];
				acntng_orderBy = tableOrderby[i];
				acntng_ignoreColumns = tableIgnoreColumns[i];
				acntng_expectXlsFile = DB_COM_PATH + caseDataRole.get(Constants.EXPT_DB_FILE_NAME.TRD);
				Assert
					.assertTrue(DbunitUtils.compareData(connection, schemaBase, acntng_tableName, acntng_orderBy, acntng_expectXlsFile, acntng_ignoreColumns));
			}
		}
	}

}
