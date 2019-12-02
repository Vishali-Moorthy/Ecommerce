package com.hcl.ecommerce.service;

import com.hcl.ecommerce.dto.ReviewDto;

/**
 * This interface defines one method
 * @author Vishalakshi
 *
 */
public interface ReviewService {
	
	/**
	 * This method add review values to the review table
	 * @param reviewRequestDto
	 * @return
	 */
	public String addReview(ReviewDto reviewRequestDto);

}
