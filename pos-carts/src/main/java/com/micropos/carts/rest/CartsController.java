package com.micropos.carts.rest;

import java.util.*;

import com.micropos.api.*;
import com.micropos.carts.service.CartService;
import com.micropos.dto.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("carts")
public class CartsController implements CartsApi{

    private CartService cartService;

    /**
     * @param cartService the cartService to set
     */
    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }

    @Override
    public ResponseEntity<List<CartDto>> listCarts(){
        return CartsApi.super.listCarts();
    }

    @Override
    public ResponseEntity<CartDto> addCart(CartDto cartDto){
        return CartsApi.super.addCart(cartDto);
    }

    @Override
    public ResponseEntity<CartDto> getCartById(Integer id){
        return CartsApi.super.getCartById(id);
    }

    @Override
    public ResponseEntity<CartDto> addItemToCart(Integer cartId,CartItemDto cartItemDto){
        return CartsApi.super.addItemToCart(cartId, cartItemDto);
    }

    @Override
    public ResponseEntity<Double> getCartTotalAmount(Integer cartId) {
        double totalAmount =  cartService.checkout(cartId);
        if(cartId==-1d)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(totalAmount);
    }
}
