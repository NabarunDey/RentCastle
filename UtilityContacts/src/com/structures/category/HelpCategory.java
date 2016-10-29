package com.structures.category;

public enum HelpCategory {
	
	FEEDBACK("FEEDBACK"),
	SUGGESTION("SUGGESTION"),
	COMPLAINT("COMPLAINT");

	
	private String text;

	private HelpCategory(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	
	

}
