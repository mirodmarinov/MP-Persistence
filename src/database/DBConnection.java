package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class is the Database Connection class
 * used in the "Western Style Ltd" System.
 * 
 * Uses Singleton pattern
 * 
 * @author Group1 dmai0920
 */
public class DBConnection 
{
	//All fields
	private Connection connection = null;
	private static DBConnection dbConnection;
	
	//These are the Credentials used to connect to the database
	private static final String DRIVER_CLASS = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String DATABASE_NAME = "dmai0920_1028757";
	private static final String SERVER_ADDRESS = "hildur.ucn.dk";
	private static final int    SERVER_PORT = 1433;
	private static final String USER_NAME = "dmai0920_1028757";
	private static final String PASSWORD = "Password1!";
	
	/**
	 * Constructor establishing the connection.
	 * Throws an exception if the connection fails
	 * 
	 */
	private DBConnection() 
	{
		String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s", 
				SERVER_ADDRESS, SERVER_PORT, DATABASE_NAME, USER_NAME, PASSWORD);
		try 
		{
			Class.forName(DRIVER_CLASS);
			System.out.println("Connection string is: " + connectionString.substring(0, connectionString.length() - PASSWORD.length()) + "....");
			connection = DriverManager.getConnection(connectionString);
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
	
	/**
	 * Getter for the single instance of the connection to the database
	 * @return
	 */
	public static DBConnection getInstance() 
	{
		if(dbConnection == null) 
		{
			dbConnection = new DBConnection();
		}
		return dbConnection;
	}
	
	/**
	 * Methods used for transactions
	 * @throws SQLException
	 */
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
	
	/**
	 * Executes a prepared statement where the ID is auto generated by SQL
	 * @param ps
	 * @return
	 * @throws SQLException
	 */
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
	
	/**
	 * Executes a SQL statement where the ID is auto generated by SQL
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
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
	
	/**
	 * Method to execute SQL scripts which cause update in the database
	 * @param sql
	 * @return
	 * @throws SQLException
	 */
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
	
	/**
	 * Gather method for the connection
	 * @return
	 */
	public Connection getConnection() 
	{
		return connection;
	}
	
	/**
	 * A method to close the connection to the database
	 */
	public void disconnect() 
	{
		try 
		{
			connection.close();
			//connection = null;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
}
