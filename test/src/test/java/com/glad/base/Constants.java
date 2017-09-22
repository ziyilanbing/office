package com.glad.base;

public class Constants {

	public static final String ENTERPRISE_ID = "0630";

	public static final String USER_ID = "pactera";

	public static final String USER_PASSWORD = "pactera";

	public static final String SCHEMA = "core_global";

	/**
	 * a <code>String</code> prefix of common field's name of CommandForm class
	 */
	public static final String UNDER_LINE = "_";

	/**
	 * a <code>String</code> prefix of common field's name of CommandForm class
	 */
	public static final String EMPTY_FLG = "\"\"";
	/**
	 * split by \n
	 */
	public static final String SPLIT_LIST = "\n";

	public static final String DB_FILE_NAME = "initDBFileName";

	public static interface CASE_DATA_ROLE {
		String DATA_GROUP_ID = "test_case";
	}

	public static interface IN_DTO {
		String DATA_GROUP_ID = "inDto_DataGroupId";
		String DATA_NO = "inDto_DataNo";
	}

	public static interface IN_DTO2 {
		String DATA_GROUP_ID = "inDto2_DataGroupId";
		String DATA_NO = "inDto2_DataNo";
	}

	public static interface IN_DTO3 {
		String DATA_GROUP_ID = "inDto3_DataGroupId";
		String DATA_NO = "inDto3_DataNo";
	}

	public static interface IN_DTO4 {
		String DATA_GROUP_ID = "inDto4_DataGroupId";
		String DATA_NO = "inDto4_DataNo";
	}

	public static interface IN_MAP {
		String DATA_GROUP_ID = "inMap_DataGroupId";
		String DATA_NO = "inMap_DataNo";
	}

	public static interface IN_MQ {
		String DATA_GROUP_ID = "inMQ_DataGroupId";
		String DATA_NO = "inMQ_DataNo";
	}

	public static interface IN_COMMAND {
		String ARGS = "command_Args";
	}

	public static interface IN_PARM {
		String VALUE_1 = "parm_Value1";
		String VALUE_2 = "parm_Value2";
		String VALUE_3 = "parm_Value3";
		String VALUE_4 = "parm_Value4";
		String VALUE_5 = "parm_Value5";
	}

	public static interface EXPT_DB_FILE_NAME {
		String TRD = "exptDBFileName_TRD";
		String REF = "exptDBFileName_REF";
	}

	public static interface EXPT_DTO {
		String DATA_GROUP_ID = "exptDto_DataGroupId";
		String DATA_NO = "exptDto_DataNo";
	}

	public static interface EXPT_DTO2 {
		String DATA_GROUP_ID = "exptDto2_DataGroupId";
		String DATA_NO = "exptDto2_DataNo";
	}

	public static interface EXPT_DTO3 {
		String DATA_GROUP_ID = "exptDto3_DataGroupId";
		String DATA_NO = "exptDto3_DataNo";
	}

	public static interface EXPT_DTO4 {
		String DATA_GROUP_ID = "exptDto4_DataGroupId";
		String DATA_NO = "exptDto4_DataNo";
	}

	public static interface EXPT_MAP {
		String DATA_GROUP_ID = "exptMap_DataGroupId";
		String DATA_NO = "exptMap_DataNo";
	}

	public static interface EXPT_MQ {
		String DATA_GROUP_ID = "exptMQ_DataGroupId";
		String DATA_NO = "exptMQ_DataNo";
	}

	public static interface EXPT_MQ2 {
		String DATA_GROUP_ID = "exptMQ2_DataGroupId";
		String DATA_NO = "exptMQ2_DataNo";
	}

	public static interface EXPT_MQ3 {
		String DATA_GROUP_ID = "exptMQ3_DataGroupId";
		String DATA_NO = "exptMQ3_DataNo";
	}

	public static interface EXPT_ERROR {
		String DATA_GROUP_ID = "exptError_DataGroupId";
		String DATA_NO = "exptError_DataNo";
	}

	public static interface EXPT_CSV {
		String CSV_FILENAME = "exptCsv_FileName";
		String DATA_GROUP_ID = "exptCsv_DataGroupId";
		String DATA_NO = "exptCsv_DataNo";
	}

	public static interface EXPT_TRG {
		String TRG_FILENAME = "exptTrg_FileName";
		String DATA_GROUP_ID = "exptTrg_DataGroupId";
		String DATA_NO = "exptTrg_DataNo";
	}

	public static interface EXPT_RETURN {
		String VALUE = "exptReturn_Value";
	}

}
