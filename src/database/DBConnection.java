package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

<<<<<<< Updated upstream
public class DBConnection 
{
=======
/**
 * This class is the Database Connection class
 * used in the "Western Style Ltd" System.
 * 
 * Author: Group 1
 * Version: 1
 */

public class DBConnection {
>>>>>>> Stashed changes
	private Connection connection = null;
	private static DBConnection dbConnection;
	
	private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DATABASE_NAME = "dmai0920_1028757";
	private static final String SERVER_ADDRESS = "hildur.ucn.dk";
	private static final int    SERVER_PORT = 1433;
	private static final String USER_NAME = "dmai0920_1028757";
	private static final String PASSWORD = "Password1!";
	
	private DBConnection() 
	{
		String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s", 
				SERVER_ADDRESS, SERVER_PORT, DATABASE_NAME, USER_NAME, PASSWORD);
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
		catch (SQLException e) 
		{
			System.err.println("Could not connect to database " + DATABASE_NAME + "@" + SERVER_ADDRESS + ":" + SERVER_PORT + " as user " + USER_NAME + " using password ******");
			System.out.println("Connection string was: " + connectionString.substring(0, connectionString.length() - PASSWORD.length()) + "....");
			e.printStackTrace();
		}
	}
	
	public static DBConnection getInstance() 
	{
		if(dbConnection == null) 
		{
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	
	public void startTransaction() throws SQLException 
	{
		connection.setAutoCommit(false);
	}
	
	public void commitTransaction() throws SQLException 
	{
		connection.commit();
		connection.setAutoCommit(true);
	} 
	
	public void rollbackTransaction() throws SQLException 
	{
		connection.rollback();
		connection.setAutoCommit(true);
	}
	
	public int executeInsertWithIdentity(PreparedStatement ps) throws SQLException  
	{
		int res = -1;
		try 
		{
			res = ps.executeUpdate();
			if(res > 0) 
			{
				ResultSet rs = ps.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}
		return res;
	}
	
	public int executeInsertWithIdentity(String sql) throws SQLException  
	{
		System.out.println("DBConnection, Inserting: " + sql);
		int res = -1;
		try (Statement s = connection.createStatement()) 
		{
			res = s.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
			if(res > 0) 
			{
				ResultSet rs = s.getGeneratedKeys();
				rs.next();
				res = rs.getInt(1);
			}
			//s.close(); -- the try block does this for us now

		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}
		return res;
	}
	
	public int executeUpdate(String sql) throws SQLException 
	{
		System.out.println("DBConnection, Updating: " + sql);
		int res = -1;
		try (Statement s = connection.createStatement())
		{
			res = s.executeUpdate(sql);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			throw e;
		}
		return res;
	}
	
	/*
	 * Heyo, we need this method
	 */
	public Connection getConnection() 
	{
		return connection;
	}
	
	public void disconnect() 
	{
		try 
		{
			connection.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
