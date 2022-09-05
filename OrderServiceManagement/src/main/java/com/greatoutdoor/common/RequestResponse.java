package com.greatoutdoor.common;

public class RequestResponse {
	private long orderId;
	private Cart cartId; // reflects details of cart
	private Address addressId;// details of address are joined
	private int orderQuantity;
	private String dispatchStatus;
	private String dispatchDate;
	private String deliveryDate;

	// default
	public RequestResponse() {
		super();
	}

	// parameterized
	public RequestResponse(long orderId, Cart cartId, Address addressId, int orderQuantity, String dispatchStatus,
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

	// getter setter
	public Address getAddressId() {
		return addressId;
	}

	public void setAddressId(Address addressId) {
		this.addressId = addressId;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public Cart getCartId() {
		return cartId;
	}

	public void setCartId(Cart cartId) {
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
