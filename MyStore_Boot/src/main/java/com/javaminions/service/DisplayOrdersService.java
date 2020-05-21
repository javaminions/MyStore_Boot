package com.javaminions.service;

import java.util.ArrayList;
import java.util.List;

import com.javaminions.model.CartHandler;
import com.javaminions.model.LineItem;
import com.javaminions.pojos.OrderDetails;
import com.javaminions.pojos.OrderHistory;
import com.javaminions.pojos.OrderHistoryLineItem;
import com.javaminions.pojos.Orders;
import com.javaminions.pojos.Product;

public class DisplayOrdersService {
	
	List<Orders> orders = new ArrayList<Orders>();
	List<Orders> customerOrders = new ArrayList<Orders>();
	
	List<OrderDetails> orderDetails = new ArrayList<OrderDetails>();
	List<OrderDetails> matchedCustomerDetails = new ArrayList<OrderDetails>();
	
	List<Product> products = new ArrayList<Product>();
	int user_id;
	
	public DisplayOrdersService(List<Orders> orders, List<OrderDetails> orderDetails, List<Product> products, int user_id) {
		this.orders = orders;
		this.orderDetails = orderDetails;
		this.products = products;
		this.user_id = user_id;
		
		matchOrders();
		matchOrderDetails();
		
	}
	
	public void matchOrders() {
		for(Orders o: orders) {
			if(o.getUser_id()==user_id) {
				customerOrders.add(o);
			}
		}
	}
	public void matchOrderDetails() {
		for(OrderDetails o: orderDetails) {
			for(Orders co: customerOrders) {
				if(co.getId()==o.getOrder_id()) {
					matchedCustomerDetails.add(o);
				}
			}
		}
	}
	public OrderHistory rebuildCart() {
		//for every line of orderdetails create all lineitems > cart > orderhistorylineitem > orderHistory
		
		OrderHistory oHistory = new OrderHistory();
		
		for(Orders o: customerOrders) {
			CartHandler cart = new CartHandler();
			for(OrderDetails oDetails: matchedCustomerDetails) {
				
				if(o.getId()==oDetails.getOrder_id()) {
					cart.addLineItem(new LineItem(oDetails.getQuantity(), products.get(oDetails.getProduct_code()-1)));
				}
				
			}
			oHistory.addOrderHistoryLineItem(new OrderHistoryLineItem(o.getId(), cart));
		}
		return oHistory;
	}

	
}
