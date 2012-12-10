package com.batman.data.items;

import java.util.*;
import java.io.*;
import java.sql.*;
import com.google.appengine.api.rdbms.AppEngineDriver;
import java.util.logging.*;

public class ItemGoogleSqlDAO implements ItemDAO {

    private final static Logger log = Logger.getLogger(
	    ItemGoogleSqlDAO.class.getName(), null);

    /*
     * (non-Javadoc)
     * 
     * @see com.batman.data.items.ItemDAO#getItems()
     */
    @Override
    public List<Item> getItems() {
	ArrayList<Item> items = new ArrayList<Item>();
	Connection c = null;

	try {
	    // Connect to the Google SQL Database
	    DriverManager.registerDriver((new AppEngineDriver()));

	    // This connection information should be moved to configuration
	    c = DriverManager
		    .getConnection("jdbc:google:rdbms://uakronbatcave:batcave/store");

	    // Get all of the Items
	    String query = "SELECT * from store.Items";
	    PreparedStatement statement = c.prepareStatement(query);
	    ResultSet result = statement.executeQuery();

	    // Populate the result to be returned from the result set
	    while (result.next()) {
		Item item = new Item();
		item.setGuid(result.getString("GUID"));
		item.setName(result.getString("Name"));
		item.setImage(result.getString("Image"));
		item.setPrice(result.getDouble("Price"));

		items.add(item);
	    }
	} catch (SQLException e) {
	    // Log the stack trace
	    StringWriter sw = new StringWriter();
	    e.printStackTrace(new PrintWriter(sw));
	    log.severe(sw.toString());
	} finally {
	    if (c != null)
		try {
		    // Clean up the connection
		    c.close();
		} catch (SQLException ignore) {
		}
	}

	return items;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.batman.data.items.ItemDAO#getItem(java.lang.String)
     */
    @Override
    public Item getItem(String guid) {
	Item item = new Item();
	Connection c = null;

	try {
	    // Connect to the Google SQL Database
	    DriverManager.registerDriver((new AppEngineDriver()));

	    // This connection information should be moved to configuration
	    c = DriverManager
		    .getConnection("jdbc:google:rdbms://uakronbatcave:batcave/store");

	    // Get all of the Items
	    String query = "SELECT * from store.Items where GUID = ? limit 1";
	    PreparedStatement statement = c.prepareStatement(query);
	    statement.setString(1, guid);

	    ResultSet result = statement.executeQuery();
	    result.next();

	    item.setGuid(result.getString("GUID"));
	    item.setName(result.getString("Name"));
	    item.setImage(result.getString("Image"));
	    item.setPrice(result.getDouble("Price"));
	} catch (SQLException e) {
	    // Log the stack trace
	    StringWriter sw = new StringWriter();
	    e.printStackTrace(new PrintWriter(sw));
	    log.severe(sw.toString());
	} finally {
	    if (c != null)
		try {
		    // Clean up the connection
		    c.close();
		} catch (SQLException ignore) {
		}
	}

	return item;
    }
}