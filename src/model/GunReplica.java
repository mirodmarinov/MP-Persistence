package model;

import java.math.BigDecimal;

/**
 * @author Group1 dmai0920
 * A subclass representing the gun replicas in Products
 */
public class GunReplica extends Product {

	//All new fields
	private String calibre;
	private String material;
	
	/**
	 * General constructor including the super class constructor
	 */
	public GunReplica(String calibre, String material, int productNumber, String name, String description, int stock, int minimumStock,
			BigDecimal purchasePrice, BigDecimal salesPrice, BigDecimal rentPrice, String countryOfOrigin,
			Supplier supplier) {
		
		super(productNumber, name, description, stock, minimumStock, purchasePrice, salesPrice, rentPrice,
				countryOfOrigin, supplier, Category.GUN_REPLICA);
		this.setCalibre(calibre);
		this.setMaterial(material);
	}

	/**
	 * Getters and setters for the fields
	 */
	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}
	
	@Override
	public String[] infoToArray()
	{
		String[] productInfo = new String[] {getCalibre(), getMaterial(), String.valueOf(getProductNumber()), getName(), getDescription(), 
						String.valueOf(getStock()), String.valueOf(getMinimumStock()), getPurchasePrice().toString(), getSalesPrice().toString(),
						getRentPrice().toString(), getCountryOfOrigin(), String.valueOf(getSupplier().getId()), getSupplier().getName()};

		return productInfo;
	}

}
