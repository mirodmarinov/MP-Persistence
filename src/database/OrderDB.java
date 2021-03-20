package database;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

import java.math.BigDecimal;

import model.*;

public class OrderDB implements OrderDBIF {

	private Connection connection;
	
	private static final String INSERT_ORDER = String.format("INSERT INTO Order"
			+ "VALUES (?,?,?,?,?,?)");
	private PreparedStatement sqlCreateOrder;
	
	public OrderDB() throws SQLException {
		connection = DBConnection.getInstance().getConnection();
		sqlCreateOrder = connection.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
	}
	
	@Override
	public Order create(Customer customer, ArrayList<OrderLineItem> orderLineItems) throws SQLException {
		/*Order(int orderNumber, String orderDate, String deliveryDate, String paymentDate,
				Status status, Customer customer, ArrayList<OrderLineItem> products, BigDecimal discount, BigDecimal totalPrice)*/

		DBConnection.getInstance().startTransaction();

		sqlCreateOrder.setString(1, LocalDate.now().toString());
		sqlCreateOrder.setNull(2, Types.VARCHAR);
		sqlCreateOrder.setNull(3, Types.VARCHAR);
		sqlCreateOrder.setInt(4, customer.getId());
		sqlCreateOrder.setNull(5, Types.VARCHAR);
		sqlCreateOrder.setBigDecimal(6, new BigDecimal(1));
		sqlCreateOrder.setString(7, "");
		
		return buildObject(null);
	}
	
	public Order buildObject(ResultSet rs) throws SQLException 
	{
		Order order = null;
		Customer customer = null; // TODO Find by ID
		ArrayList<OrderLineItem> products = null; // TODO ummm
		Status status = Status.valueOf(rs.getString("status"));
		
		order = new Order(rs.getInt("orderNumber"), rs.getString("orderDate"), rs.getString("deliveryDate"), rs.getString("paymentDate"),
						status, customer, products, (BigDecimal)rs.getObject("discount"),
						(BigDecimal)rs.getObject("totalPrice"));
		
		return order;
	}
}
