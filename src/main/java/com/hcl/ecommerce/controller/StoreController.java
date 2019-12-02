package com.hcl.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.service.StoreService;

/**
 * The Store controller contains one method
 * @author Vishalakshi
 *
 */
@RestController
@RequestMapping("/stores")
public class StoreController {

	@Autowired
	private StoreService storeService;

	/**
	 * Add store method add store values into the store table
	 * @param storeDto
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<String> addStore(@RequestBody StoreDto storeDto) {
		if (storeDto == null || storeDto.getStoreName() == null || storeDto.getStoreLocation() == null
				|| storeDto.getStoreContactNo() == 0) {
			return new ResponseEntity<>("Enter all neccessary fields", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(storeService.addStore(storeDto), HttpStatus.OK);
		}
	}

}
