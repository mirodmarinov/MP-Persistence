/**
 * 
 */
package database;

import java.math.BigDecimal;
import java.sql.SQLException;

import model.*;

/**
 * @author Group1 dmai0920
 * A productDB stub used for Test scaffolding.
 *
 */
public class ProductDBStub implements ProductDBIF {
	
	public Product pumpkin = new Clothing("38", "red", 1, "Sexy Pumpkin", "Topless Pumpkin", 20, 2,new BigDecimal(1000), new BigDecimal(1200), new BigDecimal(400), "USA", new Supplier(100, "name", "phone", "mail", "contry", "zip", "city", "ste", "20"));

	/**
	 * Used for testing purposes. Returns fictional data from a fictional database
	 */
	@Override
	public Product findProductByNumber(int productNumber) throws SQLException {
		if(productNumber == 1)
		{
			return pumpkin;
		}
		else if(productNumber == 2)
		{
			return new Equipment("Construction", 2, "Nails", "Big nails", 100, 30, new BigDecimal(100), new BigDecimal(120), new BigDecimal(10), "Denmark", new Supplier(100, "name", "phone", "mail", "contry", "zip", "city", "ste", "20"));
		}
		else if(productNumber == 3) 
		{
			return new GunReplica("40mm", "iron", 3, "Sawoff Shotgun", "Shotgun with 2 barrels", 10, 2, new BigDecimal(1000), new BigDecimal(1200), new BigDecimal(400), "USA", new Supplier(100, "name", "phone", "mail", "contry", "zip", "city", "ste", "20"));
		}
		return null;
	}
}
