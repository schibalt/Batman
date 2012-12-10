package com.batman.server.cart;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.*;
import com.batman.data.items.*;

public class ShoppingCart implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3204986759790796536L;

	private Map<String, Integer> countLookup;
	private Map<String, Item> itemLookup;
	private Double totalPrice;
	private int totalCount;
	private String displayPrice;

	public ShoppingCart() {
		initialiseCart();
	}

	// getters
	/**
	 * @return Key = GUID, Value = Count
	 */
	public Map<String, Integer> getCounts()
	{
		return this.countLookup;
	}

	public double getTotalPrice()
	{
		return this.totalPrice;
	}

	public int getTotalCount()
	{
		return this.totalCount;
	}
	
	public String getDisplayPrice(){
		return this.displayPrice;
	}

	// lookups
	public Item lookupItem(String guid)
	{
		return this.itemLookup.get(guid);
	}

	public int lookupCount(String guid)
	{
		return this.countLookup.get(guid);
	}

	// mutators
	/**
	 * Adds a item(s) to the cart.
	 * 
	 * @param item
	 *            to add to cart
	 * @param count
	 *            of items to add to cart
	 */
	public void addItem(Item item, int count)
	{

		String guid = item.getGuid();

		// Does the item already exist in the cart?
		if (this.countLookup.containsKey(guid))
		{
			// Yes, update the count
			this.countLookup.put(guid, countLookup.get(guid) + count);
		} else
		{
			// No, add it to the count and item lookup
			this.countLookup.put(guid, count);
			this.itemLookup.put(guid, item);
		}

		this.totalPrice += (item.getPrice() * count);
		this.totalCount += count;
		this.displayPrice = NumberFormat.getCurrencyInstance().format(this.totalPrice);
	}

	/**
	 * Removes all items from the cart
	 */
	public void clearCart()
	{
		initialiseCart();
	}

	private void initialiseCart()
	{
		this.countLookup = new HashMap<String, Integer>();
		this.itemLookup = new HashMap<String, Item>();
		this.totalPrice = new Double(0);
		this.totalCount = 0;
		this.displayPrice = NumberFormat.getCurrencyInstance().format(this.totalPrice);
	}
}
