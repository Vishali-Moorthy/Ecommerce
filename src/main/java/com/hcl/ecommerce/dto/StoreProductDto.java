package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * StoreProductDto has five fields
 * @author Vishalakshi
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class StoreProductDto {
	
	private Integer storeId;
	private Integer productId;
	private Integer discount;
	private Double finalPrice;
	private Double rating;

}
