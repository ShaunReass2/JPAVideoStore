package com.skilldistillery.jpavideostore.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class IntermediateJPQLLab {

	

	
	public static void main(String[] args) {
		
		// In a main method write a query that calculates the average length of the films in the database
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		 EntityManager em = emf.createEntityManager(); 
		
		 String jpql = "SELECT AVG(f.length) FROM Film f"; 
		 
		 double avgLen = em.createQuery(jpql, Double.class).getSingleResult(); 
		 System.out.println("Average film length: " + avgLen);
		 
		 // Write a query that calculates the number of addresses grouped by their state.
		 
		 jpql = "SELECT a.state, COUNT(a) FROM Address a GROUP BY a.state"; 
		 
		List<Object[]> stateData = em.createQuery(jpql, Object[].class).getResultList(); 
		
		for (Object[] state : stateData) {
			System.out.println(state[0] + ": " + state[1]);
		}
		
		
	}

}


//IntermediateJPQLLab ijc = new IntermediateJPQLLab(); 
//EntityManager em = emf.createEntityManager(); 	
//String jpql = "SELECT AVG(f.length) FROM Film f"; 
//System.out.println(em.createQuery(jpql, Double.class).getSingleResult());



//String query = "SELECT AVG(f.rentalRate) FROM Film f WHERE f.id < 10";
//
//double average = em.createQuery(query, Double.class).getSingleResult();


//String jpql = "SELECT a, COUNT(*) FROM Staff s GROUP BY a.state"; 
//System.out.println(em.createQuery(jpql, Double.class).getSingleResult());