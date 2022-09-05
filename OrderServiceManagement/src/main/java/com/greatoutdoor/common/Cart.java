package com.greatoutdoor.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CartInfo")
public class Cart {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cartId;
	private long orderId;// refrence to order class
	private String productDetails;
	private int quantity;
	private double totalPrice;

	public Cart() {
		super();
	}

	public Cart(long cartId, long orderId, String productDetails, int quantity, double totalPrice) {
		super();
		this.cartId = cartId;
		this.orderId = orderId;
		this.productDetails = productDetails;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(long cartId) {
		this.cartId = cartId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public String getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(String productDetails) {
		this.productDetails = productDetails;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

}
