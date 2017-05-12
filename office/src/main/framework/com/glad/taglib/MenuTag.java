package com.glad.taglib;

import java.io.Serializable;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import com.glad.Constants;
import com.glad.entity.SysMenu;
import com.glad.menu.MenuTree;
import com.glad.menu.TreeNode;
import com.glad.service.MenuService;

/**
 * create menu html 1
 * 
 * @author zhongqs
 * @date 2017年4月17日
 */
public class MenuTag extends HtmlEscapeTag {

	private static ApplicationContext applicationContext;
	/**
	 * slf4j logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(MenuTag.class);
	private static String MENU_LEVEL_HTML = "aaaaaaaaaaaaaaaaaaaaa";
	@Autowired
	private MenuService menuService;

	@Override
	protected int doStartTagInternal() throws JspException {
		logger.info("doStartTagInternal ");

		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		MenuTree menuTree = null;

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		MenuHtmlData menudata = (MenuHtmlData) request.getSession().getAttribute(Constants.USER_MENU_STREAM_KEY);
		// user check
		if (!(auth instanceof AnonymousAuthenticationToken)) {

			String userId = auth.getName();
			StringBuilder builder = null;
			if (menudata == null || userId != menudata.getName()) {
				menuTree = (MenuTree) request.getSession().getAttribute(Constants.USER_MENU_TREE);
				builder = makeHtml(menuTree);
				menudata = new MenuHtmlData(userId, builder);
				request.getSession().setAttribute(Constants.USER_MENU_STREAM_KEY, menudata);
			} else {
				builder = menudata.getMenuHtml();
			}

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

	/**
	 * 
	 * @param menuTree
	 * @return
	 */
	private StringBuilder makeHtml(MenuTree menuTree) {
		StringBuilder builder = new StringBuilder();
		// add menu's top [Glad Office]
		builder.append("<div class=\"navbar-default sidebar\" role=\"navigation\">\r\n");
		builder.append("  <div class=\"sidebar-nav navbar-collapse\">\r\n");
		builder.append("    <ul class=\"nav\" id=\"side-menu\">\r\n");
		builder.append("      <li><a href=\"#\"><i class=\"fa fa-dashboard fa-fw\"></i> Dashboard</a></li>\r\n");

		builder.append(makeListHtml(menuTree.getRoot(), 1));

		builder.append("this is menu ended");

		return builder;
	}

	private String makeListHtml(TreeNode node, int level) {
		StringBuilder menuHtml = new StringBuilder();

		Iterator childIterator = node.getChildIterator();
		while (childIterator.hasNext()) {
			TreeNode treeNode = (TreeNode) childIterator.next();
			menuHtml.append(makeLiHtml(treeNode, level));

			if (treeNode.hasChild()) {
				level++;
				menuHtml.append(ulLevelHtml(level));
				menuHtml.append(makeListHtml(treeNode, level));
				menuHtml.append("</ul>\r\n");
				level--;
			}
			menuHtml.append("</li>\r\n");

		}
		return menuHtml.toString();
	}

	private Object ulLevelHtml(int level) {
		StringBuilder ulLvlHtml = new StringBuilder();
		if (level == 2) {
			ulLvlHtml.append("      <ul class=\"nav nav-second-level collapse\">\r\n");
		} else {
			ulLvlHtml.append("      <ul class=\"nav nav-third-level collapse\">\r\n");
		}
		return ulLvlHtml.toString();
	}

	private String makeLiHtml(TreeNode treeNode, int level) {

		StringBuilder liHtml = new StringBuilder();
		liHtml.append("        <li><a href=\"");
		liHtml.append(((SysMenu) treeNode.getData()).getMenuUrl());
		if (level == 1) {
			liHtml.append("\"><i class=\"fa fa-sitemap fa-fw\"></i>");
		} else {
			liHtml.append("\">");
		}
		liHtml.append(((SysMenu) treeNode.getData()).getMenuName());
		if (level == 1) {
			liHtml.append("<span class=\"fa arrow\"></span>");
		}
		liHtml.append("</a>");
		return liHtml.toString();
	}

	private class MenuHtmlData implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = -5176003866179150793L;

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
