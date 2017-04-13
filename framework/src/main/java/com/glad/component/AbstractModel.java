package com.glad.component;

public abstract class AbstractModel {

	/**
	 * Screen Id
	 */
	private String screenId;

	/**
	 * Screen Name
	 */
	private String screenName;

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
