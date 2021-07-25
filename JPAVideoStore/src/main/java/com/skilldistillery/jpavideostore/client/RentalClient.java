package com.skilldistillery.jpavideostore.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Rental;
import com.skilldistillery.jpavideostore.entities.Staff;

public class RentalClient {

	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		 EntityManager em = emf.createEntityManager();
		  
		 Rental client = em.find(Rental.class, 5); 
		 System.out.println(client);
		  
		  em.close(); 
		  emf.close(); 

	}

}
