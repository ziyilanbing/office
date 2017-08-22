package com.glad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.glad.Constants;
import com.glad.annotation.ScreenId;
import com.glad.base.BaseController;
import com.glad.collections.MySession;
import com.glad.exp.OfficeException;
import com.glad.menu.MenuTree;
import com.glad.model.DashboardModel;
import com.glad.service.MenuService;

/**
 * @author zhongqs
 * @date 2017年3月9日
 */
@Controller
@RequestMapping("/dashboard")
@ScreenId("glad.office.Dashboard")
public class DashboardController extends BaseController<DashboardModel> {

	@Autowired
	private MenuService menuService;

	@Override
	public void doInit(ModelMap model, DashboardModel commandForm) throws OfficeException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : principal.toString();
		MySession.LoginUserId.value(userName);
		model.addAttribute("user", userName);
	}

	@Override
	public void setRequest(HttpServletRequest request) throws OfficeException {
		// Get menuTree
		MenuTree menuTree = (MenuTree) (request.getSession().getAttribute(Constants.USER_MENU_TREE));
		if (menuTree == null) {
			menuTree = menuService.getMenuTree();
			request.getSession().setAttribute(Constants.USER_MENU_TREE, menuTree);
		}
		logger.info(menuTree.toString());
		// Set Login Ip
		MySession.LoginIp.value(request.getRemoteAddr());
		super.setRequest(request);
	}
}