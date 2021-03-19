package control;

import java.sql.SQLException;

import database.CustomerDB;
import model.Customer;

/**
 * @author Group1 dmai0920
 * Handles the customer logic
 */
public class CustomerController
{
	//Fields
	private CustomerDB customerDB; 

	/**
	 * General constructor setting the fields
	 * @throws SQLException
	 */
	public CustomerController() throws SQLException //TODO - check exception
	{
		customerDB = new CustomerDB();
	}
	
	/**
	 * Method to find the customer by phone
	 * @param phone
	 * @return
	 * @throws SQLException
	 */
	public Customer findCustomerByPhone(String phone) throws SQLException //TODO - check exception
	{
		return customerDB.findCustomerByPhone(phone);
	}

}
