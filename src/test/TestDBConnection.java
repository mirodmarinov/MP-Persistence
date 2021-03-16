package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.sql.Connection;
import database.DBConnection;

class DBConnectionTest {

	@Test
	void testGetConnection() {		
		try {
			Connection connection = DBConnection.getInstance().getConnection();
			assertNotNull(connection);
		} catch(Exception e){
			fail("Issues with DBConnection");
		}
	}
}
