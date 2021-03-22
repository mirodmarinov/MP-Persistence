package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import exceptions.*;
import database.*;
import control.*;

class TestOrderController
{
	
	OrderController orderCtr;
	ProductDBStub productDB;
	CustomerDBStub customerDB;

	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
	}

	@BeforeEach
	void setUp() throws Exception
	{
		//Arrange
		orderCtr = new OrderController();
		productDB = new ProductDBStub();
		customerDB = new CustomerDBStub();
		orderCtr.setStub(new OrderDBStub(), productDB, customerDB);
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	// APO1 
	@Test
	void shouldAddProductToOrderWithMaxAmount() throws Exception
	{
		//Arrange
		orderCtr.findProductByNumber(1);
		
		//Act
		boolean result = orderCtr.addProductToOrder(1, 20);
		
		//Assert
		assertEquals(true, result);
	}
	
	// APO2
	@Test
	void addingMoreThanInStockShouldThrowStockNotEnoughException() throws Exception
	{
		//Arrange
		orderCtr.findProductByNumber(1);
		
		//Act & Assert
		assertThrows(NotEnoughStockException.class, () -> {
			orderCtr.addProductToOrder(1, 21);
		  });
	}
	
	// APO3
	@Test
	void shouldThrowInvalidAmountException() throws Exception
	{
		//Arrange
		orderCtr.findProductByNumber(1);
		
		//Act & Assert
		assertThrows(InvalidAmountException.class, () -> {
			orderCtr.addProductToOrder(1, 0);
		  });
	}
	
	
	// CO1
	@Test
	void testCreateOrder() throws SQLException, InvalidProductNumberException, ProductNotFoundException, InvalidAmountException, NotEnoughStockException, CustomerNotFoundException, InvalidPhoneNumberException
	{
		//Arrange
		orderCtr.findCustomerByPhone("12345678");
		orderCtr.findProductByNumber(1);
		orderCtr.addProductToOrder(1, 20);
		
		// Act
		String[] returnedInfo = orderCtr.createOrder();
		
		// Assert
		assertArrayEquals(new String[]{orderCtr.generateInvoice(), orderCtr.generateDeliveryNotes()},returnedInfo);
	}
	
	
	// CO2
	@Test
	void testClearOrder() throws SQLException, InvalidProductNumberException, ProductNotFoundException, InvalidAmountException, NotEnoughStockException, CustomerNotFoundException, InvalidPhoneNumberException
	{
		//Arrange
		orderCtr.findCustomerByPhone("12345678");
		orderCtr.findProductByNumber(1);
		orderCtr.addProductToOrder(1, 20);
		
		//Act
		orderCtr = new OrderController();
		
		//Assert
		assertThrows(NullPointerException.class , () -> {orderCtr.createOrder();});	
	}
}
