package database;

import java.sql.SQLException;

import model.Product;

/**
 * @author Group1 dmai0920
 * An interface used by the ProductDB
 * Part of the DAO pattern
 */
public interface ProductDBIF
{
	Product findProductByNumber(String productNumber) throws SQLException; //TODO - check exceptions
}
