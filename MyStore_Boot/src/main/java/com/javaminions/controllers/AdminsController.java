package com.javaminions.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.pojos.UserProfile;
import com.javaminions.repo.ProductRepo;
import com.javaminions.service.ProductsService;

@Controller
public class AdminsController {
	
	@Autowired
	ProductRepo prepo;
	
	@GetMapping("/adminpage")
	public String adminPage(HttpServletRequest request, HttpServletResponse response) {
		
		UserProfile user = (UserProfile) request.getSession().getAttribute("user");
		
		if (user.isAdmin == true) {
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
