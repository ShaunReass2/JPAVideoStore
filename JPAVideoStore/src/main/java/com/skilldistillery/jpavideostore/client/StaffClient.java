package com.skilldistillery.jpavideostore.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Staff;

public class StaffClient {

	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		 EntityManager em = emf.createEntityManager();
		  
		 Staff client = em.find(Staff.class, 5); 
		 System.out.println(client);
		  
		  em.close(); 
		  emf.close(); 

	}

}
