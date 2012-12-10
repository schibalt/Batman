package com.batman.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.batman.data.customers.Customer;
import com.batman.server.cart.ShoppingCart;

public class FriendlyUrl extends HttpServlet {
    private final static Logger log = Logger.getLogger(
	    FriendlyUrl.class.getName(), null);

    private static final long serialVersionUID = 8641049249826262967L;

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	/*
	// Retrieve the current session from the request
	HttpSession session = request.getSession();

	// Get the items back out of the session
	Customer user = (Customer) session.getAttribute("user");

	if (null != user) {

	    // Send the display items back to the page
	    request.setAttribute("user", user);

	    log.severe("user is " + user.getName() + " " + user.getUsername());
	} else
	    request.setAttribute("user", null);
*/
	log.severe("getting /WEB-INF" + request.getServletPath() + ".jsp");
	request.getRequestDispatcher(
		"/WEB-INF" + request.getServletPath() + ".jsp").forward(
		request, response);
    }

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	/*
	// Retrieve the current session from the request
	HttpSession session = request.getSession();

	// Get the items back out of the session
	Customer user = (Customer) session.getAttribute("user");

	if (null != user) {

	    // Send the display items back to the page
	    request.setAttribute("user", user);

	    log.severe("user is " + user.getName() + " " + user.getUsername());
	} else
	    request.setAttribute("user", null);
*/
	log.severe("posting /WEB-INF" + request.getServletPath() + ".jsp");
	request.getRequestDispatcher(
		"/WEB-INF" + request.getServletPath() + ".jsp").forward(
		request, response);
    }
}
