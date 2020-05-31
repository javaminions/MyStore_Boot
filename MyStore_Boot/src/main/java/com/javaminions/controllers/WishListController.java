package com.javaminions.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaminions.model.WishlistHandler;
import com.javaminions.pojos.Product;
import com.javaminions.pojos.UserProfile;
import com.javaminions.pojos.Wishlist;
import com.javaminions.repo.ProductRepo;
import com.javaminions.repo.WishlistRepo;
import com.javaminions.service.InitWishlistService;

@Controller
public class WishListController {

	@Autowired
	WishlistRepo wishs;

	@Autowired
	ProductRepo prod;

	@GetMapping("wishlist")
	public String wishlist(HttpServletRequest request, HttpServletResponse response) {

		HttpSession session = request.getSession();
		String signedin = (String) request.getSession().getAttribute("signedin");
		WishlistHandler wishlist = (WishlistHandler) request.getSession().getAttribute("wishlist");
		UserProfile user = (UserProfile) request.getSession().getAttribute("user");
		
		WishlistHandler emptyWish = new WishlistHandler();
		System.out.println("WishListController Signedin=="+signedin);
		if (signedin == null || signedin.equalsIgnoreCase("no")) {
			return "signin";
		} else if(wishlist==null){
			session.setAttribute("wishlistProducts", emptyWish.getWishProducts());
		} else {
			new InitWishlistService().generateWishlist(request, response, wishs.findAll(), user, prod.findAll());
			wishlist = (WishlistHandler) request.getSession().getAttribute("wishlist");
			session.setAttribute("wishlistProducts", wishlist.getWishProducts());
		}
		return "WishList";
	}

	@GetMapping("wishlistAdd")
	public String wishlistAdd(@RequestParam String prodcode, HttpServletRequest request, HttpServletResponse response) {

		List<Product> prods = (List<Product>) prod.findAll();

		HttpSession session = request.getSession();
		String signedin = (String) request.getSession().getAttribute("signedin");
		WishlistHandler wishlistHandler = (WishlistHandler) request.getSession().getAttribute("wishlist");
		if(wishlistHandler==null) {
			wishlistHandler = new WishlistHandler();

		}
		if (signedin == null || signedin.equalsIgnoreCase("no")) {
			return "signin";
		} else {
			UserProfile user = (UserProfile) session.getAttribute("user");
			System.out.println("username: " + user.getId());
			System.out.println("prodcode" + prodcode);
			boolean found = false;

			for (Product p : wishlistHandler.getWishProducts()) {
				if (p.getCode().equals(prodcode)) {
					System.out.println("found prodode " + prodcode);
					found = true;
				}
			}

			if (found) {
				System.out.println("Already in wishlist");
				return "categories";
			} else {
				for (Product p : prods) {
					if (p.getCode().equals(prodcode)) {
						wishlistHandler.addProduct(p);
						session.setAttribute("wishlistProducts", wishlistHandler.getWishProducts());
					}
				}

				Wishlist wl = new Wishlist();
				wl.setProduct_code(Integer.parseInt(prodcode));
				wl.setUser_id(user.getId());
				wishs.save(wl);
			}
			return "WishList";
		}
	}

	@GetMapping("wishlistDelete")
	public String wishlistDelete(@RequestParam String prodcode, HttpServletRequest request,
			HttpServletResponse response) {

		// get products from db
		List<Product> prods = (List<Product>) prod.findAll();

		HttpSession session = request.getSession();
		String signedin = (String) request.getSession().getAttribute("signedin");
		WishlistHandler wishlistHandler = (WishlistHandler) request.getSession().getAttribute("wishlist");
	
		// get all wishlists from db
		List<Wishlist> theWishs = (List<Wishlist>) wishs.findAll();
		
		// if not signed in, redirect to sign in page
		if (signedin == null || signedin.equalsIgnoreCase("no")) {
			return "signin";
		} else {
			// otherwise, loop through and delete in both db and local object
			for (Wishlist w : theWishs) {
				if (w.getProduct_code() == Integer.parseInt(prodcode)) {
					wishs.delete(w);
					for (Product p : prods) {
						if (p.getCode().equals(prodcode)) {
							wishlistHandler.removeProduct(p);
							session.setAttribute("wishlistProducts", wishlistHandler.getWishProducts());
							break;
						}
					}
				}
			}
			return "WishList";
		}
	}
}
