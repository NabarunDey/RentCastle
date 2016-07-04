package com.structures.status;

public enum PaymentStatus {
	
	PENDING("PENDING"),
	COMPLETED("COMPLETED"),
	UPCOMING("UPCOMING");
	
	private String text;

	private PaymentStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
