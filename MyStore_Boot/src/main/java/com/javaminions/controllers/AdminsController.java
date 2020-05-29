package com.javaminions.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.pojos.OrderDetails;
import com.javaminions.pojos.OrderHistory;
import com.javaminions.pojos.Orders;
import com.javaminions.pojos.Product;
import com.javaminions.pojos.UserProfile;
import com.javaminions.repo.OrderDetailsRepo;
import com.javaminions.repo.OrdersRepo;
import com.javaminions.repo.ProductRepo;
import com.javaminions.repo.UserProfileRepo;
import com.javaminions.service.AdminOrderHistoryService;
import com.javaminions.service.DisplayOrdersService;
import com.javaminions.service.ProductsService;

@Controller
public class AdminsController {
	
	@Autowired
	OrdersRepo oRepo;
	
	@Autowired
	OrderDetailsRepo oDetails;
	
	@Autowired
	ProductRepo prepo;
	
	@GetMapping("/fulfillment")
	public String fulfillmentPage () {
		return "fulfillments";
	}
	
	@GetMapping("/adminOrderHistory")
	public String getOrderHistory (HttpServletRequest request) {
		UserProfile user = (UserProfile) request.getSession().getAttribute("user");
		
		List<Orders> orders = (List<Orders>) oRepo.findAll();
		List<OrderDetails> orderDetails = (List<OrderDetails>) oDetails.findAll();
		List<Product> products = (List<Product>) prepo.findAll();
		
		OrderHistory oHistory = new AdminOrderHistoryService(orders, orderDetails, products, user.getId()).rebuildCart();
		request.getSession().setAttribute("adminOrderHistory", oHistory.getOrderHistory());
		
		return "adminOrderView";
	}
	
	
	@GetMapping("/adminpage")
	public String adminPage(HttpServletRequest request, HttpServletResponse response) {
		
		UserProfile user = (UserProfile) request.getSession().getAttribute("user");
		
		if (user!=null && user.isAdmin() == true) {
			return "Admins";
		} else {
			return "home";
		}	
	}

	
	@GetMapping("/addproductpage")
	public String productPageLoad () {
		return "addProducts";
	}
	
	@PostMapping("/addproduct")
	public String addProduct (HttpServletRequest request, HttpServletResponse response, @RequestParam String code, @RequestParam String name, @RequestParam String description, @RequestParam int inventory, @RequestParam double price, @RequestParam String category, @RequestParam String img) {
		
		
		new ProductsService().addProduct(request, response, code, name, description, inventory, price, category, img, prepo);
		
		
		return "Admins";
	}
	
	

}
