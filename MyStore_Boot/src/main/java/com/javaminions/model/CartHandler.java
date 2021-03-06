package com.javaminions.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartHandler {
	
	private ArrayList<LineItem> lineItems = new ArrayList();
	
	public CartHandler() {
		
	}
	public void addLineItem(LineItem lineItem) {
		lineItems.add(lineItem);
	}
	public ArrayList<LineItem> getLineItems() {
		return lineItems;
	}
	public int getItemCount() {
		int count = 0;
		for(LineItem lineitem: lineItems ) {
			count += lineitem.getQuantity();
		}
		return count;
	}
	public void setCart(ArrayList<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	public String getTotalCost() {
		double total = 0;
		for(LineItem line: lineItems) {
			total += line.getProduct().getPrice()*line.getQuantity();
		}
		
		return NumberFormat.getCurrencyInstance(Locale.US).format(total);
	}
	public void removeLineItem(LineItem lineItem) {
		int index=0;
		for(LineItem line: lineItems) {
			if(line.getProduct().getCode().equalsIgnoreCase(lineItem.getProduct().getCode())) {
				lineItems.remove(index);
				return;
			}
			index++;
		}
	}

}
