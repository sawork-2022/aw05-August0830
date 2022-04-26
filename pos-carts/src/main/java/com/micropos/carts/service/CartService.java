package com.micropos.carts.service;

import java.util.List;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.CartItem;

public interface CartService {
    Cart addCart(Cart cart, CartItem item);
    double checkout(Integer cartId);

    List<Cart> getAllCarts();
}