package com.javaminions.controllers;

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
		
		WishlistHandler emptyWish = new WishlistHandler();
		emptyWish.addProduct(new Product());
		if (signedin == null || signedin.equalsIgnoreCase("no")) {
			return "signin";
		} else {
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

		List<Product> prods = (List<Product>) prod.findAll();

		HttpSession session = request.getSession();
		String signedin = (String) request.getSession().getAttribute("signedin");
		WishlistHandler wishlistHandler = (WishlistHandler) request.getSession().getAttribute("wishlist");
		List<Wishlist> theWishs = (List<Wishlist>) wishs.findAll();
		if (signedin == null || signedin.equalsIgnoreCase("no")) {
			return "signin";
		} else {

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
