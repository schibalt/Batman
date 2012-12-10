package com.batman.data.orders;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.google.appengine.api.rdbms.AppEngineDriver;

public class OrderGoogleSqlDAO implements OrderDAO
{
	private final static Logger log = Logger.getLogger(
			OrderGoogleSqlDAO.class.getName(), null);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.batman.data.orders.OrderDAO#submitOrder(com.batman.data.orders.Order)
	 */
	@Override
	public boolean submitOrder(Order order)
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

			// Set the order
			String query = "INSERT INTO Orders (guid, username, time, price) VALUES (?, ?, ?, ?)";
			PreparedStatement statement = c.prepareStatement(query);
			statement.setString(1, order.getGuid());
			statement.setString(2, order.getUsername());
			statement.setLong(3, order.getTime());
			statement.setDouble(4, order.getPrice());
			int success = 2;
			success = statement.executeUpdate();

			if (success == 1)
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
		return true;
	}
}