package com.javaminions.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaminions.model.CartHandler;
import com.javaminions.model.LineItem;
import com.javaminions.pojos.UserProfile;
import com.javaminions.repo.OrderDetailsRepo;
import com.javaminions.repo.OrdersRepo;
import com.javaminions.repo.UserProfileRepo;
import com.javaminions.service.CreateOrder;
import com.javaminions.service.OrderService;

@Controller
public class OrderController {
	@Autowired 
	UserProfileRepo uProfile;
	 
	@Autowired
	OrdersRepo oRepo;
	
	@Autowired
	OrderDetailsRepo odr;

	@GetMapping("/submitorder")
	public String submitOrder(HttpServletRequest request, HttpServletResponse response) {

		
		UserProfile user = (UserProfile) request.getSession().getAttribute("user");
		CreateOrder order = new CreateOrder(user.getUsername(), oRepo, uProfile);
		int orderid = order.getOrderId();
		CartHandler cart = (CartHandler) request.getSession().getAttribute("cart");
		ArrayList<LineItem> products = cart.getLineItems();
		
		try {
			
			new OrderService().submitOrder(request, response, orderid, products, odr, cart);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return "AfterCheck";
		
	}
	
	@GetMapping("/donechecking")
	public String doneOrdering() {
		
		return "home";
	}
	

}
