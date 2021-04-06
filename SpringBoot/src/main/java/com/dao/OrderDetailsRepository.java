package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.OrderDetails;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

}
