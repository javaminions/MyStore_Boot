package com.javaminions.repo;

import org.springframework.data.repository.CrudRepository;

import com.javaminions.pojos.Cart;

public interface CartRepo extends CrudRepository<Cart, Integer>{

}
