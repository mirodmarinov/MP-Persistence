package model;

/**
 * @author Group1 dmai0920
 * A subclass to represent the Business type for the customer
 */
public class BusinessCustomer extends Customer 
{
	//All the new fields
	private int cvrNumber;
	private String businessName;
	
	/**
	 * Generic constructor with all attributes, also calling the super class
	 */
	public BusinessCustomer(String businessName, int cvrNumber, int id, String email, String phoneNumber, String country, String zipcode, String city,
			String streetname, String housenumber) 
	{
		super(id, email, phoneNumber, country, zipcode, city, streetname, housenumber);
		this.businessName = businessName;
		this.cvrNumber = cvrNumber;
	}

	/**
	 * Getters and setters for the fields
	 */
	public String getBusinessName() 
	{
		return businessName;
	}

	public void setBusinessName(String businessName) 
	{
		this.businessName = businessName;
	}

	public int getCvrNumber() 
	{
		return cvrNumber;
	}

	public void setCvrNumber(int cvrNumber) 
	{
		this.cvrNumber = cvrNumber;
	}
	
	/**
	 * This methods converts all the BusinessCustomer fields to a string array for GUI purposes
	 * @return String array
	 */
	@Override
	public String[] infoToArray() //TODO- add this method to the diagrams
	{
		String[] customerInfo = new String[] {String.valueOf(getId()), getEmail(), getPhoneNumber(), getCountry(), getZipcode(), 
						getCity(), getStreetname(), getHousenumber(), getBusinessName(), String.valueOf(getCvrNumber())}; 
		
		return customerInfo;
	}

}
