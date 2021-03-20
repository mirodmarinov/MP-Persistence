package database;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Order;
import model.OrderLineItem;
import model.Customer;

public interface OrderDBIF {

	Order create(Customer customer, ArrayList<OrderLineItem> orderLineItems) throws SQLException;
}
