package com.javaminions.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaminions.pojos.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}
