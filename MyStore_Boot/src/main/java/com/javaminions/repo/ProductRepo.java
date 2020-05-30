package com.javaminions.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaminions.pojos.Product;

public interface ProductRepo extends JpaRepository<Product, String>{

}
