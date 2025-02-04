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

class TestCustomerController {

	CustomerController customerCtr;
	
	@BeforeEach
	void setUp() throws Exception {
		customerCtr = new CustomerController();
		customerCtr.setStub(new CustomerDBStub());
	}

	// FC1
	@Test
	void testFindValidCustomerByPhoneNumber() throws SQLException, CustomerNotFoundException, InvalidPhoneNumberException
	{
		Customer actualCustomer = new PrivateCustomer("Jan", "Jensen", 1, "test@gmail.com", "12345678", "Denmark", "9000", "Aalborg", "Vesterbro", "79");
		Customer returnedCustomer = customerCtr.findCustomerByPhone("12345678");
		assertEquals(1, returnedCustomer.getId());
		assertArrayEquals(returnedCustomer.infoToArray(), actualCustomer.infoToArray());
	}

	// FC2
	@Test
	void testCustomerWithPhone12345677DoesntExist()
	{
		assertThrows(CustomerNotFoundException.class , () -> {customerCtr.findCustomerByPhone("12345677");});
	}

	// FC3
	@Test
	void testInvalidCharactersInPhoneThrowsException()
	{
		assertThrows(InvalidPhoneNumberException.class , () -> {customerCtr.findCustomerByPhone("Nails, hair, hips, heels");});
	}
	
	//FC4
	@Test
	void testPhoneNumberTooLongShouldThrowException()
	{
		assertThrows(InvalidPhoneNumberException.class , () -> {customerCtr.findCustomerByPhone("12345678912345678");});
	}

	//FC5
	@Test
	void testPhoneNumberTooShortShouldThrowException()
	{
		assertThrows(InvalidPhoneNumberException.class , () -> {customerCtr.findCustomerByPhone("123");});
	}
}
