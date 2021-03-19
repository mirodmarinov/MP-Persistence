package control;

import java.sql.SQLException;

import database.CustomerDB;
import model.Customer;

public class CustomerController
{
	private CustomerDB customerDB; 

	public CustomerController() throws SQLException //TODO - check exception
	{
		customerDB = new CustomerDB();
	}
	
	public Customer findCustomerByPhone(String phone) throws SQLException //TODO - check exception
	{
		Customer customer = null;
		
		customer = customerDB.findCustomerByPhone(phone);
		
		return customer;
	}

}
