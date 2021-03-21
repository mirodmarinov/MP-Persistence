package database;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Order;
import model.OrderLineItem;
import model.Customer;

public interface OrderDBIF {

	//used to support the OrderDB class 
	Order create(Customer customer, ArrayList<OrderLineItem> orderLineItems,  BigDecimal totalPrice, BigDecimal discount) throws SQLException;
}
