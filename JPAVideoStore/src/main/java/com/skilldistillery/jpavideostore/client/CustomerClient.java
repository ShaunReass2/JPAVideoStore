package com.skilldistillery.jpavideostore.client;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Customer;

public class CustomerClient {

	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
		 EntityManager em = emf.createEntityManager();
		 Scanner sc = new Scanner(System.in);
		 
		 sc.nextLine(); // pause		
		 System.out.println("before find");
		 Customer cust = em.find(Customer.class, 1); 
		 
		 sc.nextLine(); // pause
		 System.out.println("before printing cust");

		 System.out.println(cust);
		 
		 sc.nextLine(); // pause
		 System.out.println("before printing rentals.size *********");
		 System.out.println(cust.getRentals().size());
		 
		  
		  em.close();   // no memory leaks
		  emf.close(); 
	}

}
