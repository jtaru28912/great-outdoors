package com.greatoutdoor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatoutdoor.entity.Cart;
import com.greatoutdoor.exception.CartItemException;
import com.greatoutdoor.repo.CartRepo;

@Service
public class CartServiceImpl implements CartService {
//DI
	@Autowired
	CartRepo repo;

	// add
	@Override
	public Cart addToCart(Cart cart) {
		return repo.save(cart);
	}

	// find by id
	@Override
	public Cart findFromCartList(Long s) throws CartItemException {
		return repo.findById(s).orElseThrow(() -> new CartItemException("no such id exist"));
	}

	// delete by id
	@Override
	public String deleteAnItemFromCart(Long c) throws CartItemException {
		repo.findById(c).orElseThrow(() -> new CartItemException("no such id exist"));
		repo.deleteById(c);
		return "item is deleted";
	}

	// find all
	@Override
	public List<Cart> findAllItemOfCart() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	// UPDATE
	@Override
	public Cart updateCart(Cart d, Long c) throws CartItemException {
		Cart e = repo.findById(c).orElseThrow(() -> new CartItemException("no such id exist"));
		// If the Id exists let's update the same with new value;
		e.setTotalPrice(d.getTotalPrice());
		e.setProductDetails(d.getProductDetails());
		e.setQuantity(d.getQuantity());
		repo.save(e);
		return e;

	}

	// delete all
	@Override
	public void deleteAllItemFromCart() {
		repo.deleteAll();

	}

}
