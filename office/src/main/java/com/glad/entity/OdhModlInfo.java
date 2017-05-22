package com.glad.entity;

import java.util.Date;

import com.glad.component.AbstractDto;

public class OdhModlInfo extends AbstractDto {
	private String modelId;

	private String parentModelId;

	private String modelUrl;

	private String modelName;

	private String modelInfo;

	private Integer layerNo;

	private Integer displayOrder;

	private String loginNo;

	private String loginIp;

	private Date recInsertTime;

	private String updateNo;

	private String updateIp;

	private Date recUpdateTime;

	public String getModelId() {
		return modelId;
	}

	public void setModelId(String modelId) {
		this.modelId = modelId;
	}

	public String getParentModelId() {
		return parentModelId;
	}

	public void setParentModelId(String parentModelId) {
		this.parentModelId = parentModelId;
	}

	public String getModelUrl() {
		return modelUrl;
	}

	public void setModelUrl(String modelUrl) {
		this.modelUrl = modelUrl;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getModelInfo() {
		return modelInfo;
	}

	public void setModelInfo(String modelInfo) {
		this.modelInfo = modelInfo;
	}

	public Integer getLayerNo() {
		return layerNo;
	}

	public void setLayerNo(Integer layerNo) {
		this.layerNo = layerNo;
	}

	public Integer getDisplayOrder() {
		return displayOrder;
	}

	public void setDisplayOrder(Integer displayOrder) {
		this.displayOrder = displayOrder;
	}

	public String getLoginNo() {
		return loginNo;
	}

	public void setLoginNo(String loginNo) {
		this.loginNo = loginNo;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getRecInsertTime() {
		return recInsertTime;
	}

	public void setRecInsertTime(Date recInsertTime) {
		this.recInsertTime = recInsertTime;
	}

	public String getUpdateNo() {
		return updateNo;
	}

	public void setUpdateNo(String updateNo) {
		this.updateNo = updateNo;
	}

	public String getUpdateIp() {
		return updateIp;
	}

	public void setUpdateIp(String updateIp) {
		this.updateIp = updateIp;
	}

	public Date getRecUpdateTime() {
		return recUpdateTime;
	}

	public void setRecUpdateTime(Date recUpdateTime) {
		this.recUpdateTime = recUpdateTime;
	}

	public String toString() {
		String ret = null;
		ret = getModelName() + "(" + getModelId() + ")\n";
		return ret;
	};
}