package com.greatoutdoor.service;

import java.util.List;

import com.greatoutdoor.entity.Address;
import com.greatoutdoor.exception.AddressException;

public interface AddressService {
	//addition
	Address addAddress(Address addr);
	//upgradation of address
	Address updateAddress(Address addr, Long addressId) throws AddressException;
	//delete address by id
	void deleteAddress(Long addressId) throws AddressException;
	//delete all
	public void deleteAllItemFromAddress();
	//find all address
	public List<Address> findAllAddress();
	//find by id
	public Address findAddressByList(Long s) throws AddressException;


}
