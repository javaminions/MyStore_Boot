package com.javaminions.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaminions.pojos.Orders;

public interface OrdersRepo extends JpaRepository<Orders, Integer>{

}
