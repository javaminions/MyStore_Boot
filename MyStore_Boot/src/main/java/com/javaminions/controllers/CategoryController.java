package com.javaminions.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaminions.pojos.Product;
import com.javaminions.repo.ProductRepo;
import com.javaminions.service.CategoryService;

@Controller
public class CategoryController {
	
	@Autowired
	ProductRepo prods;

	@RequestMapping("/categories")
	public String searchName(HttpServletRequest request,
			HttpServletResponse response) {
		List<Product> products = (List<Product>) prods.findAll();
		request.getSession().setAttribute("products", products);

		new CategoryService().searchProductByName(request, response, products);

		return "categories";
	}
}
