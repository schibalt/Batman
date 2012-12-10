package com.batman.data.orderitems;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.batman.data.orderitems.OrderItems.OrderItem;
import com.google.appengine.api.rdbms.AppEngineDriver;

public class OrderItemsGoogleSqlDAO implements OrderItemsDAO
{
	private final static Logger log = Logger.getLogger(
			OrderItemsGoogleSqlDAO.class.getName(), null);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.batman.data.orders.OrderDAO#submitOrder(com.batman.data.orders.Order)
	 */
	@Override
	public boolean submitOrder(ArrayList<OrderItem> orderItems)
	{
		log.info("setOrder");
		Connection c = null;

		try
		{
			// Connect to the Google SQL Database
			DriverManager.registerDriver((new AppEngineDriver()));
			// This connection information should be moved to configuration
			c = DriverManager
					.getConnection("jdbc:google:rdbms://uakronbatcave:batcave/store");

			boolean transSuccess= true;
			
			for(OrderItem orderItem : orderItems)
			{
				// Set the order
				String query = "INSERT INTO OrderItems (orderguid, guid, quantity, price) VALUES (?, ?, ?, ?)";
				PreparedStatement statement = c.prepareStatement(query);
				statement.setString(1, orderItem.getOrderGuid());
				statement.setString(2, orderItem.getItemGuid());
				statement.setLong(3, orderItem.getQuantity());
				statement.setDouble(4, orderItem.getPrice());
				int success = 2;
				success = statement.executeUpdate();

				if (success != 1)
					transSuccess = false;
			}

			if (transSuccess == true)
				log.info("Order successfully set!");
			else
				log.info("Failed to set Order!");
		}
		catch (SQLException e)
		{
			// Log the stack trace
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			log.severe(sw.toString());
		}
		finally
		{
			if (c != null)
				try
				{
					// Clean up the connection
					c.close();
				}
				catch (SQLException ignore)
				{
				}
		}
		return false;
	}
}