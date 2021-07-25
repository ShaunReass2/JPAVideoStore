package com.skilldistillery.bootmvc.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.jpavideostore.entities.Film;
	
@Service
@Transactional     // handles transaction.begin/commit
public class FilmDAOJpaImpl implements FilmDAO {
		
		@PersistenceContext
		private EntityManager em; 
		
		@Override
		public Film findById(int id) {
			return em.find(Film.class, id); 	
		}
	}


