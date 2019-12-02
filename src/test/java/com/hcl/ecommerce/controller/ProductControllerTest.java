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

import com.hcl.ecommerce.dto.ProductDto;
import com.hcl.ecommerce.entity.Product;
import com.hcl.ecommerce.exception.ProductNotFoundException;
import com.hcl.ecommerce.service.ProductService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class ProductControllerTest {
	
	@InjectMocks
	ProductController productController;
	
	@Mock
	ProductService productService;

	@Test
	public void testAddProduct() {
		Object actual;
		ProductDto productDto = new ProductDto();
		productDto.setProductName("Pen");
		productDto.setPrice(98.0);
		
		Product product = new Product();
		product.setPrice(productDto.getPrice());
		product.setProductName(productDto.getProductName());
		
		Mockito.when(productService.addProduct(productDto)).thenReturn("Product added successfully");
		HttpStatus statusCode = productController.addProduct(productDto).getStatusCode();
		assertEquals(HttpStatus.OK, statusCode);
		
		actual = productController.addProduct(productDto).getBody();
		assertEquals("Product added successfully", actual);
		
	}
	
	@Test
	public void testAddProductForNegative() {
		Object actual;
		ProductDto productDto = null;
		Mockito.when(productService.addProduct(productDto)).thenReturn("Productname or price is empty");
		HttpStatus statusCode = productController.addProduct(productDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = productController.addProduct(productDto).getBody();
		assertEquals("Productname or price is empty", actual);
		
	}
	
	@Test
	public void testAddProductForNullNegative() {
		Object actual;
		ProductDto productDto = new ProductDto();
		productDto.setProductName(null);
		productDto.setPrice(98.0);
		
		Product product = new Product();
		product.setPrice(productDto.getPrice());
		product.setProductName(productDto.getProductName());
		
		Mockito.when(productService.addProduct(productDto)).thenReturn("Productname or price is empty");
		HttpStatus statusCode = productController.addProduct(productDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = productController.addProduct(productDto).getBody();
		assertEquals("Productname or price is empty", actual);
		
	}
	
	@Test
	public void testAddProductForNegativeNull() {
		Object actual;
		ProductDto productDto = new ProductDto();
		productDto.setProductName("Pen");
		productDto.setPrice(null);
		
		Product product = new Product();
		product.setPrice(productDto.getPrice());
		product.setProductName(productDto.getProductName());
		
		Mockito.when(productService.addProduct(productDto)).thenReturn("Productname or price is empty");
		HttpStatus statusCode = productController.addProduct(productDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = productController.addProduct(productDto).getBody();
		assertEquals("Productname or price is empty", actual);
		
	}
	
	@Test
	public void testSearchProduct() throws ProductNotFoundException {
		Product product = new Product();
		product.setProductName("mobile");
		List<Product> products = new ArrayList<>();
		products.add(product);
		Mockito.when(productService.searchProduct("mobile")).thenReturn(products);
		HttpStatus status = productController.searchProduct("mobile").getStatusCode();
		assertEquals(HttpStatus.OK, status);
	}
	
	@Test
	public void testSearchProductForNegative() throws ProductNotFoundException {
		Product product = new Product();
		product.setProductName(null);
		List<Product> products = new ArrayList<>();
		products.add(product);
		Mockito.when(productService.searchProduct(null)).thenReturn(products);
		HttpStatus status = productController.searchProduct(null).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, status);
	}

}
