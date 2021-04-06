package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Address;

@Service
public class AddressDao {

	@Autowired
	AddressRepository addressRepository;
	
	public void register(Address address) {
		addressRepository.save(address);
	}

	public List<Address> getAll() {
		return(addressRepository.findAll());
	}

	public Address getAddressById(Integer addressId) {
		return(addressRepository.findById(addressId).orElse(null));
	}
}
