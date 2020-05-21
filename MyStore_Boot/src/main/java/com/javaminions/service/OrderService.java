package com.javaminions.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaminions.model.CartHandler;
import com.javaminions.model.LineItem;
import com.javaminions.pojos.OrderDetails;
import com.javaminions.repo.OrderDetailsRepo;

public class OrderService {

	public void submitOrder(HttpServletRequest request, HttpServletResponse response, int orderid,
			ArrayList<LineItem> products, OrderDetailsRepo odr, CartHandler cart) throws ServletException, IOException {

		for (LineItem product : products) {
			OrderDetails od = new OrderDetails();
			od.setOrder_id(orderid);
			od.setProduct_code(Integer.parseInt(product.getProduct().getCode()));
			od.setQuantity(product.getQuantity());

			System.out.println(product);

			odr.save(od);
		}
		
		

		// delete products out of the cart
		products.clear();
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().contains("cartprod")) {
				c.setMaxAge(0);
				c.setPath("/");
				response.addCookie(c);
			}
			

			cart.setCart(products);

			new CartService().refreshCookies(cart, request, response);
			request.getSession().setAttribute("cart", cart);
			request.getSession().setAttribute("orderid", orderid);

		}

	}
}
