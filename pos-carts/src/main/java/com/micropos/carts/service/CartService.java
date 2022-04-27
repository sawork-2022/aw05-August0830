package com.micropos.carts.service;

import java.util.List;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.CartItem;

public interface CartService {
    Cart addItemToCart(Cart cart, CartItem item);
    double checkout(Integer cartId);
    Cart addEmptyCart(Cart cart);
    List<Cart> getAllCarts();
    Cart getCartById(Integer id);
}