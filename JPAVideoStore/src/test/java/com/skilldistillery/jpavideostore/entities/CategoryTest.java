package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CategoryTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Category category; 
	
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
		category = em.find(Category.class, 1); 
 	}

	@AfterEach
	void tearDown() throws Exception {
		em.close(); 
		category = null; 
	}

	@Test
	void test_Category_entity_mapping() {
		assertNotNull(category); 
		assertEquals("Action", category.getName()); 
	}
	
	@Test
	void test_Categoy_Film_ManyToMany_mapping() {
		assertNotNull(category); 
		assertNotNull(category.getFilms()); 
		assertTrue(category.getFilms().size() > 0); 
		assertEquals(64, category.getFilms().size()); 
	}

}
