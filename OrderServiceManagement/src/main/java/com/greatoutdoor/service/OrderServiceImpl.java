package com.greatoutdoor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatoutdoor.entity.Order;
import com.greatoutdoor.exception.OrderException;
import com.greatoutdoor.repository.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepo repo;

	@Override
	// add order
	public Order placeOrder(Order order) {
		return repo.save(order);
	}

	@Override
	// view all
	public List<Order> findAllOrders() {
		return repo.findAll();
	}

	@Override
	// view by id
	public Order findOrderById(long oId) throws OrderException {
		return repo.findById(oId).orElseThrow(() -> new OrderException("There is no such order id exist"));
	}

	@Override
	// cancel all
	public String cancelAllOrders() {
		repo.deleteAll();
		return "all orders deleted successfuly";
	}

	@Override
	// cancel by order id
	public String cancelOrderById(long oId) throws OrderException {
		if (repo.existsById(oId)) {
			repo.deleteById(oId);
			return "delete succesful";
		} else {
			throw new OrderException("Order Id is Not found");
		}
	}

	@Override
	// update
	public Order updateDate(Long oId, Order od) throws OrderException {
		Order e = repo.findById(oId).orElseThrow(()-> new OrderException("Id not found"));
		e.setDeliveryDate(od.getDeliveryDate());
		e.setDispatchDate(od.getDispatchDate());
		e.setDispatchStatus(od.getDispatchStatus());
		e.setOrderQuantity(od.getOrderQuantity());
		repo.save(e);
		return e;
	
	}

}
