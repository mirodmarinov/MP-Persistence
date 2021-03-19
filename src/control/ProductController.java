package control;

import java.sql.SQLException;


import database.ProductDB;
import model.Product;

public class ProductController 
{
	//Fields
	private ProductDB productDB; 
	
	//Constructor
	public ProductController() throws SQLException
	{
		productDB = new ProductDB();
	}
	
	/**
	 * This method calls the ProductController to find a product based on its number in the database
	 * @param productNumber
	 * @return Product
	 * @throws SQLException
	 */
	public Product findProductByNumber(int productNumber) throws SQLException
	{
		Product product = null;
		
		product = productDB.findProductByNumber(productNumber);
		
		return product;
	}
}
