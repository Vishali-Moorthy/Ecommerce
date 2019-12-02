package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.StoreDto;

/**
 * This interface defines one method
 * @author Vishalakshi
 *
 */
public interface StoreService {
	
	/**
	 * Add store method add values into the store table
	 * @param storeDto
	 * @return
	 */
	public String addStore(StoreDto storeDto);

}
