package model;

/**
 * @author Group1 dmai0920
 * A class to represent the orderlineitems. These items hold a reference to the
 * purchased product and the amount of it. Used to avoid redundancy in the system
 * by sotring the product only once.
 */
public class OrderLineItem
{
	//Fields of OrderLineItem
	private int     quantity;
	private Product product;
	
	/**
	 * General constructor with all fields
	 */
	public OrderLineItem(Product product, int quantity)
	{
		this.product  = product;
		this.quantity = quantity;
	}
	
	/**
	 * Getters and setters for all fields
	 */
	public int getQuantity()
	{
		return quantity;
	}

	public void setQuantity(int quantity)
	{
		this.quantity = quantity;
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
