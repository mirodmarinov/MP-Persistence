package database;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Clothing;
import model.Equipment;
import model.GunReplica;
import model.Product;
import model.Supplier;
import database.SupplierDB;

/**
 * @author Group1 dmai0920
 * A class used to access the database layer
 * Part of the DAO pattern
 */
public class ProductDB implements ProductDBIF
{
	SupplierDB supplierDB;
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
	public Product findProductByNumber(int productNumber) throws SQLException //TODO - check exception
	{
		Product product = null;
		
		psFindByNumber.setInt(1, productNumber);
		ResultSet rs = psFindByNumber.executeQuery();
		
		if(rs.next())
		{
			product = buildObject(rs);
		}
		
		return product;
	}
	
	/**
	 * This method created a Product object based on the ResultSet that was found, it checks the category numbers and creates a different
	 * type of product based on that number
	 * @param rs
	 * @return the created Product
	 * @throws SQLException
	 */
	public Product buildObject(ResultSet rs) throws SQLException //TODO - check exception
	{
		supplierDB = new SupplierDB();
		Product product = null;
		int category = rs.getInt("category_number");
		
		switch(category)
		{
			case 1:
			{
				product = new Clothing(rs.getString("size"), rs.getString("colour"),rs.getInt("number"), rs.getString("name"),
								rs.getString("description"),rs.getInt("stock"), rs.getInt("minimum_stock"), rs.getBigDecimal("purchase_price"),
								rs.getBigDecimal("sales_price"), rs.getBigDecimal("rent_price"), rs.getString("country_of_origin"), 
								supplierDB.findSupplierById(rs.getInt("supplier_id")));
				break;
			}
			case 2:
			{
				product = new Equipment(rs.getString("type"), rs.getInt("number"), rs.getString("name"),
								rs.getString("description"),rs.getInt("stock"), rs.getInt("minimum_stock"), rs.getBigDecimal("purchase_price"),
								rs.getBigDecimal("sales_price"), rs.getBigDecimal("rent_price"), rs.getString("country_of_origin"), 
								supplierDB.findSupplierById(rs.getInt("supplier_id")));
				break;
			}
			case 3:
			{
				product = new GunReplica(rs.getString("calibre"), rs.getString("material"), rs.getInt("number"), rs.getString("name"),
								rs.getString("description"),rs.getInt("stock"), rs.getInt("minimum_stock"), rs.getBigDecimal("purchase_price"),
								rs.getBigDecimal("sales_price"), rs.getBigDecimal("rent_price"), rs.getString("country_of_origin"), 
								supplierDB.findSupplierById(rs.getInt("supplier_id")));
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
