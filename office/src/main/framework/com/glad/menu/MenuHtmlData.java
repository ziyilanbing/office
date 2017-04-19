package com.glad.menu;

public class MenuHtmlData {

	private String name;
	private MenuTree menuTree;

	public MenuHtmlData(String name, MenuTree menuTree) {
		this.name = name;
		this.menuTree = menuTree;
	}

	public String getName() {
		return name;
	}

	public MenuTree getMenuTree() {
		return menuTree;
	}

}
