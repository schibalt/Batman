package com.batman.data.items;

import java.io.Serializable;

public class Item implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3988693624717198312L;
	
	private String guid;
	private String name;
	private String image;
	private Double price;

	// accessors
	public void setGuid(String guid) {
		this.guid = guid;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	// mutators
	public String getGuid() {
		return this.guid;
	}

	public String getName() {
		return this.name;
	}

	public String getImage() {
		return this.image;
	}

	public Double getPrice() {
		return this.price;
	}
}
