package control;

import java.sql.SQLException;

import model.Customer;

public class OrderController
{
	CustomerController customerCtr;

	public OrderController() throws SQLException //TODO check exception
	{
		customerCtr = new CustomerController();
	}

	public String[] findCustomerByPhone(String phone) throws SQLException //TODO fix exception
	{
		String[] customerInfo;
		
		Customer customer = customerCtr.findCustomerByPhone(phone);
		customerInfo = customer.infoToArray();

		return customerInfo;
	}
}
