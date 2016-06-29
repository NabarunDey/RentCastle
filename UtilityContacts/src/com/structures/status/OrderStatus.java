package com.structures.status;

public enum OrderStatus {
	
	INITIATED("INITIATED"),
	PENDING("PENDING"),
	COMPLETE("COMPLETE");
	
	private String text;

	private OrderStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
