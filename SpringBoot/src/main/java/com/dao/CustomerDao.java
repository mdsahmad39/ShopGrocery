package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Customer;

@Service
public class CustomerDao {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public void register(Customer user) {
		customerRepository.save(user);
	}
	
	public Customer verifyCustomerInfo(String loginId, String password) {
		return customerRepository.findByLoginIdAndPassword(loginId, password);
	}

	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer getCustomerById(Integer addressId) {
		return (customerRepository.findById(addressId).orElse(null));
	}

	public void update(Customer customer) {
		customerRepository.save(customer);
	}
	
}
