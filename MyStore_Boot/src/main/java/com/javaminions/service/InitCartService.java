package com.javaminions.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaminions.model.CartHandler;
import com.javaminions.pojos.Product;
import com.javaminions.service.*;

public class InitCartService {
	   public void initCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	Cookie[] cookies = request.getCookies();
	    	CartHandler cart = new CartHandler();
	    	if(request.getSession().getAttribute("cart")!=null) {
	    		cart = (CartHandler) request.getSession().getAttribute("cart");
	    	} else {
	    		ArrayList<Product> products = (ArrayList<Product>) request.getSession().getAttribute("products");
	    		//if a product matches set the cart line items 
	    		if(cookies!=null) {
	    			for(Cookie c: cookies) {
		    			if(c.getName().contains("cartprod")) {
		    				cart.addLineItem(CookieMonsterService.unstringify(c, products));
		    			}
		    		}
	    		}
	    	}
			request.getSession().setAttribute("cart", cart);
			request.getSession().setAttribute("cartCount", cart.getItemCount());
	    }
}
