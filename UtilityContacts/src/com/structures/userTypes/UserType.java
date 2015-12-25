package com.structures.userTypes;

public enum UserType {

	SELLER("Seller"),
	CUSTOMER("Customer");

	private String text;

	private UserType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}
}
