package com.batman.data.orders;

import java.io.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;

public class Order implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -2547946872957392979L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
    private String guid;
    private String username;
    private long time;
    private Double price;

    public String getGuid() {
	return guid;
    }

    public void setGuid(String guid) {
	this.guid = guid;
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public long getTime() {
	return time;
    }

    public void setNanoTime(long time) {
	this.time = time;
    }

    public Double getPrice() {
	return price;
    }

    public void setPrice(Double price) {
	this.price = price;
    }
}
