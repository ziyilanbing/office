package com.glad.framework.component;

public abstract class AbstractModel {

	/**
	 * Screen Id
	 */
	private String screenId;

	/**
	 * Screen Name
	 */
	private String screenName;

	/**
	 * Redirect Screen Name
	 */
	private String redirectScreenId;

	public String getRedirectScreenId() {
		return redirectScreenId;
	}

	public void setRedirectScreenId(String redirectScreenId) {
		this.redirectScreenId = redirectScreenId;
	}

	public String getScreenId() {
		return screenId;
	}

	public void setScreenId(String screenId) {
		this.screenId = screenId;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

}
