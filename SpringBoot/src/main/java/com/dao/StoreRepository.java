package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dto.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Integer> {

	Store findByLoginIdAndPassword(String loginId, String password);

}
