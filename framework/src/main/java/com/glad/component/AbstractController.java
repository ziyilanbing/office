package com.glad.component;

import org.slf4j.Logger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import com.glad.exp.AppErrorException;
import com.glad.exp.AppFailedException;
import com.glad.exp.AppWarnException;

/**
 * 
 * @author zhongqs
 * @date 2017年3月16日
 */
public abstract class AbstractController {

	public static String PAGE_INIT_URL = "/init";

	public String handleException(Logger logger, Exception exception, String warnScreenName) throws Exception {
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

	/**
	 * Get Default View
	 * 
	 * @return
	 */
	public String getDefaultView() {

		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		String servletPath = requestAttributes.getRequest().getServletPath();

		// replace 'init' 'submit'
		if (servletPath.substring(1).contains("/")) {
			return servletPath.replaceAll("\\/\\w+$", "");
		}

		return servletPath;
	}

	/**
	 * 
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
		return new StringBuilder(UrlBasedViewResolver.REDIRECT_URL_PREFIX).append(mappedUrl[0]).append(PAGE_INIT_URL)
				.toString();
	}

}
