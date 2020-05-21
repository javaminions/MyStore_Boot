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

	public void signInUser (HttpServletRequest request, HttpServletResponse response, String userName, String password, UserProfileRepo userProfile, List<Wishlist> wishlist, List<Product> prods) throws ServletException, IOException, SQLException, ClassNotFoundException {		
		System.out.println("sign in called");
		String message= "";
		
		HttpSession session = request.getSession();
		UserProfile user = new UserProfile();
		user.setFirstName("");

//		Database database = Database.getInstance();
		List<UserProfile> users = (List<UserProfile>) userProfile.findAll();
		for(UserProfile u:users) {
			if(u.getUsername().equalsIgnoreCase(userName)) {
				user = u;
				new InitWishlistService().generateWishlist(request, response, wishlist, user);
			}
		}
		
		
		if(user.getFirstName().equals("")) {
			message = "We could not find your username, please register before proceeding";
			request.setAttribute("message", message);
			request.getRequestDispatcher("views/register.jsp").forward(request, response);
		}
		
		else if (!user.equals(null)) {
			//set Session Attribute & Make Cookies!
			session.setAttribute("user", user);
			session.setAttribute("signedin", "yes");
			
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
			
			request.getSession().setAttribute("message", message);
			request.getRequestDispatcher("views/home.jsp").forward(request, response);
			
		} 
	}
}
