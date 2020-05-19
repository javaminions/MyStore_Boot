package com.javaminions.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserProfile {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String cartProducts;
	private String email;
	
	public UserProfile(int id, String username, String password, String firstName, String lastName, String email ) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public UserProfile(String username, String password, String firstName, String lastName, String email ) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public UserProfile() {
		
	}
	

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getCartProducts() {
		return cartProducts;
	}
	
	public String getEmail() {
		return email;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setCartProducts(String cartProducts) {
		this.cartProducts = cartProducts;
	}
}
