package com.glad.framework.component;

import org.apache.commons.logging.Log;

import com.glad.framework.exp.AppErrorException;
import com.glad.framework.exp.AppFailedException;
import com.glad.framework.exp.AppWarnException;

public abstract class AbstractController {

	public String handleException(Log log, Exception exception, String warnScreenName) throws Exception {
		try {
			throw exception;
		} catch (AppWarnException e) {
			// screen message out
			// log out

		} catch (AppErrorException e) {

			throw e;
		} catch (AppFailedException e) {

			throw e;
		} catch (Exception e) {
			throw e;
		}
		return warnScreenName;
	};

}
