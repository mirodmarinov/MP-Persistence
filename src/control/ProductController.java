package control;

import java.sql.SQLException;



import database.ProductDBIF;
import database.ProductDB;
import model.Product;

public class ProductController {


	//Fields
	private ProductDBIF productDB; 
	
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
