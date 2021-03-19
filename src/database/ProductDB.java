package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	private static final String FIND_BY_NUMBER = String.format("SELECT number, name, description, stock, minimum_stock, purchase_price, "
					+ "sales_price, rent_price, country_of_origin, supplier_id, category_number, size, colour, calibre, material, type "
					+ "FROM Product LEFT JOIN Clothing ON Product.number = Clothing.product_number LEFT JOIN GunReplica ON Product.number = "
					+ "GunReplica.product_number LEFT JOIN Equipment ON Product.number = Equipment.product_number WHERE number = ?");
	PreparedStatement psFindByNumber;
	/**
	 * General constructor doing the connection to the database
	 * and preparing the SQL statements
	 */
	public ProductDB() throws SQLException //TODO - check exception
	{
		connection = DBConnection.getInstance().getConnection();
		
		psFindByNumber = connection.prepareStatement(FIND_BY_NUMBER);
	}
	
	/**
	 * Gets a specific product by ID
	 * @param productNumber
	 */
	@Override
	public Product findProductByNumber(String productNumber) throws SQLException //TODO - check exception
	{
		Product product = null;
		
		psFindByNumber.setString(1, productNumber);
		ResultSet rs = psFindByNumber.executeQuery();
		
		if(rs.next())
		{
			product = buildObject(rs);
		}
		
		return product;
	}
	
	public Product buildObject(ResultSet rs) throws SQLException //TODO - check exception
	{
		Product product = null;
		int category = rs.getInt("category_number");
		
		switch(category)
		{
			case 1:
			{
				//product = new Clothing()
				break;
			}
			case 2:
			{
				
				break;
			}
			case 3:
			{
				
				break;
			}
			default:
			{
				//TODO - throw an exception
			}
		}
		
		
		return product;
	}

}
