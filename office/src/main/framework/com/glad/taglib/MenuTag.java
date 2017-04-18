package com.glad.taglib;

import javax.servlet.jsp.JspException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import com.glad.aspect.TraceAdvice;

/**
 * create menu html 1
 * 
 * @author zhongqs
 * @date 2017年4月17日
 */
public class MenuTag extends HtmlEscapeTag {

	/**
	 * slf4j logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(TraceAdvice.class);

	@Override
	protected int doStartTagInternal() throws JspException {
		logger.info("doStartTagInternal ");
		return super.doStartTagInternal();
	}
}
