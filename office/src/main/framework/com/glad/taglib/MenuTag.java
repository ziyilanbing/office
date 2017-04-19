package com.glad.taglib;

import javax.servlet.jsp.JspException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import com.glad.aspect.TraceAdvice;
import com.glad.menu.MenuCreator;
import com.glad.menu.MenuTree;

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

		MenuTree menuTree = null;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		// user check TODO
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			menuTree = MenuCreator.createMenuExt(auth.getName());

			try {

				StringBuilder builder = makeHtml(menuTree);
				pageContext.getOut().print(builder.toString());

			} catch (Exception e) {
				// getExceptionMessage()
				String message = "";
				logger.error("Failed to get the menu data.");
				throw new JspException();
			}
		}

		return EVAL_PAGE;
	}

	private StringBuilder makeHtml(MenuTree menuTree) {
		// TODO Auto-generated method stub
		StringBuilder builder = new StringBuilder("aaaaa");

		return builder;
	}
}
