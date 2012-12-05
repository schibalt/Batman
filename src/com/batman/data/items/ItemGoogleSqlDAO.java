package com.batman.data.items;
import java.util.*;
import java.io.*;
import java.sql.*;
import com.google.appengine.api.rdbms.AppEngineDriver;
import java.util.logging.*;

public class ItemGoogleSqlDAO {
	
	private final static Logger log = Logger.getLogger(ItemGoogleSqlDAO.class.getName(), null);
	
	/**
	 * Retrieve a set of all available items from the configured Google SQL Database
	 * @return
	 */
	public List<Item> getItems() {
		ArrayList<Item> items = new ArrayList<Item>();
		Connection c = null;
		try{
			// Connect to the Google SQL Database
			DriverManager.registerDriver((new AppEngineDriver()));
			// This connection information should be moved to configuration
			c = DriverManager.getConnection("jdbc:google:rdbms://uakronbatcave:batcave/store");
			
			// Get all of the Items
			String query = "SELECT * from Items";
			PreparedStatement statement = c.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			
			// Populate the result to be returned from the result set
			while(result.next()){
				Item item = new Item();
				item.setGuid(result.getString("GUID"));
				item.setName(result.getString("Name"));
				item.setImage(result.getString("Image"));
				item.setPrice(result.getDouble("Price"));
				items.add(item);
			}
		}
		catch(SQLException e){
			// Log the stack trace
			StringWriter sw = new StringWriter();
			e.printStackTrace(new PrintWriter(sw));
			log.severe(sw.toString());
		}
		finally{
			if(c!=null){
				try{
					// Clean up the connection
					c.close();
				} catch(SQLException ignore){}
			}
		}
		
		return items;
	}
}