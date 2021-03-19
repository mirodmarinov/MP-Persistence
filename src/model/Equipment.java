package model;

import java.math.BigDecimal;

public class Equipment extends Product {

	private String type;
	
	public Equipment(String type, int productNumber, String name, String description, int stock, int minimumStock,
			BigDecimal purchasePrice, BigDecimal salesPrice, BigDecimal rentPrice, String countryOfOrigin,
			Supplier supplier) {
		
		super(productNumber, name, description, stock, minimumStock, purchasePrice, salesPrice, rentPrice,
				countryOfOrigin, supplier, Category.EQUIPMENT);
		this.setType(type);
	}

	/**
	 * Getter and setter for the field
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
