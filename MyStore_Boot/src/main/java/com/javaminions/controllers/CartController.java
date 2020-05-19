package com.javaminions.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.costco.model.Cart;
import com.javaminions.service.CartService;
import com.javaminions.service.InitCartService;

@Controller
public class CartController {
	
	@GetMapping("Cart")
	public String categories(HttpServletResponse response, HttpServletRequest request) {
	
	
		String signedin = (String) request.getSession().getAttribute("signedin");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			return "home";
		}
		
		Cart cart = null;
		if(request.getSession().getAttribute("cart")==null) {
			cart = new Cart();
		} else {
			cart = (Cart) request.getSession().getAttribute("cart");
		}
		
		return "Cart";
	}
	
	@GetMapping("showall")
	public String showall(HttpServletRequest request, HttpServletResponse response) {
		
		String signedin = (String) request.getSession().getAttribute("signedin");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			return "home";
		}
		
		Cart cart = null;
		if(request.getSession().getAttribute("cart")==null) {
			cart = new Cart();
		} else {
			cart = (Cart) request.getSession().getAttribute("cart");
		}
		
		return "Cart";

	}
	
	@GetMapping("addtocart")
	public String addtocart(Cart cart, @RequestParam String prodcode,  HttpServletRequest request, HttpServletResponse response) {
		
		String signedin = (String) request.getSession().getAttribute("signedin");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			return "home";
		}
		
		if(request.getSession().getAttribute("cart")==null) {
			cart = new Cart();
		} else {
			cart = (Cart) request.getSession().getAttribute("cart");
		}
		
		try {
			
			new CartService().addToCart(cart, prodcode, request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "Cart";
		
		
	}
	
	@GetMapping("update")
	public String updateCart (@RequestParam String action, @RequestParam String prodcode, Cart cart, HttpServletRequest request, HttpServletResponse response) {
		
		String signedin = (String) request.getSession().getAttribute("signedin");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			return "home";
		}
		
		if(request.getSession().getAttribute("cart")==null) {
			cart = new Cart();
		} else {
			cart = (Cart) request.getSession().getAttribute("cart");
		}
		
		try {
			
			new CartService().updateCount(action, prodcode, cart, request, response);
			
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
		return "Cart";
		
	}
	


}