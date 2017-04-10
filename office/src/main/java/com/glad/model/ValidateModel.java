package com.glad.model;

import javax.validation.constraints.NotNull;

import com.glad.component.AbstractModel;

public class ValidateModel extends AbstractModel {

	@NotNull
	private String textInput;

	public String getTextInput() {
		return textInput;
	}

	public void setTextInput(String textInput) {
		this.textInput = textInput;
	}

}
