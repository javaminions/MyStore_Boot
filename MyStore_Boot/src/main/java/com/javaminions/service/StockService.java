package com.javaminions.service;

import org.springframework.stereotype.Service;

import com.javaminions.model.CartHandler;
import com.javaminions.model.LineItem;
import com.javaminions.pojos.Product;
import com.javaminions.repo.ProductRepo;

@Service
public class StockService {
	
	public static String checkout(CartHandler cart, ProductRepo products) {
		System.out.println("you hit me ! >:(");
		for(LineItem lineItem: cart.getLineItems()) {
			Product prod = new Product();
			
			for(Product p:products.findAll()) {
				if(p.getCode().equals(prod.getCode())) {
					prod=p;
				}
			}
			prod.setInventory(prod.getInventory()-lineItem.getQuantity());
			products.save(prod);
			System.out.println("Saved product:"+prod.toString());
			
		}
		return "processed checkout";
	}

}
