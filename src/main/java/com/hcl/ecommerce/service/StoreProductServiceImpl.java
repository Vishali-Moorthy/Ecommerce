package com.hcl.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ecommerce.dto.StoreProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.StoreProduct;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.ReviewRepository;
import com.hcl.ecommerce.repository.StoreProductRepository;

/**
 * This class contains two methods
 * @author Vishalakshi
 *
 */
@Service
public class StoreProductServiceImpl implements StoreProductService{
	
	@Autowired
	private StoreProductRepository storeProductRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;

	/**
	 * Add storeProduct method add store and product values into the storeproduct table
	 */
	@Override
	public String addStoreProduct(StoreProductDto storeProductRequestDto) {
		StoreProduct storeProduct = new StoreProduct();
		storeProduct.setStoreId(storeProductRequestDto.getStoreId());
		Integer productId = storeProductRequestDto.getProductId();
		storeProduct.setProductId(productId );
		Integer discountPrice = storeProductRequestDto.getDiscount();
		storeProduct.setDiscount(discountPrice );
		Product product = productRepository.findByProductId(productId);
		Double price = product.getPrice();
		Double discount = (discountPrice * price) / 100;
		Double finalPrice = price - discount;
		storeProduct.setFinalPrice(finalPrice);
		storeProductRepository.save(storeProduct);
		return "Store and Product added successfully";
	}

	/**
	 * This method search the product from the storeproduct table with the given productId
	 * Return the ratings of the stores for yhe given productId
	 */
	@Override
	public List<StoreProductDto> searchProductById(Integer productId) {
		List<StoreProduct> storeProducts = storeProductRepository.findByProductId(productId);
		List<StoreProductDto> storeProductDto = new ArrayList<>(); 
		for (StoreProduct storeProduct : storeProducts) {
			StoreProductDto storeProductDtos = new StoreProductDto();
			storeProductDtos.setFinalPrice(storeProduct.getFinalPrice());
			storeProductDtos.setProductId(productId);
			storeProductDtos.setStoreId(storeProduct.getStoreId());
			storeProductDtos.setDiscount(storeProduct.getDiscount());
			storeProductDtos.setRating(reviewRepository.findByStoreId(storeProduct.getStoreId()));
			storeProductDto.add(storeProductDtos);
		}
		return storeProductDto;
	}

}
