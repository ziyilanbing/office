package com.glad.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.glad.dao.OdhModlInfoMapper;
import com.glad.dao.SysMenuMapper;
import com.glad.entity.OdhModlInfo;
import com.glad.exp.OfficeException;
import com.glad.menu.MenuNodeComparator;
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

	@Autowired
	private OdhModlInfoMapper odhModlInfoDao;

	public MenuTree getMenuTree() throws OfficeException {

		MenuTree menuTree = selectMenu();
		validateMenu(menuTree);
		return menuTree;
	}

	private MenuTree selectMenu() throws OfficeException {

		// List<SysMenu> menuList = menuDao.selectAll();

		List<OdhModlInfo> menuList = odhModlInfoDao.selectAll();

		if (menuList == null || menuList.size() == 0) {
			logger.error("Menu not found.");
			throw new OfficeException("error.notfound.menu");
		}
		TreeNode currentNode = null;
		TreeNode parentNode = null;

		TreeNode root = null;
		OdhModlInfo data = null;
		Map nodeMap = new HashMap();
		Iterator itr = menuList.iterator();
		MenuNodeComparator comp = new MenuNodeComparator();

		while (itr.hasNext()) {
			data = (OdhModlInfo) itr.next();
			currentNode = new TreeNode(data, comp);
			if (StringUtils.isEmpty(data.getParentModelId())) {
				root = currentNode;
			} else {
				parentNode = (TreeNode) nodeMap.get(data.getParentModelId().toString());
				if (parentNode == null) {
					logger.debug("parent menu PK = [" + data.getParentModelId() + "] not found for menu PK = ["
							+ data.getModelId() + "]");
					String args[] = new String[2];
					args[0] = data.getModelId();
					args[1] = data.getParentModelId();
					throw new OfficeException("error.corrupted.menuList", args);
				} else {
					parentNode.addChild(currentNode);
				}
			}
			nodeMap.put(data.getModelId(), currentNode);
		}

		return new MenuTree(root);
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
