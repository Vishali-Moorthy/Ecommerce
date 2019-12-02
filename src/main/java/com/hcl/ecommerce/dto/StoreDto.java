package com.hcl.ecommerce.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * StoreDto has three fields
 * @author Vishalakshi
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class StoreDto {
	
	private String storeName;
	private String storeLocation;
	private long storeContactNo;

}
