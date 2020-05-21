package com.javaminions.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaminions.pojos.Product;
import com.javaminions.pojos.UserProfile;
import com.javaminions.pojos.Wishlist;
import com.javaminions.repo.UserProfileRepo;

public class InitPageService {

	public void pageInitializer(HttpServletRequest request, HttpServletResponse response, List<Product> prods, List<UserProfile> users, List<Wishlist> wishlist)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		boolean signedin = false;

		request.getSession().setAttribute("products", prods);

		// check to see if signed in,
		// if so set signedin to yes and
		// retrieve firstName cookie to set as session attribute

		//System.out.println("signed in is: " + signedin);
		Cookie[] cookies = request.getCookies();
		String userName = null;
		
		if(cookies!=null) {
			for (Cookie c : cookies) {
				if (c.getName().equalsIgnoreCase("usernamecookie")) {
					session.setAttribute("signedin", "yes");
					signedin = true;
					userName = c.getValue();
					
				}
			}
		}
		
		
		UserProfile user = new UserProfile();
		
		for(UserProfile u:users) {
			if(u.getUsername().equalsIgnoreCase(userName)) {
				user = u;
				new InitWishlistService().generateWishlist(request, response, wishlist, user);
			}
		}
		
		session.setAttribute("user", user);

		// if not signed in set cart to 0 and set signedin to no
		if (signedin == false) {
			// cart = 0
			session.setAttribute("cartCount", "0");
			session.setAttribute("signedin", "no");
			// set navbar to say sign in
		}

		new InitCartService().initCart(request, response);
	}
}
