package com.micropos.carts.mapper;

import java.util.*;

import com.micropos.carts.*;
import com.micropos.carts.model.Cart;
import com.micropos.carts.model.CartItem;
import com.micropos.dto.CartDto;
import com.micropos.dto.CartItemDto;
import com.micropos.dto.ProductDto;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

@Mapper
public interface CartMapper {
    Collection<Cart> toCarts(Collection<CartDto> cartDtos);
    Collection<CartDto> toCartDtos(Collection<Cart> carts);

    CartItem  toCartItem(CartItemDto cartItemDto);
    CartItemDto toCartItemDto(CartItem cartItem);

    Cart toCart(CartDto cartDto);
    CartDto toCartDto(Cart cart);
}