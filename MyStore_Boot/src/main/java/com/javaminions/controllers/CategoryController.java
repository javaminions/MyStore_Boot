package com.javaminions.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.pojos.Product;
import com.javaminions.service.CategoryService;

@Controller
public class CategoryController {

	@PostMapping("/categories")
	public String searchName(@RequestParam String searchInput, HttpServletRequest request,
			HttpServletResponse response) {

		new CategoryService().searchProductByName(request, response, searchInput);

		return "categories";
	}
}
