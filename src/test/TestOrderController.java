package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.*;
import exceptions.*;
import database.*;
import control.*;

class TestOrderController
{
	
	OrderController orderCtr;

	@BeforeAll
	static void setUpBeforeClass() throws Exception
	{
	}

	@BeforeEach
	void setUp() throws Exception
	{
		//Arrange
		orderCtr = new OrderController();
		orderCtr.setStub(new OrderDBStub(), new ProductDBStub(), new CustomerDBStub());
	}

	@AfterEach
	void tearDown() throws Exception
	{
	}

	@Test
	void testAddProductToOrder() throws Exception
	{
		//Arrange
		orderCtr.findProductByNumber(1);
		
		//Act
		boolean result = orderCtr.addProductToOrder(1, 20);
		
		//Assert
		assertEquals(result, true);
		//assertEquals()
	}
	
	@Test
	void testCreateOrder()
	{
		
	}
	
	

}
