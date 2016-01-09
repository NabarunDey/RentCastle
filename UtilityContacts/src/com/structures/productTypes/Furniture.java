package com.structures.productTypes;

public enum Furniture {
	
	BED("Bed"),
	ALMIRAH("Almirah");

	private String text;

	private Furniture(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
