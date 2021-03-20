/**
 * 
 */
package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import control.CustomerController;
import control.ProductController;
import database.CustomerDBStub;
import database.ProductDBStub;

import java.math.BigDecimal;

import java.sql.SQLException;
import model.*;
import exceptions.*;
/**
 * @author Group1 dmai0920
 * A test Class for Product Controller
 *
 */
class TestProductController {

	ProductController productCtr;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		productCtr = new ProductController();
		productCtr.setProductDB(new ProductDBStub());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindProductByNumber() throws SQLException, InvalidProductNumberException, ProductNotFoundException {
		Product actualProduct = new Clothing("38", "red", 1, "Sexy Pumpkin", "Topless Pumpkin", 10, 2, new BigDecimal(1000), new BigDecimal(1200), new BigDecimal(400), "USA", new Supplier(100, "name", "phone", "mail", "contry", "zip", "city", "ste", "20"));
		Product returnedProduct = productCtr.findProductByNumber(1);
		assertEquals(1, returnedProduct.getProductNumber());
		assertArrayEquals(returnedProduct.infoToArray(), actualProduct.infoToArray());
		assertEquals(actualProduct, returnedProduct);
	}
	
	@Test
	void testProductWithId69420DoesntExistAndThrowsException()
	{
		assertThrows(ProductNotFoundException.class , () -> {productCtr.findProductByNumber(69420);});
	}
	
	@Test
	void testInvalidProductNumberShouldThrowException()
	{
		assertThrows(InvalidProductNumberException.class , () -> {productCtr.findProductByNumber(-1);});
	}

}
