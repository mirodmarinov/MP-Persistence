package model;

import java.math.BigDecimal;

/**
 * @author Group1 dmai0920
 * A subclass representing the clothes in Products
 */
public class Clothing extends Product 
{

	//All new fields
	private String size;
	private String colour;
	
	/**
	 * General constructor including the super class constructor
	 */
	public Clothing(String size, String colour, int productNumber, String name, String description, int stock, int minimumStock,
			BigDecimal purchasePrice, BigDecimal salesPrice, BigDecimal rentPrice, String countryOfOrigin,
			Supplier supplier) 
	{	
		super(productNumber, name, description, stock, minimumStock, purchasePrice, salesPrice, rentPrice,
				countryOfOrigin, supplier, Category.CLOTHING);
		this.size = size;
		this.colour = colour;
	}

	/**
	 * Getters and setters for the files
	 */
	public String getSize() 
	{
		return size;
	}

	public void setSize(String size) 
	{
		this.size = size;
	}

	public String getColour() 
	{
		return colour;
	}

	public void setColour(String colour) 
	{
		this.colour = colour;
	}

	/**
	 * This method converts all the information about the Clothing into a string array for future GUI purposes
	 */
	@Override
	public String[] infoToArray()
	{
		String[] productInfo = new String[] {getSize(), getColour(), String.valueOf(getProductNumber()), getName(), getDescription(), 
						String.valueOf(getStock()), String.valueOf(getMinimumStock()), getPurchasePrice().toString(), getSalesPrice().toString(),
						getRentPrice().toString(), getCountryOfOrigin(), String.valueOf(getSupplier().getId()), getSupplier().getName()};

		return productInfo;
	}
}
