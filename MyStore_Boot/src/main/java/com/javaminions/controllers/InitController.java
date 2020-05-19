package com.javaminions.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.javaminions.model.Product;
import com.javaminions.repo.ProductRepo;
import com.javaminions.service.CarouselService;
import com.javaminions.service.InitPageService;


@Controller
public class InitController {
	
	@Autowired
	ProductRepo prod;
	
	@GetMapping("/")
	public String goHome(HttpServletRequest request, HttpServletResponse response) {
		try {
			
			List<Product> prods = (List<Product>) prod.findAll();
			
			new InitPageService().pageInitializer(request, response, prods);
			String caroSelection = request.getParameter("caroSelection");
			System.out.println(caroSelection);
			if(caroSelection!=null) {
				new CarouselService().caroHandler(caroSelection, request, response);
			}
		
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "home";
	}

}
