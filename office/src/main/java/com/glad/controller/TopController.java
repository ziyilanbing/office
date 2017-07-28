package com.glad.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.glad.Constants;
import com.glad.annotation.ScreenId;
import com.glad.base.BaseController;
import com.glad.exp.AppWarnException;
import com.glad.exp.OfficeException;
import com.glad.menu.MenuTree;
import com.glad.model.TopModel;
import com.glad.service.MenuService;
import com.glad.util.Constant;

/**
 * @author zhongqs
 * @date 2017年3月9日
 */
@Controller
@RequestMapping("/top")
@ScreenId("glad.office.Top")
public class TopController extends BaseController<TopModel> {

	@Autowired
	private MenuService menuService;

	@Override
	public void doInit(ModelMap model, TopModel commandForm) throws OfficeException {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String userName = principal instanceof UserDetails ? ((UserDetails) principal).getUsername() : principal.toString();
		model.addAttribute("user", userName);

	}

	@Override
	public void setRequest(HttpServletRequest request) throws OfficeException {
		// get menuTree
		MenuTree menuTree = (MenuTree) (request.getSession().getAttribute(Constants.USER_MENU_TREE));
		if (menuTree == null) {
			menuTree = menuService.getMenuTree();
			request.getSession().setAttribute(Constants.USER_MENU_TREE, menuTree);
		}
		logger.info(menuTree.toString());
		super.setRequest(request);
	}

	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public String exceptionTest(ModelMap model, @ModelAttribute TopModel commandForm, BindingResult result) throws Exception {
		try {

			throw new AppWarnException("OFE0001MW", new String[]{"parm1", "parm2"}, Constant.TEST);

		} catch (Exception e) {
			handleException(model, result, e);
		}
		return this.getDefaultView();
	}
}