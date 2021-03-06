package com.skilldistillery.jpavideostore.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Actor;
import com.skilldistillery.jpavideostore.entities.Film;
import com.skilldistillery.jpavideostore.entities.Rental;
import com.skilldistillery.jpavideostore.entities.Store;

public class JPQLRelationshipsLab {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore"); 
	private EntityManager em; 
	
	public List<Store> getStoresByState(String state) {
		em = emf.createEntityManager(); 
		List<Store> stores = null; 
		
		// SELECT COUNT(*) FROM store s JOIN address a ON s.address_id = a.id WHERE a.state_province = 
		
		String jpql = "SELECT s FROM Store s WHERE s.address.state = :state"; 
		stores = em.createQuery(jpql, Store.class)
				   .setParameter("state", state) 
				   .getResultList(); 
		
		em.close();
		return stores; 
	}
	
	public List<Rental> getRentalsForCustomerWithCustomerId(int id) {
		em = emf.createEntityManager(); 
		List<Rental> rentals = null; 
		String jpql = "SELECT r FROM Rental r WHERE r.customer.id = :cid"; 
//		String jpql = "SELECT c.rentals FROM Customer c WHERE c.id = :cid"; 		
//      String jpql = "SELECT c FROM Customer c WHERE c.id = :cid"; 
		rentals = em.createQuery(jpql, Rental.class)
				    .setParameter("cid", id)
				    .getResultList(); 
		
		em.close();
		return rentals; 
	}
	
	public List<Film> getFilmsForActorWithId(int id) {
		em = emf.createEntityManager(); 
		List<Film> films = null; 

//		Slightly hard way of doing it
		
//		Actor a = em.find(Actor.class, id); 
//		String jpql = "SELECT f FROM Film f WHERE :player MEMBER OF f.actors"; 
//		films = em.createQuery(jpql, Film.class)
//			    .setParameter("player", a)
//				.getResultList(); 
		
//		Easier way of doing it
		
//		String jpql = "SELECT f FROM Film f WHERE f.actors.id = :id";     NOPE
		
//		JOIN to a collection property to reference properties of the entities in the collection
		
		
		String jpql = "SELECT f FROM Film f JOIN f.actors a WHERE a.id = :id";     		
		films = em.createQuery(jpql, Film.class)
			    .setParameter("id", id)
				.getResultList(); 
				
		Actor a = em.find(Actor.class, id); 
		if (a != null) {
			films = a.getFilms(); 
		}
		
		return films; 
	}
	
	public int getNumberOfFilmsForCategforyWithName(String name) {
		em = emf.createEntityManager(); 
		int count = -1; 
//		String jpql = "SELECT f FROM Film f WHERE f.categories.name = :catName"; 
//		String jpql = "SELECT f FROM Film f JOIN f.categories c WHERE c.name = :catName"; 
//		List<Film> films = em.createQuery(jpql, Film.class)
//			    .setParameter("catName", name)
//				.getResultList(); 
//		
//		count.films.size(); 
		
		String jpql = "SELECT COUNT(f) FROM Film f JOIN f.categories c WHERE c.name = c:catName"; 
		long longCount = em.createQuery(jpql, Long.class)
				  .setParameter("catName", name)
			      .getSingleResult(); 
		
		count = (int)longCount; 
		
		em.close();
		return count; 
	}

}
