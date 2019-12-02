package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.repository.ProductRepository;

/**
 * This class contains two methods
 * @author Vishalakshi
 *
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	/**
	 * Add product method add product to the product table
	 */
	@Override
	public String addProduct(ProductDto productRequestDto) {
		Product product = new Product();
		product.setProductName(productRequestDto.getProductName());
		product.setPrice(productRequestDto.getPrice());
		productRepository.save(product);
		return "Product added successfully";
	}

	/**
	 * Search product method search the product in the product table with the given product name
	 * It returns the product values from the table
	 */
	@Override
	public List<Product> searchProduct(String productName) throws ProductNotFoundException {
		Iterable<Product> product = productRepository.findAll();
		List<Product> products = new ArrayList<>();
		for (Product productList : product) {
			products.add(productList);
		}
		products = products.stream().filter(
				productDetail -> productDetail.getProductName().toLowerCase().startsWith(productName.toLowerCase()))
				.collect(Collectors.toList());
		if (products.isEmpty()) {
			throw new ProductNotFoundException("No products found for your search");
		}
		return products;

	}

}
