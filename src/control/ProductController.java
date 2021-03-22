package control;

import java.sql.SQLException;



import database.ProductDBIF;
import exceptions.ExceptionMessages;
import database.ProductDB;
import model.*;
import exceptions.*;

public class ProductController 
{
	//Fields
	private ProductDBIF productDB; 
	
	//Constructor
	public ProductController() throws SQLException
	{
		productDB = new ProductDB();
	}
	
	/**
	 * This method calls the ProductController to find a product based on its number in the database
	 * @param productNumber
	 * @return Product
	 * @throws SQLException,InvalidProductNumberException,ProductNotFoundException
	 */
	public Product findProductByNumber(int productNumber) throws SQLException, InvalidProductNumberException, ProductNotFoundException
	{
		if(productNumber < 0)
		{
			throw new InvalidProductNumberException(ExceptionMessages.INVALID_PRODUCT_NUMBER);
		}
		Product productCopy = null;
		productCopy = productDB.findProductByNumber(productNumber);
		if(productCopy == null)
		{
			throw new ProductNotFoundException(ExceptionMessages.NO_PRODUCT_FOUND);
		}
		return productCopy;
	}
	
	public void setStub(ProductDBIF productDB)
	{
		this.productDB = productDB;
	}
}
