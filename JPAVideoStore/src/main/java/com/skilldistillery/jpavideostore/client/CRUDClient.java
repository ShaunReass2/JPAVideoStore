package com.skilldistillery.jpavideostore.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Address;
import com.skilldistillery.jpavideostore.entities.Customer;

public class CRUDClient {

	private static 
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");

	public static void main(String[] args) {
		CRUDClient cc = new CRUDClient();
//		System.out.println("Updated: " + cc.updateNullEmail());
		
		Address addr = new Address("street name", "Littleton", "Colorado", "80122", "303-771-1234");     // need to add constructor in Address.java
		cc.addNewAddress(addr); 
	}
	
	public Address addNewAddress(Address addr) {
		EntityManager em = emf.createEntityManager(); 
		em.getTransaction().begin();
		
		// INSERT INTO address (street, street2, city, ...) VALUES (addr.getStreet(), etc
		em.persist(addr); 
		
		em.flush(); 
		em.getTransaction().commit();
		em.close();
		return addr; 		
	}
	
	public int updateNullEmail() {
		EntityManager em = emf.createEntityManager(); 
		int count = 0; 
		
		// create JPQL statement to find the affected customers
		String jpql = "SELECT cust FROM Customer cust WHERE email = ' ' OR email IS null"; 
		
		// access those customers from the database, so we can update their email
		List<Customer> customers = em.createQuery(jpql, Customer.class).getResultList(); 
		
		// start the transaction
		em.getTransaction().begin();
		
		// loop through the list of customers and change their email
		for (Customer customer : customers) {
			customer.setEmail(customer.getFirstName() + "." + customer.getLastName() + "@sdcustomer.org");
			
			count++; 
		}
		
		// sync up
		em.flush(); 
		
		// do not forget to commit our work
		em.getTransaction().commit();
		em.close();
		return count; 
	}
	
	public boolean deleteAddress(int addrId) {
		EntityManager em = emf.createEntityManager(); 
		em.getTransaction().begin();
		
		Address address = em.find(Address.class, addrId); 
		
		if(address != null) {
			em.remove(address);
		}
		em.flush();
		
		boolean wasDeleted = ! em.contains(address); 
		em.getTransaction().commit();
		em.close();
		return wasDeleted; 
	}
	
	
	
	
	
	
	
	
	
	
	
	
}

	