package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.Store;

/**
 * This interface declares three methods
 * @author Vishalakshi
 *
 */
@Repository
public interface StoreRepository extends JpaRepository<Store, Integer>{

	/**
	 * This method is used to check whether the storeId is present in the store table
	 * @param storeId
	 * @return
	 */
	boolean existsByStoreId(Integer storeId);

	/**
	 * This method is used to find the store with the storeId
	 * @param storeId
	 * @return
	 */
	Store findByStoreId(Integer storeId);

	/**
	 * This method is used to find the store with the store name
	 * @param storeName
	 * @return
	 */
	Store findByStoreName(String storeName);

}
