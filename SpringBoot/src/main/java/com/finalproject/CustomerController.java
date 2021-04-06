package com.finalproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.AddressDao;
import com.dao.CustomerDao;
import com.dto.Address;
import com.dto.Customer;

@RestController
public class CustomerController {

	@Autowired
	CustomerDao customerDao;
	
	@Autowired
	AddressDao addressDao;
	
	@PostMapping("/registerCustomer")
	public void registerCustomer(@RequestBody Customer customer) {
		customerDao.register(customer);
	}
	
//	private String houseNo;
//	private String street;
//	private String city;
//	private long pincode;
//	private String state;
//	private String country;
	
	@GetMapping("/register")
	public void register() {
		Address address = new Address("3-38", "Gachibowli", "HYD", 342423, "TG", "India");
		addressDao.register(address);
		Customer customer = new Customer("ahmad", "ali", "male", address, "hello@gmail.com", 8989898989l, "ahmad12", "password");
		customerDao.register(customer);
	}
	
	@GetMapping("/loginCustomer/{loginId}/{password}")
	public Customer loginUser(@PathVariable("loginId") String loginId, @PathVariable("password") String password) {
		return customerDao.verifyCustomerInfo(loginId, password);
	}
	
	@GetMapping("/GetCustomerById/{Id}")
	public Customer getCustomerById(@PathVariable("Id") Integer addressId)
	{
		return customerDao.getCustomerById(addressId);
	}
	
	@PostMapping("/updateCustomer")
	public void updateCustomer(@RequestBody Customer customer)
	{
		customerDao.update(customer);
	}
}
