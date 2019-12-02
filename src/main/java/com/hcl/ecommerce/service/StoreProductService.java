package com.hcl.ecommerce.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.hcl.ecommerce.dto.StoreProductDto;

/**
 * This interface defines two methods
 * @author Vishalakshi
 *
 */
public interface StoreProductService {
	
	/**
	 * Add storeProduct method add store and product values into the storeproduct table
	 * @param storeProductRequestDto
	 * @return
	 */
	public String addStoreProduct(@RequestBody StoreProductDto storeProductRequestDto);
	
	/**
	 * This method search the product from the storeproduct table with the given productId
	 * @param productId
	 * @return
	 */
	public List<StoreProductDto> searchProductById(Integer productId);

}
