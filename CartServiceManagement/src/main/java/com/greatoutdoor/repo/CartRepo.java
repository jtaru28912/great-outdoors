package com.greatoutdoor.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.greatoutdoor.entity.Cart;

public interface CartRepo extends JpaRepository<Cart,Long>{

}
