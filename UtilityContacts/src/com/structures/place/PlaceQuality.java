package com.structures.place;

public enum PlaceQuality {
	
	Premium("Gym"),
	Regular("SwimmingPool"),
	Economy("Economy");
	
	private String text;

	private PlaceQuality(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
