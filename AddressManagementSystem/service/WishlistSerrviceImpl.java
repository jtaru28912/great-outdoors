package com.greatoutdoors.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatoutdoors.dao.WishlistDao;
import com.greatoutdoors.entity.Wishlist;
import com.greatoutdoors.exception.ResourceNotFoundException;
@Service
public class WishlistSerrviceImpl implements WishlistService {

	@Autowired
	private WishlistDao repo;

	@Override
	public List<Wishlist> viewAllItemsOfWishlist() {
		return repo.findAll();
	}

	@Override
	public void deleteWishlistByUserId(Long wid) throws ResourceNotFoundException {
		Optional<Wishlist> k = repo.findById(wid);
		Wishlist l = k.get();
		if (l.equals(null)) {
			throw new ResourceNotFoundException("Wishlist", "Id", wid);
		}
		repo.deleteById(wid);
	}

	@Override
	public Wishlist findPriductInWishlist(Long wish) {
		return repo.findById(wish).orElseThrow(() -> new ResourceNotFoundException("Wishlist", "Id", wish));
	}

	@Override
	public Wishlist addProductToWishlist(Wishlist w) {
		return repo.save(w);
	}

	@Override
	public void deleteAllWishlist() {
		repo.deleteAll();
	}

}
