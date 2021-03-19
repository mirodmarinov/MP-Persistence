package database;

import java.sql.SQLException;

import model.BusinessCustomer;
import model.Customer;
import model.PrivateCustomer;

/**
 * @author Group1 dmai0920
 * A Stub for the customer controller tests
 */
public class CustomerDBStub implements CustomerDBIF {

	@Override
	public Customer findCustomerByPhone(String phone) throws SQLException
	{
		if (phone == "12345678")
		{
			return new PrivateCustomer("Jan", "Jensen", 1, "test@gmail.com", "12345678", "Denmark", "9000", "Aalborg", "Vesterbro", "79");
		}
		else if (phone == "87654321")
		{
			return new BusinessCustomer("BusinessName", 1234, 1, "businessCust@gmail.com", "87654321", "Denamrk", "9000", "Aalborg", "Somethingvej", "79");
		}
		return null;
	}
}
