package com.glad.component;

import java.util.Date;

/**
 * @author zhongqs
 */
public class AbstractDto {

	/**
	 * LOGIN_NO 登录者工号
	 */
	private String loginNo;

	/**
	 * LOGIN_IP 登录者IP
	 */
	private String loginIp;

	/**
	 * REC_INSERT_TIME 登录时间
	 */
	private Date recInsertTime;

	/**
	 * DELETE_STATE 删除状态位
	 */
	private String deleteState;

	/**
	 * UPDATE_NO 更新者工号
	 */
	private String updateNo;

	/**
	 * UPDATE_IP 更新者IP
	 */
	private String updateIp;

	/**
	 * REC_UPDATE_TIME 记录更新时间
	 */
	private Date recUpdateTime;

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

	public String getDeleteState() {
		return deleteState;
	}

	public void setDeleteState(String deleteState) {
		this.deleteState = deleteState;
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
}
