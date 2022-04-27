package com.micropos.carts.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.micropos.carts.model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
}