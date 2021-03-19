package model;

/**
 * @author Group1 dmai0920
 * A subclass to represent the Private type for the customer
 */
public class PrivateCustomer extends Customer {

	//All the new fields
	private String firstName;
	private String lastName;
	
	/**
	 * Generic constructor with all attributes, also calling the super class
	 */
	public PrivateCustomer(String firstName, String lastName, int id, String email, String phoneNumber, String country, String zipcode, String city,
			String streetname, String housenumber) {
		super(id, email, phoneNumber, country, zipcode, city, streetname, housenumber);
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Getters and setters for the fields. 
	 */
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String[] infoToArray()
	{
		String[] customerInfo = new String[] {String.valueOf(getId()), getEmail(), getPhoneNumber(), getCountry(), getZipcode(), 
						getCity(), getStreetname(), getHousenumber(), getFirstName(), getLastName()}; 
		
		return customerInfo;
	}
}
