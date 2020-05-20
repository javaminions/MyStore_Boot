package com.javaminions.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaminions.pojos.UserProfile;
import com.javaminions.repo.UserProfileRepo;

public class UserService {

	public void updateUser (String email, String firstName, String lastName, String username, String password, HttpServletRequest request, HttpServletResponse response, UserProfileRepo userProfile) throws ServletException, IOException, ClassNotFoundException, SQLException {
		
		HttpSession session = request.getSession();
		UserProfile user = (UserProfile) session.getAttribute("user");
		
		List<UserProfile> users = (List<UserProfile>) userProfile.findAll();
		for(UserProfile u:users) {
			if(u.getEmail().equalsIgnoreCase(user.getEmail())) {
				u.setFirstName(firstName);
				u.setLastName(lastName);
				u.setUsername(username);
				u.setPassword(password);
				u.setEmail(email);
				userProfile.save(u);
				
				Cookie[] cookies = request.getCookies();
				for(Cookie c: cookies) {
					if(c.getName().contains("userName")) {
						c.setMaxAge(0);
						c.setPath("/");
					}
					
					if(c.getName().contains("passwordCookie")) {
						c.setMaxAge(0);
						c.setPath("/");
					}
					
					if(c.getName().contains("emailCookie")) {
						c.setMaxAge(0);
						c.setPath("/");
					}
					
					if(c.getName().contains("firstNameCookie")) {
						c.setMaxAge(0);
						c.setPath("/");
					}
					
					if(c.getName().contains("lastNameCookie")) {
						c.setMaxAge(0);
						c.setPath("/");
					}
				}
				
				
				//UserName Cookie
				session.setAttribute("userName", u.getUsername());
				Cookie unc = new Cookie("userNameCookie", username);
				unc.setPath("/");
				unc.setMaxAge(60 * 60 * 24 * 365 * 2);
				response.addCookie(unc);
				
				
				//Password Cookie
				Cookie pc = new Cookie("passwordCookie", u.getPassword());
				pc.setPath("/");
				pc.setMaxAge(60 * 60 * 24 * 365 * 2);
				response.addCookie(pc);
				
				//Email Cookie
				Cookie ec = new Cookie("emailCookie", u.getEmail());
				ec.setPath("/");
				ec.setMaxAge(60 * 60 * 24 * 365 * 2);
				response.addCookie(ec);
				
				//First Name Cookie
				Cookie fnc = new Cookie("firstNameCookie", u.getFirstName());
				fnc.setPath("/");
				fnc.setMaxAge(60 * 60 * 24 * 365 * 2);
				response.addCookie(fnc);
				
				//Last Name Cookie
				Cookie lnc = new Cookie("lastNameCookie", u.getLastName());
				lnc.setPath("/");
				lnc.setMaxAge(60 * 60 * 24 * 365 * 2);
				response.addCookie(lnc);
				
				session.setAttribute("user", u);
			}
			
		}
		
		/*
		 * Database database = Database.getInstance(); database.addUserIntoDB(user);
		 */
		
		session.setAttribute("signedin", "yes");
		request.getRequestDispatcher("views/home.jsp").forward(request, response);
		
	}
	
}
