package com.greatoutdoors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatoutdoors.dao.AddressDao;
import com.greatoutdoors.entity.Address;
import com.greatoutdoors.exception.ResourceNotFoundException;

@Service
public class AddressServiceImpl implements AddressService{
	
	@Autowired
	private AddressDao repo;
	
	@Override
	public Address addAddress(Address addr) {
		// TODO Auto-generated method stub
		return repo.save(addr);
	}

	@Override
	public Address updateAddress(Address addr, Long addressId) {
		// TODO Auto-generated method stub
		Address existing =repo.findById(addressId)
				.orElseThrow(()-> new ResourceNotFoundException("Address", "addressId", addressId) );
		existing.setArea(addr.getArea());
		existing.setBuildingNo(addr.getBuildingNo());
		existing.setCity(addr.getCity());
		existing.setState(addr.getState());
		existing.setStreetName(addr.getStreetName());
		existing.setZip(addr.getZip());
		repo.save(existing);
		return existing;
	}

	@Override
	public void deleteAddress(Long addressId) {
		// TODO Auto-generated method stub
		repo.findById(addressId).orElseThrow(() -> new ResourceNotFoundException("Address", "Id", addressId));
		repo.deleteById(addressId);
	}

}
