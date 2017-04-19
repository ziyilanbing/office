package com.glad.service;

import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glad.dao.SysMenuMapper;
import com.glad.entity.SysMenu;
import com.glad.exp.OfficeException;
import com.glad.menu.MenuTree;
import com.glad.menu.TreeNode;
import com.glad.taglib.MenuTag;

@Service("MenuService")
@Transactional
public class MenuService {

	/**
	 * slf4j logger
	 */
	private static final Logger logger = LoggerFactory.getLogger(MenuTag.class);

	@Autowired
	private SysMenuMapper menuDao;

	public MenuTree getMenuTree() throws OfficeException {
		List<SysMenu> menuList = menuDao.selectAll();
		MenuTree menuTree = null;

		validateMenu(menuTree);
		return menuTree;
	}

	private void validateMenu(MenuTree menuTree) throws OfficeException {

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
