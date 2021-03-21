package model;

import exceptions.ExceptionMessages;
import exceptions.InvalidAmountException;
import exceptions.NotEnoughStockException;

/**
 * @author Group1 dmai0920
 * A class to represent the orderlineitems. These items hold a reference to the
 * purchased product and the amount of it. Used to avoid redundancy in the system
 * by sorting the product only once.
 */
public class OrderLineItem
{
	//Fields of OrderLineItem
	private int amount;
	private Product product;
	
	/**
	 * General constructor with all fields
	 */
	public OrderLineItem(Product product, int amount) throws InvalidAmountException, NotEnoughStockException
	{
		this.product  = product;
		if(amount <= 0)
		{
			throw new InvalidAmountException("Amount must be atleast 1, please input a higher number.");
		}
		else if(amount > this.product.getStock())
		{
			throw new NotEnoughStockException(ExceptionMessages.NOT_ENOUGH_STOCK);
		}
		else
		{
			this.amount = amount;
		}
	}
	
	/**
	 * Getters and setters for all fields
	 */
	public int getQuantity()
	{
		return amount;
	}

	public void setQuantity(int quantity)
	{
		this.amount = quantity;
	}

	public Product getProduct()
	{
		return product;
	}

	public void setProduct(Product product)
	{
		this.product = product;
	}
}
