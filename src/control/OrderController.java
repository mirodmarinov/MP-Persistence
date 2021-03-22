package control;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import database.CustomerDBIF;
import database.OrderDB;
import database.OrderDBIF;
import database.ProductDBIF;
import exceptions.*;
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
	OrderDBIF orderDB;
	ArrayList<OrderLineItem> orderLineItems;

	/**
	 * General constructor setting the fields
	 * @throws SQLException
	 */
	public OrderController() throws SQLException //TODO check exception
	{
		customerCtr = new CustomerController();
		productCtr = new ProductController();
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
	
	/**
	 * A method to calculate the total price from the selected products
	 * @return total
	 */
	private BigDecimal getCustomerDiscount() 
	{ 
		BigDecimal customerDiscount = new BigDecimal(0);
		if (customer instanceof PrivateCustomer) 
		{
			customerDiscount = Order.DELIVERY_FEE;
		}
		else if (customer instanceof PrivateCustomer)
		{
			//TODO - what :D
		}
		return customerDiscount;
	}
	
	/**
	 * A method to calculate the total price from the selected products
	 * @return total
	 */
	private BigDecimal getTotalPrice()
	{
		BigDecimal total = new BigDecimal(0);
		for(int index = 0; index < orderLineItems.size(); index++)
		{
			Product product = orderLineItems.get(index).getProduct();
			BigDecimal amount = new BigDecimal(orderLineItems.get(index).getAmount());
			total.add(product.getSalesPrice()).multiply(amount);
		}
		
		//check if the current customer qualifies for a discount - i.e the threshold is less than the current total.
		if (customer.getThreshold().compareTo(total) == -1)
		{
			//calculating discount for privateCustomer
			if (customer instanceof PrivateCustomer) 
			{
				total.subtract(Order.DELIVERY_FEE);
			}
			//calculating discount for BusinessCustomers
			else if (customer instanceof BusinessCustomer)
			{
				total.subtract(BusinessCustomer.DISCOUNT);
			}
		}
		return total;
	}
	
	/**
	 * A method to generate the invoice
	 * @return
	 */
	private String generateInvoice()
	{
		BigDecimal discount = getCustomerDiscount();
		//Header
		StringBuilder invoice = new StringBuilder(
			"-=-=-=-=-=-=-= Western Style =-=-=-=-=-=-=-" +"\n"+
			"" 											  +"\n"+
			"Address: Aalborg, Denmark" 				  +"\n"+
			"phone: 0123456789" 					      +"\n"+
			"" 											  +"\n"+
			"-------------------------------------------" +"\n"+
			"No. 123/45"								  +"\n"+
			"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-" +"\n");
		//List of Products
		for(int index = 0; index < orderLineItems.size(); index++)
		{
			OrderLineItem oli = orderLineItems.get(index);
			invoice.append(
			oli.getAmount() + "x " + oli.getProduct().getName() + "	" + oli.getProduct().getSalesPrice().multiply(new BigDecimal(oli.getAmount())) + "\n");
		}
		//Footer
		invoice.append(
			"-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-" +"\n"+
			"Total: " + getTotalPrice() + " DKK"          +"\n"+
			((discount.compareTo(new BigDecimal(0)) == 0) ? "" : "Discount: ") +"\n"+
			"-------------------------------------------" +"\n"
		);
		return invoice.toString();
	}
	
	
	/**
	 * A method to generate the delivery notes
	 * @return
	 */
	private String generateDeliveryNotes()
	{
		String name;
		if(customer instanceof BusinessCustomer){
			name = ((BusinessCustomer)customer).getBusinessName();
		}
		else
		{
			name = ((PrivateCustomer)customer).getFirstName() + " " + ((PrivateCustomer)customer).getLastName();
		}
		String note = 
			"Western Stlye"    +"\n"+
			"Aalborg, Denmark" +"\n"+
			""                 +"\n"+
			"To: " + name      +"\n"+
			"Address: " + customer.getStreetname() + " " + customer.getHousenumber() + ", " + customer.getCity() + " " + customer.getZipcode() + ", " + customer.getCountry() + "\n"+
			"Date: " + LocalDate.now().toString() +"\n"+
			"Signature: _____________";
		return note;
	}
	
	public void setStub(OrderDBIF orderDB, ProductDBIF productDB, CustomerDBIF customerDB)
	{
		customerCtr.setStub(customerDB);
		productCtr.setStub(productDB);
		this.orderDB = orderDB;
		
	}
}
