package model;

/**
 * @author Group1 dmai0920
 * A class to represent the supplier in the system
 */
public class Supplier
{
	//Fields for Supplier
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String country;
	private String zipCode;
	private String city;
	private String streetName;
	private String houseNumber;
	
	/**
	 * General constructor with all fields
	 */
	public Supplier(int id, String name, String phoneNumber, String email, String country, String zipCode, String city, 
			String streetName, String houseNumber) 
	{
		this.id = id;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.country = country;
		this.zipCode = zipCode;
		this.city = city;
		this.streetName = streetName;
		this.houseNumber = houseNumber;
	}

	/**
	 * Getters and setters for all fields
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
}
