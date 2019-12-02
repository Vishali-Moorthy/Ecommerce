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

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.repository.ProductRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductServiceTest {
	
	@InjectMocks
	ProductServiceImpl productServiceImpl;
	
	@Mock
	ProductRepository productRepository;
	
	@Test
	public void testAddProduct() {
		ProductDto productDto = new ProductDto();
		productDto.setPrice(457.00);
		productDto.setProductName("Pen");
		Product product = new Product();
		product.setProductId(1);
		product.setProductName(productDto.getProductName());
		product.setPrice(productDto.getPrice());
		Mockito.when(productRepository.save(product)).thenReturn(product);
		String result = productServiceImpl.addProduct(productDto);
		
		assertEquals("Product added successfully", result);
	
	}
	
	
	@Test
	public void testSearchProductForPositive() throws ProductNotFoundException {
		Product product = new Product();
		List<Product> list = new ArrayList<>();
		product.setProductId(1);
		product.setProductName("Pen");
		product.setPrice(87.0);
		list.add(product);
		Mockito.when(productRepository.findAll()).thenReturn(list);
		List<Product> result = productServiceImpl.searchProduct(product.getProductName());
		assertEquals(list, result);
	}
	
	@Test(expected = Exception.class)
	public void testSearchProductForNegative() throws ProductNotFoundException {
		Product product = new Product();
		List<Product> list = new ArrayList<>();
		product.setProductId(1);
		product.setProductName("Pen");
		product.setPrice(87.0);
		Mockito.when(productRepository.findAll()).thenReturn(list);
		List<Product> result = productServiceImpl.searchProduct("Speaker");
		assertEquals(list, result);
	}
	

}
