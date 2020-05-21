package com.javaminions.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javaminions.database.Database;
import com.javaminions.model.LineItem;
import com.javaminions.pojos.Product;

public class CookieMonsterService {
	public static String[] stringify(LineItem lineItem) {

		String cookieName = "cartprod";
		String code;
		String quantity;
		String[] cookieData = new String[2];

		code = lineItem.getProduct().getCode();
		quantity = String.valueOf(lineItem.getQuantity());

		cookieData[0] = "" + cookieName + code;
		cookieData[1] = "" + quantity;

		return cookieData;
	}

	public static LineItem unstringify(Cookie c, List<Product> products) {

		LineItem lineItem = new LineItem();
		String[] trimmer = c.getName().split("cartprod");
		String quantity = c.getValue();

		for (Product p : products) {
			if (p.getCode().equals(trimmer[1])) {
				lineItem.setProduct(p);
				lineItem.setQuantity(Integer.parseInt(quantity));
			} else {
				// unable to return product
			}
		}

		return lineItem;

	}

//	public static void main(String[] args) {
//		Cookie c = new Cookie("cartprod1", "2");
//		List<Product> products = null;
//		try {
//			products = Database.getInstance().getAll();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		System.out.println(unstringify(c, products));
//	}

	public static void updateUserCookies(HttpServletRequest request, HttpServletResponse response, String username,
			String password, String email, String firstname, String lastname) {

		HttpSession session = request.getSession();
		Cookie[] cookies = request.getCookies();
		for (Cookie c : cookies) {
			if (c.getName().contains("userName")) {
				c.setMaxAge(0);
				c.setPath("/");
			}

			if (c.getName().contains("passwordCookie")) {
				c.setMaxAge(0);
				c.setPath("/");
			}

			if (c.getName().contains("emailCookie")) {
				c.setMaxAge(0);
				c.setPath("/");
			}

			if (c.getName().contains("firstNameCookie")) {
				c.setMaxAge(0);
				c.setPath("/");
			}

			if (c.getName().contains("lastNameCookie")) {
				c.setMaxAge(0);
				c.setPath("/");
			}
		}

		Cookie unc = new Cookie("userNameCookie", username);
		unc.setPath("/");
		unc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(unc);

		// Password Cookie
		Cookie pc = new Cookie("passwordCookie", password);
		pc.setPath("/");
		pc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(pc);

		// Email Cookie
		Cookie ec = new Cookie("emailCookie", email);
		ec.setPath("/");
		ec.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(ec);

		// First Name Cookie
		Cookie fnc = new Cookie("firstNameCookie", firstname);
		fnc.setPath("/");
		fnc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(fnc);

		// Last Name Cookie
		Cookie lnc = new Cookie("lastNameCookie", lastname);
		lnc.setPath("/");
		lnc.setMaxAge(60 * 60 * 24 * 365 * 2);
		response.addCookie(lnc);
	}
}
