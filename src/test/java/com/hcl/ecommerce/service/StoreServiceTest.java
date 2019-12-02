package com.hcl.ecommerce.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.ecommerce.dto.StoreDto;
import com.hcl.ecommerce.entity.Store;
import com.hcl.ecommerce.repository.StoreRepository;

@RunWith(MockitoJUnitRunner.Silent.class)
public class StoreServiceTest {
	
	@InjectMocks
	private StoreServiceImpl storeServiceImpl;
	
	@Mock
	private StoreRepository storeRepository;
	
	@Test
	public void testAddStore() {
		StoreDto storeDto = new StoreDto();
		storeDto.setStoreName("Amazon");
		storeDto.setStoreContactNo(8765478654L);
		storeDto.setStoreLocation("trichy");
		Store store =new Store();
		store.setStoreId(1);
		store.setStoreContactNo(storeDto.getStoreContactNo());
		store.setStoreLocation(storeDto.getStoreLocation());
		store.setStoreName(storeDto.getStoreName());
		Mockito.when(storeRepository.save(store)).thenReturn(store);
		String result =storeServiceImpl.addStore(storeDto);
		
		assertEquals("Store added successfully", result);
		
	}

}
