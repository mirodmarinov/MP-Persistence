package model;

public class Customer
{
	private String name;
	private String address;
	private String zipcode;
	private String city;
	private String phoneNumber;
	private Type   type;
	
	public Customer(String name, String address, String zipcode, String city, String phoneNumber, Type type)
	{
		this.name = name;
		this.address = address;
		this.zipcode = zipcode;
		this.city = city;
		this.phoneNumber = phoneNumber;
		this.type = type;
	}
}
