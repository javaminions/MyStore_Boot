package com.javaminions.model;

import java.text.NumberFormat;
import java.util.Locale;

import com.javaminions.pojos.Product;

public class LineItem {
	
	private int quantity;
	private Product product;
	
	public LineItem() {
		
	}
	
	public LineItem(int quantity, Product product) {
		super();
		this.quantity = quantity;
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}

	
	public String getTotal() {
		double totall = 0;
		totall = product.getPrice()*quantity;
		return NumberFormat.getCurrencyInstance().format(totall);
	}
	
	

}
