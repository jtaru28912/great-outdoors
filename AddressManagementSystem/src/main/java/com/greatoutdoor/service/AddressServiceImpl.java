package com.greatoutdoor.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.greatoutdoor.dao.AddressDao;
import com.greatoutdoor.entity.Address;
import com.greatoutdoor.exception.AddressException;

@Service
public class AddressServiceImpl implements AddressService {
	// dependency injection
	@Autowired
	private AddressDao repo;

	// adding address
	@Override
	public Address addAddress(Address addr) {
		return repo.save(addr);
	}

	// update address
	@Override
	public Address updateAddress(Address addr, Long addressId) throws AddressException {
		Address existing = repo.findById(addressId).orElseThrow(() -> new AddressException("No id found"));
		existing.setArea(addr.getArea());
		existing.setBuildingNo(addr.getBuildingNo());
		existing.setCity(addr.getCity());
		existing.setState(addr.getState());
		existing.setStreetName(addr.getStreetName());
		existing.setZip(addr.getZip());
		repo.save(existing);
		return existing;
	}

	// delete address by id
	@Override
	public void deleteAddress(Long addressId) throws AddressException {
		repo.findById(addressId).orElseThrow(() -> new AddressException("No id found"));
		repo.deleteById(addressId);
	}

	// delete all
	@Override
	public void deleteAllItemFromAddress() {
		repo.deleteAll();
	}

	// view all
	@Override
	public List<Address> findAllAddress() {
		return repo.findAll();
	}

	// find by id
	@Override
	public Address findAddressByList(Long s) throws AddressException {
		return repo.findById(s).orElseThrow(() -> new AddressException("Id not found"));
	}

}
