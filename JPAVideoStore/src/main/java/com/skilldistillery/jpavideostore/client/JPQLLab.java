package com.skilldistillery.jpavideostore.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Customer;
import com.skilldistillery.jpavideostore.entities.Film;

public class JPQLLab {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore"); 
	
	public List<Customer> getRangeOfCustomers(int minId, int maxId) {
		
		EntityManager em = emf.createEntityManager(); 
		
		List<Customer> customers = null; 
		
		String jpql = "SELECT c FROM Customer c WHERE id BETWEEN :low AND :hi"; 
		customers = em.createQuery(jpql, Customer.class)
					  .setParameter("low", minId) 
					  .setParameter("hi", maxId) 
					  .getResultList(); 
		
		em.close();
		return customers; 
		
	}
	
	public String getCustomerEmailByName(String fName, String lName) {
		EntityManager em = emf.createEntityManager(); 
		String email = null; 
		String jpql = "SELECT c FROM Customer c WHERE c.firstName = :f AND c.lastName = :l"; 
		List<Customer> customers = em.createQuery(jpql, Customer.class)
								     .setParameter("f", fName) 
				                     .setParameter("l", lName) 
				                     .getResultList(); 
		
//		if (customers.size() == 1) {          // works fine
//		if (!customers.isEmpty()) {           // works fine
		if(customers.size() > 0) {	
			email = customers.get(0).getEmail(); 
		}
		
		em.close(); 
		return email; 
	}
	
	public Film getFilmByTitle(String title) {
		EntityManager em = emf.createEntityManager(); 
		Film film = null; 
		
		String jpql = "SELECT f FROM Film f WHERE title = :t"; 
		
		try {
			film = em.createQuery(jpql, Film.class)
				 	 .setParameter("t", title) 
			         .getSingleResult();
			
		} catch (Exception e) {

//			e.printStackTrace();
		}
		
		em.close(); 
		return film; 
	}
	
	public List<String> getFilmsTitlesByReleaseYear(int year) {
		EntityManager em = emf.createEntityManager(); 
		String jpql = "SELECT f.title FROM Film f WHERE f.releaseYear = :y"; 
		List<String> titles = em.createQuery(jpql, String.class)
				                .setParameter("y", year)
				                .getResultList(); 
		
		em.close(); 
		return titles; 
	}

}
 