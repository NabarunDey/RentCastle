package com.structures.productTypes;

public enum ProductType {

	FURNITURE("Furniture"),
	ELECTRONICS("Electronics");

	private String text;

	private ProductType(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public enum Furniture {

		BED("Bed"),
		ALMIRAH("Almirah");

		private String text;

		private Furniture(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}
	}
	
	public enum Electronics {

		REFRIGERATOR("Refrigerator"),
		WASHINGMACHINE("WashingMachine");

		private String text;

		private Electronics(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}
	}




}
