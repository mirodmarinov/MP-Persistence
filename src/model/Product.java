package model;

import java.math.BigDecimal;

/**
 * @author Group1 dmai0920
 * A class representing the Products in the system
 *
 */
public class Product
{
	//Fields of the product
	private int productNumber;
	private String name;
	private String description;
	private int stock;
	private int minimumStock;
	private BigDecimal purchasePrice;
	private BigDecimal salesPrice;
	private BigDecimal rentPrice;
	private String countryOfOrigin;
	private int supplierId;
	private int categoryNumber;
	
	/**
	 * A general constructor with all fields
	 */
	public Product(int productNumber, String name,  String description, int stock, int minimumStock, BigDecimal purchasePrice, 
			BigDecimal salesPrice, BigDecimal rentPrice, String countryOfOrigin, int supplierId, int categoryNumber)
	{
		this.productNumber = productNumber;
		this.name = name;
		this.description = description;
		this.stock = stock;
		this.minimumStock = minimumStock;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.rentPrice = rentPrice;
		this.countryOfOrigin = countryOfOrigin;
		this.setSupplierId(supplierId);
		this.setCategoryNumber(categoryNumber);
	}

	/**
	 * Getters and setters for all fields
	 */
	public int getProductNumber()
	{
		return productNumber;
	}

	public void setProductNumber(int productNumber)
	{
		this.productNumber = productNumber;
	}
	
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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

	public int getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public int getCategoryNumber() {
		return categoryNumber;
	}

	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}
}
