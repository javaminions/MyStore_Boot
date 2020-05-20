package com.javaminions.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.repo.UserProfileRepo;
import com.javaminions.service.UserService;

@Controller
public class UserController {

	
	@Autowired
	UserProfileRepo userProfile;
	
	@GetMapping("/account")
	public String account() {
		return "Account";
	}
	
	@PostMapping("/updateUser")
	public String update(@RequestParam String email, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpServletResponse response) {
		try {
			System.out.println("updateUser called");
	new UserService().updateUser(email, firstName, lastName, username, password, request, response, userProfile);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "UserProfile";
	}
}
