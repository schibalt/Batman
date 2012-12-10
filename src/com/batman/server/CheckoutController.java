package com.batman.server;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.batman.data.customers.Customer;
import com.batman.data.items.Item;
import com.batman.data.items.ItemDAO;
import com.batman.data.items.ItemGoogleSqlDAO;
import com.batman.data.orderitems.OrderItems;
import com.batman.data.orderitems.OrderItems.OrderItem;
import com.batman.data.orders.Order;
import com.batman.data.orders.OrderDAO;
import com.batman.data.orders.OrderGoogleSqlDAO;
import com.batman.data.orders.OrderJPADAO;
import com.batman.server.cart.ShoppingCart;

public class CheckoutController extends HttpServlet {

    private final static Logger log = Logger.getLogger(
	    CheckoutController.class.getName(), null);
    /**
	 * 
	 */
    private static final long serialVersionUID = 2499355774763224962L;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	    throws ServletException, IOException {

	log.info("doGet");
	// Go back to the page
	// Save the items in the session

	HttpSession session = req.getSession();
	ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
	
	// Cookie[] cookies = req.getCookies();
	Customer customer = (Customer) session.getAttribute("user");
	String customerID = customer.getUsername();
	
	/*
	 * for (Cookie cookie : cookies) { if
	 * (cookie.getName().equals("username")) customer = cookie.getValue();
	 * break; }
	 */

	long nanoTime = System.nanoTime();

	UUID orderUuid = UUID.randomUUID();
	String svOrderUuid = orderUuid.toString();

	// inst order
	Order newOrder = new Order();
	newOrder.setGuid(svOrderUuid);
	newOrder.setPrice(cart.getTotalPrice());
	newOrder.setNanoTime(nanoTime);
	newOrder.setUsername(customerID);

	// inst DAO
	OrderDAO orderDAO = new OrderJPADAO();
	// OrderDAO orderDAO = new OrderGoogleSqlDAO();

	// submit
	boolean successfulSubmission = orderDAO.submitOrder(newOrder);

	if (!successfulSubmission) {
	    req.getRequestDispatcher("/batcave/account").forward(req, resp);
	    /*
	     * req.getRequestDispatcher("/WEB-INF" + req.getServletPath() +
	     * ".jsp") .forward(req, resp);
	     */
	    return;
	}

	OrderItems orderItems = new OrderItems();

	OrderItem orderItem;

	// Populate the display items list with the count and name of
	// the items in the cart
	Map<String, Integer> cartCounts = cart.getCounts();

	/*
	 * iterate through cart and set order items. the real item has to be
	 * found
	 */
	for (Map.Entry<String, Integer> entry : cartCounts.entrySet()) {

	    String guid = entry.getKey();
	    Integer count = entry.getValue();

	    ItemDAO itemDAO = new ItemGoogleSqlDAO();

	    Item itemToBuy = itemDAO.getItem(guid);
	    log.info(itemToBuy.getName() + " returned by " + guid);

	    // reinst item
	    orderItem = orderItems.new OrderItem();

	    // set col vals
	    orderItem.setItem(svOrderUuid, guid, count, itemToBuy.getPrice());

	    // add
	    orderItems.addItem(orderItem);
	}

	// Clear out the cart
	cart.clearCart();
	session.setAttribute("cart", cart);

	req.getRequestDispatcher("/WEB-INF" + req.getServletPath() + ".jsp")
		.forward(req, resp);
    }

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {

	log.info("doPost");
	// Go back to the page
	request.getRequestDispatcher(
		"/WEB-INF" + request.getServletPath() + ".jsp").forward(
		request, response);
    }
}
