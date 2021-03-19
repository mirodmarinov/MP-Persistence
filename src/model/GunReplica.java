package model;

import java.math.BigDecimal;

public class GunReplica extends Product {

	private String calibre;
	private String material;
	
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

}
