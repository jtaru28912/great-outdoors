package com.greatoutdoor.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OrderInfo")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long orderId;
	private long cartId; // reflects details of cart
	private long addressId;// reflects address;
	private int orderQuantity;
	private String dispatchStatus;
	private String dispatchDate;
	private String deliveryDate;

//default
	public Order() {
		super();
	}

//parameterized
	public Order(long orderId, long cartId, long addressId, int orderQuantity, String dispatchStatus,
			String dispatchDate, String deliveryDate) {
		super();
		this.orderId = orderId;
		this.cartId = cartId;
		this.addressId = addressId;
		this.orderQuantity = orderQuantity;
		this.dispatchStatus = dispatchStatus;
		this.dispatchDate = dispatchDate;
		this.deliveryDate = deliveryDate;
	}

//getter setters
	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public int getOrderQuantity() {
		return orderQuantity;
	}

	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}

	public String getDispatchStatus() {
		return dispatchStatus;
	}

	public void setDispatchStatus(String dispatchStatus) {
		this.dispatchStatus = dispatchStatus;
	}

	public String getDispatchDate() {
		return dispatchDate;
	}

	public void setDispatchDate(String dispatchDate) {
		this.dispatchDate = dispatchDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
