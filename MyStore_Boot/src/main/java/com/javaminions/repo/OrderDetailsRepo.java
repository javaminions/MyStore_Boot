package com.javaminions.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaminions.pojos.OrderDetails;

public interface OrderDetailsRepo extends JpaRepository<OrderDetails, Integer>{

}
