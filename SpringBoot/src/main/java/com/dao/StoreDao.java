package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.Store;

@Service
public class StoreDao {
	
	@Autowired
	StoreRepository storeRepository;
	
	public void register(Store store) {
		storeRepository.save(store);
	}
	
	public List<Store> getAllStores(){
		return storeRepository.findAll();
	}

	public Store verfiyStore(String loginId, String password) {
		return storeRepository.findByLoginIdAndPassword(loginId, password);
	}

	public Store getById(Integer storeId) {
		return storeRepository.findById(storeId).orElse(null);
	}

	public void updateSeller(Store store) {
		storeRepository.save(store);	
	}

	public long countStores() {
		return storeRepository.count();
	}

}
