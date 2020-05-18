package com.javaminions.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.service.SignInService;

@Controller
public class NavbarController {
	
	@GetMapping("categories")
	public String categories() {
		return "categories";
	}

	@GetMapping("signin")
	public void signin(@RequestParam("action") String signin, HttpServletRequest request, HttpServletResponse response) {
		System.out.println("routing to sign in");
		if (signin.equals("signinPage")) {
			try {
				System.out.println("action is equal to signin");
				new SignInService().signInUser(request,response);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//return "home"; 
	}
}
