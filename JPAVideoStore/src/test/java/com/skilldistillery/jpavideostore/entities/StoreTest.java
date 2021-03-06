package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class StoreTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Store store; 
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	    emf = Persistence.createEntityManagerFactory("VideoStore");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close(); 
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager(); 
		store = em.find(Store.class, 1); 
 	}

	@AfterEach
	void tearDown() throws Exception {
		em.close(); 
		store = null; 
	}

	@Test
	@DisplayName("testing store to address mapping")
	void test1() {
		assertNotNull(store); 
		assertEquals("Seattle", store.getAddress().getCity()); 
	}
	
	@Test
	@DisplayName("testing store to Customers mapping")
	void test2() {
		assertNotNull(store); 
		assertEquals(74, store.getCustomers().size()); 
	}
	
	@Test
	@DisplayName("testing store to staffs mapping")
	void test3() {
		assertNotNull(store); 
		assertEquals(16, store.getStaffs().size()); 
	}
	
	@Test
	@DisplayName("testing store to staffs mapping")
	void test4() {
		assertNotNull(store); 
		assertEquals("LaFever", store.getManager().getLastName()); 
	}
	
	@Test
	@DisplayName("testing store and inventoryItem mapping")
	void test5() {
		assertNotNull(store); 
		assertEquals("LaFever", store.getManager().getLastName()); 
	}
	
	@Test
	@DisplayName("testing store and inventoryItem mapping")
	void test6() {
		assertNotNull(store); 
		assertEquals("LaFever", store.getManager().getLastName()); 
	}
	@Test
	@DisplayName("testing store inventoryItem One to Many mapping")
	void test7() {
		assertNotNull(store); 
		assertNotNull(store.getInventoryItems()); 
		assertTrue(store.getInventoryItems().size() > 0); 
		assertEquals(2270, store.getInventoryItems().size()); 
	}
	
}
