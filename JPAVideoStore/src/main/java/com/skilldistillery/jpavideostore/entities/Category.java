package com.skilldistillery.jpavideostore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	@ManyToMany
	@JoinTable(name="film_category",
			joinColumns = @JoinColumn(name = "category_id"), 
			inverseJoinColumns = @JoinColumn(name = "film_id")
			)
	private List<Film> films;

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
	
	public void addFilm (Film film) {
		if (films ==null) { films = new ArrayList<>(); }
		if (! films.contains(film)) {
			films.add(film); 
			film.addCategory(this);
		}
	}
	
	public void removeFilm(Film film) {
		if (films != null && films.contains(film)) {
			films.remove(film); 
			film.removeCategory(this);
		}
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
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
	
	
}
