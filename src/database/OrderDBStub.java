package database;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import model.Customer;
import model.Order;
import model.OrderLineItem;
import model.Status;

public class OrderDBStub implements OrderDBIF {

	
	@Override
	public Order create(Customer customer, ArrayList<OrderLineItem> orderLineItems, BigDecimal totalPrice,
			BigDecimal discount) throws SQLException {
		//returning an arbitrary orderId
		return new Order(1, LocalDate.now().toString(), null, null, Status.PENDING, customer, orderLineItems, discount, totalPrice);
	}
	
}
