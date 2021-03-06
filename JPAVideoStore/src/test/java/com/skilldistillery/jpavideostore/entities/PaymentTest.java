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

class PaymentTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Payment payment; 
	
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
		payment = em.find(Payment.class, 1); 
 	}

	@AfterEach
	void tearDown() throws Exception {
		em.close(); 
		payment = null; 
	}

	@Test
	@DisplayName("testing payment mappings")
	void test1() {
		assertNotNull(payment); 
		assertEquals(2.99, payment.getAmount()); 
		assertEquals(2014, payment.getPaymentDate().getYear()); 
		assertEquals(5, payment.getPaymentDate().getMonthValue()); 
		assertEquals(25, payment.getPaymentDate().getDayOfMonth()); 
	}
	
	@Test
	@DisplayName("testing payment rental mapping")
	void test2() {
		assertNotNull(payment); 
		assertEquals(76, payment.getRental().getId()); 
	}

	
}
