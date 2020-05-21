package com.javaminions.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.pojos.Product;
import com.javaminions.pojos.Wishlist;
import com.javaminions.repo.ProductRepo;
import com.javaminions.repo.UserProfileRepo;
import com.javaminions.repo.WishlistRepo;
import com.javaminions.service.SignInService;

@Controller
public class SignInController {
	
	@Autowired
	UserProfileRepo userProfile;
	
	@Autowired
	WishlistRepo wishs;
	
	@Autowired
	ProductRepo prod;

	@PostMapping("signInUser")
	public void signInUser(@RequestParam String userName, @RequestParam String password, HttpServletRequest request,
			HttpServletResponse response) {

		System.out.println("sign in called");
		List<Wishlist> wishList = (List<Wishlist>) wishs.findAll();
		List<Product> prods = (List<Product>) prod.findAll();
		try {
			
			new SignInService().signInUser(request, response, userName, password, userProfile, wishList, prods);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
