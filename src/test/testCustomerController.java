package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import control.CustomerController;
import database.CustomerDBStub;
import model.*;
import exceptions.*;

class testCustomerController {

	CustomerController customerCtr;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		customerCtr = new CustomerController();
		customerCtr.setCustomerDB(new CustomerDBStub());
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFindValidCustomerByPhoneNumber() throws SQLException
	{
		Customer actualCustomer = new PrivateCustomer("Jan", "Jensen", 1, "test@gmail.com", "12345678", "Denmark", "9000", "Aalborg", "Vesterbro", "79");
		Customer returnedCustomer = customerCtr.findCustomerByPhone("12345678");
		assertEquals(1, returnedCustomer.getId());
		assertArrayEquals(returnedCustomer.infoToArray(), actualCustomer.infoToArray());
		assertEquals(actualCustomer, returnedCustomer);
	}

	@Test
	void testCustomerWithPhone11111111DoesntExist()
	{
		assertThrows(CustomerNotFoundException.class , () -> {customerCtr.findCustomerByPhone("12345677");});
	}
	
	@Test
	void testInvalidCharactersInPhoneThrowsException()
	{
		assertThrows(InvalidPhoneNumberException.class , () -> {customerCtr.findCustomerByPhone("Nails, hair, hips, heels");});
	}
	
	@Test
	void testPhoneNumberTooLongShouldThrowException()
	{
		assertThrows(InvalidPhoneNumberException.class , () -> {customerCtr.findCustomerByPhone("12345678912345678");});
	}

	@Test
	void testPhoneNumberTooShortShouldThrowException()
	{
		assertThrows(InvalidPhoneNumberException.class , () -> {customerCtr.findCustomerByPhone("123");});
	}
}
