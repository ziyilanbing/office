package com.glad.model;

import com.glad.annotation.NotEmpty;
import com.glad.component.AbstractModel;

public class ValidateModel extends AbstractModel {

	@NotEmpty
	private String textInput;

	public String getTextInput() {
		return textInput;
	}

	public void setTextInput(String textInput) {
		this.textInput = textInput;
	}

}
