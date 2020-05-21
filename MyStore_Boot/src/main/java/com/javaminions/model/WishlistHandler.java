package com.javaminions.model;

import java.text.NumberFormat;
import java.util.ArrayList;

import com.javaminions.pojos.Product;

public class WishlistHandler {
	private ArrayList<Product> wishProducts = new ArrayList();
	
	public WishlistHandler() {
		
	}
	public void addProduct(Product product) {
		wishProducts.add(product);
	}
	public ArrayList<Product> getWishProducts() {
		return wishProducts;
	}
	public int getItemCount() {
		return wishProducts.size();
	}
	public void setWishList(ArrayList<Product> product) {
		this.wishProducts = wishProducts;
	}
	
	public void removeProduct(Product p) {
		int index=0;
		for(Product product: wishProducts) {
			if(product.getCode().equalsIgnoreCase(p.getCode())) {
				wishProducts.remove(index);
				return;
			}
			index++;
		}
	}
}
