package com.hcl.ecommerce.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.StoreProduct;

/**
 * This interface declares one method
 * @author Vishalakshi
 *
 */
@Repository
public interface StoreProductRepository extends JpaRepository<StoreProduct, Integer>{

	/**
	 * This method is used to find the storeProduct from the storeProduct table with the productId
	 * @param productId
	 * @return
	 */
	List<StoreProduct> findByProductId(Integer productId);


}
