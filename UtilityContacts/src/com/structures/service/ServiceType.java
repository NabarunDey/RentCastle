package com.structures.service;

public enum ServiceType {
	
	BIKESERVICE("BIKESERVICE"),
	CARSERVICE("CARSERVICE");
	
	private String text;

	private ServiceType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
