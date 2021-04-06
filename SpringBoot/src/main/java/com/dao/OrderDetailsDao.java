package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.OrderDetails;

@Service
public class OrderDetailsDao {
	
	@Autowired
	OrderDetailsRepository orderDetailsRepository;
	
	public void register(OrderDetails orderdetails) {
		orderDetailsRepository.save(orderdetails);
	}

}
