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
	public String signin() {
		System.out.println("routing to sign in");
	
		return "signin";
	}
	
	@GetMapping("register")
	public String register() {
		System.out.println("hit register method");
		
		return "register";
	}
}
