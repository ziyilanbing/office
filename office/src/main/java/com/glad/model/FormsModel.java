package com.glad.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.glad.component.AbstractModel;

public class FormsModel extends AbstractModel {

	@NotNull
	@NotEmpty
	@NotBlank
	@Size(min = 5, max = 10)
	private String textInput;

	@NotNull
	private String textInputwithPlaceholder;

	@NotNull
	private String textarea;

	@NotNull
	private String checkbox1;

	@NotNull
	private String checkbox2;

	@NotNull
	private String checkbox3;

	@NotNull
	private String checkboxes;

	@NotNull
	private String radioButtons;

	@NotNull
	private String selects;

	@NotNull
	private String multipleSelects;

	public String getTextInput() {
		return textInput;
	}

	public void setTextInput(String textInput) {
		this.textInput = textInput;
	}

	public String getTextInputwithPlaceholder() {
		return textInputwithPlaceholder;
	}

	public void setTextInputwithPlaceholder(String textInputwithPlaceholder) {
		this.textInputwithPlaceholder = textInputwithPlaceholder;
	}

	public String getTextarea() {
		return textarea;
	}

	public void setTextarea(String textarea) {
		this.textarea = textarea;
	}

	public String getCheckbox1() {
		return checkbox1;
	}

	public void setCheckbox1(String checkbox1) {
		this.checkbox1 = checkbox1;
	}

	public String getCheckbox2() {
		return checkbox2;
	}

	public void setCheckbox2(String checkbox2) {
		this.checkbox2 = checkbox2;
	}

	public String getCheckbox3() {
		return checkbox3;
	}

	public void setCheckbox3(String checkbox3) {
		this.checkbox3 = checkbox3;
	}

	public String getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(String checkboxes) {
		this.checkboxes = checkboxes;
	}

	public String getRadioButtons() {
		return radioButtons;
	}

	public void setRadioButtons(String radioButtons) {
		this.radioButtons = radioButtons;
	}

	public String getSelects() {
		return selects;
	}

	public void setSelects(String selects) {
		this.selects = selects;
	}

	public String getMultipleSelects() {
		return multipleSelects;
	}

	public void setMultipleSelects(String multipleSelects) {
		this.multipleSelects = multipleSelects;
	}

}
