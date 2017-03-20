package com.glad.component;

import java.io.Serializable;

/**
 * 
 * @author zhongqs
 * @date 2017年3月16日
 */
public class AbstractDto extends FieldBase implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1420004154945290394L;

	/**
	 * Create Time
	 */
	private String createTime;

	/**
	 * Create By
	 */
	private String createBy;

	/**
	 * Update Time
	 */
	private String updateTime;

	/**
	 * Update By
	 */
	private String updateBy;

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
}
