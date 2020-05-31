package com.javaminions.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaminions.database.Database;
import com.javaminions.pojos.Product;
import com.javaminions.pojos.UserProfile;
import com.javaminions.pojos.Wishlist;
import com.javaminions.repo.UserProfileRepo;

public class SignInService {
	
	int choice;

	public int signInUser (HttpServletRequest request, HttpServletResponse response, String userName, String password, UserProfileRepo users, List<Wishlist> wishlist, List<Product> prods) throws ServletException, IOException, SQLException, ClassNotFoundException {		
		System.out.println("sign in called");
		String message= "";
		
		HttpSession session = request.getSession();
		List<UserProfile> theUsers = (List<UserProfile>) users.findAll(); 
		UserProfile user = new UserProfile();
		user.setFirstName("");

//		Database database = Database.getInstance();
		//List<UserProfile> users = (List<UserProfile>) userProfile.findAll();
		for(UserProfile u:theUsers) {
			if(u.getUsername().equalsIgnoreCase(userName)) {
				System.out.println();
				user = u;
				new InitWishlistService().generateWishlist(request, response, wishlist, user, prods);
			}
		}
		
		
		if(user.getFirstName().equals("")) {
			choice = 1;
		}
		
		else if (!user.equals(null) && user.getPassword().equals(password)) {
			//set Session Attribute & Make Cookies!
			session.setAttribute("user", user);
			session.setAttribute("signedin", "yes");
			session.setAttribute("isAdmin", user.isAdmin());
			
			//UserName Cookie
			Cookie unc = new Cookie("userNameCookie", user.getUsername());
			unc.setPath("/");
			unc.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(unc);
			
			//Password Cookie
			Cookie pc = new Cookie("passwordCookie", user.getPassword());
			pc.setPath("/");
			pc.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(pc);
			
			//Email Cookie
			Cookie ec = new Cookie("emailCookie", user.getEmail());
			ec.setPath("/");
			ec.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(ec);
			
			//First Name Cookie
			Cookie fnc = new Cookie("firstNameCookie", user.getFirstName());
			fnc.setPath("/");
			fnc.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(fnc);
			
			//Last Name Cookie
			Cookie lnc = new Cookie("lastNameCookie", user.getLastName());
			lnc.setPath("/");
			lnc.setMaxAge(60 * 60 * 24 * 365 * 2);
			response.addCookie(lnc);
			
			choice = 2;
			
		} 
		
		else if (!user.equals(null) && !user.getPassword().equals(password)) {
			choice = 3;
		}
		
		return choice;
	}
}
