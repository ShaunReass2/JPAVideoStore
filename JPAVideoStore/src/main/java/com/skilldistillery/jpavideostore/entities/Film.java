package com.skilldistillery.jpavideostore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Film {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String title;
	
	private String description;
	
	@Column(name = "release_year")
	private Integer releaseYear;
	
	@Column(name = "rental_rate")
	private double rentalRate;
	
	private Integer length;
	
	@Column(name = "replacement_Cost")
	private double replacementCost;
	
	@Enumerated(EnumType.STRING)
	private Rating rating;
	
	@ManyToOne
	@JoinColumn(name = "language_id")
	private Language language;
	
	@ManyToMany(mappedBy = "films", fetch = FetchType.LAZY)
	private List<Actor> actors;
	
	@ManyToMany(mappedBy = "films")
	private List<Category> categories;
	
	@OneToMany(mappedBy = "film")
	private List<InventoryItem> inventoryItems; 
	

	public Film() {
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(Integer releaseYear) {
		this.releaseYear = releaseYear;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}
	
	public List<InventoryItem> getInventoryItems() {
		return inventoryItems;
	}

	public void setInventoryItems(List<InventoryItem> inventoryItems) {
		this.inventoryItems = inventoryItems;
	}
	
	public void addCategory(Category category) {
		if (categories == null) { categories = new ArrayList<>(); }
		if (! categories.contains(category)) {
			categories.add(category); 
			category.addFilm(this);
		}
	}
	
	public void removeCategory(Category category) {
		if (categories != null && categories.contains(category)); 
			categories.remove(category); 
			category.removeFilm(this);
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", releaseYear=" + releaseYear
				+ ", rentalRate=" + rentalRate + ", length=" + length + ", replacementCost=" + replacementCost
				+ ", rating=" + rating + "]";
	}
}