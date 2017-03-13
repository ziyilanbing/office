package com.glad.entity;

import java.io.Serializable;

import com.glad.framework.base.BaseEntity;

public class Datatables extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String rendering_engine;

	private String browser;

	private String platforms;

	private String engine_version;

	private String css_grade;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRendering_engine() {
		return rendering_engine;
	}

	public void setRendering_engine(String rendering_engine) {
		this.rendering_engine = rendering_engine;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	public String getPlatforms() {
		return platforms;
	}

	public void setPlatforms(String platforms) {
		this.platforms = platforms;
	}

	public String getEngine_version() {
		return engine_version;
	}

	public void setEngine_version(String engine_version) {
		this.engine_version = engine_version;
	}

	public String getCss_grade() {
		return css_grade;
	}

	public void setCss_grade(String css_grade) {
		this.css_grade = css_grade;
	}

}
