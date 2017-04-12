package com.glad.model;

import javax.validation.constraints.Size;

import com.glad.annotation.NotEmpty;
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
