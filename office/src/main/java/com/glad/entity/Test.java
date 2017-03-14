package com.glad.entity;

public class Test {
	public static void main(String[] args) {
		TestTable t = new TestTable();
		t.setColA("cola");
		t.setColB("colb");
		t.setColC("colc");
		t.setKeyA("keya");
		t.setKeyB(123);
		System.out.println(t.toString());
	}
}
