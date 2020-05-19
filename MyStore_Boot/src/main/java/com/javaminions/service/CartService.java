package com.javaminions.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;

import com.costco.model.Cart;
import com.costco.model.LineItem;
import com.costco.model.Product;



public class CartService {

	public void addToCart(Cart cart, String prodcode, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String signedin = (String) request.getSession().getAttribute("signedin");
		if(signedin==null || signedin.equalsIgnoreCase("no")) {
			request.getRequestDispatcher("IndexHandler?action=signinPage").forward(request, response);
		}
		
		cart = null;
		if(request.getSession().getAttribute("cart")==null) {
			cart = new Cart();
		} else {
			cart = (Cart) request.getSession().getAttribute("cart");
		}
		
		ArrayList<Product> products = (ArrayList<Product>) request.getSession().getAttribute("products");
		Product productToAdd = null;
		for(Product product: products) {
			if(product.getCode().equalsIgnoreCase(prodcode)) {
				productToAdd = product;
			} else {
				//product not found, error 
				//products should have been loaded correctly by now 
			}
		}
		
		if(cart.getItemCount()==0) {
			//add to cart
			LineItem lineItem = new LineItem(1, productToAdd);
			cart.addLineItem(lineItem);
			request.getSession().setAttribute("cart", cart);
			request.getSession().setAttribute("cartCount", cart.getItemCount());
			
			String[] stringified = CookieMonsterService.stringify(lineItem);
			
			Cookie c = new Cookie(stringified[0], stringified[1]);
			c.setMaxAge(60*60*24*365*2);
			c.setPath("/");
			response.addCookie(c);
			
		} else {
			//check if item exists and then add to cart or add +1 to count 
			ArrayList<LineItem> lineItems = cart.getLineItems();
			boolean exists = false; 
			for(LineItem lineItem: lineItems) {
				if(lineItem.getProduct().getCode().equalsIgnoreCase(prodcode)) {
					lineItem.setQuantity(lineItem.getQuantity()+1);
					exists = true; 
				}
			}
			if(!exists) {
				LineItem lineItem = new LineItem(1, productToAdd);
				cart.addLineItem(lineItem);
			}
			cart.setCart(lineItems);
			request.getSession().setAttribute("cart", cart);
			refreshCookies(cart, request, response);
		}
		request.getRequestDispatcher("/categories?filterCategory=all").forward(request, response);
	}
	
	
	public void initializeCart(Cart cart, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//read cookies
		Cookie[] cookies = request.getCookies();
		List<Product> products = (List<Product>) request.getSession().getAttribute("products");
		//if a product matches set the cart line items 
		for(Cookie c: cookies) {
			if(c.getName().contains("cartprod")) {
				cart.addLineItem(CookieMonsterService.unstringify(c, products));
			}
		}
	}
	
	
	public void updateCount(String action, String prodcode, Cart cart, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(action.equalsIgnoreCase("plus")) {
			System.out.println("action is plus method");
			System.out.println("prodcode is" + prodcode);
			ArrayList<LineItem> lineItems = cart.getLineItems();
			for(LineItem lineItem: lineItems) {
				if(lineItem.getProduct().getCode().equalsIgnoreCase(prodcode)) {
					lineItem.setQuantity(lineItem.getQuantity()+1);
					System.out.println(prodcode);
				}
				
			}
			cart.setCart(lineItems);
			refreshCookies(cart, request, response);
			request.getSession().setAttribute("cart", cart);
		}
		
		if(action.equalsIgnoreCase("minus")) {
			ArrayList<LineItem> lineItems = cart.getLineItems();
			for(LineItem lineItem: lineItems) {
				if(lineItem.getProduct().getCode().equalsIgnoreCase(prodcode)) {
					if(lineItem.getQuantity()==1) {
						cart.removeLineItem(lineItem);
					} else {
						lineItem.setQuantity(lineItem.getQuantity()-1);
					}
				}
			}
			cart.setCart(lineItems);
			refreshCookies(cart, request, response);
			request.getSession().setAttribute("cart", cart);
		}
		if(action.equalsIgnoreCase("delete")) {
			System.out.println(prodcode);
			ArrayList<LineItem> lineItems = cart.getLineItems();
			int index = 0;
			for(LineItem lineItem: lineItems) {
				if(lineItem.getProduct().getCode().equalsIgnoreCase(prodcode)) {
					lineItems.remove(index);
					break;
				}
				index++;
			}
			cart.setCart(lineItems);
			refreshCookies(cart, request, response);
			request.getSession().setAttribute("cart", cart);
		}
		
	}
	
	
	public void refreshCookies(Cart cart, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		for(Cookie c: cookies) {
			if(c.getName().contains("cartprod")) {
				c.setMaxAge(0);
				c.setPath("/");
			}
		}
		ArrayList<LineItem> lineItems = cart.getLineItems();
		for(LineItem lineItem: lineItems) {
			String[] cookieData = CookieMonsterService.stringify(lineItem);
			Cookie c = new Cookie(cookieData[0], cookieData[1]);
			c.setMaxAge(60*60*24*365*2);
			c.setPath("/");
			response.addCookie(c);
		}
		request.getSession().setAttribute("cartCount", cart.getItemCount());
	}
	
	
	
	
	
	
}