package com.structures.place;

public enum PlaceType {
	
	Gym("Gym"),
	SwimmingPool("SwimmingPool"),
	YogaCenter("YogaCenter");

	
	private String text;

	private PlaceType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
