package com.glad.entity;

import com.glad.component.AbstractDto;

public class Datatables extends AbstractDto {
    private Integer id;

    private String renderingEngine;

    private String browser;

    private String platforms;

    private String engineVersion;

    private String cssGrade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRenderingEngine() {
        return renderingEngine;
    }

    public void setRenderingEngine(String renderingEngine) {
        this.renderingEngine = renderingEngine;
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

    public String getEngineVersion() {
        return engineVersion;
    }

    public void setEngineVersion(String engineVersion) {
        this.engineVersion = engineVersion;
    }

    public String getCssGrade() {
        return cssGrade;
    }

    public void setCssGrade(String cssGrade) {
        this.cssGrade = cssGrade;
    }
}