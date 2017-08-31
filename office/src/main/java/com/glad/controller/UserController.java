package com.glad.controller;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.glad.Constants;
import com.glad.annotation.ScreenId;
import com.glad.base.BaseController;
import com.glad.entity.OdhModlInfo;
import com.glad.menu.MenuTree;
import com.glad.menu.TreeNode;
import com.glad.model.DefaultModel;

/**
 * Created by CodeGenerator on 2017/07/28.
 */
@Controller
@RequestMapping("/admin/user")
@ScreenId("glad.office.user")
public class UserController extends BaseController<DefaultModel> {

	@RequestMapping(method = {RequestMethod.GET})
	public String details(ModelMap model) throws Exception {

		return getIndexView();
	}

	@ResponseBody
	@RequestMapping(value = "/listjson", method = {RequestMethod.GET})
	public String listjson(ModelMap model, HttpServletRequest request) throws Exception {
		MenuTree menuTree = (MenuTree) request.getSession().getAttribute(Constants.USER_MENU_TREE);
		System.out.println(menuToJson(menuTree.getRoot()));
		return menuToJson(menuTree.getRoot());
	}

	private String menuToJson(TreeNode node) {
		StringBuilder jsonsb = new StringBuilder("[");
		Iterator childIterator = node.getChildIterator();
		while (childIterator.hasNext()) {
			TreeNode treeNode = (TreeNode) childIterator.next();
			jsonsb.append("{layer:\"" + ((OdhModlInfo) treeNode.getData()).getModelId() + "\"");
			jsonsb.append(",id:\"" + ((OdhModlInfo) treeNode.getData()).getModelId() + "\"");
			jsonsb.append(",text:\"" + ((OdhModlInfo) treeNode.getData()).getModelName() + "\"");
			jsonsb.append(",icon:\"fa fa-sitemap\"");
			jsonsb.append(",children:");
			jsonsb.append(menuToJson(treeNode));
			jsonsb.append("},");
		}
		jsonsb.append("]");
		return jsonsb.toString();
	}

}
