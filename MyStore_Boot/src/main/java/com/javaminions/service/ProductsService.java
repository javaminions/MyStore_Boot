package com.javaminions.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaminions.pojos.Product;
import com.javaminions.repo.ProductRepo;

public class ProductsService {
	
	public void addProduct (HttpServletRequest request, HttpServletResponse response, String code, String name, String description, int inventory, double price, String category, String img, ProductRepo prepo) {
		
		Product product = new Product (code, name, description, inventory, price, category, img);
		prepo.save(product);
		
	}

}
