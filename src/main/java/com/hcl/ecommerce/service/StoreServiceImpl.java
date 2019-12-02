package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.repository.StoreRepository;

/**
 * This class contain one method
 * @author Vishalakshi
 *
 */
@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreRepository storeRepository;

	/**
	 * Add store method add store values into the store table
	 */
	@Override
	public String addStore(StoreDto storeDto) {
		Store store = new Store();
		store.setStoreName(storeDto.getStoreName());
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreContactNo(storeDto.getStoreContactNo());
		storeRepository.save(store);
		return "Store added successfully";

	}

}
