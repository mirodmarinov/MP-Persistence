package model;

import java.math.BigDecimal;

/**
 * @author Group1 dmai0920
 * A class representing the product in the system
 *
 */
public class Product
{
	//Fields of the product
	private String name;
	private int productNumber;
	private String description;
	private int stock;
	private int minimumStock;
	private BigDecimal purchasePrice;
	private BigDecimal salesPrice;
	private BigDecimal rentPrice;
	private String countryOfOrigin;
	
	/**
	 * A general constructor with all fields
	 */
	public Product(String name, int productNumber, String description, int stock, int minimumStock, BigDecimal purchasePrice, BigDecimal salesPrice, BigDecimal rentPrice, String countryOfOrigin)
	{
		this.name = name;
		this.productNumber = productNumber;
		this.description = description;
		this.stock = stock;
		this.minimumStock = minimumStock;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
	}

	/**
	 * Getters and setters for all fields
	 */
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getProductNumber()
	{
		return productNumber;
	}

	public void setProductNumber(int productNumber)
	{
		this.productNumber = productNumber;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getStock()
	{
		return stock;
	}

	public void setStock(int stock)
	{
		this.stock = stock;
	}

	public int getMinimumStock()
	{
		return minimumStock;
	}

	public void setMinimumStock(int minimumStock)
	{
		this.minimumStock = minimumStock;
	}

	public BigDecimal getPurchasePrice()
	{
		return purchasePrice;
	}

	public void setPurchasePrice(BigDecimal purchasePrice)
	{
		this.purchasePrice = purchasePrice;
	}

	public BigDecimal getSalesPrice()
	{
		return salesPrice;
	}

	public void setSalesPrice(BigDecimal salesPrice)
	{
		this.salesPrice = salesPrice;
	}

	public BigDecimal getRentPrice()
	{
		return rentPrice;
	}

	public void setRentPrice(BigDecimal rentPrice)
	{
		this.rentPrice = rentPrice;
	}

	public String getCountryOfOrigin()
	{
		return countryOfOrigin;
	}

	public void setCountryOfOrigin(String countryOfOrigin)
	{
		this.countryOfOrigin = countryOfOrigin;
	}
}
