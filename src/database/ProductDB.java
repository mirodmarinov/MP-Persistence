package database;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.Product;

/**
 * @author Group1 dmai0920
 * A class used to access the database layer
 * Part of the DAO pattern
 */
public class ProductDB implements ProductDBIF
{
	//the connection the the database
	private Connection connection;
	
	//SQL queries used for prepared statements
	private static final String FIND_BY_NUMBER = String.format("");
	PreparedStatement psFindByNumber;

	/**
	 * General constructor doing the connection to the database
	 * and preparing the SQL statements
	 */
	public ProductDB()
	{
		connection = DBConnection.getInstance().getConnection();
		
	}
	
	/**
	 * Gets a specific product by ID
	 * @param productNumber
	 */
	@Override
	public Product findProductByNumber(String productNumber)
	{
		// TODO Auto-generated method stub
		return null;
	}

}
