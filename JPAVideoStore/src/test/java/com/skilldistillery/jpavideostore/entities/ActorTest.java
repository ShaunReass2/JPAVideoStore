package com.skilldistillery.jpavideostore.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ActorTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Actor actor; 
	
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
		actor = em.find(Actor.class, 1); 
 	}

	@AfterEach
	void tearDown() throws Exception {
		em.close(); 
		actor = null; 
	}

	@Test
	@DisplayName("testing actor mappings")
	void test1() {
		assertNotNull(actor); 
		assertEquals("Penelope", actor.getFirstName()); 
		assertEquals("Guiness", actor.getLastName()); 
	}

	@Test
	@DisplayName("testing actor and film mappings")
	void test2() {
		assertNotNull(actor); 
		assertNotNull(actor.getFilms()); 
		assertTrue(actor.getFilms().size() > 0);  
	}
	
}
