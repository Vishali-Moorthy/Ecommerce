package com.hcl.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.ReviewDto;
import com.hcl.ecommerce.entity.Review;
import com.hcl.ecommerce.repository.ReviewRepository;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.repository.UserRepository;

/**
 * This class contains one method
 * @author Vishalakshi
 *
 */
@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private StoreRepository storeRepository;

	/**
	 * This method add review values to the review table
	 */
	@Override
	public String addReview(ReviewDto reviewRequestDto) {
		Review review = new Review();
		Integer userId = reviewRequestDto.getUserId();
		Integer storeId = reviewRequestDto.getStoreId();

		if (userRepository.existsByUserId(userId)) {
			if (storeRepository.existsByStoreId(storeId)) {
				review.setUserId(userId);
				review.setStoreId(storeId);
				review.setRating(reviewRequestDto.getRating());
			} else {
				return "StoreId not found";
			}
		} else {
			return "UserId not found";
		}

		reviewRepository.save(review);
		return "Review added successfully";

	}
}
