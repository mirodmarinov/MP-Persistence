package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import database.DBConnection;

class TestDBConnection
{

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
}

