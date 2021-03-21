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
	/**
	 * Used as a support class for the ProductDB and the ProductDBStub
	 * @param productNumber
	 * @return
	 * @throws SQLException
	 */
	Product findProductByNumber(int productNumber) throws SQLException; //TODO - check exceptions
}
