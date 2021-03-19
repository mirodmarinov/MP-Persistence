package model;

public class PrivateCustomer extends Customer {

	private String firstName;
	private String lastName;
	
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
