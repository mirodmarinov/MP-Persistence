package control;

import java.sql.SQLException;
import java.util.ArrayList;

import database.OrderDB;
import exceptions.CustomerNotFoundException;
import exceptions.InvalidAmountException;
import exceptions.InvalidPhoneNumberException;
import exceptions.InvalidProductNumberException;
import exceptions.NotEnoughStockException;
import exceptions.ProductNotFoundException;
import model.*;
import java.math.BigDecimal;

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
	OrderDB orderDB;
	ArrayList<OrderLineItem> orderLineItems;

	/**
	 * General constructor setting the fields
	 * @throws SQLException
	 */
	public OrderController() throws SQLException //TODO check exception
	{
		customerCtr = new CustomerController();
		orderDB = new OrderDB();
		orderLineItems = new ArrayList<>();
	}

	/**
	 * A method to get a customer by phone from the Customer controller
	 * @param phone
	 * @return
	 * @throws SQLException
	 * @throws InvalidPhoneNumberException 
	 * @throws CustomerNotFoundException 
	 */
	public String[] findCustomerByPhone(String phone) throws SQLException, CustomerNotFoundException, InvalidPhoneNumberException
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
	 * @throws InvalidProductNumberException 
	 * @throws ProductNotFoundException 
	 */
	public String[] findProductByNumber(int productNumber) throws SQLException, InvalidProductNumberException, ProductNotFoundException
	{
		String[] productCopyInfo;
		
		Product productCopy = productCtr.findProductByNumber(productNumber);
		this.product = productCopy;
		productCopyInfo = productCopy.infoToArray();
		
		return productCopyInfo;
	}
	/**
	 *	Adding a product to the ArrayList of OrderLineItems 
	 * @param productNumber
	 * @param amount
	 * @return a boolean success value
	 * @throws InvalidAmountException
	 * @throws NotEnoughStockException
	 */
	public boolean addProductToOrder(int productNumber, int amount) throws InvalidAmountException, NotEnoughStockException
	{
		boolean added = false;
		
		if(this.product.getProductNumber() == productNumber)
		{
			OrderLineItem orderLineItem = new OrderLineItem(this.product, amount);
			added = orderLineItems.add(orderLineItem);
			this.product = null;
		}
		
		return added;
	}
	
	public String[] createOrder() throws SQLException
	{
		Order order = orderDB.create(customer, orderLineItems, getCustomerDiscount(), getTotalPrice()); //TODO Check discount
		String[] info = {generateInvoice(), generateDeliveryNotes()};
		return info;
	}
	
	/** TODO add to DCD /!\
	 * A method to calculate the total price from the selected products
	 * @return total
	 */
	private BigDecimal getCustomerDiscount()
	{
		return null;
	}
	
	/** TODO add to DCD /!\
	 * A method to calculate the total price from the selected products
	 * @return total
	 */
	private BigDecimal getTotalPrice()
	{
		BigDecimal total = new BigDecimal(0);
		for(int index = 0; index < orderLineItems.size(); index++)
		{
			Product product = orderLineItems.get(index).getProduct();
			BigDecimal quantity = new BigDecimal(orderLineItems.get(index).getQuantity());
			total.add(product.getSalesPrice()).multiply(quantity);
		}
		return total;
	}
	
	/** TODO add to DCD /!\
	 * A method to generate the invoice
	 * @return
	 */
	private String generateInvoice()
	{
		return "";
	}
	
	/** TODO add to DCD /!\
	 * A method to generate the delivery notes
	 * @return
	 */
	private String generateDeliveryNotes()
	{
		return "";
	}
}
