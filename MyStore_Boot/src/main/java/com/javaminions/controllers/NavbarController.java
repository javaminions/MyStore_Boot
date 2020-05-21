package com.javaminions.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavbarController {
	
	@GetMapping("categories")
	public String categories() {
		return "categories";
	}

	@GetMapping("signin")
	public String signin() {
		System.out.println("routing to sign in");
	
		return "signin";
	}
	
	@GetMapping("register")
	public String register() {
		System.out.println("hit register method");
		
		return "register";
	}
	
	@GetMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
    	Cookie[] cookies = request.getCookies();
    	for(Cookie c:cookies) {
    		c.setMaxAge(0);
    		c.setPath("/");
    		response.addCookie(c);
    	}
    	HttpSession session = request.getSession();
    	session.setAttribute("signedin", "no");
    	session.setAttribute("cartCount", "0");
    	session.setAttribute("cart", null);
    	
    	return "home";
	}

	@GetMapping("profile")
	public String profile() {
		
		return "UserProfile";
	}
	
	/*
	 * @GetMapping("wishlist") public String wishlist() { return "WishList"; }
	 */

}
