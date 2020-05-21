package com.javaminions.pojos;

import com.javaminions.model.CartHandler;

public class OrderHistoryLineItem {
	
	private int orderNumber;
	private CartHandler cart;
	
//	public OrderHistoryLineItem() {
//		
//	}
	
	public int getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	public CartHandler getCart() {
		return cart;
	}
	public void setCart(CartHandler cart) {
		this.cart = cart;
	}

	public OrderHistoryLineItem(int orderNumber, CartHandler cart) {
		super();
		this.orderNumber = orderNumber;
		this.cart = cart;
	}
}
