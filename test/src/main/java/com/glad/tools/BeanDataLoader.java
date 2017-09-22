package com.glad.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 * Reading excel file and saving each record to BeanData
 */
public class BeanDataLoader {

	/**
	 * Parse excel and generate BeanData object.
	 * 
	 * @param sheet
	 * @param dataId
	 * @param seqId
	 * @return List<BeanData>
	 */
	public static List<BeanData> readDataFromExcel(XSSFSheet sheet, String dataGroupNo) {
		// Return object
		List<BeanData> dataContents = new ArrayList<BeanData>();

		// Get the header line
		String[] titles = getTitles(sheet);

		// Get matched line number
		Map<String, String> dataNoMap = getRealValueRowNumber(sheet, dataGroupNo);

		// Get the test data from above line number
		if (dataNoMap.isEmpty()) {
			throw new RuntimeException("Do not find any matched data. Parameter:[DataType=Bean][DataGroupNo=" + dataGroupNo + "]");
		} else {
			Iterator<String> keyIterator = dataNoMap.keySet().iterator();
			while (keyIterator.hasNext()) {
				String dataNo = String.valueOf(keyIterator.next());
				int rowNum = Integer.parseInt(dataNoMap.get(dataNo));
				Map<String, String> dataMap = getData(sheet, titles, rowNum);
				BeanData beanData = new BeanData();
				beanData.setValues(dataMap);
				beanData.setDataNo(dataNo);
				dataContents.add(beanData);
			}
		}
		return dataContents;
	}

	/**
	 * Get matched line number according to dataGroupNo.
	 * 
	 * @param sheet
	 * @param dataGroupNo
	 * @return Map<String, String>
	 */
	private static Map<String, String> getRealValueRowNumber(XSSFSheet sheet, String dataGroupNo) {
		Map<String, String> dataNoMap = new LinkedHashMap<String, String>();

		// From the second line
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			XSSFRow row = sheet.getRow(i);
			if (dataGroupNo.equals(DataUtility.getCellValue(row.getCell(DataUtility.DATA_GROUP_NO_COLUMN_NUM_BEAN)))) {
				String dataNo = DataUtility.getCellValue(row.getCell(DataUtility.DATA_NO_COLUMN_NUM_BEAN));
				if (DataUtility.isNotNull(dataNo)) {
					dataNoMap.put(dataNo, String.valueOf(i));
				}
			}
		}
		return dataNoMap;
	}

	/**
	 * Read the first line save it to array.
	 * 
	 * @param sheet
	 * @return
	 */
	private static String[] getTitles(XSSFSheet sheet) {
		XSSFRow row = sheet.getRow(DataUtility.HEADER_LINE_ROW_NUM);
		String[] title = new String[row.getPhysicalNumberOfCells()];

		for (int i = 0; i < row.getPhysicalNumberOfCells(); i++) {
			title[i] = DataUtility.getCellValue(row.getCell(i));
		}
		return title;
	}

	/**
	 * Parse data, it's line number is rowNumber.
	 * 
	 * @param sheet
	 * @param titles
	 * @param rowNumber
	 * @return
	 */
	private static Map<String, String> getData(XSSFSheet sheet, String[] titles, int rowNumber) {
		Map<String, String> rtnHashMap = new HashMap<String, String>();

		XSSFRow tempRow = sheet.getRow(rowNumber);
		for (int j = 2; j < titles.length; j++) {
			String value = "";
			if (DataUtility.isValidCell(tempRow.getCell(j))) {
				value = DataUtility.getCellValue(tempRow.getCell(j));
			} else {
				value = null;
			}
			rtnHashMap.put(titles[j], value);
		}
		return rtnHashMap;
	}

}
