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
 * Store class four fields with storeId as primary key
 * @author Vishalakshi
 *
 */
@Entity
@Table(name = "store")
@Getter
@Setter
@NoArgsConstructor
public class Store {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer storeId;
	private String storeName;
	private String storeLocation;
	private long storeContactNo;
	
	

}
