package com.greatoutdoors.service;

import com.greatoutdoors.entity.Address;

public interface AddressService {
	Address addAddress(Address addr);

	Address updateAddress(Address addr, Long addressId);

	void deleteAddress(Long addressId);

}
