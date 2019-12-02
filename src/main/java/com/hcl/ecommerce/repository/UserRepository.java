package com.hcl.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.ecommerce.entity.User;

/**
 * This interface declares one method
 * @author Vishalakshi
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	/**
	 * This method is used to check whether the userId is present in the user table
	 * @param userId
	 * @return
	 */
	boolean existsByUserId(Integer userId);


}
