package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;

/**
 * This interface declares three methods
 * @author Vishalakshi
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	/**
	 * This method used to find the product in the product table with the productId
	 * @param productId
	 * @return
	 */
	Product findByProductId(Integer productId);

	/**
	 * This method used to find the product in the product table with the product name
	 * @param string
	 * @return
	 */
	Product findByProductName(String string);

	/**
	 * This method is to save the productDto
	 * @param productDto
	 * @return
	 */
	String save(ProductDto productDto);


}
