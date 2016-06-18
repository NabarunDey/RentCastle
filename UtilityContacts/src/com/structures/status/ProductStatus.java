package com.structures.status;

public enum ProductStatus {
	
	AVAILABLE("Available"),
	NOTAVAILABLE("NotAvailable");
	
	private String text;

	private ProductStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
