package com.javaminions.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.javaminions.pojos.Orders;
import com.javaminions.pojos.UserProfile;
import com.javaminions.repo.OrdersRepo;
import com.javaminions.repo.UserProfileRepo;

@Controller
public class CreateOrder {
	String username = "";
	int user_id = 0;
	CreateOrder(String username){
		this.username = username;
	}
	
	@Autowired
	OrdersRepo orders;
	
	@Autowired
	UserProfileRepo userProfiles;
	
	void findUserId() {
		List<UserProfile> uProfiles = (List<UserProfile>) userProfiles.findAll();
		for(UserProfile u: uProfiles) {
			if(u.getUsername().equalsIgnoreCase(username)) {
				user_id = u.getId();
			}
		}
	}
	int getOrderId() {
		Orders newOrder = new Orders();
		newOrder.setUser_id(user_id);
		orders.save(newOrder);
		List <Orders> allOrders = (List<Orders>) orders.findAll();
		return allOrders.get(allOrders.size()-1).getId();
	}

}
