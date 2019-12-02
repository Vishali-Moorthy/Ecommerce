package com.hcl.ecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * StoreProduct class five fields with storeProductId as primary key
 * @author Vishalakshi
 *
 */
@Entity
@Table(name = "store_product")
@Getter
@Setter
@NoArgsConstructor
public class StoreProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer storeProductId;
	private Integer storeId;
	private Integer productId;
	private Integer discount;
	private Double finalPrice;
	
	

}
