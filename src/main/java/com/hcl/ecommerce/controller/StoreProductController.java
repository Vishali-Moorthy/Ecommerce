package com.hcl.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ecommerce.dto.StoreProductDto;
import com.hcl.ecommerce.service.StoreProductService;

/**
 * The Storeproduct controller contains two methods
 * @author Vishalakshi
 *
 */
@RestController
@RequestMapping("/storeproducts")
public class StoreProductController {

	@Autowired
	private StoreProductService storeProductService;

	/**
	 * Add Storeproduct method adds store and product values into the storeproduct table
	 * @param storeProductRequestDto
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<String> addStoreProduct(@RequestBody StoreProductDto storeProductRequestDto) {
		return new ResponseEntity<>(storeProductService.addStoreProduct(storeProductRequestDto), HttpStatus.OK);
	}

	/**
	 * Searchproduct By id method search the product for the given productId and shows the ratings for the available stores
	 * @param productId
	 * @return
	 */
	@GetMapping("")
	public ResponseEntity<List<StoreProductDto>> searchProductById(@RequestParam Integer productId) {
		if (productId == null) {
			return new ResponseEntity<>(storeProductService.searchProductById(null), HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(storeProductService.searchProductById(productId), HttpStatus.OK);
		}
	}

}
