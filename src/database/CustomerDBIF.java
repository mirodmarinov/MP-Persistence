package database;

import java.sql.SQLException;

import model.Customer;

/**
 * @author Group1 dmai0920
 * This interface shows what methods we use in the CustomerDB class
 * Part of the DAO pattern
 */
public interface CustomerDBIF
{
	//TODO - replace exceptions
	Customer findCustomerByPhone(String phone) throws SQLException;	
}
