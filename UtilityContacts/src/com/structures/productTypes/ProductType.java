package com.structures.productTypes;

public enum ProductType {

	FURNITURE("Furniture");
		
	private String text;

	private ProductType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}





}
