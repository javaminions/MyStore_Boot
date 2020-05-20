package com.javaminions.pojos;

public class Wishlist {
	
	private int id;
	private int user_id;
	private int product_code;
	public Wishlist() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public Wishlist(int id, int user_id, int product_code) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.product_code = product_code;
	}

}
