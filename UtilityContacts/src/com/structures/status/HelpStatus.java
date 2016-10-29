package com.structures.status;

public enum HelpStatus {
	
	PENDING("INITIATED"),
	COMPLETED("PROCESSING");
	
	private String text;

	private HelpStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
