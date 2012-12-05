package com.batman.server.cart;

import java.io.Serializable;

public class DisplayItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6579456480027748353L;

	private String name;
	private String count;
	
	public String getName(){
		return this.name;
	}
	public String getCount(){
		return this.count;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public void setCount(String count){
		this.count = count;
	}
}
