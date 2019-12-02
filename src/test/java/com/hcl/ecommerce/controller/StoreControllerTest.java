package com.hcl.ecommerce.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.service.StoreService;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreControllerTest {
	
	@InjectMocks
	StoreController storeController;
	
	@Mock
	StoreService storeService;
	
	@Test
	public void testAddStore() {
		Object actual;
		StoreDto storeDto = new StoreDto();
		storeDto.setStoreContactNo(8347342823L);
		storeDto.setStoreLocation("Tanjore");
		storeDto.setStoreName("Amazon");
		
		Store store = new Store();
		store.setStoreId(1);
		store.setStoreContactNo(storeDto.getStoreContactNo());
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreName(storeDto.getStoreName());
		
		Mockito.when(storeService.addStore(storeDto)).thenReturn("Store added successfully");
		HttpStatus statusCode = storeController.addStore(storeDto).getStatusCode();
		assertEquals(HttpStatus.OK, statusCode);
		
		actual = storeController.addStore(storeDto).getBody();
		assertEquals("Store added successfully", actual);
		
	}
	
	@Test
	public void testAddStoreForNegative() {
		Object actual;
		StoreDto storeDto = null;
		Mockito.when(storeService.addStore(storeDto)).thenReturn("Enter all neccessary fields");
		HttpStatus statusCode = storeController.addStore(storeDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = storeController.addStore(storeDto).getBody();
		assertEquals("Enter all neccessary fields", actual);
		
	}
	
	@Test
	public void testAddStoreForNullNegative() {
		Object actual;
		StoreDto storeDto = new StoreDto();
		storeDto.setStoreContactNo(0);
		storeDto.setStoreLocation("Tanjore");
		storeDto.setStoreName("Amazon");
		
		Store store = new Store();
		store.setStoreId(1);
		store.setStoreContactNo(storeDto.getStoreContactNo());
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreName(storeDto.getStoreName());
		
		Mockito.when(storeService.addStore(storeDto)).thenReturn("Enter all neccessary fields");
		HttpStatus statusCode = storeController.addStore(storeDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = storeController.addStore(storeDto).getBody();
		assertEquals("Enter all neccessary fields", actual);
		
	}
	
	@Test
	public void testAddStoreForNegativeNull() {
		Object actual;
		StoreDto storeDto = new StoreDto();
		storeDto.setStoreContactNo(8347342823L);
		storeDto.setStoreLocation(null);
		storeDto.setStoreName("Amazon");
		
		Store store = new Store();
		store.setStoreId(1);
		store.setStoreContactNo(storeDto.getStoreContactNo());
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreName(storeDto.getStoreName());
		
		Mockito.when(storeService.addStore(storeDto)).thenReturn("Enter all neccessary fields");
		HttpStatus statusCode = storeController.addStore(storeDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = storeController.addStore(storeDto).getBody();
		assertEquals("Enter all neccessary fields", actual);
		
	}
	
	@Test
	public void testAddStoreForNegativeCase() {
		Object actual;
		StoreDto storeDto = new StoreDto();
		storeDto.setStoreContactNo(8347342823L);
		storeDto.setStoreLocation("Tanjore");
		storeDto.setStoreName(null);
		
		Store store = new Store();
		store.setStoreId(1);
		store.setStoreContactNo(storeDto.getStoreContactNo());
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreName(storeDto.getStoreName());
		
		Mockito.when(storeService.addStore(storeDto)).thenReturn("Enter all neccessary fields");
		HttpStatus statusCode = storeController.addStore(storeDto).getStatusCode();
		assertEquals(HttpStatus.NOT_FOUND, statusCode);
		
		actual = storeController.addStore(storeDto).getBody();
		assertEquals("Enter all neccessary fields", actual);
		
	}

}
