package com.greatoutdoor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.greatoutdoor.entity.Address;
import com.greatoutdoor.exception.AddressException;
import com.greatoutdoor.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	private AddressService service;

	public AddressController(AddressService service) {
		super();
		this.service = service;
	}

	// adding
	@PostMapping("/add")
	public ResponseEntity<Address> addAddress(@RequestBody Address addr) {
		return new ResponseEntity<Address>(service.addAddress(addr), HttpStatus.CREATED);
	}

	// updating
	@PutMapping("update/{addressId}")
	public ResponseEntity<Address> updateAirport(@RequestBody Address addr, @PathVariable("addressId") Long addressId)
			throws AddressException {
		return new ResponseEntity<Address>(service.updateAddress(addr, addressId), HttpStatus.OK);
	}

	// finding all
	@GetMapping("/viewall")
	public List<Address> findAllItemOfCart() {
		return service.findAllAddress();
	}

	// view by id
	@GetMapping("/view/{id}")
	public ResponseEntity<Address> findFromCartList(@PathVariable("id") Long cid) throws AddressException {
		return new ResponseEntity<Address>(service.findAddressByList(cid), HttpStatus.OK);
		// status -- 200
	}

	// deleting the data
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteAddress(@PathVariable("id") Long addressId) throws AddressException {
		// delete airport db
		service.deleteAddress(addressId);
		return new ResponseEntity<String>("Address record deleted successfully!", HttpStatus.OK);
	}

	// deleting all
	@DeleteMapping("/deleteAll")
	public void deleteAllAddress() {
		service.deleteAllItemFromAddress();
	}
}
