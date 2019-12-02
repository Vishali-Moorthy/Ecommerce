package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.ReviewDto;
import com.hcl.ecommerce.entity.Review;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.entity.User;
import com.hcl.ecommerce.repository.ReviewRepository;
import com.hcl.ecommerce.repository.StoreRepository;
import com.hcl.ecommerce.repository.UserRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ReviewServiceTest {

	@InjectMocks
	ReviewServiceImpl reviewServiceImpl;
	
	@Mock
	ReviewRepository reviewRepository;
	
	@Mock
	UserRepository userRepository;

	@Mock
	StoreRepository storeRepository;
	
	@Test
	public void testAddReview() {
			ReviewDto reviewDto = new ReviewDto();
			User user = new User();
			Store store = new Store();
			user.setUserId(2);
			store.setStoreId(1);
			reviewDto.setRating(2);
			reviewDto.setStoreId(1);
			reviewDto.setUserId(2);
			Review review = new Review();
			review.setReviewId(1);
			review.setRating(reviewDto.getRating());
			review.setStoreId(reviewDto.getStoreId());
			review.setUserId(reviewDto.getUserId());
			Mockito.when(reviewRepository.save(review)).thenReturn(review);
			Mockito.when(userRepository.existsByUserId(2)).thenReturn(true);
			Mockito.when(storeRepository.existsByStoreId(1)).thenReturn(true);
			String result = reviewServiceImpl.addReview(reviewDto);
			
			assertEquals("Review added successfully", result);
			
			ReviewDto reviewDtos = new ReviewDto();
			User users = new User();
			Store stores = new Store();
			users.setUserId(5);
			stores.setStoreId(3);
			reviewDtos.setRating(2);
			reviewDtos.setStoreId(7);
			reviewDtos.setUserId(5);
			Review reviews = new Review();
			reviews.setReviewId(1);
			reviews.setRating(reviewDtos.getRating());
			reviews.setStoreId(reviewDtos.getStoreId());
			reviews.setUserId(reviewDtos.getUserId());
			Mockito.when(reviewRepository.save(reviews)).thenReturn(reviews);
			Mockito.when(userRepository.existsByUserId(5)).thenReturn(true);
			Mockito.when(storeRepository.existsByStoreId(7)).thenReturn(false);
			String results = reviewServiceImpl.addReview(reviewDtos);
			
			assertEquals("StoreId not found", results);
			
			ReviewDto reviewDtos1 = new ReviewDto();
			User users1 = new User();
			Store stores1 = new Store();
			users1.setUserId(5);
			stores1.setStoreId(3);
			reviewDtos1.setRating(2);
			reviewDtos1.setStoreId(3);
			reviewDtos1.setUserId(6);
			Review reviews1 = new Review();
			reviews1.setReviewId(1);
			reviews1.setRating(reviewDtos1.getRating());
			reviews1.setStoreId(reviewDtos1.getStoreId());
			reviews1.setUserId(reviewDtos1.getUserId());
			Mockito.when(reviewRepository.save(reviews1)).thenReturn(reviews1);
			Mockito.when(userRepository.existsByUserId(6)).thenReturn(false);
			Mockito.when(storeRepository.existsByStoreId(3)).thenReturn(true);
			String results1 = reviewServiceImpl.addReview(reviewDtos1);
			
			assertEquals("UserId not found", results1);
		
		}
	
	
}
