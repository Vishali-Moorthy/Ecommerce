package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.Review;

/**
 * This interface declares three methods
 * @author Vishalakshi
 *
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{

	/**
	 * This method is used to check whether the userId is present in the user table
	 * @param userId
	 * @return
	 */
	boolean existsByUserId(Integer userId);

	/**
	 * This method is used to check whether the storeId is present in the store table
	 * @param storeId
	 * @return
	 */
	boolean existsByStoreId(Integer storeId);

	/**
	 * This method is used to find the store by storeId
	 * It contains a query which is used for calculating the average of rating
	 * @param storeId
	 * @return
	 */
	@Query("select avg(s.rating) from Review s where s.storeId = ?1")
	Double findByStoreId(Integer storeId);

}
