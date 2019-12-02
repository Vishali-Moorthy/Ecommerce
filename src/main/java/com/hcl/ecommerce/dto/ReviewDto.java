package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ReviewDto class has three fields
 * @author Vishalakshi
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {
	
	private Integer userId;
	private Integer storeId;
	private Integer rating;


}
