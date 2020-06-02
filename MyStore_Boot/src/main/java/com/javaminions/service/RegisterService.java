package com.javaminions.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaminions.database.Database;
import com.javaminions.model.WishlistHandler;
import com.javaminions.pojos.Product;
import com.javaminions.pojos.UserProfile;
import com.javaminions.pojos.Wishlist;
import com.javaminions.repo.ProductRepo;
import com.javaminions.repo.UserProfileRepo;
import com.javaminions.repo.WishlistRepo;

public class RegisterService {

public void registerUser (HttpServletRequest request, HttpServletResponse response, String userName, String password, String email, String firstName, String lastName, UserProfileRepo userProfile, ProductRepo prods, WishlistRepo wishs) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
	
		HttpSession session = request.getSession();
		UserProfile user = new UserProfile(userName, password, firstName, lastName, email, false);
		session.setAttribute("user", user);
		session.setAttribute("wishlistProducts", new WishlistHandler().getWishProducts());
		
		//UserName Cookie
		session.setAttribute("userName", userName);
		Cookie unc = new Cookie("userNameCookie", userName);
		unc.setPath("/");
		unc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(unc);
		
		
		//Password Cookie
		Cookie pc = new Cookie("passwordCookie", password);
		pc.setPath("/");
		pc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(pc);
		
		//Email Cookie
		Cookie ec = new Cookie("emailCookie", email);
		ec.setPath("/");
		ec.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(ec);
		
		//First Name Cookie
		Cookie fnc = new Cookie("firstNameCookie", firstName);
		fnc.setPath("/");
		fnc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(fnc);
		
		//Last Name Cookie
		Cookie lnc = new Cookie("lastNameCookie", lastName);
		lnc.setPath("/");
		lnc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(lnc);
		

		userProfile.save(user);
		//BC - testing if this attribute will work
		session.setAttribute("isAdmin", user.isAdmin());
		
		ArrayList<Wishlist> theWishlists = (ArrayList<Wishlist>) wishs.findAll();
		ArrayList<Product> theProds = (ArrayList<Product>) prods.findAll();
		new InitWishlistService().generateWishlist(request, response, theWishlists, user, theProds);
		/*
		 * Database database = Database.getInstance(); database.addUserIntoDB(user);
		 */
		

		
		session.setAttribute("signedin", "yes");
		//request.getRequestDispatcher("views/home.jsp").forward(request, response);
		
	}
	
}
