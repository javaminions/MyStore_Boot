package com.javaminions.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaminions.model.WishlistHandler;
import com.javaminions.pojos.Product;
import com.javaminions.pojos.UserProfile;
import com.javaminions.pojos.Wishlist;

public class InitWishlistService {

	public void generateWishlist(HttpServletRequest request, HttpServletResponse response, List<Wishlist> wishlist,
			UserProfile user, List<Product> prods) {

		HttpSession session = request.getSession();
		WishlistHandler wh = new WishlistHandler();

		if (session.getAttribute("wishlist") == null) {
			for (Wishlist w : wishlist) {
				if (user.getId() == w.getUser_id()) {
					for (Product p : prods) {
						if (w.getProduct_code() == Integer.parseInt(p.getCode())) {
							System.out.println("added a product to local obj");
							wh.addProduct(p);
						}
					}
				}
			}
			session.setAttribute("wishlist", wh);
		}
		else {
			System.out.println("wishlist aint null, ts : " + session.getAttribute("wishlist"));
		}
	}

}
