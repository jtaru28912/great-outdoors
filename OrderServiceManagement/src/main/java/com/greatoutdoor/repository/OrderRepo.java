package com.greatoutdoor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatoutdoor.entity.Order;

public interface OrderRepo extends JpaRepository<Order,Long> {

}
