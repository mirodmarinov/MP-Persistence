package database;

import java.sql.SQLException;

import model.Supplier;

public interface SupplierDBIF
{
	Supplier findSupplierById(int id) throws SQLException; //TODO - check exception

}
