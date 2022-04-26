package com.micropos.carts.model;

import java.io.Serializable;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity 
@Table(name="CartItems")
@Accessors(fluent = true, chain = true)
public class CartItem implements Serializable{

	/**
	 *
	 */
	private static final long serialVersionUID = 3584564208528154187L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;

    @Column(name="cart_id")
    @Getter
    @Setter
    private Integer cartId;

    @Column(name="product_id")
    @Getter
    @Setter
    private String productId;


    @Column(name="product_name")
    @Getter
    @Setter
    private String productName;


    @Column(name="quantitty")
    @Getter
    @Setter
    private Integer quantity;

    @Column(name="price")
    @Getter
    @Setter
    private double price;
}