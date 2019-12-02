package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.ReviewDto;
import com.hcl.ecommerce.service.ReviewService;

/**
 * The Review controller consists of one method
 * @author Vishalakshi
 *
 */
@RestController
@RequestMapping("/reviews")
public class ReviewController {
	
	@Autowired
	private ReviewService reviewService;
	
	/**
	 * Add method add reviews given by the user in the review table
	 * @param reviewRequestDto
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<String> addReview(@RequestBody ReviewDto reviewRequestDto) {
		if(reviewRequestDto == null || reviewRequestDto.getRating() == null || reviewRequestDto.getStoreId() == null || reviewRequestDto.getUserId() == null) {
			return new ResponseEntity<>("Some of the inputs are not found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(reviewService.addReview(reviewRequestDto), HttpStatus.OK);
	}

}
