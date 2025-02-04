package model;

import java.math.BigDecimal;

/**
 * @author Group1 dmai0920
 * This class represents the Customer in the system
 */
public abstract class Customer
{
	//Fields for the Customer
	private int id;
	private String phoneNumber;
	private String email;
	private String country;
	private String zipcode;
	private String city;
	private String streetname;
	private String housenumber;
	private BigDecimal threshold;
	
	/**
	 * General constructor with all parameters for the Customer object
	 */
	public Customer(int id, String email, String phoneNumber, String country, String zipcode, String city, String streetname, String housenumber)
	{
		this.id = id;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.country = country;
		this.zipcode = zipcode;
		this.city = city;
		this.streetname = streetname;
		this.housenumber = housenumber;
	}

	/**
	 * Getters and setters for all fields.
	 */
	public int getId() 
	{
		return id;
	}

	public void setId(int id) 
	{
		this.id = id;
	}

	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public String getZipcode() 
	{
		return zipcode;
	}

	public void setZipcode(String zipcode) 
	{
		this.zipcode = zipcode;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getStreetname() 
	{
		return streetname;
	}

	public void setStreetname(String streetname) 
	{
		this.streetname = streetname;
	}

	public String getHousenumber() 
	{
		return housenumber;
	}

	public void setHousenumber(String housenumber) 
	{
		this.housenumber = housenumber;
	}
	
	public BigDecimal getThreshold() 
	{
		return threshold;
	}

	public void setThreshold(BigDecimal threshold) 
	{
		this.threshold = threshold;
	}
	
	/**
	 * Used as a support method to its subclasses. - PrivateCustomer and BusinessCustomer
	 * @return
	 */
	public abstract String[] infoToArray();
	
}
