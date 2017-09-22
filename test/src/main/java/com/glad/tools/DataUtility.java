package com.glad.tools;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;

/**
 * DataUtility
 */
public class DataUtility {
	public static final String SHEET_SUMMARY = "Test Data List";
	public static final int DATA_GROUP_NO_COLUMN_NUM = 0;
	public static final int DATA_TYPE_COLUMN_NUM = 1;
	public static final int DATA_SOURCE_COLUMN_NUM = 2;
	public static final int POSITION_COLUMN_NUM = 3;
	public static final int MSG_ID_COLUMN_NUM = 4;

	public static final String DATA_SOURCE_INTERNAL = "Internal";
	public static final String DATA_SOURCE_EXTERNAL = "External";

	public static final int DATA_GROUP_NO_ROW_NUM = 0;
	public static final int DATA_NO_ROW_NUM = 1;

	public static final int DATA_GROUP_NO_COLUMN_NUM_BEAN = 0;
	public static final int DATA_NO_COLUMN_NUM_BEAN = 1;

	public static final String DATA_TYPE_MESSAGE = "Message";
	public static final String DATA_TYPE_BEAN = "JavaBean";

	public static final String SENDING_TIME = "SendingTime";
	public static final String CREATION_TIME = "CreationTime";

	public static final int TAG_COLUMN_NUM = 0;
	public static final int HEADER_LINE_ROW_NUM = 0;

	/**
	 * Check whether current variant have been set value
	 * 
	 * @param value
	 * @return
	 */
	public static boolean isNotNull(String value) {
		if (value != null && StringUtils.isNotBlank(value) && !"".equals(value)) {
			return true;
		}
		return false;
	}

	/**
	 * Read the Table cell of Values.
	 * 
	 * @param cell
	 * @return cell value
	 */
	public static String getCellValue(XSSFCell cell) {
		String value = "";
		if (cell != null) {
			switch (cell.getCellType()) {
				case XSSFCell.CELL_TYPE_STRING:
					value = cell.getRichStringCellValue().getString();
					break;
				case XSSFCell.CELL_TYPE_NUMERIC:
					value = cell.getNumericCellValue() + "";
					break;
				case XSSFCell.CELL_TYPE_FORMULA:
					value = String.valueOf(cell.getCellFormula());
					break;
				case XSSFCell.CELL_TYPE_BOOLEAN:
					value = String.valueOf(cell.getBooleanCellValue());
					break;
				case XSSFCell.CELL_TYPE_ERROR:
					value = String.valueOf(cell.getErrorCellValue());
					break;
			}
		}
		return value;
	}

	/**
	 * If the background color is gray, it is invalid.
	 * 
	 * @param cell
	 * @return
	 */
	public static boolean isValidCell(XSSFCell cell) {
		if (cell == null) {
			return true;
		}
		if (cell.getCellStyle().getFillForegroundColor() == 0) {
			return false;
		}
		return true;
	}
}
