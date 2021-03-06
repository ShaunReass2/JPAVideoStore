package com.skilldistillery.jpavideostore.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; 
	
	@Column(name="address")
	private String street; 
	
	@Column(name="address2")
	private String street2; 
	
	@Column(name="state_province")
	private String state; 
	
	private String city; 
	
	@Column(name="postal_code")
	private String postalCode; 
	
	private String phone;
	
	@ManyToOne
	@JoinColumn(name="country_code")
	private Country country;

	
	// add constructors 
	public Address () { }
	
	public Address(String street, String city, String state, String postalCode, String phone) {
		super(); 
		this.street = street; 
		this.city = city; 
		this.state = state; 
		this.postalCode = postalCode; 
		this.phone = phone; 
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", street2=" + street2 + ", state=" + state + ", city="
				+ city + ", postalCode=" + postalCode + ", phone=" + phone + ", getId()=" + getId() + ", getStreet()="
				+ getStreet() + ", getStreet2()=" + getStreet2() + ", getState()=" + getState() + ", getCity()="
				+ getCity() + ", getPostalCode()=" + getPostalCode() + ", getPhone()=" + getPhone() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
	
}
