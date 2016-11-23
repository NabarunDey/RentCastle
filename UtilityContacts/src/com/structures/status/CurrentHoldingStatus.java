package com.structures.status;

public enum CurrentHoldingStatus {
	
	ONGOING("ONGOING"),
	UPCOMING("UPCOMING"),
	ENDREQUESTED("ENDREQUESTED"),
	CLOSED("CLOSED");
	
	private String text;

	private CurrentHoldingStatus(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
