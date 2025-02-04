package model;

import java.math.BigDecimal;

/**
 * @author Group1 dmai0920
 * A subclass to represent the Private type for the customer
 */
public class PrivateCustomer extends Customer 
{
	//All the new fields
	private String firstName;
	private String lastName;
	private static final BigDecimal THRESHOLD = new BigDecimal(1500);
	
	/**
	 * Generic constructor with all attributes, also calling the super class
	 */
	public PrivateCustomer(String firstName, String lastName, int id, String email, String phoneNumber, String country, String zipcode, String city,
			String streetname, String housenumber) 
	{
		super(id, email, phoneNumber, country, zipcode, city, streetname, housenumber);
		this.firstName = firstName;
		this.lastName = lastName;
		super.setThreshold(THRESHOLD);
	}
	
	/**
	 * Getters and setters for the fields. 
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}

	/**
	 * This method converts all the information about the Private Customer in the fields to a string array for GUI purposes
	 * @return String array
	 */
	@Override
	public String[] infoToArray()
	{
		String[] customerInfo = new String[] {String.valueOf(getId()), getEmail(), getPhoneNumber(), getCountry(), getZipcode(), 
						getCity(), getStreetname(), getHousenumber(), getFirstName(), getLastName()}; 
		
		return customerInfo;
	}
}
