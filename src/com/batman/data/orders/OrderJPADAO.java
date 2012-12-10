package com.batman.data.orders;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.rdbms.AppEngineDriver;

public class OrderJPADAO implements OrderDAO {
    private final static Logger log = Logger.getLogger(
	    OrderJPADAO.class.getName(), null);

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.batman.data.orders.OrderDAO#submitOrder(com.batman.data.orders.Order)
     */
    @Override
    public boolean submitOrder(Order order) {
	/*
	 * // Connect to the Google SQL Database
	 * DriverManager.registerDriver((new AppEngineDriver()));
	 * 
	 * // This connection information should be moved to configuration
	 * Connection c = DriverManager
	 * .getConnection("jdbc:google:rdbms://uakronbatcave:batcave/store" );
	 * 
	 * String query = "SELECT * from store.Items"; PreparedStatement
	 * statement = c.prepareStatement(query); ResultSet result =
	 * statement.executeQuery();
	 */

	DatastoreService datastore = DatastoreServiceFactory
		.getDatastoreService();

	Entity orderEnt = new Entity("Order", order.getGuid());

	if (null == order.getUsername() || order.getUsername().length() <= 0
		|| order.getPrice() <= 0)
	    return false;

	// ... set properties ...
	//orderEnt.setProperty("guid", order.getGuid());
	orderEnt.setProperty("username", order.getUsername());
	orderEnt.setProperty("time", order.getTime());
	orderEnt.setProperty("price", order.getPrice());

	datastore.put(orderEnt);

	return true;
    }
}