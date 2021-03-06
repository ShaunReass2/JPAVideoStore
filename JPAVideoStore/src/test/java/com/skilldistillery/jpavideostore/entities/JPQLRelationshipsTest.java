package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpavideostore.client.JPQLRelationshipsLab;

class JPQLRelationshipsTest {
	
	private JPQLRelationshipsLab lab; 

	@BeforeEach
	void setUp() throws Exception {
		lab = new JPQLRelationshipsLab(); 
	}

	@AfterEach
	void tearDown() throws Exception {
		lab = null; 
	}

	@Test
	void test1() {
		List<Store> stores = lab.getStoresByState("Washington"); 
		assertNotNull(stores); 
		assertTrue(stores.size() > 0); 
		assertEquals(1, stores.size()); 
	}
	@DisplayName("Test for customers with Id")
	void test2() {
		List<Rental> rentals = lab.getRentalsForCustomerWithCustomerId(1); 
		assertNotNull(rentals); 
		assertTrue(rentals.size() > 0); 
		assertEquals(95, rentals.size()); 
	}
	
	@DisplayName("Test for films for actor with Id")
	void test3() {
		List<Film> films = lab.getFilmsForActorWithId(1); 
		assertNotNull(films); 
		assertTrue(films.size() > 0); 
		assertEquals(19, films.size()); 
	}
	
	@DisplayName("Test for films for actor with Id")
	void test4() {
		int num = lab.getNumberOfFilmsForCategforyWithName("Comedy"); 
		assertTrue(num >= 0); 
		assertEquals(58, num);  
	}

}
