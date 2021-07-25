package com.skilldistillery.jpavideostore.entities;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Rental {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "rental_Date")
	private LocalDateTime rentalDate;
	@Column(name = "return_Date")
	private LocalDateTime returnDate;
	public Rental() {
		super();
	}
	@ManyToOne
    @JoinColumn(name="staff_id")
    private Staff staff;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Staff getStaff() {
		return staff;
	}
	public void setStaff(Staff staff) {
		this.staff = staff;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDateTime getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(LocalDateTime rentalDate) {
		this.rentalDate = rentalDate;
	}
	public LocalDateTime getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
	@Override
	public String toString() {
		return "Rental [id=" + id + ", rentalDate=" + rentalDate + ", returnDate=" + returnDate + "]";
	}
}