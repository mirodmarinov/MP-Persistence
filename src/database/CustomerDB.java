package database;

import java.sql.*;

import model.BusinessCustomer;
import model.Customer;
import model.PrivateCustomer;

/**
 * @author Group1 dmai0920
 * A class used to access the database layer
 * Part of the DAO pattern
 */
public class CustomerDB implements CustomerDBIF
{
	//The connection the the database
	private Connection connection;
	
	//SQL queries used for prepared statements
	private static final String FIND_BY_PHONE = String.format("SELECT id, phone_number, country, city, zip_code, street_name, house_number, email, "
					+ "first_name, last_name, business_name, cvr_number FROM Customer LEFT JOIN PrivateCustomer ON Customer.id = PrivateCustomer.customer_id "
					+ "LEFT JOIN BusinessCustomer ON Customer.id = BusinessCustomer.customer_id WHERE phone_number = ?");
	private PreparedStatement psFindByPhone;

	/**
	 * General constructor doing the connection to the database
	 * and preparing the SQL statements
	 */
	public CustomerDB() throws SQLException //TODO - possibly change exception
	{
		connection = DBConnection.getInstance().getConnection();
		
		psFindByPhone = connection.prepareStatement(FIND_BY_PHONE);
	}

	/**
	 * Gets a specific customer by phone number
	 * @param phone
	 */
	@Override
	public Customer findCustomerByPhone(String phone) throws SQLException //TODO- check exception
	{
		Customer customer = null;
		
		psFindByPhone.setString(1, phone);
		ResultSet resultSet = psFindByPhone.executeQuery();
		
		if(resultSet.next())
		{
			customer = buildObject(resultSet);
		}
		
		return customer;
	}

	/**
	 * Builds a Java Object from database information
	 * @param resultSet
	 */
	private Customer buildObject(ResultSet resultSet) throws SQLException //TODO - check exception
	{
		Customer customer = null;
		
		if(resultSet.getString("first_name") != null)
		{
			customer = new PrivateCustomer(resultSet.getString("first_name"), resultSet.getString("last_name"), resultSet.getInt("id"), resultSet.getString("email"), resultSet.getString("phone_number"), resultSet.getString("country"), resultSet.getString("zip_code"), resultSet.getString("city"), resultSet.getString("street_name"), resultSet.getString("house_number"));
		}
		else if(resultSet.getString("cvr_number") != null)
		{
			customer = new BusinessCustomer(resultSet.getString("business_name"), resultSet.getInt("cvr_number"), resultSet.getInt("id"), resultSet.getString("email"), resultSet.getString("phone_number"), resultSet.getString("country"), resultSet.getString("zip_code"), resultSet.getString("city"), resultSet.getString("street_name"), resultSet.getString("house_number"));
		}
		
		return customer;
	}
}
