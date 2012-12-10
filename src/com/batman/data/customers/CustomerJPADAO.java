package com.batman.data.customers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;

import com.batman.server.Owasp;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

public class CustomerJPADAO implements CustomerDAO {

    private final static int ITERATION_NUMBER = 1000;

    @Override
    public boolean authenticate(String login, String password)
	    throws SQLException, NoSuchAlgorithmException {

	// TODO Auto-generated method stub
	return false;
    }

    @Override
    public boolean createUser(Customer newCustomer)
	    throws UnsupportedEncodingException {

	String username = newCustomer.getUsername();
	String password = newCustomer.getPassword();

	if (username != null && password != null && username.length() <= 100) {
	    
	    // Uses a secure Random not a simple Random
	    SecureRandom random;

	    try {
		
		random = SecureRandom.getInstance("SHA1PRNG");

		// Salt generation 64 bits long
		byte[] bSalt = new byte[8];
		random.nextBytes(bSalt);

		// Digest computation
		byte[] bDigest = Owasp.getHash(ITERATION_NUMBER, password,
			bSalt);
		String sDigest = Owasp.byteToBase64(bDigest);
		String sSalt = Owasp.byteToBase64(bSalt);

		/*
		 * ps = con.prepareStatement(
		 * "INSERT INTO CREDENTIAL (LOGIN, PASSWORD, SALT) VALUES (?,?,?)"
		 * ); ps.setString(1, login); ps.setString(2, sDigest);
		 * ps.setString(3, sSalt); ps.executeUpdate(); return true;
		 */
		DatastoreService datastore = DatastoreServiceFactory
			.getDatastoreService();

		Entity custEnt = new Entity("Customer", newCustomer.getUsername());

		if (null == newCustomer.getUsername()
			|| newCustomer.getUsername().length() <= 0)
		    return false;

		// ... set properties ...
		/*
		 * orderEnt.setProperty("guid", order.getGuid());
		 * orderEnt.setProperty("username", order.getUsername());
		 * orderEnt.setProperty("time", order.getTime());
		 * orderEnt.setProperty("price", order.getPrice());
		 */
		custEnt.setProperty("username", username);
		custEnt.setProperty("name", newCustomer.getName());
		custEnt.setProperty("email", newCustomer.getEmail());
		custEnt.setProperty("password", sDigest);
		custEnt.setProperty("salt", sSalt);

		datastore.put(custEnt);
		return true;
		
	    } catch (NoSuchAlgorithmException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	// TODO Auto-generated method stub
	return false;
    }

}
