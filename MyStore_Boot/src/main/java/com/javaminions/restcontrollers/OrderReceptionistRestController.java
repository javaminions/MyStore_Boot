package com.javaminions.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaminions.repo.ProductRepo;
import com.javaminions.service.OrderReceptionistService;

@RestController
public class OrderReceptionistRestController {
	
	@Autowired
	ProductRepo p;
	
	@RequestMapping("orderconfirmation/{id}/{quantity}")
	@ResponseBody
	public String confirmOrder(@PathVariable int id, @PathVariable int quantity) {
		return OrderReceptionistService.updateProductCount(p, id, quantity);
	}

}
