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
			UserProfile user) {

		HttpSession session = request.getSession();
		List<Product> prods = (List<Product>) session.getAttribute("products");
		WishlistHandler wh = new WishlistHandler();

		if (session.getAttribute("wishlist") == null) {
			for (Wishlist w : wishlist) {
				if (user.getId() == w.getUser_id()) {
					for (Product p : prods) {
						if (w.getProduct_code() == Integer.parseInt(p.getCode())) {
							wh.addProduct(p);
						}
					}
				}
			}
			session.setAttribute("wishlist", wh);
		}

	}

}