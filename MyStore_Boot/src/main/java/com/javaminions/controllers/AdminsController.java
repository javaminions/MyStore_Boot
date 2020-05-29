package com.javaminions.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.pojos.UserProfile;
import com.javaminions.repo.ProductRepo;
import com.javaminions.repo.UserProfileRepo;
import com.javaminions.service.FulfillmentService;
import com.javaminions.service.ProductsService;

@Controller
public class AdminsController {
	
	@Autowired
	ProductRepo prepo;
	
	@GetMapping("/fulfillment")
	public String fulfillmentPage (HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.setAttribute("supplierOrders", new FulfillmentService().getOrderFulfillments()); 
		return "fulfillments";
	}
	
	@GetMapping("/adminOrderHistory")
	public String getOrderHistory () {
		return "adminorderhistory";
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
