package com.skilldistillery.bootmvc.data;

import com.skilldistillery.jpavideostore.entities.Film;

public interface FilmDAO {
		Film findById(int id); 
		
}
