package control;

import java.sql.SQLException;
import java.util.ArrayList;

import exceptions.InvalidAmountException;
import exceptions.NotEnoughStockException;
import model.Customer;
import model.OrderLineItem;
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
	Product product;
	Customer customer;
	ArrayList<OrderLineItem> orderLineItems;

	/**
	 * General constructor setting the fields
	 * @throws SQLException
	 */
	public OrderController() throws SQLException //TODO check exception
	{
		customerCtr = new CustomerController();
		orderLineItems = new ArrayList<>();
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
		this.customer = customer;
		customerInfo = customer.infoToArray();

		return customerInfo;
	}
	
	/**
	 * This method calls the Product controller and creates a string array containing all the necessary information for GUI purposes
	 * @param productNumber
	 * @return
	 * @throws SQLException
	 */
	public String[] findProductByNumber(int productNumber) throws SQLException
	{
		String[] productCopyInfo;
		
		Product productCopy = productCtr.findProductByNumber(productNumber);
		this.product = productCopy;
		productCopyInfo = productCopy.infoToArray();
		
		return productCopyInfo;
	}
	
	public boolean addProductToOrder(int productNumber, int amount) throws InvalidAmountException, NotEnoughStockException
	{
		boolean added = false;
		
		if(this.product.getProductNumber() == productNumber)
		{
			OrderLineItem orderLineItem = new OrderLineItem(this.product, amount);
			added = orderLineItems.add(orderLineItem);
		}
		
		return added;
	}
	//TODO - not sure if finished, check later
}
