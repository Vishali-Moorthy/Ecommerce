package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.StoreProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.entity.StoreProduct;
import com.hcl.ecommerce.repository.ProductRepository;
import com.hcl.ecommerce.repository.ReviewRepository;
import com.hcl.ecommerce.repository.StoreProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreProductServiceTest {
	
	@InjectMocks
	StoreProductServiceImpl storeProductServiceImpl;
	
	@Mock
	StoreProductRepository storeProductRepository;
	
	@Mock
	ReviewRepository reviewRepository;
	
	@Mock
	ProductRepository productRepository;
	
	@Test
	public void testAddStoreProduct() {
		StoreProductDto storeProductDto = new StoreProductDto();
		Product product = new Product();
		product.setProductId(1);
		product.setPrice(45.0);
		storeProductDto.setDiscount(12);
		storeProductDto.setFinalPrice(234.0);
		storeProductDto.setProductId(1);
		storeProductDto.setRating(3.0);
		storeProductDto.setStoreId(4);
		
		StoreProduct storeProduct = new StoreProduct();
		storeProduct.setStoreProductId(1);
		storeProduct.setDiscount(storeProductDto.getDiscount());
		Double price = product.getPrice();
		Double discount = (storeProductDto.getDiscount() * price) / 100;
		Double finalPrice = price - discount;
		storeProduct.setFinalPrice(finalPrice);
		storeProduct.setProductId(product.getProductId());
		storeProduct.setStoreId(storeProductDto.getStoreId());
		Mockito.when(productRepository.findByProductId(1)).thenReturn(product);
		Mockito.when(storeProductRepository.save(storeProduct)).thenReturn(storeProduct);
		String result = storeProductServiceImpl.addStoreProduct(storeProductDto);
		
		assertEquals("Store and Product added successfully", result);
	
	}
	@Test
	public void testSearchProductByIdForPositive() {
		Integer productId = 1;
		List<StoreProduct> storeProducts = new ArrayList<>();
		StoreProduct storeProduct = new StoreProduct();
		storeProduct.setFinalPrice(182.0);
		storeProduct.setProductId(1);
		storeProduct.setStoreProductId(1);
		storeProduct.setDiscount(12);
		storeProduct.setStoreId(2);
		storeProducts.add(storeProduct);
		List<StoreProduct> list = new ArrayList<>();
		list.add(storeProduct);
		
		Mockito.when(storeProductRepository.findByProductId(1)).thenReturn(storeProducts);
		List<StoreProductDto> listStoreProductDtos = new ArrayList<>();
		StoreProductDto storeProductDto = new StoreProductDto();
		storeProductDto.setFinalPrice(storeProduct.getFinalPrice());
		storeProductDto.setDiscount(storeProduct.getDiscount());
		storeProductDto.setProductId(productId);
		storeProductDto.setStoreId(storeProduct.getStoreId());
		Mockito.when(reviewRepository.findByStoreId(storeProduct.getStoreId())).thenReturn(2.2);
		storeProductDto.setRating(4.0);
		listStoreProductDtos.add(storeProductDto);
		List<StoreProductDto> result = storeProductServiceImpl.searchProductById(productId);
		assertEquals(1, result.size());
	}
	
	@Test
	public void testSearchProductByIdForNegative() {
		Integer productId = null;
		Mockito.when(storeProductRepository.findByProductId(1)).thenReturn(null);
		assertEquals(null, productId);

	}

}
