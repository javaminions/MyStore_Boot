package com.javaminions.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.pojos.Product;
import com.javaminions.repo.ProductRepo;
import com.javaminions.service.CategoryService;
import com.javaminions.service.FulfillmentService;

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
	
	@PostMapping("/restock")
	public String searchName(HttpServletRequest request, @RequestParam String prodCode, @RequestParam int restockQuantity) {

		System.out.println("prod code: " + prodCode);
		System.out.println("restock quantity: " + restockQuantity);
		HttpSession session = request.getSession();
		request.setAttribute("sentRequest", true);
		
		ResponseEntity<String> supplierResponse = new FulfillmentService().makeFulfillmentRequest(prodCode, restockQuantity);
		session.setAttribute("supplierRestockResponse", supplierResponse);
		System.out.println(supplierResponse.getBody());
		
		if(supplierResponse.getStatusCode() == HttpStatus.OK) {
			new FulfillmentService().restockProductInventory(prods, prodCode, restockQuantity);
		}

		return "categories";
	}
}
