package com.skilldistillery.jpavideostore.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Actor;

public class ActorDAOImpl implements ActorDAO {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore"); 
	
	@Override
	public Actor create(Actor actor) {
	
		EntityManager em = emf.createEntityManager(); 
		
		// start a transaction 
		em.getTransaction().begin();
		
		System.out.println("Actor before persist: " + actor);
		em.persist(actor);
		System.out.println("Acotr after persist: " + actor);
		
		em.flush(); 
		em.getTransaction().commit();
		
		em.close();	
		return null; 
	
	}
	

	@Override
	public Actor update(int id, Actor actor) {
		EntityManager em = emf.createEntityManager();
		
		Actor dbActor = em.find(Actor.class, id); 
		
		// start a transaction
		em.getTransaction().begin();
		
		dbActor.setFirstName((actor.getFirstName())); 
		dbActor.setLastName((actor.getLastName())); 
			
		em.flush();
		
		em.getTransaction().commit();
		System.out.println("after update: " + dbActor);
		em.close(); 
		
		return dbActor; 
	}
	
	public boolean destroy(int id) {
		EntityManager em = emf.createEntityManager();
		
		Actor poorActor = em.find(Actor.class, id); 
		
		// start a transaction 
		em.getTransaction().begin();
		
		em.remove(poorActor);
		
		boolean successfulKickOut; 
		
		// hey actors union, do you still have poorActor in the union?
		successfulKickOut = !em.contains(poorActor);     //  True => false; False => true; 
		
//		em.getTransaction().commit();
		
		em.getTransaction().commit(); 
		em.close(); 
		return successfulKickOut; 
		
	}
}




