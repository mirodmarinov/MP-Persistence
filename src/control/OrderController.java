package control;

import java.sql.SQLException;

import model.Customer;
import model.Product;

/**
 * @author Group1 dmai0920
 * Handles the order logic
 */
public class OrderController
{
	//All fields
	CustomerController customerCtr;
	ProductController productCtr;

	/**
	 * General constructor setting the fields
	 * @throws SQLException
	 */
	public OrderController() throws SQLException //TODO check exception
	{
		customerCtr = new CustomerController();
	}

	/**
	 * A method to get a customer by phone from the Customer controller
	 * @param phone
	 * @return
	 * @throws SQLException
	 */
	public String[] findCustomerByPhone(String phone) throws SQLException //TODO fix exception
	{
		String[] customerInfo;
		
		Customer customer = customerCtr.findCustomerByPhone(phone);
		customerInfo = customer.infoToArray();

		return customerInfo;
	}
	
	public String[] findProductByNumber(int productNumber) throws SQLException
	{
		String[] productInfo;
		
		Product product = productCtr.findProductByNumber(productNumber);
		return null;
	}
}
