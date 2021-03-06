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

class FilmTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Film film; 
	
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
		film = em.find(Film.class, 1); 
 	}

	@AfterEach
	void tearDown() throws Exception {
		em.close(); 
		film = null; 
	}

	@Test
	@DisplayName("testing film mappings")
	void test1() {
		assertNotNull(film); 
		assertEquals("A Epic Drama of a Feminist And a Mad Scientist who must Battle a Teacher in The Canadian Rockies", film.getDescription()); 
		
		assertEquals(1993, film.getReleaseYear()); 
		assertEquals(0.99, film.getRentalRate()); 
		assertEquals(20.99, film.getReplacementCost()); 
	}
	
	@Test
	void test_Film_rating_enum_mapping() {
		assertNotNull(film); 
		assertEquals(Rating.PG, film.getRating()); 
		}
	
	@Test
	@DisplayName("test film to language mapping")
	void test3() {
		assertNotNull(film); 
		assertEquals("Japanese", film.getLanguage().getName()); 
	}
	
	@Test
	@DisplayName("test film actor many to many relationship mapping")
	void test4() {
		assertNotNull(film); 
		assertNotNull(film.getActors()); 
		assertTrue(film.getActors().size() > 0); 
	}
	
	@Test
	@DisplayName("test film category many to many relationship mapping")
	void test5() {
		assertNotNull(film); 
		assertNotNull(film.getCategories()); 
		assertTrue(film.getCategories().size() > 0); 
		assertEquals(1, film.getCategories().size()); 
	}
	
	@Test
	@DisplayName("test film and inventoryItem mapping")
	void test6() {
		assertNotNull(film); 
		assertNotNull(film.getCategories()); 
		assertTrue(film.getCategories().size() > 0); 
		assertEquals(1, film.getCategories().size()); 
	}
	
	@Test
	@DisplayName("test film inventoryItem One to Many relatioship mapping")
	void test7() {
		assertNotNull(film); 
		assertNotNull(film.getInventoryItems()); 
		assertTrue(film.getInventoryItems().size() > 0); 
		assertEquals(28, film.getInventoryItems().size()); 
	}

}



//assertTrue(!language.getFilms().isEmpty()); 

