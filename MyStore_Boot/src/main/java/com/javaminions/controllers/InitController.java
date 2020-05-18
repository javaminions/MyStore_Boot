package com.javaminions.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaminions.service.InitPageService;

@Controller
public class InitController {
	
	@GetMapping("/")
	public String goHome(HttpServletRequest request, HttpServletResponse response) {
		try {
			new InitPageService().pageInitializer(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "home";
	}

}
