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

class CustomerTest {
	
	private static EntityManagerFactory emf;
	
	private EntityManager em;
	
	private Customer customer;
	
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
	    customer = em.find(Customer.class, 1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
	    em.close();
	    customer = null;
	}
	
	@Test
	@DisplayName("testing customer mappings")
	void test() {
		assertNotNull(customer);
		assertEquals("Mary", customer.getFirstName());
		assertEquals("Smithers", customer.getLastName());
	}
	
	@Test
	@DisplayName("testing customer to rental mapping")
	void test2() {
		assertNotNull(customer);
		assertEquals(95, customer.getRentals().size());
	}
	
	@Test
	@DisplayName("testing customer to rental mapping")
	void test3() {
		assertNotNull(customer); 
		assertEquals("Los Angeles", customer.getStore().getAddress().getCity()); 
	}
	
//	@Test
//	void test_Customer_temporal_data() {
//		assertNotNull(customer); 
//		assertEquals(2014, customer.getCreatedAt().getYear());
//		assertEquals(25, customer.getCreatedAt().getDayOfMonth());
//	}
}