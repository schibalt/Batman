package com.batman.data.customers;

import java.io.Serializable;

public class Customer implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7750736181644362818L;

	private String username;
	private String name;
	private String email;
	private String password;
	private String salt;
	
	public String getUsername() {
	    return username;
	}
	public void setUsername(String username) {
	    this.username = username;
	}
	public String getName() {
	    return name;
	}
	public void setName(String name) {
	    this.name = name;
	}
	public String getEmail() {
	    return email;
	}
	public void setEmail(String email) {
	    this.email = email;
	}
	public String getPassword() {
	    return password;
	}
	public void setPassword(String password) {
	    this.password = password;
	}
	public String getSalt() {
	    return salt;
	}
	public void setSalt(String salt) {
	    this.salt = salt;
	}
}
