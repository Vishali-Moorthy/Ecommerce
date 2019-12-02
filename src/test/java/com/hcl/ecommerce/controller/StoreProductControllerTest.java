package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.ecommerce.dto.StoreProductDto;
import com.hcl.ecommerce.entity.StoreProduct;
import com.hcl.ecommerce.service.StoreProductService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreProductControllerTest {
	
	@InjectMocks
	StoreProductController storeProductController;
	
	@Mock
	StoreProductService storeProductService;
	
	@Test
	public void testAddStore() {
		Object actual;
		StoreProductDto storeProductDto = new StoreProductDto();
		storeProductDto.setDiscount(12);
		storeProductDto.setFinalPrice(654.94);
		storeProductDto.setStoreId(2);
		storeProductDto.setProductId(3);
		
		StoreProduct storeProduct = new StoreProduct();
		storeProduct.setStoreProductId(1);
		storeProduct.setDiscount(storeProductDto.getDiscount());
		storeProduct.setFinalPrice(storeProductDto.getFinalPrice());
		storeProduct.setProductId(storeProductDto.getProductId());
		storeProduct.setStoreId(storeProductDto.getStoreId());
		
		Mockito.when(storeProductService.addStoreProduct(storeProductDto)).thenReturn("StoreProduct added successfully");
		HttpStatus statusCode = storeProductController.addStoreProduct(storeProductDto).getStatusCode();
		assertEquals(HttpStatus.OK, statusCode);
		
		actual = storeProductController.addStoreProduct(storeProductDto).getBody();
		assertEquals("StoreProduct added successfully", actual);
	
	}
	
	@Test
	public void testSearchProductById() {
		StoreProductDto product = new StoreProductDto();
		product.setProductId(1);
		List<StoreProductDto> products = new ArrayList<>();
		products.add(product);
		Mockito.when(storeProductService.searchProductById(1)).thenReturn(products);
		HttpStatus status = storeProductController.searchProductById(1).getStatusCode();
		assertEquals(HttpStatus.OK, status);
	}
	
	@Test
	public void testSearchProductByIdForNegative() {
		StoreProductDto product = new StoreProductDto();
		product.setProductId(null);
		List<StoreProductDto> products = new ArrayList<>();
		products.add(product);
		Mockito.when(storeProductService.searchProductById(1)).thenReturn(products);
		HttpStatus status = storeProductController.searchProductById(null).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, status);
	}

}
