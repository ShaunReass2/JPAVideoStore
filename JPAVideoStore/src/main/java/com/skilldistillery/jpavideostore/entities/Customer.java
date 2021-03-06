package com.skilldistillery.jpavideostore.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Customer {
	
	@Id
	private int id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	@ManyToOne
	@JoinColumn(name="store_id")
	private Store store;

	@OneToMany(mappedBy = "customer")
	private List<Rental> rentals;

	
	
	public Customer() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public void addRental(Rental rental) {
		
		// if haven't yet recorded any films for this language,let's do so now
		if (rentals == null) {
			rentals = new ArrayList<>();
		}
		
		if (!rentals.contains(rental)) {
			
			// current list of films assoc w this lang doesn't yet include this film
			rentals.add(rental);
			
			if (rental.getCustomer() != null) {
				
				// film was prev assoc with a diff lang, remove prev assoc film having prev language
				rental.getCustomer().getRentals().remove(rental);
			}
			
			// ... and finally (whew!), assoc the film with THIS language
			rental.setCustomer(this);
		}
	}

	public void removeRental(Rental rental) {
		
		// film is no longer assoc with the current language (ie: this)
		rental.setCustomer(null);
		if (rental != null) {
			
			// ... and remove any mention of that film from THIS language
			rentals.remove(rental);
		}
	}
	
	public List<Rental> getRentals() {
		return rentals;
	}

	public void setRentals(List<Rental> rentals) {
		this.rentals = rentals;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
}