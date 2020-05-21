package com.javaminions.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.model.WishlistHandler;

@Controller
public class WishListController {
	
	@GetMapping("wishlist")
	public String wishlist(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession(); 
		String signedin = (String) request.getSession().getAttribute("signedin");
		WishlistHandler wishlist = (WishlistHandler) request.getSession().getAttribute("wishlist");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			return "signin";
		}
		else {
		session.setAttribute("wishlistProducts", wishlist.getWishProducts());
		}
		return "WishList";
	}
}
