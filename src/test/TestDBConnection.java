package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import database.*;
import model.*;
import control.*;
import exceptions.*;

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

	@AfterAll
	void tearDown() throws Exception
	{
		DBConnection.getInstance().disconnect();
	}

	
	@Test
	void testGetConnection() 
	{
		try 
		{
			Connection connection = DBConnection.getInstance().getConnection();
			assertNotNull(connection);
		} 
		catch(Exception e)
		{
			fail("Issues with DBConnection");
		}	
	}
	
	@Test
	void testInsertingIntoDB()
	{
		// TODO We don't have inserting in any of the DAOs iirc
		//customerDB.create(...)
	}
	
	@Test
	void testRetrieveInformationFromDatabaseLayer() throws SQLException
	{
		customerDB.findCustomerByPhone(""); // TODO Idk we have no information in the DB
	}
	
	@Test
	void testRetrieveInformationFromControlLayer() throws SQLException
	{
		customerCtr.findCustomerByPhone(""); // TODO Idk we have no information in the DB
	}
	
	@Test
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
				connection = DriverManager.getConnection(connectionString);
				System.out.println("Connection string is: " + connectionString.substring(0, connectionString.length() - PASSWORD.length()) + "....");
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

