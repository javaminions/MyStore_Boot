package com.javaminions.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FooterController {
	
	@GetMapping("contactus")
	public String contactUs() {
		return "ContactUs";
	}
	
	@GetMapping("aboutus")
	public String aboutUs() {
		return "AboutUs";
	}
	
	@GetMapping("testimonials")
	public String testimonials() {
		return "Testimonials";
	}
	
	@GetMapping("press")
	public String press() {
		return "Press";
	}
	
	@GetMapping("payments")
	public String payments() {
		return "Payments";
	}
	
	@GetMapping("shipping")
	public String shipping() {
		return "Shipping";
	}
	
	@GetMapping("return")
	public String goToReturn() {
		return "Return";
	}
	
	@GetMapping("faq")
	public String faq() {
		return "FAQ";
	}

}
