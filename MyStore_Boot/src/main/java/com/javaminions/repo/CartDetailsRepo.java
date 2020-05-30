package com.javaminions.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaminions.pojos.CartDetails;

public interface CartDetailsRepo extends JpaRepository<CartDetails, Integer>{

}
