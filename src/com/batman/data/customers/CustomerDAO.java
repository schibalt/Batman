package com.batman.data.customers;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;

public interface CustomerDAO {
    public abstract boolean authenticate( String login, String password)
	    throws SQLException, NoSuchAlgorithmException ;
    
    public abstract boolean createUser(Customer newCustomer)
	    throws SQLException, NoSuchAlgorithmException,
	    UnsupportedEncodingException ;
}
