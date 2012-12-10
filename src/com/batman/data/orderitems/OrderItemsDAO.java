package com.batman.data.orderitems;

import java.util.ArrayList;

import com.batman.data.orderitems.OrderItems.OrderItem;

public interface OrderItemsDAO
{

	public abstract boolean submitOrder(ArrayList<OrderItem> orderItems);

}