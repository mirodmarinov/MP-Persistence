package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

import database.*;
import model.*;
import control.*;
import exceptions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TestDBConnection
{
	static Connection connection;
	CustomerController customerCtr;
	CustomerDB customerDB;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
		connection = DBConnection.getInstance().getConnection();
	}

	@BeforeEach
	void setUp() throws Exception
	{
		customerDB = new CustomerDB();
		customerCtr = new CustomerController();
		
	}

	@Test
	@Order(0)
	void testGetConnection() 
	{
		try 
		{
			connection = DBConnection.getInstance().getConnection();
			assertNotNull(connection);
		} 
		catch(Exception e)
		{
			fail("Issues with DBConnection");
		}	
	}
	
	@Test
	@Order(1)
	void testInsertingIntoDB() throws SQLException
	{
		
		String sql = "INSERT INTO Customer VALUES('11111111', 'Denmark', 'Aalborg', '9000','Annerbergvej', '110', 'anneberg@info.dk')";
		PreparedStatement s = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		assertEquals(s.executeUpdate(), 1);
		ResultSet generatedKeys = s.getGeneratedKeys();
		if (generatedKeys.next())
		{
			String sqlinsertToPrivateQuestomer = "INSERT INTO PrivateCustomer VALUES("+ generatedKeys.getLong(1) + ", 'Hanne', 'Thejlgård')";
			PreparedStatement sPrivate = connection.prepareStatement(sqlinsertToPrivateQuestomer);
			assertEquals(sPrivate.executeUpdate(), 1);
		}
		else
		{
			fail();
		}
	}
	
	@Test
	@Order(2)
	void testRetrieveInformationFromControlLayer() throws SQLException, CustomerNotFoundException, InvalidPhoneNumberException
	{
		assertNotNull(customerCtr.findCustomerByPhone("11111111"));
	}
	
	@Test
	@Order(3)
	void deleteFromTheDatabase() throws SQLException
	{
		Customer customer = customerDB.findCustomerByPhone("11111111");
		Statement s = connection.createStatement();
		assertEquals(1,s.executeUpdate("DELETE FROM PrivateCustomer WHERE customer_id = " + customer.getId()));
		assertEquals(1,s.executeUpdate("DELETE FROM Customer WHERE id = " + customer.getId()));
	}
	
	@Test
	@Order(4)
	void testInvalidLoginCredentialsDoesntConnectAndThrowsSQLException()
	{
		String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		String DATABASE_NAME = "VERY_WRONG_DATABASE_NAME";
		String SERVER_ADDRESS = "hildur.ucn.dk";
		int    SERVER_PORT = 1433;
		String USER_NAME = "dmai0920_1028757";
		String PASSWORD = "VERY_WRONG_PASSWORD";
	

		String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s", 
				SERVER_ADDRESS, SERVER_PORT, DATABASE_NAME, USER_NAME, PASSWORD);
		
		assertThrows(SQLException.class, () ->
		{	
			try 
			{
				Class.forName(DRIVER_CLASS);
				//System.out.println("Connection string is: " + connectionString.substring(0, connectionString.length() - PASSWORD.length()) + "....");
				connection = DriverManager.getConnection(connectionString);
				System.out.println("Test Connected");
			} 
			catch (ClassNotFoundException e) 
			{
				System.err.println("Could not load JDBC driver");
				e.printStackTrace();
			} 
		});
	}
}

