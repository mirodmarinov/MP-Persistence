package model;

/**
 * @author Group1 dmai0920
 * This class represents the Customer in the system
 */
public class Customer
{
	//Fields for the Customer
	private String name;
	private String address;
	private String zipcode;
	private String city;
	private String phoneNumber;
	
	/**
	 * General constructor with all parameters for the Customer object
	 */
	public Customer(String name, String address, String zipcode, String city, String phoneNumber)
	{
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phoneNumber = phoneNumber;
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

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
}
