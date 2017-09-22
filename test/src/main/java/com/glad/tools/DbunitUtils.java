/**
 * Copyright(c) Nomura Research Institute, Ltd. All Rights Reserved.
 */
package com.glad.tools;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.assertion.DefaultFailureHandler;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.database.QueryDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.ext.mysql.MySqlConnection;
import org.dbunit.ext.oracle.OracleDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;

import junit.framework.ComparisonFailure;

/**
 * Db unit utility class
 */

public class DbunitUtils {
	/**
	 * jdbc Driver
	 */
	private static String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
	private static String PASSWORD = "123456";
	private static String USERNAME = "root";
	private static String JDBCURL = "jdbc:mysql://localhost:3306/office";

	/**
	 * Export table's data to excel file.
	 * 
	 * @param conn
	 * @param schema
	 * @param TableNames
	 * @param xlsFile
	 */
	public static void exportTableData2Excel(Connection conn, String schema, String[] tableNames, String xlsFile) throws Exception {
		FileOutputStream stream = null;
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			dbunitConn.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
			IDataSet backupDataSet = dbunitConn.createDataSet(tableNames);
			stream = new FileOutputStream(xlsFile);
			XlsDataSet.write(backupDataSet, stream);
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
			if (stream != null) {
				stream.close();
			}
		}
	}

	/**
	 * Export query result to excel file.
	 * 
	 * @param conn
	 * @param schema
	 * @param queryName
	 * @param querySql
	 * @param xlsFile
	 * @throws Exception
	 */
	public static void exportQueryData2Excel(Connection conn, String schema, String queryName, String querySql, String xlsFile) throws Exception {
		FileOutputStream stream = null;
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			dbunitConn.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
			QueryDataSet backupDataSet = new QueryDataSet(dbunitConn);
			backupDataSet.addTable(queryName, querySql);
			stream = new FileOutputStream(xlsFile);
			XlsDataSet.write(backupDataSet, stream);
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
			if (stream != null) {
				stream.close();
			}
		}
	}

	/**
	 * Load table's data from excel with clean insert mode.
	 * 
	 * @param conn
	 * @param schema
	 * @param xlsFile
	 */
	public static void loadDataFromExcelCleanInsertMode(Connection conn, String schema, String xlsFile) throws Exception {
		FileInputStream inputStream = null;
		JdbcDatabaseTester jdbcDatabaseTester = null;
		MySqlConnection dbunitConn = null;
		try {
			// jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			// dbunitConn = jdbcDatabaseTester.getConnection();
			dbunitConn = new MySqlConnection(conn, schema);
			inputStream = new FileInputStream(xlsFile);
			IDataSet dataSet_cleanInsert = new XlsDataSet(inputStream);
			DatabaseOperation.CLEAN_INSERT.execute(dbunitConn, dataSet_cleanInsert);
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	/**
	 * Load table's data from excel with insert mode.
	 * 
	 * @param conn
	 * @param schema
	 * @param xlsFile
	 */
	public static void loadDataFromExcelInsertMode(Connection conn, String schema, String xlsFile) throws Exception {
		FileInputStream inputStream = null;
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			dbunitConn.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
			inputStream = new FileInputStream(xlsFile);
			IDataSet dataSet_Insert = new XlsDataSet(inputStream);
			DatabaseOperation.INSERT.execute(dbunitConn, dataSet_Insert);
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	/**
	 * Load table's data from SQL with insert mode.
	 * 
	 * @param conn
	 * @param schema
	 * @param tableName
	 * @param SqlInsertData
	 */
	public static void loadDataFromSqlInsertMode(Connection conn, String schema, String tableName, String insertSql) throws Exception {
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			QueryDataSet backupDataSet = new QueryDataSet(dbunitConn);
			backupDataSet.addTable(tableName, insertSql);
			DatabaseOperation.INSERT.execute(dbunitConn, backupDataSet);
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
		}
	}

	/**
	 * Update tables' data form excel with update mode.
	 * 
	 * @param conn
	 * @param schema
	 * @param xlsFile
	 */
	public static void updateDataFromExcel(Connection conn, String schema, String xlsFile) throws Exception {
		FileInputStream inputStream = null;
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			dbunitConn.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
			inputStream = new FileInputStream(xlsFile);
			IDataSet dataSet_update = new XlsDataSet(inputStream);
			DatabaseOperation.UPDATE.execute(dbunitConn, dataSet_update);
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	/**
	 * Update table's data from SQL with update mode.
	 * 
	 * @param conn
	 * @param schema
	 * @param tableName
	 * @param updateSql
	 */
	public static void updateDataFromSql(Connection conn, String schema, String tableName, String updateSql) throws Exception {
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			QueryDataSet backupDataSet = new QueryDataSet(dbunitConn);
			backupDataSet.addTable(tableName, updateSql);
			DatabaseOperation.UPDATE.execute(dbunitConn, backupDataSet);
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
		}
	}

	/**
	 * Update table's data from excel with refresh mode.
	 * 
	 * @param conn
	 * @param schema
	 * @param xlsFile
	 */
	public static void refreshDataFromExcel(Connection conn, String schema, String xlsFile) throws Exception {
		FileInputStream inputStream = null;
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			dbunitConn.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new OracleDataTypeFactory());
			inputStream = new FileInputStream(xlsFile);
			IDataSet dataSet_refresh = new XlsDataSet(inputStream);
			DatabaseOperation.REFRESH.execute(dbunitConn, dataSet_refresh);
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
			if (inputStream != null) {
				inputStream.close();
			}
		}
	}

	/**
	 * Delete data from SQL which table specified.
	 * 
	 * @param conn
	 * @param schema
	 * @param tableName
	 * @param deleteSql
	 */
	public static void deleteDataFromSql(Connection conn, String schema, String tableName, String deleteSql) throws Exception {
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			QueryDataSet backupDataSet = new QueryDataSet(dbunitConn);
			backupDataSet.addTable(tableName, deleteSql);
			DatabaseOperation.DELETE.execute(dbunitConn, backupDataSet);
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
		}
	}

	/**
	 * Delete all data which tables specified.
	 * 
	 * @param conn
	 * @param schema
	 * @param TableNames
	 */
	public static void deleteAllData(Connection conn, String schema, String[] tableNames) throws Exception {
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			IDataSet backupDataSet = dbunitConn.createDataSet(tableNames);
			DatabaseOperation.DELETE_ALL.execute(dbunitConn, backupDataSet);
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
		}
	}

	/**
	 * Compare Data between Excel and table.
	 * 
	 * @param conn
	 * @param schema
	 * @param TableName
	 * @param xlsFile
	 * @param ignoreColumns
	 * @return true if equals, otherwise return false
	 */
	public static boolean compareData(Connection conn, String schema, String tableName, String orderBy, String xlsFile, String[] ignoreColumns)
		throws Exception {
		FileInputStream fileInputStream = null;
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM "	+ tableName + " ORDER BY " + orderBy, ResultSet.TYPE_SCROLL_INSENSITIVE,
															ResultSet.CONCUR_READ_ONLY);
			ITable outputDataSet = dbunitConn.createTable(tableName, stmt);
			fileInputStream = new FileInputStream(xlsFile);
			IDataSet testDataSet = new XlsDataSet(fileInputStream);
			ITable testitable = testDataSet.getTable(tableName);
			ITable outputitable = DefaultColumnFilter.excludedColumnsTable(outputDataSet, ignoreColumns);
			ITable testitables = DefaultColumnFilter.excludedColumnsTable(testitable, ignoreColumns);
			Assertion.assertEquals(testitables, outputitable, new DefaultFailureHandler());
			return true;
		} catch (ComparisonFailure e) {
			return false;
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
			if (fileInputStream != null) {
				fileInputStream.close();
			}
		}
	}

	/**
	 * Compare Data between Excel and table.
	 * 
	 * @param conn
	 * @param schema
	 * @param TableName
	 * @param sql
	 * @param xlsFile
	 * @param ignoreColumns
	 * @return true if equals, otherwise return false
	 */
	public static boolean compareDataSql(Connection conn, String schema, String tableName, String sql, String xlsFile, String[] ignoreColumns)
		throws Exception {
		FileInputStream fileInputStream = null;
		JdbcDatabaseTester jdbcDatabaseTester = null;
		IDatabaseConnection dbunitConn = null;
		try {
			jdbcDatabaseTester = new JdbcDatabaseTester(DRIVER_CLASS_NAME, JDBCURL, USERNAME, PASSWORD, schema);
			dbunitConn = jdbcDatabaseTester.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ITable outputDataSet = dbunitConn.createTable(tableName, stmt);
			fileInputStream = new FileInputStream(xlsFile);
			IDataSet testDataSet = new XlsDataSet(fileInputStream);
			ITable testitable = testDataSet.getTable(tableName);
			if (ignoreColumns == null) {
				ignoreColumns = new String[0];
			}
			ITable outputitable = DefaultColumnFilter.excludedColumnsTable(outputDataSet, ignoreColumns);
			ITable testitables = DefaultColumnFilter.excludedColumnsTable(testitable, ignoreColumns);
			Assertion.assertEquals(testitables, outputitable, new DefaultFailureHandler());
			return true;
		} catch (ComparisonFailure e) {
			return false;
		} finally {
			if (jdbcDatabaseTester != null) {
				jdbcDatabaseTester.closeConnection(dbunitConn);
			}
			if (fileInputStream != null) {
				fileInputStream.close();
			}
		}
	}
}
