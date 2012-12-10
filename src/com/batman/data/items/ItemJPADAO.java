package com.batman.data.items;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import com.batman.server.EMF;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.PreparedQuery;
import com.google.appengine.api.rdbms.AppEngineDriver;

//import com.google.appengine.api.datastore.Query;

public class ItemJPADAO implements ItemDAO {
    private final static Logger log = Logger.getLogger(
	    ItemGoogleSqlDAO.class.getName(), null);

    @Override
    public List<Item> getItems() {
	boolean populatingDatastore = false;

	if (populatingDatastore) {
	    try {
		// Connect to the Google SQL Database
		DriverManager.registerDriver((new AppEngineDriver()));

		// This connection information should be moved to configuration
		Connection c = DriverManager
			.getConnection("jdbc:google:rdbms://uakronbatcave:batcave/store");

		String query = "SELECT * from store.Items";
		PreparedStatement statement = c.prepareStatement(query);
		ResultSet result = statement.executeQuery();

		DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();

		while (result.next()) {
		    Entity item = new Entity("Item", result.getString("Name"));

		    // ... set properties ...
		    item.setProperty("GUID", result.getString("GUID"));
		    item.setProperty("Name", result.getString("Name"));
		    item.setProperty("Image", result.getString("Image"));
		    item.setProperty("Price", result.getDouble("Price"));

		    datastore.put(item);
		}
	    } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}

	EntityManager em = EMF.get().createEntityManager();
	List<Item> items;

	try {
	    Query q = em.createQuery("select t from Item t");
	    items = q.getResultList();
	} finally {
	    em.close();
	}

	log.info("Hello, JPA. We have " + items.size() + " number of entries.");

	for (Item item : items)
	    System.out.println(item.getName());

	return items;
    }

    @Override
    public Item getItem(String guid) {
	EntityManager em = EMF.get().createEntityManager();
	Item item;

	log.info("querying for guid \'" + guid + "\'");

	try {
	    CriteriaBuilder cb = em.getCriteriaBuilder();

	    CriteriaQuery<Item> q = cb.createQuery(Item.class);
	    Root<Item> c = q.from(Item.class);
	    q.select(c);
	    ParameterExpression<String> p = cb.parameter(String.class);
	    q.where(cb.equal(c.get("GUID"), p));

	    TypedQuery<Item> query = em.createQuery(q);
	    query.setParameter(p, guid);
	    item = query.getSingleResult();
	} finally {
	    em.close();
	}

	System.out.println(item.getName());

	return item;
    }

}
