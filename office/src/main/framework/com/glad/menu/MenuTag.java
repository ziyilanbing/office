package com.glad.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import com.glad.Constants;

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
	private static final Logger logger = LoggerFactory.getLogger(MenuTag.class);

	@Override
	protected int doStartTagInternal() throws JspException {
		logger.info("doStartTagInternal ");

		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		MenuTree menuTree = null;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MenuHtmlData menudata = (MenuHtmlData) request.getSession().getAttribute(Constants.USER_MENU_STREAM_KEY);
		// user check TODO
		if (!(auth instanceof AnonymousAuthenticationToken)) {

			String userId = auth.getName();
			if (menuTree == null || userId != menudata.getName()) {
				menuTree = MenuCreator.createMenuExt(userId);
			}

			menudata = new MenuHtmlData(auth.getName(), menuTree);
			request.getSession().setAttribute(Constants.USER_MENU_STREAM_KEY, menudata);

			try {
				StringBuilder builder = makeHtml(menuTree);
				pageContext.getOut().print(builder.toString());

			} catch (Exception e) {
				// getExceptionMessage()
				String message = "";
				logger.error("Failed to get the menu data." + message);
				throw new JspException(e);
			}
		}

		return EVAL_PAGE;
	}

	private StringBuilder makeHtml(MenuTree menuTree) {
		// TODO
		StringBuilder builder = new StringBuilder("aaaaa");

		return builder;
	}
}
