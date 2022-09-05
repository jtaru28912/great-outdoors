package com.greatoutdoor.service;

import java.util.List;

import com.greatoutdoor.entity.Cart;
import com.greatoutdoor.exception.CartItemException;

public interface CartService {
	//add
	Cart addToCart(Cart cart);
	//find by id
	public Cart findFromCartList(Long s) throws CartItemException;
	//find all
	public List<Cart> findAllItemOfCart();
	//delete by id
	public String deleteAnItemFromCart(Long c) throws CartItemException;
	//delete all
	public void deleteAllItemFromCart();
	//update
	public Cart updateCart(Cart d, Long c) throws CartItemException;

}
