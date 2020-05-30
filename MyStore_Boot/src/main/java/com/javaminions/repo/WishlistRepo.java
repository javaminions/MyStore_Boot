package com.javaminions.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaminions.pojos.Wishlist;

public interface WishlistRepo extends JpaRepository<Wishlist, Integer>{

}
