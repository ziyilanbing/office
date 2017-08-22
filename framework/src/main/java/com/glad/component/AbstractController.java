package com.glad.component;

import org.slf4j.Logger;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.glad.exp.AppErrorException;
import com.glad.exp.AppFailedException;
import com.glad.exp.AppWarnException;
import com.glad.utils.LoggingUtil;
import com.glad.utils.ScreenUtils;

/**
 * @author zhongqs
 * @date 2017年3月16日
 */
public abstract class AbstractController {

	public static String PAGE_INIT_URL = "/init";

	public void handleException(Logger logger, ModelMap model, BindingResult result, Exception exception) throws Exception {
		try {
			throw exception;
		} catch (AppWarnException e) {
			AppWarnException appWarnException = e;
			// set screen message
			ScreenUtils.setErrorMessage(model, result, (AppWarnException) exception);
			// log out
			LoggingUtil.writeLog(logger, appWarnException.getKey(), appWarnException.getLocalizedMessage(), appWarnException);
		} catch (AppErrorException e) {
			throw e;
		} catch (AppFailedException e) {
			throw e;
		}
	};

	/**
	 * Get Default View
	 * 
	 * @return
	 */
	public String getDefaultView() {

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String servletPath = requestAttributes.getRequest().getServletPath();

		// /Dashboard/
		if (servletPath.endsWith("/")) {
			return servletPath.substring(0, servletPath.indexOf("/", servletPath.indexOf("/") + 1));
		}
		// /Dashboard/init
		if (servletPath.substring(1).contains("/")) {
			// replace 'init' 'submit'
			return servletPath.replaceAll("\\/\\w+$", "");
		}
		// /Dashboard
		return servletPath;
	}

	/**
	 * Get Default View
	 * 
	 * @return
	 */
	public String getIndexView() {

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String servletPath = requestAttributes.getRequest().getServletPath();

		// /Dashboard/
		if (servletPath.endsWith("/")) {
			return servletPath.substring(0, servletPath.indexOf("/", servletPath.indexOf("/") + 1));
		}
		// /Dashboard/init
		if (servletPath.endsWith("/init") || servletPath.endsWith("/index")) {
			// replace 'init'
			return servletPath.replaceAll("\\/\\w+$", "");
		}
		// /Dashboard
		return servletPath;
	}

	/**
	 * @param controllerType
	 * @return redirect: pageid/init
	 */
	public static String getRedirectRequest(Class<? extends AbstractController> controllerType) {
		RequestMapping mapping = controllerType.getAnnotation(RequestMapping.class);

		if (mapping == null) {
			return null;
		}

		String[] mappedUrl = mapping.value();
		if (mappedUrl == null) {
			return null;
		}

		// redirect: pageid/init
		return new StringBuilder(UrlBasedViewResolver.REDIRECT_URL_PREFIX).append(mappedUrl[0]).append(PAGE_INIT_URL).toString();
	}

}
