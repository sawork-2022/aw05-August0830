package com.micropos.carts.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.*;

@Entity
@Table(name = "carts")
@Accessors(fluent = true, chain=true)
public class Cart implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5555559482394141750L;

    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Integer id;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(name="cartItems",
    joinColumns = @JoinColumn(name="cart_id"))
    @Getter
    @Setter
    private List<CartItem> cartItems = new ArrayList<>();

    public Cart(){
        id = -1;
    }

    public Cart(Integer id, List<CartItem> cartItems){
        this.id = id;
        if(cartItems!=null && !cartItems.isEmpty())
            this.cartItems.addAll(cartItems);
    }

    public boolean addItem(CartItem item){
        return cartItems.add(item);
    }

    public boolean removeItem(CartItem item){
        return cartItems.remove(item);
    }

	public Object id(@NotNull Integer id2) {
		return null;
	}
}