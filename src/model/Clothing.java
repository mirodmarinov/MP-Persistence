package model;

import java.math.BigDecimal;

public class Clothing extends Product {

	private String size;
	private String colour;
	
	public Clothing(String size, String colour, int productNumber, String name, String description, int stock, int minimumStock,
			BigDecimal purchasePrice, BigDecimal salesPrice, BigDecimal rentPrice, String countryOfOrigin,
			Supplier supplier) {
		
		super(productNumber, name, description, stock, minimumStock, purchasePrice, salesPrice, rentPrice,
				countryOfOrigin, supplier, Category.CLOTHING);
		this.size = size;
		this.colour = colour;
	}

	/**
	 * Getters and setters for the files
	 */
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}
}
