package com.batman.server;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.batman.data.items.Item;
import com.batman.data.items.ItemDAO;
import com.batman.data.items.ItemGoogleSqlDAO;
import com.batman.data.items.ItemJPADAO;
import com.batman.server.cart.ShoppingCart;

public class StoreController extends HttpServlet {
    private final static Logger log = Logger.getLogger(
	    StoreController.class.getName(), null);

    private static final long serialVersionUID = -732680452922711695L;

    protected void doGet(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	log.info("doGet");

	// ItemDAO itemDAO = new ItemGoogleSqlDAO();
	ItemDAO itemDAO = new ItemJPADAO();

	// Retrieve the Items from the Google SQL database
	List<Item> items = itemDAO.getItems();

	/*
	 * // Save the items in the session HttpSession session =
	 * request.getSession(); session.setAttribute("items", items);
	 */

	// Continue loading the page
	loadItems(request, response, items);
    }

    protected void doPost(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	log.info("doPost");
	updateCart(request, response);

	// ItemDAO itemDAO = new ItemGoogleSqlDAO();
	ItemDAO itemDAO = new ItemJPADAO();

	// Retrieve the Items from the Google SQL database
	List<Item> items = itemDAO.getItems();

	loadItems(request, response, items);
    }

    private void loadItems(HttpServletRequest request,
	    HttpServletResponse response, List<Item> items)
	    throws ServletException, IOException {
	log.info("loadItems");

	/*
	 * // Retrieve the Items from the session HttpSession session =
	 * request.getSession(); List<Item> items = (List<Item>)
	 * session.getAttribute("items");
	 */

	// Add the items to the request attribute
	request.setAttribute("items", items);

	// Go back to the page
	request.getRequestDispatcher(
		"/WEB-INF" + request.getServletPath() + ".jsp").forward(
		request, response);
    }

    private void updateCart(HttpServletRequest request,
	    HttpServletResponse response) throws ServletException, IOException {
	// Get the GUID of the Item to add to cart from the button that was
	// pressed
	String guid = request.getParameter("button");

	log.info("guid-in-button is \'" + guid + "\'");

	// Get the count out of the appropriate box
	String count = request.getParameter(guid);

	// Retrieve the current session from the request
	HttpSession session = request.getSession();

	// Get the items back out of the session
	// List<Item> items = (List<Item>) session.getAttribute("items");
	ItemDAO itemDAO = new ItemJPADAO();

	Item itemToAdd = itemDAO.getItem(guid);

	/*
	 * // Iterate over the items to find the one that has the appropriate
	 * guid // This is necessary to retrieve the price of the item for (Item
	 * item : items) if (item.getGuid().contains(guid)) { itemToAdd = item;
	 * break; }
	 */

	// If we got a match, then add the item to the cart and add the cart to
	// the session
	if (null != itemToAdd) {
	    log.info("itemtoadd isn't null");
	    ShoppingCart cart;

	    if (null == session.getAttribute("cart"))
		cart = new ShoppingCart();
	    else
		cart = (ShoppingCart) session.getAttribute("cart" + "");

	    cart.addItem(itemToAdd, Integer.parseInt(count));
	    session.setAttribute("cart", cart);
	    log.info("new total " + Double.toString(cart.getTotalPrice()));
	} else
	    log.info("item not found " + guid);
    }
}
