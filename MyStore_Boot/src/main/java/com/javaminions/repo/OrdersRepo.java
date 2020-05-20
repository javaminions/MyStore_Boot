package com.javaminions.repo;

import org.springframework.data.repository.CrudRepository;

import com.javaminions.pojos.Orders;

public interface OrdersRepo extends CrudRepository<Orders, Integer>{

}
