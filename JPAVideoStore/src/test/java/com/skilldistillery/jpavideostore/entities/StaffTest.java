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
class StaffTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Staff staff;
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
	    staff = em.find(Staff.class, 1);
	}
	@AfterEach
	void tearDown() throws Exception {
	    em.close();
	    staff = null;
	}
	@Test
	@DisplayName("testing staff mappings")
	void test1() {
		assertNotNull(staff); 
		assertEquals("Larry", staff.getFirstName()); 
		assertEquals("Kong", staff.getLastName()); 
	}
	@Test
	@DisplayName("test staff to Address mapping")
	void test2() {
		assertNotNull(staff);
		assertEquals("Las Vegas", staff.getAddress().getCity());
	}
	
	@Test
	@DisplayName("test staff to store mapping")
	void test3() {
		assertNotNull(staff);
		assertEquals(4, staff.getStore().getId());
	}
	
}