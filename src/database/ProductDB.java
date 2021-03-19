package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Product;

public class ProductDB implements ProductDBIF
{
	private Connection connection;
	
	private static final String FIND_BY_NUMBER = String.format("");
	PreparedStatement psFindByNumber;

	public ProductDB()
	{
		connection = DBConnection.getInstance().getConnection();
		
	}

	@Override
	public Product findProductByNumber(String productNumber)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
