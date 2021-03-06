package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

class InventoryItemTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private InventoryItem item; 
	
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
		item = em.find(InventoryItem.class, 1); 
 	}

	@AfterEach
	void tearDown() throws Exception {
		em.close(); 
		item = null; 
	}

	@Test
	@DisplayName("testing entity mappings")
	void test1() {
		assertNotNull(item); 
		assertEquals(MediaCondition.Used, item.getMediaCondition()); 
	}
	
	@Test
	@DisplayName("testing film and inventoryItem One to Many mappings")
	void test2() {
		assertNotNull(item); 
		assertNotNull(item.getFilm()); 
		assertEquals(1, item.getFilm().getId()); 
	}
	
	@Test
	@DisplayName("testing inventoryItem and store Many to One mappings")
	void test3() {
		assertNotNull(item); 
		assertNotNull(item.getStore()); 
		assertEquals(1, item.getStore().getId()); 
	}

	
}
