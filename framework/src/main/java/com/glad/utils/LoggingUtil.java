/**
 * Copyright(c) Nomura Research Institute, Ltd. All Rights Reserved.
 */
package com.glad.utils;

import org.slf4j.Logger;

public class LoggingUtil {
	public static void writeLog(Logger logger, String messageId, String message, Exception cause) {
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
