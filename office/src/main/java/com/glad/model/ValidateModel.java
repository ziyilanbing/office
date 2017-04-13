package com.glad.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.glad.component.AbstractModel;

public class ValidateModel extends AbstractModel {

	@NotEmpty
	@Size(max = 8, min = 0)
	private String textInput;

	public String getTextInput() {
		return textInput;
	}

	public void setTextInput(String textInput) {
		this.textInput = textInput;
	}

}
