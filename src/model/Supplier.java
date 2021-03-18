package model;

/**
 * @author Group1 dmai0920
 * A class to represent the supplier in the system
 */
public class Supplier
{
	//Fields for Supplier
	private String name;
	private String address;
	private String zipcode;
	private String city;
	private String country;
	private String phoneNumber;
	private String email;
	
	/**
	 * General constructor with all fields
	 */
	public Supplier(String name, String address, String zipcode, String city, String country, String phoneNumber, String email) 
	{
		this.name = name;
		this.address = address;
		this.country = country;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.zipcode = zipcode;
		this.city = city;
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

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
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
}
