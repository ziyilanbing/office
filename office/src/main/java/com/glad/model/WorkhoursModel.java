package com.glad.model;

import java.util.Date;

import com.glad.component.AbstractModel;
import com.glad.entity.OdhWktmManage;

public class WorkhoursModel extends AbstractModel {

	private String wktmStartYmd;

	private String wktmStarthm;

	private String wktmEndYmd;

	private String wktmEndhm;

	/**
	 * WKTM_TYPE 工时类型
	 */
	private String wktmType;

	/**
	 * WKTM_SUBTYPE 工时子类型
	 */
	private String wktmSubtype;

	/**
	 * PROJECT_STAGE 项目阶段
	 */
	private String projectStage;

	private String comment;

	private OdhWktmManage odhWktmManageChecked;

	private Date wktmStartYmdhm;

	private Date wktmEndYmdhm;

	public String getWktmStartYmd() {
		return wktmStartYmd;
	}

	public void setWktmStartYmd(String wktmStartYmd) {
		this.wktmStartYmd = wktmStartYmd;
	}

	public String getWktmStarthm() {
		return wktmStarthm;
	}

	public void setWktmStarthm(String wktmStarthm) {
		this.wktmStarthm = wktmStarthm;
	}

	public String getWktmEndYmd() {
		return wktmEndYmd;
	}

	public void setWktmEndYmd(String wktmEndYmd) {
		this.wktmEndYmd = wktmEndYmd;
	}

	public String getWktmEndhm() {
		return wktmEndhm;
	}

	public void setWktmEndhm(String wktmEndhm) {
		this.wktmEndhm = wktmEndhm;
	}

	public String getWktmType() {
		return wktmType;
	}

	public void setWktmType(String wktmType) {
		this.wktmType = wktmType;
	}

	public String getWktmSubtype() {
		return wktmSubtype;
	}

	public void setWktmSubtype(String wktmSubtype) {
		this.wktmSubtype = wktmSubtype;
	}

	public String getProjectStage() {
		return projectStage;
	}

	public void setProjectStage(String projectStage) {
		this.projectStage = projectStage;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public OdhWktmManage getOdhWktmManageChecked() {
		return odhWktmManageChecked;
	}

	public void setOdhWktmManageChecked(OdhWktmManage odhWktmManageChecked) {
		this.odhWktmManageChecked = odhWktmManageChecked;
	}

	public Date getWktmStartYmdhm() {
		return wktmStartYmdhm;
	}

	public void setWktmStartYmdhm(Date wktmStartYmdhm) {
		this.wktmStartYmdhm = wktmStartYmdhm;
	}

	public Date getWktmEndYmdhm() {
		return wktmEndYmdhm;
	}

	public void setWktmEndYmdhm(Date wktmEndYmdhm) {
		this.wktmEndYmdhm = wktmEndYmdhm;
	}

}
