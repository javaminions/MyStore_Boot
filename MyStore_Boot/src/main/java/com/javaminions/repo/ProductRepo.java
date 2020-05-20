package com.javaminions.repo;

import org.springframework.data.repository.CrudRepository;

import com.javaminions.pojos.Product;

public interface ProductRepo extends CrudRepository<Product, String>{

}
