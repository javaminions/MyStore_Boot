package com.javaminions.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.costco.database.Database;
import com.costco.model.Product;
import com.costco.model.UserProfile;

public class InitPageService {

	public void pageInitializer(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		boolean signedin = false;

		// Load products in session if null
		if (session.getAttribute("products") == null) {
			// init products
			Database database = null;
			List<Product> products = null;
			try {
				database = Database.getInstance();
				products = database.getAll();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			session.setAttribute("products", products);
		}

		// check to see if signed in,
		// if so set signedin to yes and
		// retrieve firstName cookie to set as session attribute

		System.out.println("signed in is: " + signedin);
		Cookie[] cookies = request.getCookies();
		String firstName = null;
		String lastName = null;
		String email = null;
		String userName = null;
		String password = null;
		
		for (Cookie c : cookies) {
			if (c.getName().equalsIgnoreCase("usernamecookie")) {
				session.setAttribute("signedin", "yes");
				signedin = true;
				userName = c.getValue();
				
			}
			if (c.getName().equalsIgnoreCase("passwordcookie")) {
				password = c.getValue();
			}
			if (c.getName().equalsIgnoreCase("emailcookie")) {
				email = c.getValue();
			}
			if (c.getName().equalsIgnoreCase("firstnamecookie")) {
				firstName = c.getValue();
			}
			if (c.getName().equalsIgnoreCase("lastnamecookie")) {
				 lastName = c.getValue();
			}
		}
		
		UserProfile user = new UserProfile(userName, password, firstName, lastName, email);
		session.setAttribute("user", user);

		// if not signed in set cart to 0 and set signedin to no
		if (signedin == false) {
			 firstName = null;
			// cart = 0
			session.setAttribute("cartCount", "0");
			session.setAttribute("signedin", "no");
			// set navbar to say sign in
		}

		new InitCartService().initCart(request, response);
	}
}
