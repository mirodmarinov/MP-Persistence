package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

public class SupplierDB implements SupplierDBIF
{
	private Connection connection;
	
	private static final String FIND_BY_ID = String.format("SELECT * FROM Supplier WHERE id = ?");
	PreparedStatement psFindById;

	public SupplierDB() throws SQLException //TODO - check exception
	{
		connection = DBConnection.getInstance().getConnection();
		
		psFindById = connection.prepareStatement(FIND_BY_ID);
	}

	@Override
	public Supplier findSupplierById(int id) throws SQLException
	{
		Supplier supplier = null;

		psFindById.setInt(1, id);
		ResultSet rs = psFindById.executeQuery();
		
		if(rs.next())
		{
			supplier = buildObject(rs);
		}
		
		return supplier;
	}

	private Supplier buildObject(ResultSet rs) throws SQLException
	{
		Supplier supplier = null;
		supplier = new Supplier(rs.getInt("id"), rs.getString("name"), rs.getString("phone_number"), rs.getString("email"),
						rs.getString("country"), rs.getString("zip_code"), rs.getString("city"), rs.getString("street_name"),
						rs.getString("house_number"));
		return supplier;
	}

}
