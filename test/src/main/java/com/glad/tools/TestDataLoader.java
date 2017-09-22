package com.glad.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Load test data from excel file.
 */
public class TestDataLoader {
	/**
	 * The <code>Log</code> instance for this class.
	 */
	private static final Log log = LogFactory.getLog(TestDataLoader.class);

	/**
	 * @param excel file
	 * @return
	 */
	public static Map<String, TestDataGroup> load(String path) {
		InputStream fis = null;
		try {
			fis = new FileInputStream(new File(path));
			return load(fis);
		} catch (Exception e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException ex) {
					log.error(ex);
					throw new RuntimeException(ex.getMessage());
				}
			}
		}
	}

	/**
	 * @param inputstream of excel file
	 * @return
	 */
	public static Map<String, TestDataGroup> load(InputStream inputStream) {
		Map<String, TestDataGroup> testDataGroup = null;
		try {
			XSSFWorkbook hwb = new XSSFWorkbook(inputStream);
			testDataGroup = getDataList(hwb);
		} catch (Exception e) {
			log.error(e);
			throw new RuntimeException(e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					log.error(e);
					throw new RuntimeException(e);
				}
			}
		}
		return testDataGroup;
	}

	/**
	 * Load test data from excel workbook.
	 * 
	 * @param hwb
	 * @return
	 */
	private static Map<String, TestDataGroup> getDataList(XSSFWorkbook hwb) {
		// Save all datas in the Excel
		Map<String, TestDataGroup> testDataHashMap = new LinkedHashMap<String, TestDataGroup>();
		// Load data form Sheet:Input_MQ
		XSSFSheet sheet = hwb.getSheet(DataUtility.SHEET_SUMMARY);

		// Skip the header line
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			String dataGroupNo = DataUtility.getCellValue(row.getCell(DataUtility.DATA_GROUP_NO_COLUMN_NUM));
			if (!DataUtility.isNotNull(dataGroupNo)) {
				break;
			}

			String dataType = DataUtility.getCellValue(row.getCell(DataUtility.DATA_TYPE_COLUMN_NUM));
			if (!DataUtility.isNotNull(dataType)) {
				throw new RuntimeException("Line:" + (i + 1) + "; Column:" + (DataUtility.DATA_TYPE_COLUMN_NUM + 1) + " is invalid.");
			}

			String dataSource = DataUtility.getCellValue(row.getCell(DataUtility.DATA_SOURCE_COLUMN_NUM));
			if (!DataUtility.isNotNull(dataSource)) {
				throw new RuntimeException("Line:" + (i + 1) + "; Column:" + (DataUtility.DATA_SOURCE_COLUMN_NUM + 1) + " is invalid.");
			}

			String position = DataUtility.getCellValue(row.getCell(DataUtility.POSITION_COLUMN_NUM));
			if (!DataUtility.isNotNull(position)) {
				throw new RuntimeException("Line:" + (i + 1) + "; Column:" + (DataUtility.POSITION_COLUMN_NUM + 1) + " is invalid.");
			}

			String msgId = DataUtility.getCellValue(row.getCell(DataUtility.MSG_ID_COLUMN_NUM));
			if (DataUtility.DATA_TYPE_MESSAGE.equalsIgnoreCase(dataType) && !DataUtility.isNotNull(msgId)) {
				throw new RuntimeException("Line:" + (i + 1) + "; Column:" + (DataUtility.MSG_ID_COLUMN_NUM + 1) + " is invalid.");
			}
			if ((dataType.equals(DataUtility.DATA_TYPE_BEAN))) {
				TestDataGroup testDataGroup = new TestDataGroup();
				testDataGroup.setDataType(DataType.BEAN_DATA);
				List<BeanData> dataContent = new ArrayList<BeanData>();
				dataContent = BeanDataLoader.readDataFromExcel(hwb.getSheet(position), dataGroupNo);
				testDataGroup.setDatas(dataContent);
				testDataHashMap.put(dataGroupNo, testDataGroup);
			} else {
				throw new RuntimeException("Line:" + (i + 1) + "; Column:" + (DataUtility.DATA_TYPE_COLUMN_NUM + 1) + " is invalid.");
			}
		}
		return testDataHashMap;
	}
}
