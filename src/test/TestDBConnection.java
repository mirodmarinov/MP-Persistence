package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Order;

import database.*;
import model.*;
import control.*;
import exceptions.*;

class TestDBConnection
{
	static Connection connection;
	CustomerController customerCtr;
	CustomerDB customerDB;
	Customer customer;
	
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

	@AfterAll
	static void tearDown() throws Exception
	{
		
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
	
	@Disabled
	@Order(1)
	void testInsertingIntoDB() throws SQLException
	{
		
		String sql = "INSERT INTO Customer VALUES('01', 'Denmark', 'Aalborg', '9000','Annerbergvej', '110', 'anneberg@info.dk')";
		//String sqlinsertToPrivateQuestomer = "INSERT INTO PrivateCustomer VALUES(6, 'Hanne', 'Thejlgård')";
		Statement s = connection.createStatement();
		assertEquals(s.executeUpdate(sql), 1);
		ResultSet generatedKeys = s.getGeneratedKeys();
		if (generatedKeys.next())
		{
			String sqlinsertToPrivateQuestomer = "INSERT INTO PrivateCustomer VALUES("+ generatedKeys.getLong(1) + ", 'Hanne', 'Thejlgård')";
			assertEquals(s.executeUpdate(sqlinsertToPrivateQuestomer), 1);
		}
		else
		{
			fail();
		}
		
		
	}
	
	@Test
	@Order(2)
	void testRetrieveInformationFromDatabaseLayer() throws SQLException
	{
		customer = (PrivateCustomer) customerDB.findCustomerByPhone("01"); // TODO Idk we have no information in the DB
		assertNotNull(customer);
	}
	
	@Test
	@Order(3)
	void deleteDataFromDatabase() throws SQLException
	{
		Statement s = connection.createStatement();
		assertEquals(1,s.executeUpdate("DELETE FROM Customer WHERE id = " + customer.getId()));
		assertEquals(1,s.executeUpdate("DELETE FROM PrivateCustomer WHERE customer_id = " + customer.getId()));
		
	}
	
	@Disabled
	void testRetrieveInformationFromControlLayer() throws SQLException, CustomerNotFoundException, InvalidPhoneNumberException
	{
		customerCtr.findCustomerByPhone(""); // TODO Idk we have no information in the DB
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
				System.out.println("Connected");
			} 
			catch (ClassNotFoundException e) 
			{
				System.err.println("Could not load JDBC driver");
				e.printStackTrace();
			} 
			/*catch (SQLException e) 
			{
				System.err.println("Could not connect to database " + DATABASE_NAME + "@" + SERVER_ADDRESS + ":" + SERVER_PORT + " as user " + USER_NAME + " using password ******");
				System.out.println("Connection string was: " + connectionString.substring(0, connectionString.length() - PASSWORD.length()) + "....");
				e.printStackTrace();
			}*/
		});
	}
}

