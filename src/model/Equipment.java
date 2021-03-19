package model;

import java.math.BigDecimal;

/**
 * @author Group1 dmai0920
 * A subclass representing the equipment in Products
 */
public class Equipment extends Product {

	//All new fields
	private String type;
	
	/**
	 * General constructor including the super class constructor
	 */
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
	
	@Override
	public String[] infoToArray()
	{
		String[] productInfo = new String[] {getType(), String.valueOf(getProductNumber()), getName(), getDescription(), 
						String.valueOf(getStock()), String.valueOf(getMinimumStock()), getPurchasePrice().toString(), getSalesPrice().toString(),
						getRentPrice().toString(), getCountryOfOrigin(), String.valueOf(getSupplier().getId()), getSupplier().getName()};

		return productInfo;
	}

}
