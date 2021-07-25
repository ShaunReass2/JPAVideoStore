package com.skilldistillery.jpavideostore.data;

import com.skilldistillery.jpavideostore.entities.Actor;

public interface ActorDAO {
	
	Actor create(Actor actor);

	Actor update(int id, Actor actor);

	boolean destroy(int i);

}
