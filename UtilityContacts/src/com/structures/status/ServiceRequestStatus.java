package com.structures.status;

public enum ServiceRequestStatus {
	
	INITIATED("INITIATED"),
	COMPLETE("COMPLETE");
	
	private String text;

	private ServiceRequestStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
