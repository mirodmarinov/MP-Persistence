package test;

import static org.junit.jupiter.api.Assertions.*;

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
	
	@Test
	void testCreateOrder()
	{
		
	}
}
