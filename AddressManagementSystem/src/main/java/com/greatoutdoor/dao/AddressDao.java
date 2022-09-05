package com.greatoutdoor.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatoutdoor.entity.Address;

public interface AddressDao extends JpaRepository<Address, Long>{
//Jpa repo is an interface which allow to use various functions 
}
