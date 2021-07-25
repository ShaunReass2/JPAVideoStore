package com.skilldistillery.jpavideostore.client;

import com.skilldistillery.jpavideostore.data.ActorDAO;
import com.skilldistillery.jpavideostore.data.ActorDAOImpl;

public class ActorDAOClient {

	public static void main(String[] args) {
		
		ActorDAO dao = new ActorDAOImpl(); 
		
//		Actor actor = new Actor ("Cowboy", "Jane"); 
//		dao.create(actor); 
//		System.out.println("persisted: " + actor);
		
//		Actor updateCJ = new Actor("Fred", "Freddette"); 
//		System.out.println(dao.update(201, updateCJ));
		
		System.out.println("Fred Freddette fired? " + dao.destroy(201));

	}

}
