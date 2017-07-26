package com.glad.taglib;

import java.io.Serializable;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import com.glad.Constants;
import com.glad.entity.OdhModlInfo;
import com.glad.menu.MenuTree;
import com.glad.menu.TreeNode;

/**
 * create menu html
 * 
 * @author zhongqs
 * @date 2017年4月17日
 */
public class MenuTag extends HtmlEscapeTag {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * slf4j logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(MenuTag.class);

	@Override
	protected int doStartTagInternal() throws JspException {

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
	 * @param menuTree
	 * @return
	 */
	private StringBuilder makeHtml(MenuTree menuTree) {
		StringBuilder builder = new StringBuilder();
		// add menu's top [Glad Office]
		// <!-- sidebar: style can be found in sidebar.less -->
		builder.append("<aside class=\"main-sidebar\">\r\n");
		builder.append("<section class=\"sidebar\">\r\n");
		// <!-- sidebar menu: : style can be found in sidebar.less -->
		builder.append("<ul class=\"sidebar-menu\">\r\n");

		builder.append("<li class=\"header\">Glad Office</li>\r\n");

		builder.append(makeListHtml(menuTree.getRoot(), 1));

		builder.append("</section></aside>\r\n");

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
		ulLvlHtml.append("      <ul class=\"treeview-menu\">\r\n");
		return ulLvlHtml.toString();
	}

	private String makeLiHtml(TreeNode treeNode, int level) {

		StringBuilder liHtml = new StringBuilder();
		liHtml.append("        <li><a href=\"");
		// liHtml.append(((SysMenu) treeNode.getData()).getMenuUrl());
		liHtml.append(((OdhModlInfo) treeNode.getData()).getModelUrl());
		if (level == 1) {
			liHtml.append("\"><i class=\"fa fa-sitemap fa-fw\"></i>");
		} else {
			liHtml.append("\">");
		}
		// liHtml.append(((SysMenu) treeNode.getData()).getMenuName());
		liHtml.append(((OdhModlInfo) treeNode.getData()).getModelName());
		if (treeNode.hasChild()) {
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
