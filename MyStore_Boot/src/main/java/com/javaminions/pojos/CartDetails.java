package com.javaminions.pojos;

public class CartDetails {
	
	private int id;
	private int cart_id;
	private int product_code;
	private int quantity;
	public CartDetails() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCart_id() {
		return cart_id;
	}
	public void setCart_id(int cart_id) {
		this.cart_id = cart_id;
	}
	public int getProduct_code() {
		return product_code;
	}
	public void setProduct_code(int product_code) {
		this.product_code = product_code;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public CartDetails(int id, int cart_id, int product_code, int quantity) {
		super();
		this.id = id;
		this.cart_id = cart_id;
		this.product_code = product_code;
		this.quantity = quantity;
	}

}
