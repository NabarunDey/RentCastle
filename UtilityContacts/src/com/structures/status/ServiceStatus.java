package com.structures.status;

public enum ServiceStatus {
	
	PENDING("Pending"),
	APPROVED("Approved"),
	DELETED("Deleted");
	
	private String text;

	private ServiceStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
