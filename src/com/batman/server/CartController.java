package com.batman.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.batman.server.cart.DisplayItem;
import com.batman.server.cart.ShoppingCart;

public class CartController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4884186937937467559L;
	
	private final static Logger log = Logger.getLogger(CartController.class.getName(), null);
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet");
		// Retrieve the current session from the request
		HttpSession session = request.getSession();
		
		// Get the items back out of the session
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		List<DisplayItem> displayItems = new ArrayList<DisplayItem>();
		
		// Populate the display items list with the count and name of the items in the cart
		Map<String, Integer> cartCounts = cart.getCounts();
		for(Map.Entry<String, Integer> entry : cartCounts.entrySet()){
			String guid = entry.getKey();
			Integer count = entry.getValue();
			DisplayItem displayItem = new DisplayItem();
			displayItem.setCount(Integer.toString(count));
			displayItem.setName(cart.lookupItem(guid).getName());
			displayItems.add(displayItem);
		}
		
		// Send the display items back to the page
		request.setAttribute("displayItems", displayItems);
		
		// Go back to the page
		request.getRequestDispatcher("/WEB-INF" + request.getServletPath() + ".jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		log.info("doPost");
		// Go back to the page
		request.getRequestDispatcher("/WEB-INF" + request.getServletPath() + ".jsp").forward(request, response);
	}
}
