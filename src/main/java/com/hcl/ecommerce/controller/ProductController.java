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

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.service.ProductService;

/**
 * This is Product Controller which contains two methods
 * @author Vishalakshi
 *
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	/**
	 * This addProduct method is used to add products and it update the values in the product table
	 * @param productRequestDto
	 * @return
	 */
	@PostMapping("")
	public ResponseEntity<String> addProduct(@RequestBody ProductDto productRequestDto) {
		if (productRequestDto == null || productRequestDto.getPrice() == null || productRequestDto.getProductName() == null) {
			return new ResponseEntity<>("Productname or price is empty", HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<>(productService.addProduct(productRequestDto), HttpStatus.OK);
		}
	}

	/**
	 * This searchProduct method is used to search product in the product table from the given product name
	 * @param productName
	 * @return
	 * @throws ProductNotFoundException
	 */
	@GetMapping("")
	public ResponseEntity<List<Product>> searchProduct(@RequestParam String productName)
			throws ProductNotFoundException {
		if(productName == null ) {
			return new ResponseEntity<>(productService.searchProduct(null), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(productService.searchProduct(productName), HttpStatus.OK);
	}

}
