package com.skilldistillery.jpavideostore.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Staff;

public class JPQLClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore"); 
		EntityManager em = emf.createEntityManager(); 
		
//		String jpql = "SELECT e FROM Staff e WHERE e.id <10"; 
//		String jpql = "SELECT e FROM Staff e WHERE e.last_name LIKE '%son%'";            // this works too
		
		String jpql = "SELECT e FROM Staff e WHERE e.id < :empId"; 
		int eId = 10; 
		
		List<Staff> emps = em.createQuery(jpql, Staff.class) 
							 .setParameter("empId", eId)
							 .getResultList(); 
		
		for (Staff emp : emps) {
			System.out.println(emp.getFirstName() + " " + emp.getLastName());
		}
		
//		System.out.println("-----------------------------------------------------");
//		jpql = "SELECT e.lastName FROM Staff e WHERE e.id < 10";
//		List<String> lNames = em.createQuery(jpql, String.class).getResultList(); 
//		
//		for (String lname : lNames) {
//			System.out.println(lname);
//			
//		}
//		
//		System.out.println("-----------------------------------------------------");
//		jpql = "SELECT e.firstName, e.lastName FROM Staff e WHERE e.id < 10";
//		List<Object[]> names = em.createQuery(jpql, Object[].class).getResultList(); 
//		
//		for (Object[] name : names) {
//			System.out.println(name[1] + " " + name[0]);
//			
//		}
		
		em.close();
		emf.close();
	}

}
