package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skilldistillery.jpavideostore.client.JPQLLab;

class JPQLTest {

	private JPQLLab lab; 
	
	@BeforeEach
	void setUp() throws Exception {
		lab = new JPQLLab(); 
	}

	@AfterEach
	void tearDown() throws Exception {
		lab = null; 
	}

	@Test
	void test_getRangeOfCustomers() {
		List<Customer> custs = lab.getRangeOfCustomers(100, 110); 
		assertNotNull(custs); 
		assertEquals(11, custs.size()); 
	}
		
	@Test
	void test_getCustomerEmailByName() {
		String email = lab.getCustomerEmailByName("Mary", "Smithers"); 
		assertNotNull(email); 
		assertEquals("MARY.SMITH@sdvidcustomer.org", email); 		
	}
	
	@Test
	void test_getFilmByTitle() {
		Film film = lab.getFilmByTitle("ACADEMY DINOSAUR"); 
		assertNotNull(film); 
		assertEquals(1, film.getId()); 
	}
	
	@Test
	void test_getFilmsTitlesByReleaseYear() {
		List<String> titles = lab.getFilmsTitlesByReleaseYear(1993); 
		assertNotNull(titles); 
		assertTrue(titles.size() > 0); 
		assertEquals(26, titles.size()); 
	}
		
}
