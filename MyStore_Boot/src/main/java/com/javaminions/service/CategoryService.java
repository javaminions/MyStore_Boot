package com.javaminions.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaminions.pojos.Product;

public class CategoryService {
	public void searchProductByName(HttpServletRequest request, HttpServletResponse response, String searchInput, ArrayList<Product> products) {
		HttpSession session = request.getSession();

		ArrayList<Product> filteredProducts = new ArrayList<Product>();
		if (searchInput != null && searchInput != "") {
			for (Product p : products) {
				if (p.getName().toLowerCase().contains(searchInput.toLowerCase())) {
					filteredProducts.add(p);
				}
			}
			session.setAttribute("filteredProducts", filteredProducts);
			request.setAttribute("isProductsFiltered", "yes");
			request.setAttribute("filter", searchInput);
		}
	}
}
