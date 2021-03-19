package control;

import java.sql.SQLException;

import database.CustomerDB;
import database.CustomerDBIF;
import model.Customer;

/**
 * @author Group1 dmai0920
 * Handles the customer logic
 */
public class CustomerController
{
	//Fields
	private CustomerDBIF customerDB; 

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
	
	/**
	 * Used for testing purposes, using Scaffolding and customerDB.
	 * @param customerDB
	 */
	public void setCustomerDB (CustomerDBIF customerDB)
	{
		this.customerDB = customerDB;
	}

}
