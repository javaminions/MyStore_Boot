package com.javaminions.service;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.costco.model.Product;

public class CarouselService {
	public void caroHandler(String caroHandler, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (caroHandler.equalsIgnoreCase("carousel")) {
			ArrayList<Product> products = new ArrayList<Product>();
			products = (ArrayList<Product>) request.getSession().getAttribute("products");
			String code = request.getParameter("prodcode");
			for (Product prod : products) {
				if (prod.getCode().equalsIgnoreCase(code)) {
					request.getSession().setAttribute("product", prod);
				}
			}
			request.getRequestDispatcher("views/Product.jsp").forward(request, response);

		}

	}
}
