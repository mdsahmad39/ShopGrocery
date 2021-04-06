package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dto.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query(value = "SELECT * FROM PRODUCT WHERE STORE_ID = ?1", nativeQuery = true)
	List<Product> findByStoreId(String storeId);

}
