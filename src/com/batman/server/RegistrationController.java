package com.batman.server;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.batman.data.customers.Customer;
import com.batman.data.customers.CustomerDAO;
import com.batman.data.customers.CustomerJPADAO;
import com.batman.server.cart.ShoppingCart;

public class RegistrationController extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 6316295304940843754L;

    private final static Logger log = Logger.getLogger(
	    CartController.class.getName(), null);

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	
	log.info("reg servlet");

	String name = request.getParameter("name");
	String email = request.getParameter("email");
	String username = request.getParameter("username");
	String password = request.getParameter("password");

	Customer newCustomer = new Customer();
	newCustomer.setEmail(email);
	newCustomer.setPassword(password);
	newCustomer.setName(name);
	newCustomer.setUsername(username);

	CustomerDAO customerDAO = new CustomerJPADAO();

	// Retrieve the current session from the request
	HttpSession session = request.getSession();

	session.setAttribute("user", null);

	try {

	    if (customerDAO.createUser(newCustomer)) {
		
		newCustomer = new Customer();
		newCustomer.setUsername(username);
		newCustomer.setName(name);

		session.setAttribute("user", newCustomer);
	    }

	} catch (NoSuchAlgorithmException e) {
	    
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	    
	} catch (SQLException e) {
	    
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	// Go back to the page
	request.getRequestDispatcher("/batcave/account").forward(request,
		response);
    }
}
