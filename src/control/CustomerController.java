package control;

import java.sql.SQLException;

import database.CustomerDB;
import database.CustomerDBIF;
import exceptions.*;
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
	 * @throws SQLException,CustomerNotFoundException,InvalidPhoneNumberException
	 */ 
	public Customer findCustomerByPhone(String phone) throws SQLException, CustomerNotFoundException, InvalidPhoneNumberException
	{
		phone.replaceAll(" ", "");
		if(phone.length() < 4 || phone.length() > 16)
		{
			throw new InvalidPhoneNumberException(ExceptionMessages.INVALID_PHONE_LENGHT + " Currenct lenght: " + phone.length());
		}
		try
		{
			if (phone.startsWith("+"))
			{	
				Integer.parseInt(phone.substring(1));
			}
			else
			{
				Integer.parseInt(phone);
			}
			
		}
		catch(Exception e)
		{
			throw new InvalidPhoneNumberException(ExceptionMessages.INVALID_PHONE_NUMBER);
		}
		
		Customer customer = customerDB.findCustomerByPhone(phone);
		if (customer == null)
		{
			throw new CustomerNotFoundException(ExceptionMessages.NO_CUSTOMER_FOUND);
		}
		return customerDB.findCustomerByPhone(phone);
	}
	
	/**
	 * Used for testing purposes, using Scaffolding and customerDB.
	 * @param customerDB
	 */
	public void setStub(CustomerDBIF customerDB)
	{
		this.customerDB = customerDB;
	}

}
