package com.batman.data.orderitems;

import java.io.Serializable;
import java.util.ArrayList;

public class OrderItems implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4495888873656975880L;

	private ArrayList<OrderItem> items;

	public OrderItems() {
		items = new ArrayList<OrderItem>();
	}

	public void addItem(OrderItem newItem)
	{
		items.add(newItem);
	}

	public class OrderItem implements Serializable
	{
		String orderGuid;
		String itemGuid;
		int quantity;
		double price;

		/**
	 	 * 
	 	 */
		private static final long serialVersionUID = 4142475417516131372L;

		public void setItem(String orderGuid, String itemGuid, Integer quantity, double price) {
			this.orderGuid = orderGuid;
			this.itemGuid = itemGuid;
			this.quantity = quantity;
			this.price = price;
		}

		public String getOrderGuid()
		{
			return orderGuid;
		}

		public void setOrderGuid(String orderGuid)
		{
			this.orderGuid = orderGuid;
		}

		public String getItemGuid()
		{
			return itemGuid;
		}

		public void setItemGuid(String itemGuid)
		{
			this.itemGuid = itemGuid;
		}

		public int getQuantity()
		{
			return quantity;
		}

		public void setQuantity(int quantity)
		{
			this.quantity = quantity;
		}

		public double getPrice()
		{
			return price;
		}

		public void setPrice(double price)
		{
			this.price = price;
		}
		
		
	}
}
