package com.javaminions.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaminions.pojos.OrderDetails;
import com.javaminions.pojos.OrderHistory;
import com.javaminions.pojos.Orders;
import com.javaminions.pojos.Product;
import com.javaminions.pojos.UserProfile;
import com.javaminions.repo.OrderDetailsRepo;
import com.javaminions.repo.OrdersRepo;
import com.javaminions.repo.ProductRepo;
import com.javaminions.service.DisplayOrdersService;

@Controller
public class OrdersController {
	
	@Autowired
	OrdersRepo oRepo;
	
	@Autowired
	OrderDetailsRepo oDetails;
	
	@Autowired
	ProductRepo productsList;
	
	@GetMapping("/orders")
	public String displayOrders(HttpServletRequest request) {
		UserProfile user = (UserProfile) request.getSession().getAttribute("user");
		
		List<Orders> orders = (List<Orders>) oRepo.findAll();
		List<OrderDetails> orderDetails = (List<OrderDetails>) oDetails.findAll();
		List<Product> products = (List<Product>) productsList.findAll();
		
		OrderHistory oHistory = new DisplayOrdersService(orders, orderDetails, products, user.getId()).rebuildCart();
		request.getSession().setAttribute("orderHistory", oHistory.getOrderHistory());
		
		return "Orders";
	}

}
