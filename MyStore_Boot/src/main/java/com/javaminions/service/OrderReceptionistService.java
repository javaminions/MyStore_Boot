package com.javaminions.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.javaminions.pojos.Product;
import com.javaminions.repo.ProductRepo;

@Service
public class OrderReceptionistService {

	public static String updateProductCount(ProductRepo p, int id, int quantity) {
		List<Product> products = p.findAll();
		Product prod = new Product();
		prod.setCode(String.valueOf(id));
		
		for (Product product : products) {
			if(product.getCode().equals(prod.getCode())) {
				prod = product;
			}
		}
		
		prod.setInventory(prod.getInventory()+quantity);
		p.save(prod);
		System.out.println("Updated product("+prod.getCode()+") with quantity="+quantity+" . Total quantity="+prod.getInventory());
		return "Updated product("+prod.getCode()+") with quantity="+quantity+" . Total quantity="+prod.getInventory();
	}
	
}
