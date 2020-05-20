package com.javaminions.repo;

import org.springframework.data.repository.CrudRepository;

import com.javaminions.pojos.OrderDetails;

public interface OrderDetailsRepo extends CrudRepository<OrderDetails, Integer>{

}
