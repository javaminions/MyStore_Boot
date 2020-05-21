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
				
				CookieMonsterService.updateUserCookies(request, response, username, password, email, firstName, lastName);

				session.setAttribute("userName", u.getUsername());
				session.setAttribute("user", u);
			}		
		}
		
		session.setAttribute("signedin", "yes");
		request.getRequestDispatcher("views/home.jsp").forward(request, response);
	}
}
