package com.javaminions.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javaminions.pojos.Product;

public class CategoryService {
	public void searchProductByName(HttpServletRequest request, HttpServletResponse response, List<Product> products) {
		
		String searchInput = request.getParameter("searchInput");

		ArrayList<Product> filteredProducts = new ArrayList<Product>();
		if (searchInput != null && searchInput != "") {
			for (Product p : products) {
				if (p.getName().toLowerCase().contains(searchInput.toLowerCase())) {
					filteredProducts.add(p);
				}
			}
			request.getSession().setAttribute("filteredProducts", filteredProducts);
			request.setAttribute("isProductsFiltered", "yes");
			request.setAttribute("filter", searchInput);
		}
	}
}
