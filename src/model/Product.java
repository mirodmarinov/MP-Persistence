package model;

import java.math.BigDecimal;

/**
 * @author Group1 dmai0920
 * A class representing the Products in the system
 */
public abstract class Product
{
	//Fields of the product
	private int productNumber;
	private int stock;
	private int minimumStock;
	private Category category;
	private String name;
	private String description;
	private String countryOfOrigin;
	private BigDecimal purchasePrice;
	private BigDecimal salesPrice;
	private BigDecimal rentPrice;
	private Supplier supplier;
	
	/**
	 * A general constructor with all fields
	 */
	public Product(int productNumber, String name,  String description, int stock, int minimumStock, BigDecimal purchasePrice, 
			BigDecimal salesPrice, BigDecimal rentPrice, String countryOfOrigin, Supplier supplier, Category category)
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
		this.setSupplier(supplier);
		this.setCategory(category);
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

	public Supplier getSupplierId() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
