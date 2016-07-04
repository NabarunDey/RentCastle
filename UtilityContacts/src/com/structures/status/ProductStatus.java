package com.structures.status;

public enum ProductStatus {
	
	AVAILABLE("Available"),
	NOTAVAILABLE("NotAvailable"),
	PENDING("Pending"),
	APPROVED("Approved");
	
	private String text;

	private ProductStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
