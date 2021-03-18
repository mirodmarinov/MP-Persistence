package model;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * @author Group1 dmai0920
 * A Class to represent the orders in the system
 */
public class Order
{
	//Fields of order
	private int orderNumber;
	private String orderDate;
	private String deliveryDate;
	private String paymentDate;
	private Status status; //The status of the order
	private Customer customer;
	private ArrayList<OrderLineItem> products;
	private BigDecimal discount;
	private BigDecimal totalPrice;
	
	/**
	 * General Constructor with all fields
	 */
	public Order(int orderNumber, String orderDate, String deliveryDate, String paymentDate, Status status, Customer customer, ArrayList<OrderLineItem> products, BigDecimal discount, BigDecimal totalPrice)
	{
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.paymentDate = paymentDate;
		this.status = status;
		this.customer = customer;
		this.products = products;
		this.discount = discount;
		this.totalPrice = totalPrice;
	}

	/**
	 * Getters and setters for all fields
	 */
	public int getOrderNumber()
	{
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber)
	{
		this.orderNumber = orderNumber;
	}

	public String getOrderDate()
	{
		return orderDate;
	}

	public void setOrderDate(String orderDate)
	{
		this.orderDate = orderDate;
	}

	public String getDeliveryDate()
	{
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate)
	{
		this.deliveryDate = deliveryDate;
	}

	public String getPaymentDate()
	{
		return paymentDate;
	}

	public void setPaymentDate(String paymentDate)
	{
		this.paymentDate = paymentDate;
	}

	public Status getStatus()
	{
		return status;
	}

	public void setStatus(Status status)
	{
		this.status = status;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	public ArrayList<OrderLineItem> getProducts()
	{
		return products;
	}

	public void setProducts(ArrayList<OrderLineItem> products)
	{
		this.products = products;
	}

	public BigDecimal getDiscount()
	{
		return discount;
	}

	public void setDiscount(BigDecimal discount)
	{
		this.discount = discount;
	}

	public BigDecimal getTotalPrice()
	{
		return totalPrice;
	}

	public void setTotalPrice(BigDecimal totalPrice)
	{
		this.totalPrice = totalPrice;
	}
}
