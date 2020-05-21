package com.javaminions.pojos;

import java.util.ArrayList;
import java.util.List;

public class OrderHistory {
	
	List<OrderHistoryLineItem> orderHistoryLineItem = new ArrayList<OrderHistoryLineItem>();
	
	public void addOrderHistoryLineItem(OrderHistoryLineItem item) {
		orderHistoryLineItem.add(item);
	}
	
	public List<OrderHistoryLineItem> getOrderHistory(){
		return orderHistoryLineItem;
	}

}
