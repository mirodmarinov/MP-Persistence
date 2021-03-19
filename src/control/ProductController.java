package control;

import java.sql.SQLException;


import database.ProductDB;
import model.Product;

public class ProductController {


	//Fields
	private ProductDB productDB; 
	
	public ProductController() throws SQLException
	{
		productDB = new ProductDB();
	}
	
	public Product findProductByNumber(int productNumber) throws SQLException
	{
		String[] productInfo;
		return null;
		
	}
}
