package com.greatoutdoors.service;

import java.util.List;

import com.greatoutdoors.entity.Wishlist;
import com.greatoutdoors.exception.ResourceNotFoundException;

public interface WishlistService {
	List<Wishlist> viewAllItemsOfWishlist();

	void deleteWishlistByUserId(Long wid) throws ResourceNotFoundException;

	Wishlist findPriductInWishlist(Long wish);

	Wishlist addProductToWishlist(Wishlist w);

	void deleteAllWishlist() ;

}
