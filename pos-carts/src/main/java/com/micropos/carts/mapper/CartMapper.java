package com.micropos.carts.mapper;

import java.util.*;

import com.micropos.carts.*;
import com.micropos.carts.model.Cart;
import com.micropos.carts.model.CartItem;
import com.micropos.dto.CartDto;
import com.micropos.dto.CartItemDto;
import com.micropos.dto.ProductDto;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CartMapper {
    Collection<Cart> toCarts(Collection<CartDto> cartDtos);
    Collection<CartDto> toCartDtos(Collection<Cart> carts);

    default Cart toCart(CartDto cartDto){
        return new Cart().id(cartDto.getId()).cartItems(toCartItems(cartDto.getItems(),cartDto));
    }

    default CartDto toCartDto(Cart cart){
        return new CartDto().id(cart.id()).items(toCartItemDtos(cart.cartItems()));
    }

    default CartItemDto toCartItemDto(CartItem cartItem){
        return new CartItemDto().id(cartItem.id())
                        .quantity(cartItem.quantity())
                        .product(getProductDto(cartItem));
    }

    default ProductDto getProductDto(CartItem cartItem){
        return new ProductDto().id(cartItem.productId())
                            .name(cartItem.productName())
                            .price(cartItem.price());
    }

    default List<CartItem> toCartItems(List<CartItemDto> cartItemDtos, CartDto cartDto){
        if(cartItemDtos == null || cartItemDtos.isEmpty())
            return null;
        List<CartItem> list = new ArrayList<>(cartItemDtos.size());
        for(CartItemDto cartItemDto:cartItemDtos){
            list.add(toCartItem(cartItemDto,cartDto));
        }
        return list;
    }

    default CartItem toCartItem(CartItemDto cartItemDto,CartDto cartDto){
        return new CartItem().id(cartItemDto.getId())
                            .cartId(cartDto.getId())
                            .productId(cartItemDto.getProduct().getId())
                            .productName(cartItemDto.getProduct().getName())
                            .quantity(cartItemDto.getQuantity())
                            .price(cartItemDto.getProduct().getPrice());
    }

    default List<CartItemDto> toCartItemDtos(List<CartItem> items){
        if(items == null || items.isEmpty())
            return null;
        List<CartItemDto> list = new ArrayList<>(items.size());
        for(CartItem item : items){
            list.add(toCartItemDto(item));
        }
        return list;
    }
}