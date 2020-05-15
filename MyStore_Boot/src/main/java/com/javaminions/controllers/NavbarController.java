package com.javaminions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavbarController {
	
	@GetMapping("categories")
	public String categories() {
		return "categories";
	}

}
