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
class RentalTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Rental rental;
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
	    rental = em.find(Rental.class, 1);
	}
	@AfterEach
	void tearDown() throws Exception {
	    em.close();
	    rental = null;
	}
	@Test
	void test_Rental_entity_mapping() {
		assertNotNull(rental);
		assertNotNull(rental.getRentalDate());
		assertNotNull(rental.getReturnDate());
		assertEquals(2014, rental.getRentalDate().getYear());
		assertEquals(05, rental.getRentalDate().getMonthValue());
		assertEquals(24, rental.getRentalDate().getDayOfMonth());
		assertEquals(2014, rental.getReturnDate().getYear()); 
		assertEquals(05, rental.getReturnDate().getMonthValue()); 
		assertEquals(26, rental.getReturnDate().getDayOfMonth()); 
//		assertEquals(1993, rental.getReleaseYear()); 
//		assertEquals(0.99, rental.getRentalRate()); 
//		assertEquals(20.99, rental.getReplacementCost()); 
	}
//	@Test
//	void test_Rental_enum_mapping() {
//		assertNotNull(rental); 
//		assertEquals(Rating.PG, rental.getRating()); 
//		}
	@Test
	@DisplayName("test rental to staff mapping")
	void test2() {
		assertNotNull(rental);
		assertEquals("Tingvold", rental.getStaff().getLastName());
	}
	@Test
	@DisplayName("testng rental to staff mapping")
	void test3() {
		assertNotNull(rental);
		assertEquals("Hunter", rental.getCustomer().getLastName());
	}
}