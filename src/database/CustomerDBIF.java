package database;

import java.sql.SQLException;

import model.Customer;

public interface CustomerDBIF
{
	//TODO - replace exceptions
	Customer findCustomerByPhone(String phone) throws SQLException;	
}
