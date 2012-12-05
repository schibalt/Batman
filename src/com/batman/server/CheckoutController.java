package com.batman.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.batman.server.cart.ShoppingCart;

public class CheckoutController extends HttpServlet {

	private final static Logger log = Logger.getLogger(CheckoutController.class.getName(), null);
	/**
	 * 
	 */
	private static final long serialVersionUID = 2499355774763224962L;
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet");
		// Go back to the page
		// Save the items in the session
		
		HttpSession session = request.getSession();
		ShoppingCart cart = (ShoppingCart)session.getAttribute("cart");
		
		// TODO : Store the cart contents in the database
		
		// Clear out the cart
		cart.clearCart();
		session.setAttribute("cart", cart);
		
		request.getRequestDispatcher("/WEB-INF" + request.getServletPath() + ".jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("doPost");
		// Go back to the page
		request.getRequestDispatcher("/WEB-INF" + request.getServletPath() + ".jsp").forward(request, response);
	}
}
