package com.skilldistillery.jpavideostore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	private String name;
	
	@OneToMany(mappedBy="language")
	private List<Film> films; 

//	public List<Film> getFilms() {
//		return films; 
//	}
//	
//	public void setFilms(List<Film> films) {
//		this.films = films; 
//	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}
	
//	public void addFilm(Film film) {
//		if(films == null) films = new ArrayList<>(); 
//		
//		// if i have not yet recorded any films for this language,
//		// lets do so now
//		
//		if(!films.contains(film)) {
//			
//			// current list of films association with this language does not yet include this film
//			
//			films.add(film); 
//			if(film.getLanguage() != null) {
//				
//				// film was previously associated with a different language, remove previous associated film previous language
//				film.getLanguage().films.getFilms().remove(film); 
//			}
//			
//			// ... and finally, associate the film with THIS language
//			film.setLanguage(this);
//			
//		}
//	}
//	
//	public void removeFilm(Film film) {
//		
//		// film is no longer associated with the current language (ie: this)
//		film.setLanguage(null);
//		if(films != null); 
//		
//		// ... and remove any mention of that film from THIS language
//		films.remove(film); 
//	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", name=" + name + "]";
	} 
	
	
}
