/**
 * Copyright(c) Nomura Research Institute, Ltd. All Rights Reserved.
 */
package com.glad.utils;

import org.apache.commons.logging.Log;

public class LoggingUtil {
	public static void writeLog(Log logger, String messageId, String message, Exception cause) {
		if (messageId != null && !messageId.isEmpty()) {
			if (messageId.endsWith("I")) {
				logger.info(message);
				return;
			} else if (messageId.endsWith("W")) {
				logger.warn(message, cause);
				return;
			}
		}
		logger.error(message, cause);
	}
}
