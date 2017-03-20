package com.glad.entity;

import com.glad.component.AbstractDto;

public class TestTable extends AbstractDto {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3802834696014578523L;

	private String keyA;

	private int keyB;

	private String colA;

	private String colB;

	private String colC;

	public String getKeyA() {
		return keyA;
	}

	public void setKeyA(String keyA) {
		this.keyA = keyA;
	}

	public int getKeyB() {
		return keyB;
	}

	public void setKeyB(int keyB) {
		this.keyB = keyB;
	}

	public String getColA() {
		return colA;
	}

	public void setColA(String colA) {
		this.colA = colA;
	}

	public String getColB() {
		return colB;
	}

	public void setColB(String colB) {
		this.colB = colB;
	}

	public String getColC() {
		return colC;
	}

	public void setColC(String colC) {
		this.colC = colC;
	}

}
