package com.structures.status;

public enum ProductStatus {
	
	AVAILABLE("Available");
	
	private String text;

	private ProductStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
