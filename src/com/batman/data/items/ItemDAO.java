package com.batman.data.items;

import java.util.List;

public interface ItemDAO
{

	public abstract List<Item> getItems();

	public abstract Item getItem(String guid);

}