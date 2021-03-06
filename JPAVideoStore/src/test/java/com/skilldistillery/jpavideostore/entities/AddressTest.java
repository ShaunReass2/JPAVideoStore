package com.skilldistillery.jpavideostore.entities;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
class AddressTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Address address; 
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
		address = em.find(Address.class, 1); 
 	}
	@AfterEach
	void tearDown() throws Exception {
		em.close(); 
		address = null; 
	}
	@Test
	@DisplayName("test address to country mapping")
	void test2() {
		assertNotNull(address);
		assertEquals("Canada", address.getCountry().getName());
	}
	@Test
	@DisplayName("testing customer mappings")
	void test1() {
		assertNotNull(address); 
		assertEquals("47 MySakila Drive", address.getStreet()); 
		assertEquals("Alberta", address.getState()); 
		assertTrue(address.getPostalCode().isEmpty()); 
	}
}