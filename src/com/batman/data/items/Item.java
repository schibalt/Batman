package com.batman.data.items;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.google.appengine.api.datastore.Key;

@Entity
public class Item implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 3988693624717198312L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Key key;
    private String GUID;
    private String Name;
    private String Image;
    private Double Price;

    // mutators
    public Key getKey() {
	return this.key;
    }

    public void setKey(Key key) {
	this.key = key;
    }

    public void setGuid(String guid) {
	this.GUID = guid;
    }

    public void setName(String name) {
	this.Name = name;
    }

    public void setImage(String image) {
	this.Image = image;
    }

    public void setPrice(Double price) {
	this.Price = price;
    }

    public String getGuid() {
	return this.GUID;
    }

    public String getName() {
	return this.Name;
    }

    public String getImage() {
	return this.Image;
    }

    public Double getPrice() {
	return this.Price;
    }
}
