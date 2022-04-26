package com.micropos.carts.service;

import java.util.List;
import java.util.Optional;

import com.micropos.carts.model.Cart;
import com.micropos.carts.model.CartItem;
import com.micropos.carts.repository.CartRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class CartServiceImp implements CartService {

    private CartRepository cartRepository;
    /**
     * @param cartRepository the cartRepository to set
     */
    @Autowired
    public void setCartRepository(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    /**
     * @param cartMapper the cartMapper to set
     */
    @Autowired
    public void setCartMapper(CartMapper cartMapper) {
        this.cartMapper = cartMapper;
    }

    @Override
    public Cart addCart(Cart cart, CartItem item) {
        // TODO Auto-generated method stub
        if(cart.addItem(item))
            return cartRepository.save(cart);
        return null;
    }

    @Override
    public double checkout(Integer cartId) {
        // TODO Auto-generated method stub
        Optional<Cart> cart = this.cartRepository.findById(cartId);
        if(cart.isEmpty())
            return -1.0;
        Cart realCart = cart.get();
        double sum = 0;
        for(CartItem item: realCart.cartItems()){
            sum += item.price()*item.quantity();
        }
    }

    @Override
    public List<Cart> getAllCarts() {
        // TODO Auto-generated method stub
        return Streamable.of(cartRepository.findAll()).toList();
    }

}