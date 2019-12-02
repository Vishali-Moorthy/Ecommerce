package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ProductDto class has two fields
 * @author Vishalakshi
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class ProductDto {
	
	private String productName;
	private Double price;

}
