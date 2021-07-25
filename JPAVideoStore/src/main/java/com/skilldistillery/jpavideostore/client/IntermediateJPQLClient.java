package com.skilldistillery.jpavideostore.client;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.jpavideostore.entities.Staff;

public class IntermediateJPQLClient {

	private static 
	 EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");
	
	public static void main(String[] args) {
		IntermediateJPQLClient ijc = new IntermediateJPQLClient();

		EntityManager em = emf.createEntityManager(); 
		
//		String jpql = "SELECT COUNT(*) FROM Film"; 
		
//		System.out.println(em.createQuery(jpql, Long.class).getSingleResult());      // skill drill 2
		
//		String jpqlTwo = "SELECT f.staff, COUNT(f) FROM staff f GROUP BY f.firstName HAVING COUNT(f) > 1"; 		
		
		String jpqlThree = "SELECT s.firstName, COUNT(*) FROM Staff s GROUP BY s.firstName HAVING COUNT(*) > 1"; 
		
		List<Object[]> results = em.createQuery(jpqlThree, Object[].class).getResultList(); 
		
		System.out.println(results.size());
		
		 
	}
	
	// skill drill 1
	public List<Staff> getStaffInAlphabeticalOrder() {
	
	EntityManager em = emf.createEntityManager(); 
	
	List<Staff> staff = null; 
	
	String jpql = "SELECT s FROM Staff s ORDER BY s.lastName ASC"; 
	staff = em.createQuery(jpql, Staff.class)
				  .getResultList(); 
	
	em.close();
	return staff; 
	
}	
	
	
	
	


}


