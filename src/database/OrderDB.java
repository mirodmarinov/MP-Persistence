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
			
	private static final String INSERT_ORDER_LINE_ITEM = String.format("INSERT INTO OrderLineItem"
			+ "VALUES (?,?,?)");
	private PreparedStatement sqlInsertOrderLineItem;
	
	private static final String UPDATE_PRODUCT_STOCK = String.format("UPDATE PRODUCT"
			+ "SET stock = stock - ?"
			+ "WHERE number = ?");
	private PreparedStatement sqlUpdateProductStock;
	
	public OrderDB() throws SQLException {
		connection = DBConnection.getInstance().getConnection();
		sqlCreateOrder = connection.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
		sqlInsertOrderLineItem = connection.prepareStatement(INSERT_ORDER_LINE_ITEM, Statement.RETURN_GENERATED_KEYS);
		sqlUpdateProductStock = connection.prepareStatement(UPDATE_PRODUCT_STOCK);
	}
	/**
	 * Creates an order in the database
	 */
	@Override
	public Order create(Customer customer, ArrayList<OrderLineItem> orderLineItems, BigDecimal totalPrice, BigDecimal discount) throws SQLException
	{
		Order createdOrder = null;
		int orderID;
		try
		{
			//Start a transaction when creating an order
			DBConnection.getInstance().startTransaction();
	
			sqlCreateOrder.setString(1, LocalDate.now().toString());
			sqlCreateOrder.setNull(2, Types.VARCHAR);
			sqlCreateOrder.setString(3, "PENDING");
			sqlCreateOrder.setInt(4, customer.getId());
			sqlCreateOrder.setNull(5, Types.VARCHAR);
			sqlCreateOrder.setBigDecimal(6, discount);
			sqlCreateOrder.setBigDecimal(7, totalPrice);
			
			boolean executed = sqlCreateOrder.execute(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = sqlCreateOrder.getGeneratedKeys();
			if(executed && rs.next())
			{
				orderID = rs.getInt(1);
				for (OrderLineItem addedProduct: orderLineItems)
				{
					sqlInsertOrderLineItem.setInt(1, orderID);
					sqlInsertOrderLineItem.setInt(2, addedProduct.getProduct().getProductNumber());
					sqlInsertOrderLineItem.setInt(2, addedProduct.getQuantity());
					sqlInsertOrderLineItem.execute(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS);
					
					sqlUpdateProductStock.setInt(1, addedProduct.getQuantity());
					sqlUpdateProductStock.execute(UPDATE_PRODUCT_STOCK);
				}
				
				createdOrder = new Order(orderID, LocalDate.now().toString(), null, null, Status.PENDING, customer, orderLineItems, discount, totalPrice);
				
				//Commit transaction
				DBConnection.getInstance().commitTransaction();
			}
		}
		catch (Exception e)
		{
			DBConnection.getInstance().rollbackTransaction();
		}
		return createdOrder;
	}
	
	/*public Order buildObject(ResultSet rs) throws SQLException 
	{
		Customer customer = new CustomerDB().findCustomerByID(""); // get the customer by id
		ArrayList<OrderLineItem> products = null; //Get the orderline items
		Status status = Status.valueOf(rs.getString("status"));
		
		return new Order(rs.getInt("orderNumber"), rs.getString("orderDate"), rs.getString("deliveryDate"), rs.getString("paymentDate"),
						status, customer, products, (BigDecimal)rs.getObject("discount"),
						(BigDecimal)rs.getObject("totalPrice"));
	}
	
	public OrderLineItem buildOrderLineItem(ResultSet rs) throws SQLException
	{
		Product product = null;
		return new OrderLineItem(product, rs.getInt("quantity"));
	}*/
	
}
