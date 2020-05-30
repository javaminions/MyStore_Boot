package com.javaminions.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.javaminions.pojos.Orders;
import com.javaminions.pojos.Product;
import com.javaminions.pojos.Supplierorders;
import com.javaminions.pojos.SupplierordersList;
import com.javaminions.repo.ProductRepo;

public class FulfillmentService {

	public List<Supplierorders> getOrderFulfillments() {

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8089/getfulfillments";
		ResponseEntity<SupplierordersList> response = restTemplate.getForEntity(url, SupplierordersList.class);
		SupplierordersList orders = response.getBody();

		System.out.println(orders == null);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Request Successful.");
			System.out.println(response.getBody());

			for (Supplierorders o : orders.getOrders()) {
				System.out.println(o.toString());
			}
		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}

		return orders.getOrders();
	}

	public ResponseEntity<String> makeFulfillmentRequest(String prodCode, int restockQuantity) {

		RestTemplate restTemplate = new RestTemplate();

		String url = "http://localhost:8089/neworder/" + prodCode + "/" + restockQuantity;
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		String orders = response.getBody();

		System.out.println(orders == null);

		// check response
		if (response.getStatusCode() == HttpStatus.OK) {
			System.out.println("Request Successful.");
			System.out.println(orders);

		} else {
			System.out.println("Request Failed");
			System.out.println(response.getStatusCode());
		}
		return response;
	}

	public void restockProductInventory(ProductRepo prods, String prodCode, int restockQuantity) {
		List<Product> products = (List<Product>) prods.findAll();

		for (Product p : products) {
			if (p.getCode().equals(prodCode)) {
				p.setInventory(p.getInventory() + restockQuantity);
				prods.save(p);
				System.out.println("product updated");
			}
		}
	}
}
