package com.glad.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import com.glad.Constants;
import com.glad.menu.MenuTree;
import com.glad.service.MenuService;

/**
 * create menu html 1
 * 
 * @author zhongqs
 * @date 2017年4月17日
 */
public class MenuTag extends HtmlEscapeTag implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	/**
	 * slf4j logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(MenuTag.class);

	@Autowired
	private MenuService menuService;

	@Override
	protected int doStartTagInternal() throws JspException {
		logger.info("doStartTagInternal ");

		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		MenuTree menuTree = null;

		menuService = (MenuService) applicationContext.getBean("MenuService");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MenuHtmlData menudata = (MenuHtmlData) request.getSession().getAttribute(Constants.USER_MENU_STREAM_KEY);
		// user check TODO
		if (!(auth instanceof AnonymousAuthenticationToken)) {

			String userId = auth.getName();
			if (menudata == null || userId != menudata.getName()) {
				try {
					// menuTree = createMenuExt(userId);
					menuTree = (MenuTree) request.getSession().getAttribute(Constants.USER_MENU_TREE);
				} catch (Exception e) {
					// getExceptionMessage()
					String message = "";
					logger.error("Failed to get the menu data." + message);
					throw new JspException(e);
				}
			}

			StringBuilder builder = makeHtml(menuTree);
			menudata = new MenuHtmlData(userId, builder);
			request.getSession().setAttribute(Constants.USER_MENU_STREAM_KEY, menudata);

			try {
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

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;
	}

	private class MenuHtmlData {

		private String name;
		private StringBuilder menuHtml;

		public MenuHtmlData(String name, StringBuilder menuHtml) {
			this.name = name;
			this.menuHtml = menuHtml;
		}

		public String getName() {
			return name;
		}

		public StringBuilder getMenuHtml() {
			return menuHtml;
		}

	}
}
