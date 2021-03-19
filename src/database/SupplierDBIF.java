package database;

import java.sql.SQLException;

import model.Supplier;

/**
 * This is an interface for the SupplierDB class
 * @author Group1 dmai0920
 *
 */
public interface SupplierDBIF
{
	Supplier findSupplierById(int id) throws SQLException; //TODO - check exception
}
