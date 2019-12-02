package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.ecommerce.dto.ReviewDto;
import com.hcl.ecommerce.entity.Review;
import com.hcl.ecommerce.service.ReviewService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ReviewControllerTest {
	
	@InjectMocks
	ReviewController reviewController;
	
	@Mock
	ReviewService reviewService;
	
	@Test
	public void testAddReview() {
		Object actual;
		ReviewDto reviewDto = new ReviewDto();
		reviewDto.setRating(4);
		reviewDto.setUserId(2);
		reviewDto.setStoreId(3);
		
		Review review = new Review();
		review.setReviewId(1);
		review.setStoreId(review.getStoreId());
		review.setUserId(review.getUserId());
		review.setRating(review.getRating());
		
		Mockito.when(reviewService.addReview(reviewDto)).thenReturn("Review added successfully");
		HttpStatus statusCode = reviewController.addReview(reviewDto).getStatusCode();
		assertEquals(HttpStatus.OK, statusCode);
		
		actual = reviewController.addReview(reviewDto).getBody();
		assertEquals("Review added successfully", actual);
		
	}
	
	@Test
	public void testAddReviewForNegative() {
		Object actual;
		ReviewDto reviewDto = null;
		Mockito.when(reviewService.addReview(reviewDto)).thenReturn("Some of the inputs are not found");
		HttpStatus statusCode = reviewController.addReview(reviewDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = reviewController.addReview(reviewDto).getBody();
		assertEquals("Some of the inputs are not found", actual);
		
	}
	
	@Test
	public void testAddReviewForNullNegative() {
		Object actual;
		ReviewDto reviewDto = new ReviewDto();
		reviewDto.setRating(4);
		reviewDto.setUserId(null);
		reviewDto.setStoreId(3);
		
		Review review = new Review();
		review.setReviewId(1);
		review.setStoreId(review.getStoreId());
		review.setUserId(review.getUserId());
		review.setRating(review.getRating());
		
		Mockito.when(reviewService.addReview(reviewDto)).thenReturn("Some of the inputs are not found");
		HttpStatus statusCode = reviewController.addReview(reviewDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = reviewController.addReview(reviewDto).getBody();
		assertEquals("Some of the inputs are not found", actual);
		
	}
	
	@Test
	public void testAddReviewForNegativeNull() {
		Object actual;
		ReviewDto reviewDto = new ReviewDto();
		reviewDto.setRating(4);
		reviewDto.setUserId(2);
		reviewDto.setStoreId(null);
		
		Review review = new Review();
		review.setReviewId(1);
		review.setStoreId(review.getStoreId());
		review.setUserId(review.getUserId());
		review.setRating(review.getRating());
		
		Mockito.when(reviewService.addReview(reviewDto)).thenReturn("Some of the inputs are not found");
		HttpStatus statusCode = reviewController.addReview(reviewDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = reviewController.addReview(reviewDto).getBody();
		assertEquals("Some of the inputs are not found", actual);
		
	}
	
	@Test
	public void testAddReviewForNegativeCase() {
		Object actual;
		ReviewDto reviewDto = new ReviewDto();
		reviewDto.setRating(null);
		reviewDto.setUserId(2);
		reviewDto.setStoreId(3);
		
		Review review = new Review();
		review.setReviewId(1);
		review.setStoreId(review.getStoreId());
		review.setUserId(review.getUserId());
		review.setRating(review.getRating());
		
		Mockito.when(reviewService.addReview(reviewDto)).thenReturn("Some of the inputs are not found");
		HttpStatus statusCode = reviewController.addReview(reviewDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = reviewController.addReview(reviewDto).getBody();
		assertEquals("Some of the inputs are not found", actual);
		
	}
}
