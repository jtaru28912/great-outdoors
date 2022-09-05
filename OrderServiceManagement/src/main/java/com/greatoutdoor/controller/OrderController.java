package com.greatoutdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.greatoutdoor.common.Address;
import com.greatoutdoor.common.Cart;
import com.greatoutdoor.common.RequestResponse;
import com.greatoutdoor.entity.Order;
import com.greatoutdoor.exception.OrderException;
import com.greatoutdoor.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
	// DI
	@Autowired
	OrderService service;
	// DI
	// restTemplate will aloow restful web services /APi
	@Autowired
	private RestTemplate restTemplate;

	// constructor
	public OrderController(OrderService service) {
		super();
		this.service = service;
	}

	// add
	@PostMapping("/add")
	public RequestResponse placeOrder(@RequestBody RequestResponse rr) {
		Cart c = new Cart();
		// constructor calling cart class
		c = restTemplate.postForObject("http://localhost:8888/cart/add", rr.getCartId(), Cart.class);
		Address a = new Address();
		// constructor call to address class
		a = restTemplate.postForObject("http://localhost:8889/address/add", rr.getAddressId(), Address.class);
		Order o = new Order();
		// constructor of 1st service i.e order
		o.setCartId(c.getCartId());
		// linking done with cart
		o.setAddressId(a.getAddressId());
		// linking from address done
		o.setOrderId(rr.getOrderId());
		o.setDeliveryDate(rr.getDeliveryDate());
		o.setDispatchDate(rr.getDispatchDate());
		o.setDispatchStatus(rr.getDispatchStatus());
		o.setOrderQuantity(rr.getOrderQuantity());

		o = service.placeOrder(o);
		return new RequestResponse(o.getOrderId(), c, a, o.getOrderQuantity(), o.getDispatchStatus(),
				o.getDispatchDate(), o.getDeliveryDate());
	}

	// find all orders
	@GetMapping("/findall")
	public List<Order> findAllOrders() {
		return service.findAllOrders();
	}

	// find by id
	@GetMapping("findall/{orderId}")
	public RequestResponse findOrderById(@PathVariable("orderId") long orderId) throws OrderException {
		Cart cart = new Cart();
		Address a = new Address();
		Order o = service.findOrderById(orderId);
		cart = restTemplate.getForObject("http://localhost:8888/cart/view/" + o.getCartId(), Cart.class);
		a = restTemplate.getForObject("http://localhost:8889/address/view/" + o.getAddressId(), Address.class);
		return new RequestResponse(o.getOrderId(), cart, a, o.getOrderQuantity(), o.getDispatchStatus(),
				o.getDispatchDate(), o.getDeliveryDate());
	}

	// Delete All Orders
	@DeleteMapping("/deleteAllOrders")
	public String cancelAllOrders() throws OrderException {
		return service.cancelAllOrders();
	}

	// Delete Order By Using Order Id
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAnItemFromCart(@PathVariable("id") Long oId) throws OrderException {
		service.cancelOrderById(oId);
		return new ResponseEntity<String>("Order deleted successfully!", HttpStatus.OK);
	}

	// updating the date
	@PutMapping("update/{id}")
	public RequestResponse updateOrders(@PathVariable("id") Long id, @RequestBody RequestResponse rr)
			throws OrderException {
		Cart c = new Cart();
		Address a = new Address();
		Order o = service.findOrderById(id);

		restTemplate.put("http://localhost:8888/cart/update/" + o.getCartId(), rr.getCartId(), Cart.class);
		restTemplate.put("http://localhost:8889/address/update/" + o.getAddressId(), rr.getAddressId(), Address.class);

		c = restTemplate.getForObject("http://localhost:8888/cart/view/" + o.getCartId(), Cart.class);
		a = restTemplate.getForObject("http://localhost:8889/address/view/" + o.getAddressId(), Address.class);

		Order od = new Order();
		od.setOrderId(rr.getOrderId());
		od.setDeliveryDate(rr.getDeliveryDate());
		od.setDispatchDate(rr.getDispatchDate());
		od.setDispatchStatus(rr.getDispatchStatus());
		od.setOrderQuantity(rr.getOrderQuantity());
		o = service.updateDate(id, od);
		return new RequestResponse(id, c, a, o.getOrderQuantity(), o.getDispatchStatus(), o.getDispatchDate(),
				o.getDeliveryDate());
	}

}
