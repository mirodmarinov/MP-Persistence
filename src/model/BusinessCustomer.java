package model;

public class BusinessCustomer extends Customer {

	private String businessName;
	private int cvrNumber;
	
	public BusinessCustomer(String businessName, int cvrNumber, int id, String email, String phoneNumber, String country, String zipcode, String city,
			String streetname, String housenumber) {
		super(id, email, phoneNumber, country, zipcode, city, streetname, housenumber);
		this.businessName = businessName;
		this.cvrNumber = cvrNumber;
	}

	/**
	 * Getters and setters for the fields
	 */
	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public int getCvrNumber() {
		return cvrNumber;
	}

	public void setCvrNumber(int cvrNumber) {
		this.cvrNumber = cvrNumber;
	}

}
