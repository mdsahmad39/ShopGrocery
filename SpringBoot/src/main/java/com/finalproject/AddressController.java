package com.finalproject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AddressDao;
import com.dto.Address;

@RestController
public class AddressController {

	@Autowired
	AddressDao addressDao;
	
	@GetMapping("/getAddress/{Id}")
	public Address getAddress(@PathVariable("Id") Integer addressId)
	{
		Address address=addressDao.getAddressById(addressId);
		return(address);
	}
	
	@PostMapping("/registerAddress")
	public void postAddress(@RequestBody Address address)
	{
		addressDao.register(address);
	}
	
	@GetMapping("/getAll")
	public List<Address> getAll()
	{
		return(addressDao.getAll());
	}
}
