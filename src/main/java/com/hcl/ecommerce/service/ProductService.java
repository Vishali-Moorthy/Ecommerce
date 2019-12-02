package com.hcl.ecommerce.service;

import java.util.List;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;

/**
 * This interface defines two methods
 * @author Vishalakshi
 *
 */
public interface ProductService {
	
	/**
	 * This method add product values into the product table
	 * @param productRequestDto
	 * @return
	 */
	public String addProduct(ProductDto productRequestDto);
	
	/**
	 * This method search product with the product name in the product table
	 * @param productName
	 * @return
	 * @throws ProductNotFoundException
	 */
	public List<Product> searchProduct(String productName) throws ProductNotFoundException;

}
