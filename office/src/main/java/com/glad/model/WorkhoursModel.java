package com.glad.model;

import javax.validation.constraints.NotNull;

import com.glad.component.AbstractModel;
import com.glad.entity.OdhWktmManage;

public class WorkhoursModel extends AbstractModel {

	@NotNull
	private String comment;
	@NotNull
	private String startDate;
	@NotNull
	private String startTime;
	@NotNull
	private String endDate;
	@NotNull
	private String endTime;

	private OdhWktmManage odhWktmManageChecked;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public OdhWktmManage getOdhWktmManageChecked() {
		return odhWktmManageChecked;
	}

	public void setOdhWktmManageChecked(OdhWktmManage odhWktmManageChecked) {
		this.odhWktmManageChecked = odhWktmManageChecked;
	}

}
