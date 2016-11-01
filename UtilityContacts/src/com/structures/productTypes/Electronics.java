package com.structures.productTypes;

public enum Electronics {

	REFRIGERATOR("Refrigerator"),
	WASHINGMACHINE("WashingMachine"),
	TELEVISION("Television");


	private String text;

	private Electronics(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
