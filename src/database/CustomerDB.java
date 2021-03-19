package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.BusinessCustomer;
import model.Customer;
import model.PrivateCustomer;

public class CustomerDB implements CustomerDBIF
{
	private Connection connection;
	
	private static final String FIND_BY_PHONE = String.format("SELECT id, phone_number, country, city, zip_code, street_name, house_number, email, "
					+ "first_name, last_name, business_name, cvr_number FROM Customer LEFT JOIN PrivateCustomer ON Customer.id = PrivateCustomer.customer_id "
					+ "LEFT JOIN BusinessCustomer ON Customer.id = BusinessCustomer.customer_id WHERE phone_number = ?");
	private PreparedStatement psFindByPhone;

	public CustomerDB() throws SQLException //TODO - possibly change exception
	{
		connection = DBConnection.getInstance().getConnection();
		
		psFindByPhone = connection.prepareStatement(FIND_BY_PHONE);
	}

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
