package com.batman.server.cart;

import java.io.Serializable;

public class DisplayItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6579456480027748353L;

	private String name;
	private String count;
	private String image;
	private double price;
	
	public double getPrice() {
	    return price;
	}
	public void setPrice(double price) {
	    this.price = price;
	}
	public String getImage() {
	    return image;
	}
	public void setImage(String image) {
	    this.image = image;
	}
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
