package com.greatoutdoor.service;

import java.util.List;

import com.greatoutdoor.entity.Order;
import com.greatoutdoor.exception.OrderException;

public interface OrderService {
	// placr order
	public Order placeOrder(Order order);

	// all order placed
	public List<Order> findAllOrders();

	// find order by id
	public Order findOrderById(long oId) throws OrderException;

	// cancel all order
	public String cancelAllOrders() throws OrderException;

	// cancel order by order id
	public String cancelOrderById(long oId) throws OrderException, OrderException;

	// update order date dispatch status etc..
	public Order updateDate(Long oId, Order od) throws OrderException;

}
