package com.glad.menu;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.glad.exp.OfficeException;

public class MenuCreator {

	/**
	 * slf4j logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(MenuCreator.class);

	// @Autowired

	public static MenuTree createMenuExt(String userId) throws OfficeException {
		MenuTree menuTree = null;
		menuTree = fromMenuTree(userId);
		validateMenu(menuTree);

		return null;
	}

	private static MenuTree fromMenuTree(String userId) {

		return null;
	}

	/**
	 * 
	 * @param menuTree
	 * @throws OfficeException
	 */
	private static void validateMenu(MenuTree menuTree) throws OfficeException {
		if (menuTree == null || menuTree.getChildCount() == 0) {
			throw new OfficeException("error.notfound.menu");
		}
		TreeNode menuRoot = menuTree.getRoot();
		Iterator itr = menuRoot.getChildIterator();
		TreeNode childMenu = null;
		while (itr.hasNext()) {
			childMenu = (TreeNode) itr.next();
			if (!childMenu.hasChild()) {
				logger.error("Top Level menu [" + childMenu.toString() + "]");
				throw new OfficeException("error.missing.submenu.attop");
			}
		}
	}

}
