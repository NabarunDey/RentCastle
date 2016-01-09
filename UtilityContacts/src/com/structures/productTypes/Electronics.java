package com.structures.productTypes;

public enum Electronics {

	REFRIGERATOR("Refrigerator"),
	WASHINGMACHINE("WashingMachine");

	private String text;

	private Electronics(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
