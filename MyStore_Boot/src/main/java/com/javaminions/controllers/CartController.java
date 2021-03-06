package com.javaminions.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.model.CartHandler;
import com.javaminions.repo.ProductRepo;
import com.javaminions.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	ProductRepo products;
	
	@GetMapping("Cart")
	public String categories(HttpServletResponse response, HttpServletRequest request) {
	
	
		String signedin = (String) request.getSession().getAttribute("signedin");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			return "home";
		}
		
		CartHandler cart = null;
		if(request.getSession().getAttribute("cart")==null) {
			cart = new CartHandler();
		} else {
			cart = (CartHandler) request.getSession().getAttribute("cart");
		}
		
		return "Cart";
	}
	
	@GetMapping("showall")
	public String showall(HttpServletRequest request, HttpServletResponse response) {
		
		String signedin = (String) request.getSession().getAttribute("signedin");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			return "home";
		}
		
		CartHandler cart = null;
		if(request.getSession().getAttribute("cart")==null) {
			cart = new CartHandler();
		} else {
			cart = (CartHandler) request.getSession().getAttribute("cart");
		}
		
		return "Cart";

	}
	
	@GetMapping("addtocart")
	public String addtocart(CartHandler cart, @RequestParam String prodcode,  HttpServletRequest request, HttpServletResponse response) {
		
		String signedin = (String) request.getSession().getAttribute("signedin");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			return "signin";
		}
		
		if(request.getSession().getAttribute("cart")==null) {
			cart = new CartHandler();
		} else {
			cart = (CartHandler) request.getSession().getAttribute("cart");
		}
		
		try {
			
			new CartService().addToCart(products, cart, prodcode, request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "Cart";
		
		
	}
	
	@GetMapping("update")
	public String updateCart (@RequestParam String action, @RequestParam String prodcode, CartHandler cart, HttpServletRequest request, HttpServletResponse response) {
		
		String signedin = (String) request.getSession().getAttribute("signedin");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			return "home";
		}
		
		if(request.getSession().getAttribute("cart")==null) {
			cart = new CartHandler();
		} else {
			cart = (CartHandler) request.getSession().getAttribute("cart");
		}
		
		try {
			
			new CartService().updateCount(products, action, prodcode, cart, request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		return "Cart";
		
	}
	


}