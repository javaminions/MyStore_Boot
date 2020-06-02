package com.javaminions.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaminions.repo.ProductRepo;
import com.javaminions.repo.UserProfileRepo;
import com.javaminions.repo.WishlistRepo;
import com.javaminions.service.RegisterService;


@Controller
public class RegisterController {

	@Autowired
	UserProfileRepo userProfile;
	
	@Autowired
	WishlistRepo wishs;
	
	@Autowired
	ProductRepo prod;
	
	@PostMapping("registerUser")
	public ModelAndView signInUser(@RequestParam String userName, @RequestParam String password, @RequestParam String email, @RequestParam String firstName, @RequestParam String lastName, HttpServletRequest request,
			HttpServletResponse response, ModelAndView mv) {

		System.out.println("register called");
		
		try {
			
			new RegisterService().registerUser(request, response, userName, password, email, firstName, lastName, userProfile, prod, wishs);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		mv.setViewName("home");
		return mv;

	}
}
