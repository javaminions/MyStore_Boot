package com.javaminions.service;

import java.util.List;

import com.javaminions.pojos.Orders;
import com.javaminions.pojos.UserProfile;
import com.javaminions.repo.OrdersRepo;
import com.javaminions.repo.UserProfileRepo;


public class CreateOrder {
	String username = "";
	UserProfileRepo uProfile;
	OrdersRepo oRepo;
	int user_id = 0;
	public CreateOrder(String username, OrdersRepo oRepo, UserProfileRepo uProfile){
		this.username = username;
		this.uProfile = uProfile;
		this.oRepo = oRepo;
		findUserId();
	}
	
	void findUserId() {
		List<UserProfile> uProfiles = (List<UserProfile>) uProfile.findAll();
		for(UserProfile u: uProfiles) {
			if(u.getUsername().equalsIgnoreCase(username)) {
				user_id = u.getId();
			}
		}
	}
	public int getOrderId() {
		Orders newOrder = new Orders();
		newOrder.setUser_id(user_id);
		oRepo.save(newOrder);
		List <Orders> allOrders = (List<Orders>) oRepo.findAll();
		return allOrders.get(allOrders.size()-1).getId();
	}

}
