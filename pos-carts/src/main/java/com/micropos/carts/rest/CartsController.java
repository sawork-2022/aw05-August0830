package com.micropos.carts.rest;

import java.util.*;

import com.micropos.api.*;
import com.micropos.carts.mapper.CartMapper;
import com.micropos.carts.model.*;
import com.micropos.carts.service.CartService;
import com.micropos.dto.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("poscarts")
public class CartsController implements CartsApi{

    private CartService cartService;
    private CartMapper cartMapper;

    public CartsController(CartService cartService,CartMapper cartMapper){
        this.cartService = cartService;
        this.cartMapper = cartMapper;
    }

    @Override
    @GetMapping("/carts")
    public ResponseEntity<List<CartDto>> listCarts(){
        List<CartDto> carts = new ArrayList<>(cartMapper.toCartDtos(cartService.getAllCarts()));
        if(carts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(carts,HttpStatus.OK);
    }

    @Override
    @PostMapping("/carts")
    public ResponseEntity<CartDto> addCart(@RequestBody CartDto cartDto){
        Cart cart = cartMapper.toCart(cartDto);
        if(cart==null)
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        Cart resCart = cartService.addEmptyCart(cart);
        if(resCart==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(cartDto,HttpStatus.OK);
    }

    @Override
    @GetMapping("/carts/{cartId}")
    public ResponseEntity<CartDto> getCartById(@PathVariable("cartId") Integer id){
        Cart cart = cartService.getCartById(id);
        if(cart==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CartDto cartDto = cartMapper.toCartDto(cart);
        return new ResponseEntity<>(cartDto,HttpStatus.OK);
    }

    @Override
    @PostMapping("/carts/{cartId}")
    public ResponseEntity<CartDto> addItemToCart(@PathVariable("cartId") Integer cartId,@RequestBody CartItemDto cartItemDto){
        Cart cart = cartService.getCartById(cartId);
        if(cart==null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CartItem item = cartMapper.toCartItem(cartItemDto);
        Cart resCart = cartService.addItemToCart(cart, item);
        if(resCart == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        CartDto resCartDto = cartMapper.toCartDto(resCart);
        return new ResponseEntity<>(resCartDto,HttpStatus.OK);
    }

    @Override
    @GetMapping("/carts/{cartId}/totalAmount")
    public ResponseEntity<Double> getCartTotalAmount(@PathVariable("cartId") Integer cartId) {
        double totalAmount =  cartService.checkout(cartId);
        if(cartId==-1d)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(totalAmount);
    }
}
